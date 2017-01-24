package com.stockreport.dao.impl;

import com.stockreport.dao.SiteDao;
import com.stockreport.model.Customer;
import com.stockreport.model.CustomerOrder;
import com.stockreport.model.ProductCategory;
import com.stockreport.model.Site;
import com.stockreport.service.SiteService;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Matty on 21/10/2016.
 */

@Repository
@Transactional
public class SiteDaoImpl implements SiteDao{

    @Autowired
    private SessionFactory sessionFactory;

    Date date = new Date();
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    File file = new File(dateFormat.format(date));

    public List<Site> getAllSites() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Site");
        List<Site> siteList = query.list();
        session.flush();

        Map<String, Site> siteMap = new LinkedHashMap<String, Site>();

        for(Site sl : siteList) {
            if(!siteMap.containsKey(sl.getSiteName())) {
                siteMap.put(sl.getSiteName(), sl);
            }
        }

        siteList.clear();
        siteList.addAll(siteMap.values());

        return siteList;

    }

    public List<Site> getStockBySite(String site) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Site where siteName = ?");
        query.setString(0, site);
        List<Site> siteStockList = query.list();
        session.flush();

        return siteStockList;
    }

    public Customer getSiteAddressName(String loggedInUser) {
        Session session = sessionFactory.getCurrentSession();
        Customer site = (Customer) session.get(Customer.class, loggedInUser);
        session.flush();

        return site;
    }

    public List<Site> viewSiteStockBySiteAddress(String siteAddress) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Site where siteName = ?");
        query.setString(0, siteAddress);
        List<Site> siteProductList = query.list();
        session.flush();

        return siteProductList;
    }

    public void modifyUnitCountPerSite(CustomerOrder customerOrder) {
        Session session = sessionFactory.getCurrentSession();

        int sId = customerOrder.getSite().getId();
        String siteName = customerOrder.getSite().getSiteName();
        int currentConditionGood = 0;
        int currentConditionFaulty = 0;
        int updatedConditionGood = 0;

        Query getCurrentConditionGood = session.createQuery("select conditionGood from Site s where id = ? and siteName = ?");
        getCurrentConditionGood.setInteger(0, sId);
        getCurrentConditionGood.setString(1, siteName);
        currentConditionGood = (Integer) getCurrentConditionGood.uniqueResult();
        session.flush();

        Query getCurrentConditionFaulty = session.createQuery("select conditionFaulty from Site s where id = ? and siteName = ?");
        getCurrentConditionFaulty.setInteger(0, sId);
        getCurrentConditionFaulty.setString(1, siteName);
        currentConditionFaulty = (Integer) getCurrentConditionFaulty.uniqueResult();
        session.flush();

        int updateConditionGood = currentConditionGood + customerOrder.getOrderQuantity();
        Query updateConGood = session.createQuery("update Site set conditionGood = ? where id = ? and siteName = ?");
        updateConGood.setInteger(0, updateConditionGood);
        updateConGood.setInteger(1, sId);
        updateConGood.setString(2, siteName);
        updateConGood.executeUpdate();
        session.flush();

        Query getUpdatedConditionGood = session.createQuery("select conditionGood from Site s where id = ? and siteName = ?");
        getUpdatedConditionGood.setInteger(0, sId);
        getUpdatedConditionGood.setString(1, siteName);
        updatedConditionGood = (Integer) getUpdatedConditionGood.uniqueResult();
        session.flush();


        int updateTotaProductCount = updatedConditionGood + currentConditionFaulty;
        Query updateTotal = session.createQuery("update Site set productCount = ? where id = ? and siteName = ?");
        updateTotal.setInteger(0, updateTotaProductCount);
        updateTotal.setInteger(1, sId);
        updateTotal.setString(2, siteName);
        updateTotal.executeUpdate();

        session.flush();
    }


    public List<Site> getSiteItemByProductId(int pId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Site where product = ?");
        query.setInteger(0, pId);
        List<Site> removeSiteProduct = query.list();
        session.flush();

        return removeSiteProduct;
    }


    public void removeSiteItem(Site site) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(site);
        session.flush();
    }

    public void createxml(Customer siteObject) throws IOException {

        Session session = sessionFactory.getCurrentSession();
        List<Site> siteStockList = session.createQuery("from Site where siteName = ?")
                                .setString(0, siteObject.getSAdd().getStreetName())
                                .list();

        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet  = book.createSheet(siteObject.getSAdd().getStreetName() + " Weekly Report ");
        XSSFRow rowSiteAndDate = sheet.createRow(0);
        rowSiteAndDate.createCell(0).setCellValue("Site:");
        rowSiteAndDate.createCell(1).setCellValue(siteObject.getSAdd().getStreetName());
        rowSiteAndDate.createCell(2).setCellValue("Report Date:");
        rowSiteAndDate.createCell(3).setCellValue(new SimpleDateFormat("MM/dd/yyyy").format(new java.util.Date()));
        XSSFRow rowhead = sheet.createRow(1);
        rowhead.createCell(0).setCellValue("Product name");
        rowhead.createCell(1).setCellValue("Total unit count");
        rowhead.createCell(2).setCellValue("Unit Good");
        rowhead.createCell(3).setCellValue("Unit Faulty");

        int i = 3;

        for(Site stockList : siteStockList) {
            XSSFRow rowTail = sheet.createRow(i);
            rowTail.createCell(0).setCellValue(stockList.getProduct().getProdName());
            rowTail.createCell(1).setCellValue(stockList.getProductCount());
            rowTail.createCell(2).setCellValue(stockList.getConditionGood());
            rowTail.createCell(3).setCellValue(stockList.getConditionFaulty());

            i++;
        }

        String fileName = "c:/temp/weekly stock by " + siteObject.getSAdd().getStreetName() + " " + file + ".xlsx";
        FileOutputStream fileout = new FileOutputStream(fileName);
        book.write(fileout);
        fileout.close();

    }

    public Site getStockObject(int pId, String siteName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Site where product = ? and siteName = ?");
        query.setInteger(0, pId);
        query.setString(1, siteName);

        return (Site)query.uniqueResult();
    }

    public void updateStockObject(Site updateSiteStock) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(updateSiteStock);
        session.flush();
    }

    public void updateStock(Site site) {
        int good = site.getConditionGood();
        int faulty = site.getConditionFaulty();
        int total = site.getConditionGood() + site.getConditionFaulty();
        String sitename = site.getSiteName();
        int id = site.getId();

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update Site set conditionGood =:good, conditionFaulty =:faulty, productCount =:total where id =:id");
        query.setParameter("good", good);
        query.setParameter("faulty", faulty);
        query.setParameter("total", total);
        query.setParameter("id", id);
        query.executeUpdate();
        session.flush();
    }
}
