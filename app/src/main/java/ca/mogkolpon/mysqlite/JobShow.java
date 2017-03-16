package ca.mogkolpon.mysqlite;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class JobShow extends AppCompatActivity {
    ListView jobListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_show);

        jobListView = (ListView) findViewById(R.id.job_ListView);
    }
    protected void onResume() { //เพื่อให้ เวลาเพิ่มข้อมูลจะอัพเดอรืข้อมูลให้ใหม่ คือ เพิ่มข้อมูลจะขึ้นทันที
        super.onResume();
        Job_ListView_DAO Job_ListView_DAO1 = new Job_ListView_DAO(getApplicationContext());
        Job_ListView_DAO1.open();
        ArrayList<Todo_JOB> myList = Job_ListView_DAO1.getAllTodoList();

        final JobListView adapter = new JobListView(this, myList);
        jobListView.setAdapter(adapter);
        Job_ListView_DAO1.close();

// กดปกติ
        jobListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
            public void onItemClick(AdapterView<?> patent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), String.valueOf(adapter.getItemId(position)), Toast.LENGTH_SHORT).show();
//                Intent editIntent = new Intent(getApplicationContext(), AdminEdit.class);
//                editIntent.putExtra("editTodoList",adapter.getItem(position));
//                startActivity(editIntent);
            }
        });
// กดค้าง
        jobListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {  //ทำไให้ สามารถกด เลือก คงค่าเป็นไอดีได้
            public boolean onItemLongClick(AdapterView<?> patent, View view, final int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(JobShow.this);

                builder.setPositiveButton("ลบ ไม่ได้", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {



////                        TodoList todoList1 = new TodoList();
////                        adapter.getItem(position);
////                        database.execSQL("DELETE FROM admin_db WHERE ID_admin=" + todoList1.getID_admin());
////                        mCursor.requery();
////                        nameListView.setAdapter(adapter);
////                        Toast.makeText(getApplicationContext(),"ลบข้อมูลนักเรียนเรียบร้อย", Toast.LENGTH_SHORT).show();
////                        Log.d("Todo updateTodoList","ลบข้อมูลเรียบร้อย");
                    }
                });
                builder.setNegativeButton("แก้ไข/ลบ", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent editIntent = new Intent(getApplicationContext(), JobEdit.class);
                        editIntent.putExtra("editTodoList",adapter.getItem(position));
                        startActivity(editIntent);
                        dialog.cancel();
                    }
                });
                builder.show();
                return true;
            }
        });
    }
}
