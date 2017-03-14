package ca.mogkolpon.mysqlite;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
/**
 * Created by User-Gamer on 2/19/2017.
 */
public class AdminShow extends Activity {
    ListView todoListView;
    private SQLiteDatabase database;
    private MyData myData;
    Cursor mCursor;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_show);

        todoListView=(ListView)findViewById(R.id.todo_ListView);
    }

    protected void onResume() { //เพื่อให้ เวลาเพิ่มข้อมูลจะอัพเดอรืข้อมูลให้ใหม่ คือ เพิ่มข้อมูลจะขึ้นทันที
        super.onResume();
        TodoListDAO todoListDAO=new TodoListDAO(getApplicationContext());
        todoListDAO.open();
        ArrayList<TodoList> myList = todoListDAO.getAllTodoList();

        myData = new MyData(this);
        database = myData.getWritableDatabase();
        mCursor = database.rawQuery("SELECT * FROM admin_db", null);

        final AdminListView adapter = new AdminListView(this,myList);
        todoListView.setAdapter(adapter);
        todoListDAO.close();

// กดปกติ
        todoListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
            public void onItemClick(AdapterView<?> patent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),String.valueOf(adapter.getItemId(position)),Toast.LENGTH_SHORT).show();
//                Intent editIntent = new Intent(getApplicationContext(), AdminEdit.class);
//                editIntent.putExtra("editTodoList",adapter.getItem(position));
//                startActivity(editIntent);
            }
        });
// กดค้าง
        todoListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
            public boolean onItemLongClick(AdapterView<?> patent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AdminShow.this);
                builder.setPositiveButton("ลบ ไม่ได้", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        TodoList todoList1 = new TodoList();
                        adapter.getItem(position);
                        database.execSQL("DELETE FROM admin_db WHERE ID_admin=" + todoList1.getID_admin());
                        mCursor.requery();
                        todoListView.setAdapter(adapter);
                        Toast.makeText(getApplicationContext(),"ลบข้อมูลนักเรียนเรียบร้อย", Toast.LENGTH_SHORT).show();
                        Log.d("Todo updateTodoList","ลบข้อมูลเรียบร้อย");
                    }
                });
                builder.setNegativeButton("แก้ไข", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent editIntent = new Intent(getApplicationContext(), AdminEdit.class);
                        editIntent.putExtra("editTodoList",adapter.getItem(position));
                        startActivity(editIntent);
//                        dialog.cancel();
                    }
                });
                builder.show();
                return true;
            }
        });
    }
}
