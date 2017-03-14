package ca.mogkolpon.mysqlite;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by User-Gamer on 3/9/2017.
 */

public class NameShow extends Activity {
    ListView nameListView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_show);

        nameListView=(ListView)findViewById(R.id.name_ListView);
    }
    protected void onResume() { //เพื่อให้ เวลาเพิ่มข้อมูลจะอัพเดอรืข้อมูลให้ใหม่ คือ เพิ่มข้อมูลจะขึ้นทันที
        super.onResume();
        nameListViewDAO nameListViewDAO1=new nameListViewDAO(getApplicationContext());
        nameListViewDAO1.open();
        ArrayList<TodoList> myList = nameListViewDAO1.getAllTodoList();

        final NameListView adapter = new NameListView(this,myList);
        nameListView.setAdapter(adapter);
        nameListViewDAO1.close();

// กดปกติ
//        nameListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
//            public void onItemClick(AdapterView<?> patent, View view, int position, long id) {
//                Toast.makeText(getApplicationContext(),String.valueOf(adapter.getItemId(position)),Toast.LENGTH_SHORT).show();
////                Intent editIntent = new Intent(getApplicationContext(), AdminEdit.class);
////                editIntent.putExtra("editTodoList",adapter.getItem(position));
////                startActivity(editIntent);
//            }
//        });
//// กดค้าง
//        nameListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
//            public boolean onItemLongClick(AdapterView<?> patent, View view, final int position, long id) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(NameShow.this);
//                builder.setPositiveButton("ลบ ไม่ได้", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//
//                        TodoList todoList1 = new TodoList();
//                        adapter.getItem(position);
//                        database.execSQL("DELETE FROM admin_db WHERE ID_admin=" + todoList1.getID_admin());
//                        mCursor.requery();
//                        nameListView.setAdapter(adapter);
//                        Toast.makeText(getApplicationContext(),"ลบข้อมูลนักเรียนเรียบร้อย", Toast.LENGTH_SHORT).show();
//                        Log.d("Todo updateTodoList","ลบข้อมูลเรียบร้อย");
//                    }
//                });
//                builder.setNegativeButton("แก้ไข", new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        Intent editIntent = new Intent(getApplicationContext(), AdminEdit.class);
//                        editIntent.putExtra("editTodoList",adapter.getItem(position));
//                        startActivity(editIntent);
////                        dialog.cancel();
//                    }
//                });
//                builder.show();
//                return true;
//            }
//        });
    }
}
