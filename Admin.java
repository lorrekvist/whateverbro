package wagesystemPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin extends User {
    boolean isAdmin;
    int j;
    int menuInt;
    Scanner scan = new Scanner(System.in);

    public Admin(String userName, String role, int currentBank, int currentWage, boolean isAdmin) {
        super(userName, role, currentBank, currentWage);
        this.isAdmin = isAdmin;
    }

    public ArrayList<String> roleRequest(ArrayList<String> roleReq, ArrayList<String> approved){
        System.out.println(roleReq);
        System.out.println("Please enter the name of the users request you'd like to process.");
        String requestedUser = scan.next();
        for(int i = 0; i < roleReq.size(); i++){
            if(roleReq.get(i).equals(requestedUser)){
                j = i;
            }else{
                System.out.println("No such user found, please try again.");
                roleRequest(roleReq, approved);
            }
        }
        do {
            System.out.print(" please choose, 1 to approve role change, 2 to reject.");
            menuInt = scan.nextInt();
            try {
                System.out.println(menuInt);
            } catch (Exception InputMismatchException) {
                System.out.println("Invalid choice. You can only chose either 1 to approve role change, 2 to reject. ");
            }
                if (menuInt == 0) {
                    roleRequest(roleReq, approved);
                }
                switch(menuInt){
                    case 1:
                        System.out.println("You have chosen to approve " + roleReq.get(j) + "'s role change request. It will be added to the approved list and removed from the request list.");
                        approved.add(roleReq.get(j));
                        roleReq.remove(j);
                        return approved;
                    case 2:
                        System.out.println("You have chosen to reject " + roleReq.get(j) + "'s role change request. it will be removed from the request list.");
                        roleReq.remove(j);
                        return roleReq;
                }

    }while(menuInt != 3);
        return approved;
    }
    public ArrayList<String> raiseRequst(ArrayList<String> raiseReq, ArrayList<String> approved){
        System.out.println(raiseReq);
        System.out.println("Please enter the name of the users request you'd like to process.");
        String requestedUser = scan.next();
        for(int i = 0; i < raiseReq.size(); i++){
            if(raiseReq.get(i).equals(requestedUser)){
                j = i;
            }else{
                System.out.println("No such user found, please try again.");
                roleRequest(raiseReq, approved);
            }
        }
        do {
            System.out.print(" please choose, 1 to approve raise, 2 to reject.");
            menuInt = scan.nextInt();
            try {
                System.out.println(menuInt);
            } catch (Exception InputMismatchException) {
                System.out.println("Invalid choice. You can only chose either 1 to approve raise, 2 to reject. ");
            }
            if (menuInt == 0) {
                roleRequest(raiseReq, approved);
            }
            switch(menuInt){
                case 1:
                    System.out.println("You have chosen to approve " + raiseReq.get(j) + "'s raise request. It will be added to the approved list and removed from the request list.");
                    approved.add(raiseReq.get(j));
                    raiseReq.remove(j);
                    return approved;
                case 2:
                    System.out.println("You have chosen to reject " + raiseReq.get(j) + "'s raise request. it will be removed from the request list.");
                    raiseReq.remove(j);
                    return raiseReq;
            }

        }while(menuInt != 3);
        return approved;
    }
    public void register(ArrayList<String> userList, ArrayList<String> bankAccount, ArrayList<String> wageList){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a username");
        String userName = scan.next();
        userList.add(userName);
        System.out.println("Please enter a password");
        userList.add(scan.next());

        System.out.println("User is initiated with an empty bank account.");
        bankAccount.add(userName);
        bankAccount.add("0");

        System.out.println("What is this users monthly wage?");
        wageList.add(userName);
        wageList.add(scan.next());
    }

    public void pushWages(ArrayList<String> bankAccount, ArrayList<String> wageList){
        System.out.println(bankAccount);
        for(int i = 0; i < bankAccount.size(); i++) {
            if(bankAccount.get(i).equals(wageList.get(i))){
                int wage = Integer.parseInt(wageList.get(i+1));
                int bankAcc = Integer.parseInt(bankAccount.get(i+1));
                wage = wage + bankAcc;
                bankAccount.set(i+1, Integer.toString(wage));
                }

            }
        System.out.println(bankAccount);
        }
    }

