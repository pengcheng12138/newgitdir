package com.uprightlaw.price.engine.test.model;

import java.io.Serializable;

/**
 * Created by peng cheng on 2017/9/13.
 */
public class PriceModel implements Serializable{
    private static final long serialVersionUID = 7704680613251121780L;

    private String chapter;
    private String fips;
    private boolean selfemployed;
    private int numberOfProperties;
    private int householdMember;
    private double income;
    private String maritalStatus;
    private int rushCase;
    private double price;
    private double expectPrice;
    private double totalPrice;
    private double expectTotalPrice;

    public PriceModel(){

    }

    public PriceModel(String fips, String chapter, boolean selfemployed, int numberOfProperties, int householdMember, double income, String maritalStatus, int rushCase, double price, double expectPrice, double totalPrice, double expectTotalPrice) {
        this.fips = fips;
        this.chapter = chapter;
        this.selfemployed = selfemployed;
        this.numberOfProperties = numberOfProperties;
        this.householdMember = householdMember;
        this.income = income;
        this.maritalStatus = maritalStatus;
        this.rushCase = rushCase;
        this.price = price;
        this.expectPrice = expectPrice;
        this.totalPrice = totalPrice;
        this.expectTotalPrice = expectTotalPrice;
    }

    public String getFips() {
        return fips;
    }

    public void setFips(String fips) {
        this.fips = fips;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

    public boolean isSelfemployed() {
        return selfemployed;
    }

    public void setSelfemployed(boolean selfemployed) {
        this.selfemployed = selfemployed;
    }

    public int getNumberOfProperties() {
        return numberOfProperties;
    }

    public void setNumberOfProperties(int numberOfProperties) {
        this.numberOfProperties = numberOfProperties;
    }

    public int getHouseholdMember() {
        return householdMember;
    }

    public void setHouseholdMember(int householdMember) {
        this.householdMember = householdMember;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public int getRushCase() {
        return rushCase;
    }

    public void setRushCase(int rushCase) {
        this.rushCase = rushCase;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getExpectPrice() {
        return expectPrice;
    }

    public void setExpectPrice(double expectPrice) {
        this.expectPrice = expectPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getExpectTotalPrice() {
        return expectTotalPrice;
    }

    public void setExpectTotalPrice(double expectTotalPrice) {
        this.expectTotalPrice = expectTotalPrice;
    }
}
