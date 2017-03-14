package ca.mogkolpon.mysqlite;

import android.content.Context;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by User-Gamer on 2/8/2017.
 */

//private int ID_admin,
//        ID_Emp,Tele_Emp,
//        ID_Workoff,ID_Job_Workoff,ID_Employee_Workoff,
//        ID_Job,ID_Company_Job,Money_Job,ID_Company,Telename_Company,ID_Withdraw,ID_Employee_Withdraw;
//
//private String Name,sss,Name_admin,Username_admin,Password_admin,
//        Name_Emp,Sex_Emp,Age_Emp,Address_Emp,Nickname_Emp,Line_Emp,Facebook_Emp,Email_Emp,Salary_Emp,Image_Emp,Position_Emp,
//        Workoff_Workoff,DateWork_Workoff,Job_Job,Specs_Job,
//        Company_Company,Address_Company,Line_Company,Facebook_Company,Email_Company,Withdraw_Withdraw;
//
//private Date DateBirth_Emp,DateApp_Emp,
//        DateOut_Workoff,DateApp_Workoff,
//        DateDue_Job,Getjob_Job,DateApp_Company,DateApp_Withdraw;

public class TodoList implements Serializable {
//    public TodoList(int ID_Emp, String name_Emp, String nickname_Emp, String age_Emp,
//                    byte[] image_Emp) {
//
//        this.ID_Emp = ID_Emp;
//        this.Name_Emp = name_Emp;
//        this.Nickname_Emp = nickname_Emp;
//        this.Age_Emp = age_Emp;
//        this.Image_Emp = image_Emp;
//    }

    public int getID_admin() {
        return ID_admin;
    }

    public void setID_admin(int ID_admin) {
        this.ID_admin = ID_admin;
    }

    public int getID_Emp() {
        return ID_Emp;
    }

    public void setID_Emp(int ID_Emp) {
        this.ID_Emp = ID_Emp;
    }

    public int getTele_Emp() {
        return Tele_Emp;
    }

    public void setTele_Emp(int tele_Emp) {
        Tele_Emp = tele_Emp;
    }

    public int getID_Workoff() {
        return ID_Workoff;
    }

    public void setID_Workoff(int ID_Workoff) {
        this.ID_Workoff = ID_Workoff;
    }

    public int getID_Job_Workoff() {
        return ID_Job_Workoff;
    }

    public void setID_Job_Workoff(int ID_Job_Workoff) {
        this.ID_Job_Workoff = ID_Job_Workoff;
    }

    public int getID_Employee_Workoff() {
        return ID_Employee_Workoff;
    }

    public void setID_Employee_Workoff(int ID_Employee_Workoff) {
        this.ID_Employee_Workoff = ID_Employee_Workoff;
    }

    public int getID_Job() {
        return ID_Job;
    }

    public void setID_Job(int ID_Job) {
        this.ID_Job = ID_Job;
    }

    public int getID_Company_Job() {
        return ID_Company_Job;
    }

    public void setID_Company_Job(int ID_Company_Job) {
        this.ID_Company_Job = ID_Company_Job;
    }

    public int getMoney_Job() {
        return Money_Job;
    }

    public void setMoney_Job(int money_Job) {
        Money_Job = money_Job;
    }

    public int getID_Company() {
        return ID_Company;
    }

    public void setID_Company(int ID_Company) {
        this.ID_Company = ID_Company;
    }

    public int getTelename_Company() {
        return Telename_Company;
    }

    public void setTelename_Company(int telename_Company) {
        Telename_Company = telename_Company;
    }

    public int getID_Withdraw() {
        return ID_Withdraw;
    }

    public void setID_Withdraw(int ID_Withdraw) {
        this.ID_Withdraw = ID_Withdraw;
    }

    public int getID_Employee_Withdraw() {
        return ID_Employee_Withdraw;
    }

    public void setID_Employee_Withdraw(int ID_Employee_Withdraw) {
        this.ID_Employee_Withdraw = ID_Employee_Withdraw;
    }

    public static byte[] getImage_Emp() {
        return Image_Emp;
    }

    public void setImage_Emp(byte[] image_Emp) {
        this.Image_Emp = image_Emp;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSss() {
        return sss;
    }

    public void setSss(String sss) {
        this.sss = sss;
    }

    public String getName_admin() {
        return Name_admin;
    }

    public void setName_admin(String name_admin) {
        Name_admin = name_admin;
    }

    public String getUsername_admin() {
        return Username_admin;
    }

    public void setUsername_admin(String username_admin) {
        Username_admin = username_admin;
    }

    public String getPassword_admin() {
        return Password_admin;
    }

    public void setPassword_admin(String password_admin) {
        Password_admin = password_admin;
    }

    public String getName_Emp() {
        return Name_Emp;
    }

    public void setName_Emp(String name_Emp) {
        Name_Emp = name_Emp;
    }

    public String getSex_Emp() {
        return Sex_Emp;
    }

    public void setSex_Emp(String sex_Emp) {
        Sex_Emp = sex_Emp;
    }

    public String getAge_Emp() {
        return Age_Emp;
    }

    public void setAge_Emp(String age_Emp) {
        Age_Emp = age_Emp;
    }

    public String getAddress_Emp() {
        return Address_Emp;
    }

    public void setAddress_Emp(String address_Emp) {
        Address_Emp = address_Emp;
    }

    public String getNickname_Emp() {
        return Nickname_Emp;
    }

    public void setNickname_Emp(String nickname_Emp) {
        Nickname_Emp = nickname_Emp;
    }

    public String getLine_Emp() {
        return Line_Emp;
    }

    public void setLine_Emp(String line_Emp) {
        Line_Emp = line_Emp;
    }

    public String getFacebook_Emp() {
        return Facebook_Emp;
    }

    public void setFacebook_Emp(String facebook_Emp) {
        Facebook_Emp = facebook_Emp;
    }

    public String getEmail_Emp() {
        return Email_Emp;
    }

    public void setEmail_Emp(String email_Emp) {
        Email_Emp = email_Emp;
    }

    public String getSalary_Emp() {
        return Salary_Emp;
    }

    public void setSalary_Emp(String salary_Emp) {
        Salary_Emp = salary_Emp;
    }

    public String getPosition_Emp() {
        return Position_Emp;
    }

    public void setPosition_Emp(String position_Emp) {
        Position_Emp = position_Emp;
    }

    public String getWorkoff_Workoff() {
        return Workoff_Workoff;
    }

    public void setWorkoff_Workoff(String workoff_Workoff) {
        Workoff_Workoff = workoff_Workoff;
    }

    public String getDateWork_Workoff() {
        return DateWork_Workoff;
    }

    public void setDateWork_Workoff(String dateWork_Workoff) {
        DateWork_Workoff = dateWork_Workoff;
    }

    public String getJob_Job() {
        return Job_Job;
    }

    public void setJob_Job(String job_Job) {
        Job_Job = job_Job;
    }

    public String getSpecs_Job() {
        return Specs_Job;
    }

    public void setSpecs_Job(String specs_Job) {
        Specs_Job = specs_Job;
    }

    public String getCompany_Company() {
        return Company_Company;
    }

    public void setCompany_Company(String company_Company) {
        Company_Company = company_Company;
    }

    public String getAddress_Company() {
        return Address_Company;
    }

    public void setAddress_Company(String address_Company) {
        Address_Company = address_Company;
    }

    public String getLine_Company() {
        return Line_Company;
    }

    public void setLine_Company(String line_Company) {
        Line_Company = line_Company;
    }

    public String getFacebook_Company() {
        return Facebook_Company;
    }

    public void setFacebook_Company(String facebook_Company) {
        Facebook_Company = facebook_Company;
    }

    public String getEmail_Company() {
        return Email_Company;
    }

    public void setEmail_Company(String email_Company) {
        Email_Company = email_Company;
    }

    public String getWithdraw_Withdraw() {
        return Withdraw_Withdraw;
    }

    public void setWithdraw_Withdraw(String withdraw_Withdraw) {
        Withdraw_Withdraw = withdraw_Withdraw;
    }

    public String getDateBirth_Emp() {
        return DateBirth_Emp;
    }

    public void setDateBirth_Emp(String dateBirth_Emp) {
        DateBirth_Emp = dateBirth_Emp;
    }

    public String getDateApp_Emp() {
        return DateApp_Emp;
    }

    public void setDateApp_Emp(String dateApp_Emp) {
        DateApp_Emp = dateApp_Emp;
    }

    public String getDateOut_Workoff() {
        return DateOut_Workoff;
    }

    public void setDateOut_Workoff(String dateOut_Workoff) {
        DateOut_Workoff = dateOut_Workoff;
    }

    public String getDateApp_Workoff() {
        return DateApp_Workoff;
    }

    public void setDateApp_Workoff(String dateApp_Workoff) {
        DateApp_Workoff = dateApp_Workoff;
    }

    public String getDateDue_Job() {
        return DateDue_Job;
    }

    public void setDateDue_Job(String dateDue_Job) {
        DateDue_Job = dateDue_Job;
    }

    public String getGetjob_Job() {
        return Getjob_Job;
    }

    public void setGetjob_Job(String getjob_Job) {
        Getjob_Job = getjob_Job;
    }

    public String getDateApp_Company() {
        return DateApp_Company;
    }

    public void setDateApp_Company(String dateApp_Company) {
        DateApp_Company = dateApp_Company;
    }

    public String getDateApp_Withdraw() {
        return DateApp_Withdraw;
    }

    public void setDateApp_Withdraw(String dateApp_Withdraw) {
        DateApp_Withdraw = dateApp_Withdraw;
    }

    private int ID_admin,
            ID_Emp, Tele_Emp,
            ID_Workoff, ID_Job_Workoff, ID_Employee_Workoff,
            ID_Job, ID_Company_Job, Money_Job, ID_Company, Telename_Company, ID_Withdraw, ID_Employee_Withdraw;

    private String Name, sss, Name_admin, Username_admin, Password_admin,
            Name_Emp, Sex_Emp, Age_Emp, Address_Emp, Nickname_Emp, Line_Emp, Facebook_Emp, Email_Emp, Salary_Emp, Position_Emp,
            Workoff_Workoff, DateWork_Workoff, Job_Job, Specs_Job,
            Company_Company, Address_Company, Line_Company, Facebook_Company, Email_Company, Withdraw_Withdraw,
            DateBirth_Emp, DateApp_Emp,
            DateOut_Workoff, DateApp_Workoff,
            DateDue_Job, Getjob_Job, DateApp_Company, DateApp_Withdraw;
    private static byte[] Image_Emp;


}
