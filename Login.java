package wagesystemPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Login extends Main {
    ArrayList<String> adminList = new ArrayList<String>();
    ArrayList<String> regUserList = new ArrayList<String>();
    ArrayList<String> adminBankAccounts = new ArrayList<String>();
    ArrayList<String> bankAccounts = new ArrayList<String>();
    ArrayList<String> adminWageList = new ArrayList<String>();
    ArrayList<String> wageList = new ArrayList<String>();
    ArrayList<String> roleRequests = new ArrayList<String>();
    ArrayList<String> raiseRequest = new ArrayList<String>();
    ArrayList<String> approvedRoleRequests = new ArrayList<String>();
    ArrayList<String> approvedRaiseRequests = new ArrayList<String>();
    Scanner scan = new Scanner(System.in);
    int menuInt = 0;
    int loginType = 0;

    protected void start() {
        adminList.add(0, "admin1");
        adminList.add(1, "admin1234");

        regUserList.add(0, "madlad");
        regUserList.add(1, "madlad1234");
        regUserList.add(0, "madlass");
        regUserList.add(1, "madlass1234");

        adminBankAccounts.add(0, "admin1");
        adminBankAccounts.add(1, "50000");

        adminWageList.add(0, "admin1");
        adminWageList.add(1, "35000");

        bankAccounts.add(0, "madlad");
        bankAccounts.add(1, "33000");
        bankAccounts.add(0, "madlass");
        bankAccounts.add(1, "38000");


        wageList.add(0, "madlad");
        wageList.add(1, "27500");
        wageList.add(0, "madlass");
        wageList.add(1, "25500");

        roleRequests.add(0, "madlad");
        raiseRequest.add(0, "madlad");

        do {
            System.out.print("Welcome, please choose, 1 for Admin login, 2 for Regular user, 3 to Quit.");
            try {
                menuInt = scan.nextInt();
            } catch (Exception InputMismatchException) {
                System.out.println("Invalid choice. You can only chose either 1 for Admin or 2 for Regular, 3 to Quit.: ");
                if (menuInt == 0) {
                    start();
                }
            }


            switch (menuInt) {
                case 1:
                    loginType = 1;
                    System.out.println("1 was pressed");
                    String[] currentAdmin = login(adminList, regUserList, adminBankAccounts, bankAccounts, adminWageList, wageList, loginType);
                    Admin admin = new Admin(currentAdmin[0], currentAdmin[1], Integer.parseInt(currentAdmin[2]), Integer.parseInt(currentAdmin[3]), true);
                    do {
                        System.out.print("Welcome, please choose, 1 bank value, 2 wage, 3 role, 4 delete an account, 5 to manage role change requests, 6 to manage wage raise requests, 7 to create new account, 8 to push user wages 1 month, 9 to push admin wages 1 month, 0 to Quit ");
                        try {
                            menuInt = scan.nextInt();
                        } catch (Exception InputMismatchException) {
                            System.out.println("Invalid choice. You can only chose either 1 bank value, 2 wage, 3 role, 4 delete an account, 5 to manage role change requests, 6 to manage wage raise requests, 7 to create new account, 8 to push user wages 1 month, 9 to push admin wages 1 month, 0 to Quit ");
                        }
                        switch (menuInt) {
                            case 1:
                                System.out.println("Your current bank account is: " + admin.currentBank);
                                break;
                            case 2:
                                System.out.println("Your current wage is: " + admin.currentWage);
                                break;
                            case 3:
                                System.out.println("Your role is: " + admin.role);
                                break;
                            case 4:
                                System.out.println("To delete an account please enter the Username: ");
                                String userName = scan.next();
                                System.out.println("And password: ");
                                String passWord = scan.next();
                                deleteAccount(userName, passWord);
                                break;
                            case 5:
                                System.out.println("Role change requests: ");
                                admin.roleRequest(roleRequests, approvedRoleRequests);
                                System.out.println(approvedRoleRequests);
                                break;
                            case 6:
                                System.out.println("Wage change requests: ");
                                admin.raiseRequst(raiseRequest, approvedRaiseRequests);
                                System.out.println(approvedRaiseRequests);
                                break;
                            case 7:
                                System.out.println("Create new user: ");
                                admin.register(regUserList, bankAccounts, wageList);
                                System.out.println(regUserList);
                                break;
                            case 8:
                                System.out.println("Push user wages forward");
                                admin.pushWages(bankAccounts, wageList);
                        }
                    } while (menuInt != 0);
                    break;
                case 2:
                    loginType = 2;
                    String[] currentUser = login(adminList, regUserList, adminBankAccounts, bankAccounts, adminWageList, wageList, loginType);
                    System.out.println(loginType);
                    User user = new User(currentUser[0], currentUser[1], Integer.parseInt(currentUser[2]), Integer.parseInt(currentUser[3]));

                    do {
                        System.out.print("Welcome, please choose, 1 bank value, 2 wage, 3 role, 4 role change request, 5 raise request, 6 to delete your account, 7 to Quit.");
                        try {
                            menuInt = scan.nextInt();
                        } catch (Exception InputMismatchException) {
                            System.out.println("Invalid choice. You can only chose either 1 bank value, 2 wage, 3 role, 4 role change request, 5 raise request, 6 delete your account, 7 to Quit. ");
                        }
                        switch (menuInt) {
                            case 1:
                                System.out.println("Your current bank account is: " + user.currentBank);
                                break;
                            case 2:
                                System.out.println("Your current wage is: " + user.currentWage);
                                break;
                            case 3:
                                System.out.println("Your role is: " + user.role);
                                break;
                            case 4:
                                System.out.println("Your request for role change has been recieved. ");
                                roleRequests.add(user.userName);
                                break;
                            case 5:
                                System.out.println("Your request for a raise has been recieved. ");
                                raiseRequest.add(user.userName);
                                break;
                            case 6:
                                System.out.println("Delete your own account. Please enter username");
                                String userName = scan.next();
                                System.out.println("And password");
                                String passWord = scan.next();

                                    if (user.userName.equals(userName)) {
                                        int j = 0;
                                        for (int i = 0; i < regUserList.size(); i++) {
                                            if (regUserList.get(i).equals(userName)) {
                                                j = i;
                                            }
                                        }
                                        regUserList.remove(j + 1);
                                        regUserList.remove(j);
                                    }else {
                                        System.out.println("Incorrect login credentials.");
                                    }
                                }


                    } while (menuInt != 7);
                    break;


                case 3:
                    System.out.println("Thanks for using");
                    menuInt = 3;
                    break;

            }
        }while (menuInt != 3) ;
        }


        public String[] login
        (ArrayList < String > adminList, ArrayList < String > regUserList, ArrayList < String > adminBankAccounts, ArrayList < String > bankAccounts, ArrayList < String > adminWageList, ArrayList < String > wageList,
        int loginType){
            String userName;
            String passWord;
            String bankVal;
            String wageVal;
            String[] emptyArr = {" "};
            Scanner scan = new Scanner(System.in);
            System.out.println("Please enter username");
            userName = scan.next();
            System.out.println("Please enter password");
            passWord = scan.next();

            if (loginType == 1) {
                for (int i = 0; i < adminList.size(); i++) {
                    if (userName.equals(adminList.get(i)) && passWord.equals(adminList.get(i + 1))) {
                        System.out.println("Success! You are now logged in as Admin");
                        if (userName.equals(adminBankAccounts.get(i))) {
                            bankVal = adminBankAccounts.get(i + 1);
                            if (userName.equals(adminWageList.get(i))) {
                                wageVal = adminWageList.get(i + 1);
                                System.out.println(userName + " " + bankVal + " " + wageVal);
                                String[] admin = {userName, "admin", bankVal, wageVal};
                                return admin;
                            }
                        }
                    }
                }
            } else if (loginType == 2) {
                for (int i = 0; i < regUserList.size(); i++) {
                    if (userName.equals(regUserList.get(i)) && passWord.equals(regUserList.get(i + 1))) {
                        System.out.println("Success! You are now logged in as a regular user.");
                        if (userName.equals(bankAccounts.get(i))) {
                            bankVal = bankAccounts.get(i + 1);
                            if (userName.equals(wageList.get(i))) {
                                wageVal = wageList.get(i + 1);
                                System.out.println(userName + " " + bankVal + " " + wageVal);
                                String[] regularUser = {userName, "employee", bankVal, wageVal};
                                return regularUser;
                            }
                        }
                    }


                }
            }
            System.out.println("You have either logged in with the wrong credentials or attempted to login as a user you are not, i.e. attempted to login as Admin when you are not.");
            return emptyArr;
        }
        public void deleteAccount (String userName, String passWord){
            int k = 0;
            int j = 0;
            int l = 0;
            System.out.println(regUserList + " " + bankAccounts + " " + wageList);
            for (int i = 0; i < regUserList.size(); i++) {
                if (regUserList.get(i).equals(userName)) {
                    k = i;
                }
                if (bankAccounts.get(i).equals(userName)) {
                    j = i;
                }
                if (wageList.get(i).equals(userName)) {
                    l = i;
                }


            }
            regUserList.remove(k + 1);
            regUserList.remove(k);
            bankAccounts.remove(j + 1);
            bankAccounts.remove(j);
            wageList.remove(l + 1);
            wageList.remove(l);
            System.out.println(regUserList + " " + bankAccounts + " " + wageList);
        }
    }

