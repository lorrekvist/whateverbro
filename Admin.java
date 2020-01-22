package wagesystemPackage;

public class Admin extends User {
    boolean isAdmin;

    public Admin(String userName, String role, int currentBank, int currentWage, boolean isAdmin) {
        super(userName, role, currentBank, currentWage);
        this.isAdmin = isAdmin;
    }


}
