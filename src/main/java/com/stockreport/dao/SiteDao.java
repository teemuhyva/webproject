package com.stockreport.dao;

import com.stockreport.model.Customer;
import com.stockreport.model.CustomerOrder;
import com.stockreport.model.Site;

import java.io.IOException;
import java.util.List;

/**
 * Created by Matty on 21/10/2016.
 */
public interface SiteDao {

    List<Site> getAllSites();

    List<Site> getStockBySite(String site);

    List<Site> viewSiteStockBySiteAddress(String siteAddress);

    Customer getSiteAddressName(String loggedInUser);

    void modifyUnitCountPerSite(CustomerOrder customerOrder);

    void createxml(Customer siteObject) throws IOException;

    Site getStockObject(int pId, String siteName);

    void updateStockObject(Site updateSiteStock);

    void updateStock(Site site);

}
