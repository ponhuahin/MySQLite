package ca.mogkolpon.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User-Gamer on 3/8/2017.
 */

public class MyName {
    private Context context;
    private MyData myData;                      //เรียก calss MyData มาใช้
    private SQLiteDatabase sqLiteDatabase;      //เรียก ฐานข้อมูล  มาใช้

    private static final String table_emp ="Employee_db";           //ตาราง พนักงาน

    private static final String emp_position = "Position_Emp";      //ตำแหน่ง         15
    private static final String emp_salary = "Salary_Emp";          //เงินเดือน        12
    private static final String emp_id = "ID_Emp";                  //รหัสบัตรประชาชน   1
    private static final String emp_name = "Name_Emp";              //ชื่อ          2
    private static final String emp_nickname = "Nickname_Emp";      //ชื่อเล่น         7
    private static final String emp_sex = "Sex_Emp";                //เพศ          3
    private static final String emp_datebirth = "DateBirth_Emp";    //วันเดือนปีเกิด      5
    private static final String emp_age = "Age_Emp";                //อายุ          4
    private static final String emp_address = "Address_Emp";        //ที่อยุ่          6
    private static final String emp_tel = "Tele_Emp";                //เบอร์โทร        8
    private static final String emp_line = "Line_Emp";              //ไลน์          9
    private static final String emp_facebook = "Facebook_Emp";      //Facebook    10
    private static final String emp_email = "Email_Emp";            //อีเมล          11
    private static final String emp_dateapp = "DateApp_Emp";        //วันที่สมัคร        13
    private static final String emp_image = "Image_Emp";            //รูป           14

    public MyName(Context context) {
        this.context = context;
        myData = new MyData(context);
        sqLiteDatabase = myData.getWritableDatabase();
    }   // Constructor

//    public long addNewValue(String strPosition_Emp, String strSalary_Emp, String strID_Emp,
//                            String strName_Emp, String strNickname_Emp, String strSex_Emp,
//                            String strDateBirth_Emp, String strAge_Emp, String strAddress_Emp,
//                            String strTel_Emp, String strLine_Emp, String strFacebook_Emp,
//                            String strEmail_Emp, String strDateApp_Emp, String strImage_Emp

    public long addNewValue(String strPosition_Emp,
                            String strSalary_Emp,
                            String strID_Emp,
                            String strName_Emp,
                            String strNickname_Emp,
                            String strSex_Emp,
                            String strDateBirth_Emp,
                            String strAge_Emp,
                            String strAddress_Emp,
                            String strTel_Emp,
                            String strLine_Emp,
                            String strFacebook_Emp,
                            String strEmail_Emp,
                            String strDateApp_Emp,
                            byte[] strImage_Emp
                            ) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(emp_position, strPosition_Emp);
        contentValues.put(emp_salary, strSalary_Emp);
        contentValues.put(emp_id, strID_Emp);
        contentValues.put(emp_name, strName_Emp);
        contentValues.put(emp_nickname, strNickname_Emp);
        contentValues.put(emp_sex, strSex_Emp);
        contentValues.put(emp_datebirth, strDateBirth_Emp);
        contentValues.put(emp_age, strAge_Emp);
        contentValues.put(emp_address, strAddress_Emp);
        contentValues.put(emp_tel, strTel_Emp);
        contentValues.put(emp_line, strLine_Emp);
        contentValues.put(emp_facebook, strFacebook_Emp);
        contentValues.put(emp_email, strEmail_Emp);
        contentValues.put(emp_dateapp, strDateApp_Emp);
        contentValues.put(emp_image, strImage_Emp);

        return sqLiteDatabase.insert(table_emp, null, contentValues);
    }
}
