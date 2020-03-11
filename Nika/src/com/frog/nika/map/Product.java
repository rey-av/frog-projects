package com.frog.nika.map;

import java.util.Calendar;

public class Product {

    private String name;
    private Calendar expirationDate;// дата завершения срока годности
    private Calendar productionDate;// дата изготовления
    private int shelfLife; // срок годности в днях

    public String getName() {
        return name;
    }

    public Calendar getExpirationDate() {
        return expirationDate;
    }

    public Calendar getProductionDate() {
        return productionDate;
    }

    public void setName(String Name) {
        name = Name;
    }

    public void setExpirationDate(Calendar date) {
        expirationDate = date;
    }

    public void setProductionDate(Calendar date) {
        productionDate = date;
    }

    public void setShelfLife(int duration) {
        shelfLife = duration;
    }

}
