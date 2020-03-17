package com.frog.nika.map;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TrialData {

    public void init() {
        Calendar dateProduction1 = new GregorianCalendar(2020, 02, 2);
        Calendar dateProduction2 = new GregorianCalendar(2020, 02, 4);
        Calendar dateProduction3 = new GregorianCalendar(2020, 02, 6);
        Calendar dateProduction4 = new GregorianCalendar(2020, 02, 8);

        Calendar dateExpiration1 = new GregorianCalendar(2020, 03, 1);
        Calendar dateExpiration2 = new GregorianCalendar(2020, 03, 3);
        Calendar dateExpiration3 = new GregorianCalendar(2020, 03, 5);
        Calendar dateExpiration4 = new GregorianCalendar(2020, 03, 7);

        Product product1 = new Product();
        product1.setName("Product-1");
        product1.setShelfLife(14);
        product1.setProductionDate(dateProduction1);
        product1.setExpirationDate(dateExpiration1);

        Product product2 = new Product();
        product2.setName("Product-2");
        product2.setShelfLife(14);
        product2.setProductionDate(dateProduction2);
        product2.setExpirationDate(dateExpiration2);

        Product product3 = new Product();
        product3.setName("Product-3");
        product3.setShelfLife(14);
        product3.setProductionDate(dateProduction3);
        product3.setExpirationDate(dateExpiration3);

        Product product4 = new Product();
        product4.setName("Product-4");
        product4.setShelfLife(14);
        product4.setProductionDate(dateProduction4);
        product4.setExpirationDate(dateExpiration4);

    }

}
