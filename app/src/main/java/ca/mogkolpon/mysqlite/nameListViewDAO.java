package ca.mogkolpon.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by User-Gamer on 3/9/2017.
 */

public class nameListViewDAO {
    private SQLiteDatabase database;    //เรียกใช้ คราด SQLiteDatabase ตั้งชื่อเป็น database
    private MyData myData;         //เรียกใช้ DbHelper ที่สร้างไวใน DbHelper.java

    public nameListViewDAO(Context context){        //เพื่อเรียกใช้ TodoListDAO จะเอา Context มาใช้ต่อ แล้ว ส่งต่อไปที่ DbHelper
        myData = new MyData(context);       //ส่งต่อ
    }
    public  void open(){            //เปิดฐานข้อมูล
        database = myData.getWritableDatabase();  //เปิดมาเพื่อแก้ไข getWritableDatabase  หรือ เปิดอ่านอย่างเดียว getReadableDatabase
    }
    public void close(){            //ปิดฐานข้อมูล
        myData.close();
    }

    public ArrayList<TodoList> getAllTodoList(){
        ArrayList<TodoList>todoList =new ArrayList<TodoList>();
        Cursor cursor = database.rawQuery("SELECT * FROM Employee_db;",null);  //ดึงข้อมูลมาแสดงListView
        cursor.moveToFirst();       //ให้อยุ่ในเลกคอดเซด แรก
        TodoList todoList1;
        while (!cursor.isAfterLast()){  //วนลูบ เลกคอดแรก ถึง เลกคอดสุดท้าย
            todoList1 = new TodoList();
            todoList1.setID_Emp(cursor.getInt(0));            //รหัสประชาชน
            todoList1.setName_Emp(cursor.getString(1));         //ชื่อ-นามสกุล
            todoList1.setSex_Emp(cursor.getString(2));        //เพศ
            todoList1.setAge_Emp(cursor.getString(3));        //อายุ
            todoList1.setDateBirth_Emp(cursor.getString(4));  //วัน เดือน ปี เกิด
            todoList1.setAddress_Emp(cursor.getString(5));    //ที่อยุ่
            todoList1.setNickname_Emp(cursor.getString(6));   //ชื่อเล่น
            todoList1.setTele_Emp(cursor.getString(7));          //เบอร์โทร
            todoList1.setLine_Emp(cursor.getString(8));       //ไลน์
            todoList1.setFacebook_Emp(cursor.getString(9));   //เฟส
            todoList1.setEmail_Emp(cursor.getString(10));     //อีเมล
            todoList1.setSalary_Emp(cursor.getString(11));    //เงินเดือน
            todoList1.setDateApp_Emp(cursor.getString(12));   //วันที่บันทึก
            todoList1.setImage_Emp(cursor.getBlob(13));         //ภาพ   ////  ทำให้ แสดงภาพหลายภาพไม่ได้
            todoList1.setPosition_Emp(cursor.getString(14));    //ตำแหน่ง
            todoList.add(todoList1);
            cursor.moveToNext();
        }
        cursor.close();     //ปิด
        return todoList;    //รีเทอนกับ
    }


    //  เริ่ม   แก้ไข ข้อมูล
//    public void update(TodoList todoList){
//        TodoList updateTodoList = todoList;
//        ContentValues values = new ContentValues();
//        values.put("Name_admin",updateTodoList.getName_admin());
//        values.put("Username_admin",updateTodoList.getUsername_admin());
//        values.put("Password_admin",updateTodoList.getPassword_admin());
//        values.put("ID_admin",updateTodoList.getID_admin());
//
//        String where = "ID_admin=" + updateTodoList.getID_admin();
//        this.database.update("admin_db",values, where,null);
//        Log.d("Todo updateTodoList","okokokokokok");        //เมื่อกดแล้ว ให้ขึ้น โชว์บอก
//    }//  จบ แก้ไข ข้อมูล
//
//
//    //  เริ่ม   ลบ ข้อมูล
//    public void delete(TodoList todoList){
//        TodoList delTodolist = todoList;
//        String sqlText = "DELETE FROM admin_db WHERE ID_admin=" + delTodolist.getID_admin();
//        this.database.execSQL(sqlText);
//    }//  จบ ลบ ข้อมูล


}
