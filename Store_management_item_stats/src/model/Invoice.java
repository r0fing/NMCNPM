/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author HLC_2021
 */
public class Invoice {
    private int id;
    private String subagenceName;
    private Date dateIssued;
    private int numberOfItems;
    private User user;
    private Subagence subagence;
    private ArrayList<InvoiceItem> invoiceItem = new ArrayList<>();
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubagenceName() {
        return subagenceName;
    }

    public void setSubagenceName(String subagenceName) {
        this.subagenceName = subagenceName;
    }

    public Date getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(Date dateIssued) {
        this.dateIssued = dateIssued;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subagence getSubagence() {
        return subagence;
    }

    public void setSubagence(Subagence subagence) {
        this.subagence = subagence;
    }

    public ArrayList<InvoiceItem> getInvoiceItem() {
        return invoiceItem;
    }

    public void setInvoiceItem(ArrayList<InvoiceItem> invoiceItem) {
        this.invoiceItem = invoiceItem;
    }

    
}
