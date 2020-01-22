package wagesystemPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Register extends Main {
    public static ArrayList<String> register(){
        Scanner scan = new Scanner(System.in);
        ArrayList<String> newUser = new ArrayList<String>();
        System.out.println("Please enter a username");
        String userName = scan.next();
        newUser.add(userName);
        System.out.println("Please enter a password");
        String passWord = scan.next();
        newUser.add(passWord);
        return newUser;
    }
}
