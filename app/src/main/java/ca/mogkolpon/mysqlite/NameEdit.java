package ca.mogkolpon.mysqlite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NameEdit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_edit);

        final TodoList editTodoList = (TodoList) getIntent().getSerializableExtra("editTodoList");

//        final ImageView imageView = (ImageView) findViewById(R.id.Image_Emp);             //รูป               14

        final EditText A1 = (EditText) findViewById(R.id.Idcard_Emp_edit);        //รหัสบัตรประชาชน     1
        final EditText A2 = (EditText) findViewById(R.id.Name_Emp_edit);            //ชื่อ               2
        final EditText A3 = (EditText) findViewById(R.id.Nickname_Emp_edit);        //ชื่อเล่น             3

        final EditText A5 = (EditText) findViewById(R.id.DateBirth_Emp_edit);       //วัน เดือน ปี เกิด      5
        final EditText A6 = (EditText) findViewById(R.id.Age_Emp_edit);             //อายุ               6
        final EditText A7 = (EditText) findViewById(R.id.Address_Emp_edit);         //ที่อยู่               7
        final EditText A8 = (EditText) findViewById(R.id.Tele_Emp_edit);             //เบอร์โทร            8
        final EditText A9 = (EditText) findViewById(R.id.Line_Emp_edit);            //ไลน์               9
        final EditText A10 = (EditText) findViewById(R.id.Facebook_Emp_edit);       //เฟส               10
        final EditText A11 = (EditText) findViewById(R.id.Email_Emp_edit);          //อีเมล              11
        final EditText A12 = (EditText) findViewById(R.id.Position_Emp_edit);        //ตำแหน่ง           12
        final EditText A13 = (EditText) findViewById(R.id.Salary_Emp_edit);          //เงินเดือน           13

        A1.setText(editTodoList.getIdcard_Emp());
        A2.setText(editTodoList.getName_Emp());
        A3.setText(editTodoList.getNickname_Emp());

        A5.setText(editTodoList.getDateBirth_Emp());
        A6.setText(editTodoList.getAge_Emp());
        A7.setText(editTodoList.getAddress_Emp());
        A8.setText(editTodoList.getTele_Emp());
        A9.setText(editTodoList.getLine_Emp());
        A10.setText(editTodoList.getFacebook_Emp());
        A11.setText(editTodoList.getEmail_Emp());
        A12.setText(editTodoList.getPosition_Emp());
        A13.setText(editTodoList.getSalary_Emp());

                // ปุ้ม แก้ไข ข้อมูล  //
        final Button editBtn = (Button)findViewById(R.id.Name_Reg_But_Save_edit);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoList eTodoList = new TodoList();                                  //สร้าง eTodoList ใหม่ เพื่มรับค่า editTodolist เดิม
                eTodoList.setID_Emp(editTodoList.getID_Emp());                    // ใช้ eTodoList รับค่า editTodolist ที่ส่ง มา

                eTodoList.setIdcard_Emp(String.valueOf(A1.getText()));              // แล้วเอา setTodoText ที่ได้มาจาก editText น่าออกแบบ
                eTodoList.setName_Emp(String.valueOf(A2.getText()));
                eTodoList.setNickname_Emp(String.valueOf(A3.getText()));

                eTodoList.setDateBirth_Emp(String.valueOf(A5.getText()));
                eTodoList.setAge_Emp(String.valueOf(A6.getText()));
                eTodoList.setAddress_Emp(String.valueOf(A7.getText()));
                eTodoList.setTele_Emp(String.valueOf(A8.getText()));
                eTodoList.setLine_Emp(String.valueOf(A9.getText()));
                eTodoList.setFacebook_Emp(String.valueOf(A10.getText()));
                eTodoList.setEmail_Emp(String.valueOf(A11.getText()));
                eTodoList.setPosition_Emp(String.valueOf(A12.getText()));
                eTodoList.setSalary_Emp(String.valueOf(A13.getText()));

                nameListViewDAO nameListDAO = new nameListViewDAO(getApplicationContext()); //เชื่อมต่อ todoListDAO
                nameListDAO.open();
                nameListDAO.update(eTodoList);                                      //อัพเดก
                nameListDAO.close();                                                //ปิด
                finish();                                                           //เแก้ไข แล้ว ปิด หน้านี้
            }
        });
        // ปุ้ม ลบ ข้อมูล  //
        Button delBtn = (Button)findViewById(R.id.Name_Reg_But_edit);                      // ปุ่ม ลบ   สร้าง delBtn เพิ่มรับค่าจาก delete_btn  น่าออกแบบ
        delBtn.setOnClickListener(new View.OnClickListener() {                      //
            @Override
            public void onClick(View v) {
                nameListViewDAO todoListDAODel =new nameListViewDAO(getApplicationContext());
                todoListDAODel.open();
                todoListDAODel.delete(editTodoList);
                todoListDAODel.close();
                finish();
            }
        });
    }// จบ onCreate
}// จบ class NameEdit
