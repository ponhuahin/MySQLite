package ca.mogkolpon.mysqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by User-Gamer on 2/19/2017.
 */
public class AdminEdit extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_edit);

        final TodoList editTodoList = (TodoList) getIntent().getSerializableExtra("editTodoList");

        final EditText editText = (EditText) findViewById(R.id.Name2_edit);
        final EditText editText1 = (EditText) findViewById(R.id.Username2_edit);
        final EditText editText2 = (EditText) findViewById(R.id.Password2_edit);
        editText.setText(editTodoList.getName_admin());
        editText1.setText(editTodoList.getUsername_admin());
        editText2.setText(editTodoList.getPassword_admin());

        // ปุ้ม แก้ไข ข้อมูล  //
        final Button editBtn = (Button)findViewById(R.id.SignInbut2_edit);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TodoList eTodoList = new TodoList();                                  //สร้าง eTodoList ใหม่ เพื่มรับค่า editTodolist เดิม
                eTodoList.setID_admin(editTodoList.getID_admin());                    // ใช้ eTodoList รับค่า editTodolist ที่ส่ง มา
                eTodoList.setName_admin(String.valueOf(editText.getText()));          // แล้วเอา setTodoText ที่ได้มาจาก editText น่าออกแบบ
                eTodoList.setUsername_admin(String.valueOf(editText1.getText()));
                eTodoList.setPassword_admin(String.valueOf(editText2.getText()));

                TodoListDAO todoListDAO = new TodoListDAO(getApplicationContext()); //เชื่อมต่อ todoListDAO
                todoListDAO.open();
                todoListDAO.update(eTodoList);                                      //อัพเดก
                todoListDAO.close();                                                //ปิด
                finish();                                                           //เแก้ไข แล้ว ปิด หน้านี้
            }
        });

        // ปุ้ม ลบ ข้อมูล  //
        Button delBtn = (Button)findViewById(R.id.delete_btn);                      // ปุ่ม ลบ   สร้าง delBtn เพิ่มรับค่าจาก delete_btn  น่าออกแบบ
        delBtn.setOnClickListener(new View.OnClickListener() {                      //
            @Override
            public void onClick(View v) {
                TodoListDAO todoListDAODel =new TodoListDAO(getApplicationContext());
                todoListDAODel.open();
                todoListDAODel.delete(editTodoList);
                todoListDAODel.close();
                finish();
            }
        });

    }
}
