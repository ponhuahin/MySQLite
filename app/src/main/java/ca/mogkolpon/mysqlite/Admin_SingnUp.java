package ca.mogkolpon.mysqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by User-Gamer on 2/8/2017.
 */
public class Admin_SingnUp extends AppCompatActivity {
    private EditText nameEditText, userEditText, passwordEditText;
    private Button button;
    private String nameString, userString, passwordString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin__singn_up);
////////////////////////////////////////////////////////
        bindWidget();
        buttonController();
    //  ปุ่ม ยกเลิก เริ่ม
        Button delBtn = (Button)findViewById(R.id.SignInbut_cancel);                      // ปุ่ม ลบ   สร้าง delBtn เพิ่มรับค่าจาก delete_btn  น่าออกแบบ
        delBtn.setOnClickListener(new View.OnClickListener() {                      //
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    //  ปุ่ม ยกเลิก จบ
    }   // Main Method
    private void buttonController() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get Value From Edit Text
                nameString = nameEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
                //Check Space
                if (nameString.equals("") || userString.equals("") || passwordString.equals("")) {
                    //Have Space
                    Toast.makeText(Admin_SingnUp.this,
                            getResources().getString(R.string.haveSpace),
                            Toast.LENGTH_SHORT).show();
                } else {
                    //No Space
                    MyAdmin myAdmin = new MyAdmin(Admin_SingnUp.this);
                    myAdmin.addNewValue(nameString, userString, passwordString);
                    finish();
                }   // if
            }   // onClick
        });
    }   // buttonController
    private void bindWidget() {                 //คือการผูกความสัมพันระหว่าง ตัวแปร และ ออปเจค บน Activity  เชื่อมต่อ  หน้าออกแบบ admin_singn_up
        nameEditText = (EditText) findViewById(R.id.Name2);         //เชื่อม EditText หน้าออกแบบ  id.Name2
        userEditText = (EditText) findViewById(R.id.Username2);     //เชื่อม EditText หน้าออกแบบ  id.Username2
        passwordEditText = (EditText) findViewById(R.id.Password2); //เชื่อม EditText หน้าออกแบบ  id.Password2
        button = (Button) findViewById(R.id.SignInbut2);            //เชื่อม button หน้าออกแบบ   id.SignInbut2

    }


}   // Main Class