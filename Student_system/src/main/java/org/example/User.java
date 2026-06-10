package org.example;

public class User {
    private String UserName;
    private String Password;
    private String IDNumber;
    private String PhoneNumber;


    public User() {
    }

    public User(String UserName, String Password, String IDNumber, String PhoneNumber) {
        this.UserName = UserName;
        this.Password = Password;
        this.IDNumber = IDNumber;
        this.PhoneNumber = PhoneNumber;
    }

    /**
     * 获取
     * @return UserName
     */
    public String getUserName() {
        return UserName;
    }

    /**
     * 设置
     * @param UserName
     */
    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    /**
     * 获取
     * @return Password
     */
    public String getPassword() {
        return Password;
    }

    /**
     * 设置
     * @param Password
     */
    public void setPassword(String Password) {
        this.Password = Password;
    }

    /**
     * 获取
     * @return IDNumber
     */
    public String getIDNumber() {
        return IDNumber;
    }

    /**
     * 设置
     * @param IDNumber
     */
    public void setIDNumber(String IDNumber) {
        this.IDNumber = IDNumber;
    }

    /**
     * 获取
     * @return PhoneNumber
     */
    public String getPhoneNumber() {
        return PhoneNumber;
    }

    /**
     * 设置
     * @param PhoneNumber
     */
    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String toString() {
        return "User{UserName = " + UserName + ", Password = " + Password + ", IDNumber = " + IDNumber + ", PhoneNumber = " + PhoneNumber + "}";
    }
}
