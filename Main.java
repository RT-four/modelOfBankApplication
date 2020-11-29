package rtfour;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("CentralBank");

    public static void main(String[] args) {
        boolean quit = false;
        bank.printInstructions();
        while (!quit) {
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    addBranch();
                    break;
                case 2:
                    makeTransaction();
                    break;
                case 3:
                    bank.printBranches();
                    break;
                case 4:
                    printCustomerTransactions();
                    break;
                case 5:
                    bank.printInstructions();
                    break;
                case 6:
                    addCustomer();
                    break;
            }
        }

    }


    public static void addBranch() {
        System.out.println("Enter new branch name: ");
        String branchName = scanner.next();
        Branch newBranch = Branch.createBranch(branchName);
        bank.createBranch(newBranch);
    }

    public static void makeTransaction() {
        System.out.println("Enter the branch where customer is registered: ");
        String branchName = scanner.next();
        System.out.println("Enter customer name: ");
        String customerName = scanner.next();
        System.out.println("Enter the transaction: ");
        double transactionAmount = scanner.nextDouble();
        bank.queryBranch(branchName).makeTransaction(customerName, transactionAmount);
    }

    public static void printCustomerTransactions() {
        System.out.println("Enter the branch where customer is registered: ");
        String branchName = scanner.next();
        System.out.println("Enter customer name: ");
        String customerName = scanner.next();
        bank.queryBranch(branchName).printTransactionsOfCustomer(customerName);
    }

    public static void addCustomer(){
        System.out.println("Enter the branch where customer will be registered: ");
        String branchName = scanner.next();
        System.out.println("Enter new customer name: ");
        String customerName = scanner.next();
        bank.addCustomer(branchName, customerName);
    }

}
