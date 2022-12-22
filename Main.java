
import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static int List() {
        System.out.println("\nSelect operation:\n" 
                + "1. Add new employee                   2. Add new customer\n"
                + "3. Add new product                    4. Add special product\n"
                + "5. Add new product for customer       6. Add Bonus for Employee\n"
                + "7. Remove product                     8. Print all products\n"
                + "9. Customer bill                      10. Print special products\n"
                + "11. Print all users                   12. Exit\n");
        return input.nextInt();
    }

    public static void main(String[] args) {
        Employee e = new Employee("manager", 10000);
        Store store = new Store("Happy Store", e);
        int choice;
        do {
            System.out.println("\nWelcome to "+store.getName());
            choice = List();
            if (choice == 1) {

                System.out.println("Enter Employee Name and Salary: ");
                store.addUser(new Employee(input.next("...*"), input.nextDouble()));
            } else if (choice == 2) {

                System.out.println("Enter Customer Name: ");
                store.addUser(new Customer(input.next("...*")));
            } else if (choice == 3) {

                System.out.println("Enter product Name and Price: ");
                store.addProduct(new Product(input.next(), input.nextDouble()));
            } else if (choice == 4) {

                System.out.println("select product from the list: ");
                store.isExist();
                System.out.println("enter the product id: ");
                int id = input.nextInt();
                if (store.searchProduct(id)) {
                    System.out.println("enter the Relation between products: ");
                    store.ChangeProductRelation(id, input.next());
                    int c;
                    do {
                        System.out.println("select product: ");
                        store.isExist();
                        System.out.print("enter product id:\n(-1)-Exit: ");
                        c = input.nextInt();
                        Product special = store.getProduct(c);
                        if (special != null)
                            store.addSpecialProduct(id, special);

                    } while (c != -1);
                }
            } else if (choice == 5) {
                System.out.print("Enter customer ID: ");
                int userid = input.nextInt();
                if (store.searchUser(userid)) {
                    store.NewUserBuying(userid);
                    int c;
                    do {
                        System.out.println("Select Product: ");
                        store.isExist();
                        System.out.print("enter product id:\n(-1)-Exit: ");
                        c = input.nextInt();
                        Product special = store.getProduct(c);
                        if (special != null) {
                            store.addUserProduct(userid, special);
                            store.removeProduct(special.getId());
                        }

                    } while (c != -1);
                }
            } else if (choice == 6) {
                System.out.print("Enter Bouns for all employee: ");
                int bouns = input.nextInt();
                store.increaseSalary(bouns);
            } else if (choice == 7) {
                System.out.print("Enter manager ID: ");
                int mang_id = input.nextInt();
                if (store.getManager().getId() == mang_id)
                    store.removeProductGui();
                else
                    System.out.println("Wrong ID!");
            } else if (choice == 8) {
                store.isExist();
            } else if (choice == 9) {
                System.out.print("Enter customer ID : ");
                int CustomerId = input.nextInt();
                if (store.searchUser(CustomerId)) {
                    store.CustomerProduct(CustomerId);
                    System.out.println("Total cost is " + store.totalPrice(CustomerId));
                }
            } else if (choice == 10) {
                System.out.println("Select product: ");
                store.isExist();
                System.out.print("Enter product id:");
                int p_id = input.nextInt();
                Product getproduct = store.getProduct(p_id);
                if (getproduct != null) {
                    System.out.println(getproduct.toString() + "\n relation " + getproduct.getRelationName());
                    getproduct.printspecialproduct();
                }
            } else if (choice == 11) {
                store.printUser();
            } else if (choice != 12)
                System.out.println("Try again");

        } while (choice != 12);

    }

}
