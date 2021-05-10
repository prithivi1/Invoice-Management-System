package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<Customer> customerDetails = new ArrayList<>();
    static List<Invoice> invoiceDetails = new ArrayList<>();
    static List<Products> productsList = new ArrayList<>();

    static int customerID = 0;
    static int invoiceID = 0;

    public static void main(String[] args)
    {
        productsList.add(new Products("pen",10));
        productsList.add(new Products("pencil",5));
        productsList.add(new Products("book",50));
        productsList.add(new Products("bag",200));

        while (true)
        {
            System.out.println("**********INVOICE SYSTEM***********");
            System.out.println("Select options below:");
            System.out.println("1.ADD CUSTOMER");
            System.out.println("2.CREATE INVOICE");
            System.out.println("3.LIST ALL CUSTOMER");
            System.out.println("4.LIST ALL INVOICE");
            System.out.println("5.LIST ALL INVOICE OF A CUSTOMER");
            System.out.println("6.DISPLAY AN INVOICE");
            System.out.println("7.CLOSE");

            Scanner sc = new Scanner(System.in);
            int selected_option = sc.nextInt();
            switch (selected_option)
            {
                case 1 : createCustomer();
                break;
                case 2 : createInvoice();
                break;
                case 3 : displayAllCustomers();
                break;
                case 4 : allInvoice();
                break;
                case 5 : invoiceOfCustomer();
                break;
                case 6 : displayAnInvoice();
                break;
                case 7 : System.out.println("***thanks for shopping***");
                return;
                default: System.out.println("enter valid number");
                break;
            }
        }
    }

    public static void createCustomer()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter customer name : ");
        String name = sc.nextLine();

        System.out.println("Enter customer address : ");
        String address = sc.nextLine();

        System.out.println("Enter customer phone Number : ");
        String phone = sc.nextLine();

        customerDetails.add(customerID,new Customer(name,address,phone));
        customerID++;

        System.out.println("customer created");
        System.out.println();
    }


    public static void displayAllCustomers()
    {
        System.out.println("------------------------------------------------------");
        System.out.format("%-15s%-12s%-15s%-12s","CUSTOMER_ID","NAME","ADDRESS","PHONE");
        System.out.println();
        System.out.println("------------------------------------------------------");
        for(int i=0;i<customerDetails.size();i++)
        {
            Customer ob = customerDetails.get(i);
            System.out.format("%-15s%-12s%-15s%-12s",(i+1),ob.getCustomer_name(),ob.getCustomer_address(),ob.getCustomer_phnNo());
            System.out.println();
        }
        System.out.println("------------------------------------------------------");
    }

    public static void createInvoice()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("ENTER CUSTOMER ID");
        int ID = sc.nextInt();

        if(ID<0 || ID>=customerID) {
            System.out.println("OOPS ! YOU ARE NOT A VALID CUSTOMER , REGISTER CUSTOMER FIRST");
            return;
        }

        List<Products> myItems = new ArrayList<>();

        while (true)
        {
            System.out.println("AVAILABLE PRODUCTS");
            System.out.println("----------------------------------------");
            System.out.format("%-10s%-15s%-10s","SNO","ITEMS","COST");
            System.out.println();

            for(int i=0;i<productsList.size();i++)
            {
                System.out.format("%-10s%-15s%-10s",(i+1), productsList.get(i).name,productsList.get(i).cost);
                System.out.println();
            }

            System.out.println((productsList.size()+1)+". EXIT");
            System.out.println("----------------------------------------");
            System.out.println("select items");

            int select = sc.nextInt();

            if(select==productsList.size()+1)
            {
                System.out.println("CONFIRM EXIT PRESS 1 TO CONTINUE PRESS 0");
                int temp = sc.nextInt();
                if(temp==1) {
                    return;
                }else {
                    continue;
                }
            }

            if(select<=0 || select >productsList.size())
            {
                System.out.println("Choose valid option...!");
            }else {
                System.out.println("select quantity");
                int quantity = sc.nextInt();


                int flag = 0;
                for (int i = 0; i < myItems.size(); i++) {
                    if (myItems.get(i).name == productsList.get(select - 1).name) {
                        flag = 1;
                        myItems.get(i).setQuantity(myItems.get(i).getQuantity() + quantity);
                        myItems.get(i).setCost(myItems.get(i).getCost() + (quantity * productsList.get(select - 1).getCost()));
                    }
                }

                if (flag == 0) {
                    myItems.add(new Products(productsList.get(select - 1).getName(), productsList.get(select - 1).getCost() * quantity, quantity));
                }

                System.out.println("**** YOUR SHOPPING ****");
                System.out.println("CUSTOMER ID : " + ID);
                System.out.println("INVOICE ID  : " + invoiceID);
                System.out.println();
                System.out.format("%-15s%-10s%-10s","ITEMS","QUANTITY","COST");
                System.out.println();
                int total = 0;
                for (int i = 0; i < myItems.size(); i++) {
                    System.out.format("%-15s%-10s%-10s",myItems.get(i).getName(),myItems.get(i).getQuantity(),myItems.get(i).getCost());
                    System.out.println();
                    total += myItems.get(i).getCost();
                }
                System.out.format("%-20s%-10s","total ----------> ",total);
                System.out.println();

                System.out.println("Enter 1 to checkout and 0 to continue");
                int temp = sc.nextInt();
                if (temp == 1) {
                    Invoice invoice = new Invoice(customerDetails.get(ID).getCustomer_name(), myItems, total);
                    invoiceDetails.add(invoiceID, invoice);
                    invoiceID++;
                    customerDetails.get(ID).setMyInvoice(invoice);
                    break;
                }
            }
        }
    }

    public static void allInvoice()
    {
        for(int i=0;i<invoiceDetails.size();i++)
        {
            System.out.println("CUSTOMER NAME : "+invoiceDetails.get(i).getCustomerName());
            System.out.println("SNO. ITEMS      QUANTITY        COST");
            for (int j=0;j<invoiceDetails.get(i).getItems().size();j++)
            {
                System.out.println((j+1)+". "+invoiceDetails.get(i).getItems().get(j).getName()+"   "+invoiceDetails.get(i).getItems().get(j).getQuantity()+"   "+invoiceDetails.get(i).getItems().get(j).getCost());
            }
            System.out.println("TOTAL -------------->   "+invoiceDetails.get(i).getTotal());
        }
    }

    public static void invoiceOfCustomer()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER CUSTOMER ID : ");
        int select = sc.nextInt();
        if(select<0 || select>=customerDetails.size())
        {
            System.out.println("INVALID CUSTOMER ID");
            return;
        }

        List<Invoice> list = customerDetails.get(select).getMyInvoice();

        for (int i=0;i<list.size();i++)
        {
            List<Products> customer_products = list.get(i).getItems();
            System.out.println("CUSTOMER NAME : "+list.get(i).getCustomerName());
            System.out.println("SNO. ITEMS      QUANTITY        COST");
            for (int j=0;j<customer_products.size();j++)
            {
                System.out.println((j+1)+". "+customer_products.get(j).getName()+"   "+customer_products.get(j).getQuantity()+"   "+customer_products.get(j).getCost());
            }
            System.out.println("TOTAL -------------->   "+list.get(i).getTotal());
        }
    }

    public static void displayAnInvoice()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER INVOICE NUMBER : ");
        int select = sc.nextInt();
        if(select<0 || select>=invoiceDetails.size())
        {
            System.out.println("INVALID INVOICE ID");
            return;
        }

        Invoice invoice = invoiceDetails.get(select);
        System.out.println("CUSTOMER NAME : "+invoice.getCustomerName());
        System.out.println("SNO. ITEMS      QUANTITY        COST");
        for (int j=0;j<invoice.getItems().size();j++)
        {
            System.out.println((j+1)+". "+invoice.getItems().get(j).getName()+"   "+invoice.getItems().get(j).getQuantity()+"   "+invoice.getItems().get(j).getCost());
        }
        System.out.println("TOTAL -------------->   "+invoice.getTotal());

    }
}


