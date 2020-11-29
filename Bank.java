package rtfour;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public void printBranches() {
        for (int i = 0; i < this.branches.size(); i++) {
            System.out.println(branches.get(i).getName() + ": ");
            queryBranch(i).printCustomers();
        }
    }

    public void addCustomer(String branchName, String customerName){
        int branchPosition = findBranch(branchName);
        if(branchPosition>=0){
            Customer customer = Customer.createCustomer(customerName);
            queryBranch(branchPosition).createCustomer(customer);
            System.out.println("Successfully added new customer " + customerName);
        }
        else{
            System.out.println("Error. No such branch found");
        }
    }

    public void createBranch(Branch branch) {
        if (this.findBranch(branch.getName()) >= 0) {
            System.out.println("This branch is already exists!");
        } else {
            this.branches.add(branch);
            System.out.println("Successfully added new branch " + branch.getName());
        }
    }

    public void removeBranch(Branch branch) {
        if (this.findBranch(branch.getName()) >= 0) {
            System.out.println("No such branch found");
        } else {
            this.branches.remove(branch);
        }
    }

    public int findBranch(Branch branch) {
        return this.branches.indexOf(branch);
    }

    public int findBranch(String nameOfBranch) {
        for (int i = 0; i < this.branches.size(); i++) {
            Branch branch = this.branches.get(i);
            if (branch.getName().equals(nameOfBranch)) {
                return i;
            }
        }
        return -1;
    }

    public Branch queryBranch(String branchName) {
        int branchPosition = findBranch(branchName);
        if (branchPosition >= 0) {
            return queryBranch(branchPosition);
        }
        return null;
    }

    public Branch queryBranch(int branchPosition){
        return branches.get(branchPosition);
    }


    public void printInstructions() {
        System.out.println("\n Available actions:\n press");
        System.out.println("0 - to quit application\n" +
                "1 - to add new branch\n" +
                "2 - to make transaction\n" +
                "3 - to print branches\n" +
                "4 - to print customer transactions\n" +
                "5 - to print list of available actions\n"+
                "6 - to add new customer");
        System.out.println("Choose your action: ");
    }

}

