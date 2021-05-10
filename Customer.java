package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer
{
    private String customer_name;
    private String customer_address;
    private String customer_phnNo;
    List<Invoice> myInvoice = new ArrayList<>();

    public Customer(String customer_name, String customer_address, String customer_phnNo) {
        this.customer_name = customer_name;
        this.customer_address = customer_address;
        this.customer_phnNo = customer_phnNo;
    }

    public String getCustomer_name()
    {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public String getCustomer_phnNo() {
        return customer_phnNo;
    }

    public void setCustomer_phnNo(String customer_phnNo) {
        this.customer_phnNo = customer_phnNo;
    }

    public List<Invoice> getMyInvoice() {
        return myInvoice;
    }

    public void setMyInvoice(Invoice temp) {
        myInvoice.add(temp);
    }
}

