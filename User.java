package wagesystemPackage;

public class User extends Main{
    String userName;
    String role;
    int currentBank;
    int currentWage;

    public User(String userName, String role, int currentBank, int currentWage) {
        this.userName = userName;
        this.role = role;
        this.currentBank = currentBank;
        this.currentWage = currentWage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getCurrentBank() {
        return currentBank;
    }

    public void setCurrentBank(int currentBank) {
        this.currentBank = currentBank;
    }

    public int getCurrentWage() {
        return currentWage;
    }

    public void setCurrentWage(int currentWage) {
        this.currentWage = currentWage;
    }
}
