package ca.mogkolpon.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by User-Gamer on 3/16/2017.
 */

public class Job_ListView_DAO {
    private SQLiteDatabase database;    //เรียกใช้ คราด SQLiteDatabase ตั้งชื่อเป็น database
    private MyData myData;         //เรียกใช้ MyData ที่สร้างไวใน MyData.java

    public Job_ListView_DAO(Context context){        //เพื่อเรียกใช้ Job_ListView_DAO จะเอา Context มาใช้ต่อ แล้ว ส่งต่อไปที่ MyData
        myData = new MyData(context);       //ส่งต่อ
    }
    public  void open(){            //เปิดฐานข้อมูล
        database = myData.getWritableDatabase();  //เปิดมาเพื่อแก้ไข getWritableDatabase  หรือ เปิดอ่านอย่างเดียว getReadableDatabase
    }
    public void close(){            //ปิดฐานข้อมูล
        myData.close();
    }

    public ArrayList<Todo_JOB> getAllTodoList(){
        ArrayList<Todo_JOB>todo_JOB =new ArrayList<Todo_JOB>();
        Cursor cursor = database.rawQuery("SELECT * FROM Job_db;",null);  //ดึงข้อมูลมาแสดงListView
        cursor.moveToFirst();       //ให้อยุ่ในเลกคอดเซด แรก
        Todo_JOB Todo_JOB1;
        while (!cursor.isAfterLast()){  //วนลูบ เลกคอดแรก ถึง เลกคอดสุดท้าย
            Todo_JOB1 = new Todo_JOB();
            Todo_JOB1.setID_Job(cursor.getInt(0));                  //id
            Todo_JOB1.setName_Job(cursor.getString(1));             //ชื่องาน
            Todo_JOB1.setAddress_Job(cursor.getString(2));          //ที่อยุ่งาน
            Todo_JOB1.setMoney_Job(cursor.getString(3));            //เงิน
            Todo_JOB1.setDateGet_Job(cursor.getString(4));          //วันที่รับงาน
            Todo_JOB1.setDateDue_Job(cursor.getString(5));          //วันที่บันทึก
            Todo_JOB1.setSpecs_Job(cursor.getString(6));            //รายละเอียดงาน
            Todo_JOB1.setName_Com_Job(cursor.getString(7));         //ชื่อบริษัท
            Todo_JOB1.setAddress_Com_Job(cursor.getString(8));      //ที่อยู่บริษััท
            Todo_JOB1.setTele_Job(cursor.getString(9));             //เบอร์โทร
            Todo_JOB1.setLine_Job(cursor.getString(10));            //ไลน์
            Todo_JOB1.setFacebook_Job(cursor.getString(11));        //เฟส
            Todo_JOB1.setEmail_Job(cursor.getString(12));           //อีเมล
            Todo_JOB1.setDateApp_Job(cursor.getString(13));         //วันที่ บันทึก

            todo_JOB.add(Todo_JOB1);
            cursor.moveToNext();
        }
        cursor.close();     //ปิด
        return todo_JOB;    //รีเทอนกับ
    }
    //      เริ่ม   แก้ไข ข้อมูล
    public void update(Todo_JOB todo_job){
        Todo_JOB updateTodo_JOB = todo_job;
        ContentValues values = new ContentValues();
        values.put("Name_Job",updateTodo_JOB.getName_Job());
        values.put("Address_Job",updateTodo_JOB.getAddress_Job());
        values.put("Money_Job",updateTodo_JOB.getMoney_Job());

        values.put("DateGet_Job",updateTodo_JOB.getDateGet_Job());
        values.put("DateDue_Job",updateTodo_JOB.getDateDue_Job());
        values.put("Specs_Job",updateTodo_JOB.getSpecs_Job());

        values.put("Name_Com_Job",updateTodo_JOB.getName_Com_Job());
        values.put("Address_Com_Job",updateTodo_JOB.getAddress_Com_Job());
        values.put("Tele_Job",updateTodo_JOB.getTele_Job());
        values.put("Line_Job",updateTodo_JOB.getLine_Job());
        values.put("Facebook_Job",updateTodo_JOB.getFacebook_Job());
        values.put("Email_Job",updateTodo_JOB.getEmail_Job());

        values.put("ID_Job",updateTodo_JOB.getID_Job());

        String where = "ID_Job=" + updateTodo_JOB.getID_Job();
        this.database.update("Job_db",values, where,null);
        Log.d("Todo updateTodoList","okokokokokok");        //เมื่อกดแล้ว ให้ขึ้น โชว์บอก
    }//  จบ แก้ไข ข้อมูล
//
    //  เริ่ม   ลบ ข้อมูล
    public void delete(Todo_JOB todo_job){
        Todo_JOB delTodo_JOB = todo_job;
        String sqlText = "DELETE FROM Job_db WHERE ID_Job=" + delTodo_JOB.getID_Job();
        this.database.execSQL(sqlText);
    }//  จบ ลบ ข้อมูล
}
