package com.frog.nika.map;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TrialData {

    private Calendar dateProduction = new GregorianCalendar(2020, 02, 20);
    private Calendar dateExpiration = new GregorianCalendar(2020, 03, 11);

    public void init() {
        Product product = new Product();
        product.setName("");
        product.setShelfLife(14);
        product.setProductionDate(dateProduction);
        product.setExpirationDate(dateExpiration);
    }

}
