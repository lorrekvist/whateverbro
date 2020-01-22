package wagesystemPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        start();
    }

    protected static void start() {
        ArrayList<String> adminList = new ArrayList<String>();
        ArrayList<String> regUserList = new ArrayList<String>();
        ArrayList<String> adminBankAccounts = new ArrayList<String>();
        ArrayList<String> bankAccounts = new ArrayList<String>();
        ArrayList<String> adminWageList = new ArrayList<String>();
        ArrayList<String> wageList = new ArrayList<String>();
        ArrayList<String> roleRequests = new ArrayList<String>();
        ArrayList<String> raiseRequest = new ArrayList<String>();
        adminList.add(0, "admin1");
        adminList.add(1, "admin1234");

        regUserList.add(0,"madlad");
        regUserList.add(1, "madlad1234");

        adminBankAccounts.add(0, "admin1");
        adminBankAccounts.add(1, "50000");

        adminWageList.add(0, "admin1");
        adminWageList.add(1, "35000");

        bankAccounts.add(0, "madlad");
        bankAccounts.add(1, "33000");

        wageList.add(0, "madlad");
        wageList.add(1, "27500");

        Scanner scan = new Scanner(System.in);
        int menuInt = 0;
        int loginType = 0;
        do{

            System.out.print("Welcome, please choose, 1 for Admin login, 2 for Regular user, 3 to Quit.");
            try{
                menuInt = scan.nextInt();
            }
            catch(Exception InputMismatchException){
                System.out.println("Invalid choice. You can only chose either 1 for Admin or 2 for Regular, 3 to Quit.: ");
                if (menuInt == 0) {
                    start();
                }
            }


            switch(menuInt){
                case 1:
                    loginType = 1;
                    System.out.println("1 was pressed");
                    String[] currentAdmin = Login.login(adminList, regUserList, adminBankAccounts, bankAccounts, adminWageList, wageList, loginType);
                    Admin admin = new Admin(currentAdmin[0], currentAdmin[1], Integer.parseInt(currentAdmin[2]), Integer.parseInt(currentAdmin[3]), true);
                    do {
                        System.out.print("Welcome, please choose, 1 bank value 3 to Quit.");
                        try {
                            menuInt = scan.nextInt();
                        } catch (Exception InputMismatchException) {
                            System.out.println("Invalid choice. You can only chose either 1 for Admin or 2 for Regular, 3 to Quit.: ");
                        }
                        switch(menuInt){
                            case 1:
                                System.out.println("Your current bank account is: " + admin.currentBank);
                            case 2:
                                System.out.println("Your current wage is: " + admin.currentWage);
                            case 3:
                                System.out.println("Your role is: " + admin.role);
                            case 4:
                                System.out.println("Your request for role change has been recieved. ");
                                roleRequests.add(admin.userName);
                            case 5:
                                System.out.println("Your request for a raise has been recieved. ");
                                raiseRequest.add(admin.userName);
                            case 6:
                                System.out.println("To delete your account please enter your Username: ");
                                String userName = scan.next();
                                System.out.println("And your password: ");
                                String passWord = scan.next();
                                //Method to delete
                        }
                    }while(menuInt != 7);

                    break;
                case 2:
                    loginType = 2;
                    String[] currentUser = Login.login(adminList, regUserList, adminBankAccounts, bankAccounts, adminWageList, wageList, loginType);
                    System.out.println(loginType);
                    User user = new User(currentUser[0], currentUser[1], Integer.parseInt(currentUser[2]), Integer.parseInt(currentUser[3]));

                    do {
                        System.out.print("Welcome, please choose, 1 bank value 3 to Quit.");
                        try {
                            menuInt = scan.nextInt();
                        } catch (Exception InputMismatchException) {
                            System.out.println("Invalid choice. You can only chose either 1 for Admin or 2 for Regular, 3 to Quit.: ");
                        }
                        switch(menuInt){
                            case 1:
                                System.out.println("Your current bank account is: " + user.currentBank);
                            case 2:
                                System.out.println("Your current wage is: " + user.currentWage);
                            case 3:
                                System.out.println("Your role is: " + user.role);
                            case 4:
                                System.out.println("Your request for role change has been recieved. ");
                                roleRequests.add(user.userName);
                            case 5:
                                System.out.println("Your request for a raise has been recieved. ");
                                raiseRequest.add(user.userName);
                            case 6:
                                System.out.println("To delete your account please enter your Username: ");
                                String userName = scan.next();
                                System.out.println("And your password: ");
                                String passWord = scan.next();
                                //Method to delete
                        }
                    }while(menuInt != 7);

                    break;
                case 3:
                    System.out.println("Thanks for using");
                    menuInt = 3;
                    break;

            }

        }while(menuInt!=3);
    }
    public static void adminSwitch(Object admin){
    }
    public static void userSwitch(Object user) {
        int menuInt = 0;
        Scanner scan = new Scanner(System.in);
        do {
        System.out.print("Welcome, please choose, 1 for Admin login, 2 for Regular user, 3 to Quit.");
        try {
            menuInt = scan.nextInt();
        } catch (Exception InputMismatchException) {
            System.out.println("Invalid choice. You can only chose either 1 for Admin or 2 for Regular, 3 to Quit.: ");
            if (menuInt == 0) {
                userSwitch(user);
            }
        }

        switch(menuInt){
            case 1:
                System.out.println("Your current bank account is: " + Arrays.toString(user.getClass().getFields()));
        }
    }while(menuInt != 4);
}



}
