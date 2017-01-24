package com.stockreport.service.impl;

import com.stockreport.dao.SiteDao;
import com.stockreport.model.Customer;
import com.stockreport.model.CustomerOrder;
import com.stockreport.model.Site;
import com.stockreport.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

/**
 * Created by Matty on 21/10/2016.
 */

@Service
@Transactional
public class SiteServiceImpl implements SiteService{

    @Autowired
    private SiteDao siteDao;

    public List<Site> getAllSites() {
        return siteDao.getAllSites();
    }

    public List<Site> getStockBySite(String site) {
        return siteDao.getStockBySite(site);
    }

    public Customer getSiteAddressName(String loggedInUser) {
        return siteDao.getSiteAddressName(loggedInUser);
    }

    public List<Site> viewSiteStockBySiteAddress(String siteAddress) {
        return siteDao.viewSiteStockBySiteAddress(siteAddress);
    }

    public void modifyUnitCountPerSite(CustomerOrder customerOrder) {
        siteDao.modifyUnitCountPerSite(customerOrder);
    }

    public void createxml(Customer siteObject) throws IOException {
        siteDao.createxml(siteObject);
    }

    public Site getStockObject(int pId, String siteName) {
        return siteDao.getStockObject(pId, siteName);
    }

    public void updateStockObject(Site updateSiteStock) {
        siteDao.updateStockObject(updateSiteStock);
    }

    public void updateStock(Site site) {
        siteDao.updateStock(site);
    }
}
