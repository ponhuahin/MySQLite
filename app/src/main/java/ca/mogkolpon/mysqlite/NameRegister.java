package ca.mogkolpon.mysqlite;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.Calendar;

/**
 * Created by User-Gamer on 2/24/2017.
 */

public class NameRegister extends AppCompatActivity {
    MyData myData;
    /////////////////////////////
    private EditText Position_Emp, Salary_Emp, ID_Emp, Name_Emp, Nickname_Emp, DateBirth_Emp, Age_Emp, Address_Emp, Tel_Emp, Line_Emp, Facebook_Emp, Email_Emp;
    private Button Name_Reg_But_Save, Name_Reg_But;
    private String position_emp, salary_emp, id_emp, name_emp, nickname_emp, datebirth_emp, age_emp,
            address_emp, tel_emp, line_emp, facebook_emp, email_emp, image_emp, dateapp_emp, imagePathString, imageNameString;
    String Sex_Emp0 = "ชาย";
    private ImageView imageView;
    DatePickerDialog datePickerDialog;
    private boolean statusABoolean = true;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_register);

///////////////
        bindWidget();
        buttonController();

        // ดำเนินการจัดกิจกรรมคลิกที่แก้ไขข้อความ
        DateBirth_Emp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // ดำเนินการจัดกิจกรรมคลิกที่แก้ไขข้อความ
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // ปีนี้
                int mMonth = c.get(Calendar.MONTH); // เดือนนี้
                int mDay = c.get(Calendar.DAY_OF_MONTH); // วันที่ปัจจุบัน
                // โต้ตอบตัวเลือกวันที่
                datePickerDialog = new DatePickerDialog(NameRegister.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        // กำหนดวันเดือน, เดือนปีและความคุ้มค่าในการแก้ไขข้อความ
                        DateBirth_Emp.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                        //address.setText((dayOfMonth-dayOfMonth) + "" + (monthOfYear - monthOfYear) + "" + (2017-year));
                        //pp=((dayOfMonth-dayOfMonth) + "" + (monthOfYear - monthOfYear) + "" + (c.get(Calendar.YEAR)-year));
                        Age_Emp.setText((c.get(Calendar.YEAR) - year) + "" + (monthOfYear - monthOfYear) + "" + (dayOfMonth - dayOfMonth));
                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
                dateapp_emp = (mDay + "/" + mMonth + "/" + mYear);
            }
        });
///////////////

        //ImageView Controller
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "โปรดเลือกรูปภาพ"), 1);
            }   // onClick
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 1) && (resultCode == RESULT_OK)) {
            Log.d("SutFriendV1", "Result ==> Success");
            //Find Path of Image
            Uri uri = data.getData();
            imagePathString = myFindPath(uri);
            Log.d("SutFriendV1", "imagePathString ==> " + imagePathString);
            //Setup ImageView
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver()
                        .openInputStream(uri));
                imageView.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
            statusABoolean = false;
            imageNameString = imagePathString.substring(imagePathString.lastIndexOf("/"));
            Log.d("SutFriendV1", "imageNameSting ==> " + imageNameString);
        }   // if
    }   // onActivityResult

    private String myFindPath(Uri uri) {
        String strResult = null;
        String[] strings = {MediaStore.Images.Media.DATA};
        Cursor cursor = getContentResolver().query(uri, strings, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            int index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            strResult = cursor.getString(index);
        } else {
            strResult = uri.getPath();
        }
        return strResult;
    }
    private byte[] imageViewToByte(ImageView imageView) {
        Bitmap bitmap = ((BitmapDrawable)imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
    public void RadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.Sex_Emp1:
                if (checked)
                    Sex_Emp0 = "หญิง";
                break;
            case R.id.Sex_Emp2:
                if (checked)
                    Sex_Emp0 = "ชาย";
                break;
        }
    }

    //////////////////////
    private void buttonController() {
        Name_Reg_But_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position_emp = Position_Emp.getText().toString().trim();        //ตำแหน่ง  15
                salary_emp = Salary_Emp.getText().toString().trim();            //เงินเดือน     12
                id_emp = ID_Emp.getText().toString().trim();                    //รหัสบัตรประชาชน   1
                name_emp = Name_Emp.getText().toString().trim();                //ชื่อ               2
                nickname_emp = Nickname_Emp.getText().toString().trim();        //ชื่อเล่น             7
                datebirth_emp = DateBirth_Emp.getText().toString().trim();      //วัน เดือน ปี เกิด      5
                age_emp = Age_Emp.getText().toString().trim();                  //อายุ               4
                address_emp = Address_Emp.getText().toString().trim();          //ที่อยู่               6
                tel_emp = Tel_Emp.getText().toString().trim();                  //เบอร์โทร            8
                line_emp = Line_Emp.getText().toString().trim();                //ไลน์               9
                facebook_emp = Facebook_Emp.getText().toString().trim();        //เฟส               10
                email_emp = Email_Emp.getText().toString().trim();              //อีเมล              11
                imageViewToByte(imageView);

                if (position_emp.equals("") ||              //ตำแหน่ง           15
                        salary_emp.equals("") ||           //เงินเดือน           12
                        id_emp.equals("") ||              //รหัสบัตรประชาชน     1
                        name_emp.equals("") ||              //ชื่อ               2
                        nickname_emp.equals("") ||          //ชื่อเล่น             7
                        datebirth_emp.equals("") ||         //วัน เดือน ปี เกิด      5
                        address_emp.equals("") ||            //ที่อยู่               6
                        tel_emp.equals("")) {              //เบอร์โทร            8
                    Toast.makeText(NameRegister.this, getResources().getString(R.string.haveSpace), Toast.LENGTH_SHORT).show();
                } else {
                    MyName myName = new MyName(NameRegister.this);
                    myName.addNewValue(position_emp,
                            salary_emp,
                            id_emp,
                            name_emp,
                            nickname_emp,
                            Sex_Emp0,
                            datebirth_emp,
                            age_emp,
                            address_emp,
                            tel_emp,
                            line_emp,
                            facebook_emp,
                            email_emp,
                            dateapp_emp,
                            imageViewToByte(imageView)
                    );
                    finish();
                }   // if
            }   // onClick

        });
    }   // buttonController


    private void bindWidget() {                 //คือการผูกความสัมพันระหว่าง ตัวแปร และ ออปเจค บน Activity  เชื่อมต่อ  หน้าออกแบบ admin_singn_up
        Position_Emp = (EditText) findViewById(R.id.Position_Emp);      //ตำแหน่ง           15
        Salary_Emp = (EditText) findViewById(R.id.Salary_Emp);          //เงินเดือน           12
        ID_Emp = (EditText) findViewById(R.id.ID_Emp);                  //รหัสบัตรประชาชน     1
        Name_Emp = (EditText) findViewById(R.id.Name_Emp);              //ชื่อ               2
        Nickname_Emp = (EditText) findViewById(R.id.Nickname_Emp);      //ชื่อเล่น             7
        imageView = (ImageView) findViewById(R.id.Image_Emp);             //รูป               14
        DateBirth_Emp = (EditText) findViewById(R.id.DateBirth_Emp);    //วัน เดือน ปี เกิด      5
        Age_Emp = (EditText) findViewById(R.id.Age_Emp);                //อายุ               4
        Address_Emp = (EditText) findViewById(R.id.Address_Emp);        //ที่อยู่               6
        Tel_Emp = (EditText) findViewById(R.id.Tel_Emp);                //เบอร์โทร            8
        Line_Emp = (EditText) findViewById(R.id.Line_Emp);              //ไลน์               9
        Facebook_Emp = (EditText) findViewById(R.id.Facebook_Emp);      //เฟส               10
        Email_Emp = (EditText) findViewById(R.id.Email_Emp);            //อีเมล              11

        Name_Reg_But_Save = (Button) findViewById(R.id.Name_Reg_But_Save);            //เชื่อม button หน้าออกแบบ   id.SignInbut2
        Name_Reg_But = (Button) findViewById(R.id.Name_Reg_But);

    }
    /////////////////////////

}
