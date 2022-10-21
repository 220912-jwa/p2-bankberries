package com.bankberry.entities;

public class User {
   private int accessNumber;
   private String firstName;
   private String lastName;
   private String email;
   private String pass;
   private int ckId;
   private int svngId;


    public User() {
    }

    public User(int accessNumber, String firstName, String lastName, String email, String pass, int ckId, int svngId) {
        this.accessNumber = accessNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.pass = pass;
        this.ckId = ckId;
        this.svngId = svngId;

    }

    public int getAccessNumber() {
        return accessNumber;
    }

    public void setAccessNumber(int accessNumber) {
        this.accessNumber = accessNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getCkId() {
        return ckId;
    }

    public void setCkId(int ckId) {
        this.ckId = ckId;
    }

    public int getSvngId() {
        return svngId;
    }

    public void setSvngId(int svngId) {
        this.svngId = svngId;
    }



    @Override
    public String toString() {
        return "User{" +
                "accessNumber=" + accessNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", ckId=" + ckId +
                ", svngId=" + svngId +

                '}';
    }
}
