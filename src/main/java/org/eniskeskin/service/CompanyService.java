package org.eniskeskin.service;

import org.eniskeskin.models.Company;
import org.eniskeskin.models.Order;

import java.util.*;

public class CompanyService {
    static List<Company> companyList = new ArrayList<>();
    static Map<Company, List<Order>> companyListMap = new HashMap<>();

    //Adds companys
    public void addCompany(Company company) {
        companyList.add(company);
        companyListMap.put(company, company.companyOrderList);
    }
    public void getCompanysSectorAverageOfOrderSmallerThanValue(Double value, String month) {

    }
}
