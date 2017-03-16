package ca.mogkolpon.mysqlite;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button signInBut,signUpBut;
    private MyAdmin myAdmin;
    private EditText userEditText, passwordEditText;
    private String userString, passwordString, passwordTrueString, nameString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Main หลัก
        myAdmin = new MyAdmin(MainActivity.this);
        bindWidget();
        buttonController();
    }
    private void buttonController() {
        signUpBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Admin_SingnUp.class));
            }
        });
        signInBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAuthen();
            }
        });
    }
    private void checkAuthen() {
        userString = userEditText.getText().toString().trim();
        passwordString = passwordEditText.getText().toString().trim();

        if (userString.equals("") || passwordString.equals("")) {           //เช็คค่า มีค่าว่างหรือไหม ถ้ามี ให้แจ้งเตือน  ไม่มีข้ามไป
            myDialog(getResources().getString(R.string.haveSpace));
        } else if (checkUser()) {                                           //เช็คค่า มี User นี้ หรือไหม  ให้แจ้งเตือน  ไม่มีข้ามไป
            myDialog(getResources().getString(R.string.userFalse));
        } else if (!passwordString.equals(passwordTrueString)) {            //เช็คค่า มี password นี้ หรือไหม  ให้แจ้งเตือน  ไม่มีข้ามไป
            myDialog(getResources().getString(R.string.passFalse));
        } else {                                                            //เช็คค่า ถ้ามี User, password ให้ขึ้น โชว์ Welcome แล้วไปที่หน้า popo
            myDialog("Welcome " + nameString);
            startActivity(new Intent(MainActivity.this, Popo.class));
        }
    }   // checkAuthen

    private boolean checkUser() {
        boolean result = true;  // true ==> User False
        try {
            //Connected SQLite
            SQLiteDatabase sqLiteDatabase = openOrCreateDatabase(MyData.database_name,MODE_PRIVATE,null);
            //Create Cursor ==> คือการเอาฐานข้อมูลไป ไปประมวลผลใน แรม
            Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM admin_db", null);
            cursor.moveToFirst();

            for (int i=0;i<cursor.getCount();i++) {
                if (userString.equals(cursor.getString(2))) {
                    result = false;
                    passwordTrueString = cursor.getString(3);
                    nameString = cursor.getString(1);
                }
                cursor.moveToNext();
            }   // for
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    private void myDialog(String string) {
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    private void bindWidget() {         //คือการผูกความสัมพันระหว่าง ตัวแปร และ ออปเจค บน Activity
        signInBut = (Button) findViewById(R.id.SignInbut);          //เชื่อม Button หน้าออกแบบ  id.SignInbut
        signUpBut = (Button) findViewById(R.id.SignUpbut);          //เชื่อม Button หน้าออกแบบ  id.SignUpbut
        userEditText = (EditText) findViewById(R.id.Username);      //เชื่อม EditText หน้าออกแบบ  id.Username
        passwordEditText = (EditText) findViewById(R.id.password);  //เชื่อม EditText หน้าออกแบบ  id.password
    }

    public void admin_show(View view) {
        Button btn_ok = (Button)findViewById(R.id.admin_show);
        Intent intent = new Intent(MainActivity.this,AdminShow.class);
        startActivity(intent);
    }
    public void sss(View view) {
        Button sss1 = (Button)findViewById(R.id.sss);
        Intent intent = new Intent(MainActivity.this,Popo.class);
        startActivity(intent);
    }

    //Detect Back Button ดักจับ ปุ่ม ออกจากระบบ ให้แจ้งเตือน ก่อน เริ่ม
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Confirm Exit...");
        alertDialog.setMessage("คุณต้องการออกจากโปรแกรมหรือไม่ ?");
        alertDialog.setIcon(R.drawable.user48);
        alertDialog.setPositiveButton("ใช่",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {
                        finish(); //คลิกใช่ ออกจากโปรแกรม
                        MainActivity.super.onBackPressed();
                    }
                });
        alertDialog.setNegativeButton("ไม่",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,	int which) {
                        dialog.cancel();//คลิกไม่ cancel dialog
                    }
                });
        alertDialog.show();
    }//Detect Back Button ดักจับ ปุ่ม ออกจากระบบ ให้แจ้งเตือน ก่อน จบ
}