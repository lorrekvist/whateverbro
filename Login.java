package wagesystemPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Login extends Main{
    public static String[] login(ArrayList<String> adminList, ArrayList<String> regUserList, ArrayList<String> adminBankAccounts, ArrayList<String> bankAccounts, ArrayList<String> adminWageList, ArrayList<String> wageList, int loginType) {
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
                                    String[] regularUser = { userName, "employee", bankVal, wageVal };
                                    return regularUser;
                                }
                            }
                        }


                    }
                }
                System.out.println("You have either logged in with the wrong credentials or attempted to login as a user you are not, i.e. attempted to login as Admin when you are not.");
                return emptyArr;
            }
        }

