package ca.mogkolpon.mysqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User-Gamer on 2/8/2017.
 */
public class MyData extends SQLiteOpenHelper   {
    static final String database_name = "SCSP.sqlite"; //สร้าง ฐานข้อมูล ชื่อ SCSP  ใน sqlite
    private static final int databasVersion=1;
    Context myContext;            //สร้าง myContext เพื่อรับค่าที่มาจาก Context

    private static final String tableCreateSQL = "CREATE TABLE admin_db ("+     //ตาราง ผู้รับเหมา
            "ID_admin INTEGER PRIMARY KEY AUTOINCREMENT,"+                            //ตั้ง id ให้รันเอง โดย กำหนด เป็น KEY AUTOINCREMENT
            "Name_admin TEXT,"+                     //ชื่อผู้ใช้ name  ชนิดเป็น TEXT
            "Username_admin TEXT,"+                  //ชื่อคอลัม  ผู้ใช้ Username  ชนิดเป็น TEXT
            "Password_admin TEXT"+                   //รหัสผ่าน Password  ชนิดเป็น TEXT
            ");";

    private static final String tableCreateSQL2 = "CREATE TABLE Employee_db ("+     //ตาราง พนักงาน
            "ID_Emp INTEGER PRIMARY KEY AUTOINCREMENT, "+                 //รหัสบัตรประชาชน   1
            "Name_Emp TEXT,"+               //ชื่อ          2
            "Sex_Emp TEXT, "+               //เพศ          3
            "Age_Emp TEXT, "+               //อายุ          4
            "DateBirth_Emp TEXT, "+         //วันเดือนปีเกิด      5
            "Address_Emp TEXT, "+           //ที่อยุ่          6
            "Nickname_Emp TEXT, "+          //ชื่อเล่น         7
            "Tele_Emp TEXT, "+               //เบอร์โทร        8
            "Line_Emp TEXT, "+              //ไลน์          9
            "Facebook_Emp TEXT, "+          //Facebook    10
            "Email_Emp TEXT, "+             //อีเมล          11
            "Salary_Emp TEXT, "+            //เงินเดือน        12
            "DateApp_Emp TEXT, "+           //วันที่สมัคร        13
            "Image_Emp BLOB,"+                //รูป           14
            "Position_Emp TEXT"+             //ตำแหน่ง         15
            ");";

    private static final String tableCreateSQL3 = "CREATE TABLE Workoff_db ("+     //ตาราง ทำงาน
            "ID_Workoff INTEGER PRIMARY KEY AUTOINCREMENT, "+        //ID รัน AUTOINCREMENT
            "Workoff_Workoff TEXT, "+          //ทำงาน / หยุด
            "ID_Job_Workoff int, "+            //ID งาน
            "DateWork_Workoff Date, "+         //เวลาทำงาน
            "DateOut_Workoff Date, "+          //เวลาเลิกงาน
            "ID_Employee_Workoff int, "+       //ID พนักงาน
            "DateApp_Workoff Date"+          //วันที่บันทึก
            ");";

    private static final String tableCreateSQL4 = "CREATE TABLE Job_db ("+     //ตาราง รับงาน
            "ID_Job INTEGER PRIMARY KEY AUTOINCREMENT, "+        //ID รัน AUTOINCREMENT
            "Job_Job TEXT, "+                 //ชื่แงาน
            "ID_Company_Job int, "+           //ID บริษัท
            "Money_Job int, "+                //เงิน
            "DateDue_Job Date, "+             //กำหนดส่งงาน
            "Specs_Job TEXT, "+               //รายละเอียดงาน
            "Getjob_Job Date"+              //วันที่บันทึก รับงาน
            ");";

    private static final String tableCreateSQL5 = "CREATE TABLE Company_db ("+     //ตาราง รับงาน
            "ID_Company INTEGER PRIMARY KEY AUTOINCREMENT, "+        //ID รัน AUTOINCREMENT
            "Company_Company TEXT, "+         //ชื่อบริษัท
            "Address_Company TEXT, "+         //ที่อยุ่ บริษัท
            "Telename_Company int, "+         //เบอร์โทร
            "Line_Company TEXT, "+            //ไลน์
            "Facebook_Company TEXT, "+        //Facebook
            "Email_Company TEXT, "+           //อีเมล
            "DateApp_Company Date"+         //วันที่บันทึก
            ");";

    private static final String tableCreateSQL6 = "CREATE TABLE Withdraw_db ("+     //ตาราง รับงาน
            "ID_Withdraw INTEGER PRIMARY KEY AUTOINCREMENT, "+        //ID รัน AUTOINCREMENT
            "Withdraw_Withdraw TEXT,"+         //เบิกเงิน
            "ID_Employee_Withdraw int"+       //ID พนักงาน
            "DateApp_Withdraw Date"+          //วันที่บันทึก
            ");";

    public MyData(Context context) {
        super(context, database_name, null, databasVersion);
        this.myContext = context;
    }



    // เรียก MyData แล้ว ยังไม่มีฐานข้อมูล  จะมาบรรทัดนี้
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(tableCreateSQL);
//        String insertData1 = "INSERT INTO admin_db (Name_admin,Username_admin,Password_admin) VALUES ('admin','ponhuahin','77987798');";
//       // คำสั่ง INSERT เพื่มข้อมูล ในตาราง admin_db ในคอลัม Username ข้อมูลที่ใส่คือ admin
//        db.execSQL(insertData1);

        db.execSQL(tableCreateSQL2);
//            String insertData2 = "INSERT INTO Employee_db (Nickname_Employee) VALUES ('ponhuahin');";
//            // คำสั่ง INSERT เพื่มข้อมูล ในตาราง admin_db ในคอลัม Username ข้อมูลที่ใส่คือ admin
//            db.execSQL(insertData2);
        db.execSQL(tableCreateSQL3);
        db.execSQL(tableCreateSQL4);
        db.execSQL(tableCreateSQL5);
        db.execSQL(tableCreateSQL6);

        //ทดสอบ  ฐานข้อมูล โดย ใส่ข้อมูล ลงไป
        //String insertData1 = "INSERT INTO admin_db (Username) VALUES ('admin');";
        //คำสั่ง INSERT เพื่มข้อมูล ในตาราง admin_db ในคอลัม Username ข้อมูลที่ใส่คือ admin
        //db.execSQL(insertData1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}

