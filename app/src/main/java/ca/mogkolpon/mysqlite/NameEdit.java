package ca.mogkolpon.mysqlite;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import static ca.mogkolpon.mysqlite.R.id.imageView;

public class NameEdit extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_edit);

        final TodoList editTodoList = (TodoList) getIntent().getSerializableExtra("editTodoList");

//        final ImageView imageView = (ImageView) findViewById(R.id.Image_Emp);             //รูป               14

        final EditText Position_Emp = (EditText) findViewById(R.id.Position_Emp_edit);      //ตำแหน่ง           15
        final EditText Salary_Emp = (EditText) findViewById(R.id.Salary_Emp_edit);          //เงินเดือน           12
//        final EditText ID_Emp = (EditText) findViewById(R.id.ID_Emp_edit);                  //รหัสบัตรประชาชน     1
        final EditText Name_Emp = (EditText) findViewById(R.id.Name_Emp_edit);              //ชื่อ               2
        final EditText Nickname_Emp = (EditText) findViewById(R.id.Nickname_Emp_edit);      //ชื่อเล่น             7
        final EditText DateBirth_Emp = (EditText) findViewById(R.id.DateBirth_Emp_edit);    //วัน เดือน ปี เกิด      5
        final EditText Age_Emp = (EditText) findViewById(R.id.Age_Emp_edit);                //อายุ               4
        final EditText Address_Emp = (EditText) findViewById(R.id.Address_Emp_edit);        //ที่อยู่               6
        final EditText Tel_Emp = (EditText) findViewById(R.id.Tel_Emp_edit);                //เบอร์โทร            8
        final EditText Line_Emp = (EditText) findViewById(R.id.Line_Emp_edit);              //ไลน์               9
        final EditText Facebook_Emp = (EditText) findViewById(R.id.Facebook_Emp_edit);      //เฟส               10
        final EditText Email_Emp = (EditText) findViewById(R.id.Email_Emp_edit);            //อีเมล              11

        Position_Emp.setText(editTodoList.getPosition_Emp());
        Salary_Emp.setText(editTodoList.getSalary_Emp());
//        ID_Emp.setText(editTodoList.getID_Emp());
        Name_Emp.setText(editTodoList.getName_Emp());
        Nickname_Emp.setText(editTodoList.getNickname_Emp());
        DateBirth_Emp.setText(editTodoList.getDateBirth_Emp());
        Age_Emp.setText(editTodoList.getAge_Emp());
        Address_Emp.setText(editTodoList.getAddress_Emp());
        Tel_Emp.setText(editTodoList.getTele_Emp());
        Line_Emp.setText(editTodoList.getLine_Emp());
        Facebook_Emp.setText(editTodoList.getFacebook_Emp());
        Email_Emp.setText(editTodoList.getEmail_Emp());
//
//        byte[] image_Emp = TodoList.getImage_Emp();
//        Bitmap bitmap = BitmapFactory.decodeByteArray(image_Emp, 0, image_Emp.length);
//        imageView.setImageBitmap(bitmap);

//////////////////////////////
        imageView = (ImageView) findViewById(R.id.Image_Emp_edit);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(Intent.createChooser(intent, "โปรดเลือกรูปภาพ"), 1);
            }   // onClick
        });

//        Name_Reg_But_Save = (Button) findViewById(R.id.Name_Reg_But_Save);            //เชื่อม button หน้าออกแบบ   id.SignInbut2
//        Name_Reg_But = (Button) findViewById(R.id.Name_Reg_But);
//
//        final EditText editText = (EditText) findViewById(R.id.Name2_edit);
//        final EditText editText1 = (EditText) findViewById(R.id.Username2_edit);
//        final EditText editText2 = (EditText) findViewById(R.id.Password2_edit);
//        editText.setText(editTodoList.getName_admin());
//        editText1.setText(editTodoList.getUsername_admin());
//        editText2.setText(editTodoList.getPassword_admin());

//        // ปุ้ม แก้ไข ข้อมูล  //
//        final Button editBtn = (Button)findViewById(R.id.SignInbut2_edit);
//        editBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                TodoList eTodoList = new TodoList();                                  //สร้าง eTodoList ใหม่ เพื่มรับค่า editTodolist เดิม
//                eTodoList.setID_admin(editTodoList.getID_admin());                    // ใช้ eTodoList รับค่า editTodolist ที่ส่ง มา
//                eTodoList.setName_admin(String.valueOf(editText.getText()));          // แล้วเอา setTodoText ที่ได้มาจาก editText น่าออกแบบ
//                eTodoList.setUsername_admin(String.valueOf(editText1.getText()));
//                eTodoList.setPassword_admin(String.valueOf(editText2.getText()));
//
//                TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext()); //เชื่อมต่อ todoListDAO
//                todoListDAO.open();
//                todoListDAO.update(eTodoList);                                      //อัพเดก
//                todoListDAO.close();                                                //ปิด
//                finish();                                                           //เแก้ไข แล้ว ปิด หน้านี้
//            }
//        });
//
//        // ปุ้ม ลบ ข้อมูล  //
//        Button delBtn = (Button)findViewById(R.id.delete_btn);                      // ปุ่ม ลบ   สร้าง delBtn เพิ่มรับค่าจาก delete_btn  น่าออกแบบ
//        delBtn.setOnClickListener(new View.OnClickListener() {                      //
//            @Override
//            public void onClick(View v) {
//                TodoListDAO todoListDAODel =new TodoListDAO(getApplicationContext());
//                todoListDAODel.open();
//                todoListDAODel.delete(editTodoList);
//                todoListDAODel.close();
//                finish();
//            }
//        });
    }
}
