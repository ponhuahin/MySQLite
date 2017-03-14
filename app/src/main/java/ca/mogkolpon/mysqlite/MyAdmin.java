package ca.mogkolpon.mysqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by User-Gamer on 2/8/2017.
 */
public class MyAdmin {
    private Context context;
    private MyData myData;                      //เรียก calss MyData มาใช้
    private SQLiteDatabase sqLiteDatabase;      //เรียก ฐานข้อมูล  มาใช้
    private static final String user_table = "admin_db";
    private static final String column_id = "ID_admin";

    private static final String column_name = "Name_admin";
    private static final String column_user = "Username_admin";
    private static final String column_pass = "Password_admin";

    public MyAdmin(Context context) {
        this.context = context;
        myData = new MyData(context);
        sqLiteDatabase = myData.getWritableDatabase();
    }   // Constructor

    public long addNewValue(String strName, String strUser, String strPassword) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(column_name, strName);
        contentValues.put(column_user, strUser);
        contentValues.put(column_pass, strPassword);
        return sqLiteDatabase.insert(user_table, null, contentValues);
    }
}
