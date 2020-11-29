package rtfour;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.name = name;
        this.customers = new ArrayList<Customer>();
    }

    public static Branch createBranch(String name) {
        return new Branch(name);
    }

    public int findCustomer(Customer customer) {
        return this.customers.indexOf(customer);
    }

    public int findCustomer(String name) {
        for (int i = 0; i < this.customers.size(); i++) {
            Customer customer = queryCustomer(i);
            if (customer.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public Customer queryCustomer(String customerName){
        int customerPosition = findCustomer(customerName);
        if(customerPosition>=0){
            return queryCustomer(customerPosition);
        }
        else{
            return null;
        }
    }

    public Customer queryCustomer(int customerPosition){
        return customers.get(customerPosition);
    }

    public void createCustomer(Customer customer) {
        if (findCustomer(customer) >= 0) {
            System.out.println("Error. Customer is already exists.");
        } else {
            customers.add(customer);
        }
    }

    public void makeTransaction(String customerName, double transactionAmount) {
        int customerPosition = findCustomer(customerName);
        if (customerPosition >= 0) {
            queryCustomer(customerPosition).updateTransactionHistory(transactionAmount);
            System.out.println("Successfully made transaction");
        } else {
            System.out.println("Error. Customer doesn't exist");
        }
    }

    public void printCustomers() {
        for (int i = 0; i < this.customers.size(); i++) {
            System.out.println("\t" + (i + 1) + ". " + queryCustomer(i).getName());
        }
    }

    public void printTransactionsOfCustomer(String customerName) {
        System.out.println("Transactions of " + customerName + ": ");
        for (int i = 0; i < queryTransactionHistory(customerName).size(); i++) {
            System.out.println((i + 1) + ". " + Double.valueOf(queryTransactionHistory(customerName).get(i)));
        }
    }

    public ArrayList<Double> queryTransactionHistory(String customerName){
        return queryCustomer(customerName).getTransactionHistory();
    }

    public String getName() {
        return this.name;
    }
}
