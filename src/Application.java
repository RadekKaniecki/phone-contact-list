import java.util.Scanner;

public class Application {

    static Scanner sc = new Scanner(System.in);
    static MobilePhone mb = new MobilePhone();

    public static void main(String[] args) {
        boolean exit = false;
        printInstructions();

        while(!exit) {
            System.out.print("\nWhat is your choice? (6 to print available options)");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    removeContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    queryContact();
                    break;
                case 5:
                    mb.printContactList();
                    break;
                case 6:
                    printInstructions();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    exit = true;
            }

        }

    }

    public static void printInstructions() {
        System.out.println("\nAvailable options:"
                + "\n\t1.Add new contact"
                + "\n\t2.Remove contact"
                + "\n\t3.Update contact"
                + "\n\t4.Search for contact"
                + "\n\t5.Print contact list"
                + "\n\t6.Print availabe options"
                + "\n\t0.Quit program");
    }

    public static void addContact() {
        System.out.print("Enter contact name:");
        String name = sc.nextLine();
        System.out.print("Enter contact phone number:");
        String phoneNumber = sc.nextLine();
        if(mb.addContact(name, phoneNumber)) {
            System.out.println("Contact " + name + " has been added successfully.");
        }else{
            System.out.println(name + " is already on the list.");
        }
    }

    public static void removeContact() {
        System.out.print("Enter contact name:");
        String name = sc.nextLine();
        if(mb.removeContact(name)) {
            System.out.println(name + " has been removed.");
        }else{
            System.out.println("Cannot find " + name + " on the list.");
        }
    }

    public static void updateContact() {
        System.out.print("Enter contact name:");
        String oldName = sc.nextLine();
        System.out.print("Enter new contact name:");
        String newName = sc.nextLine();
        System.out.print("Do you want to modify phoneNum? Type y/n");
        String choice = sc.nextLine();
        if(choice.equalsIgnoreCase("y")) {
            System.out.print("Enter new phone number:");
            String newPhoneNum = sc.nextLine();
            if(mb.modifyFullContact(oldName, newName, newPhoneNum)) {
                System.out.println("Contact " + oldName + " has been modified to:"
                        + "\nName: " + newName + "\nPhone number: " + newPhoneNum);
            }else {
                System.out.println("Couldn't find " + oldName + " on the contact list.");
            }
        }else {
            if(mb.modifyNameContact(oldName, newName)) {
                System.out.println("Contact " + oldName + " has been succesfully modified to " + newName);
            }else {
                System.out.println("Couldn't find " + oldName + " on the contact list.");
            }
        }
    }

    public static void queryContact() {
        System.out.print("Enter contact name:");
        String name = sc.nextLine();
        if(mb.queryContact(name)) {
            System.out.println(name + " is on the list.");
        }else {
            System.out.println("Couldn't find " + name + " on the contact list.");
        }
    }

}