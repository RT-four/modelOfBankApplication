package rtfour;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactionHistory;

    private Customer(String name) {
        this.name = name;
        this.transactionHistory = new ArrayList<Double>();
    }

    public static Customer createCustomer(String name) {
        return new Customer(name);
    }

    public void updateTransactionHistory(double amount) {
        transactionHistory.add(Double.valueOf(amount));
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactionHistory() {
        return transactionHistory;
    }
}
