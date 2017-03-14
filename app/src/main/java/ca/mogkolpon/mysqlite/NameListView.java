package ca.mogkolpon.mysqlite;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User-Gamer on 3/9/2017.
 */

public class NameListView extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<TodoList> myTodoList;

    public NameListView(Activity activity,ArrayList<TodoList> mtTodoList) {
        this.myTodoList = mtTodoList;
        this.activity = activity;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myTodoList.size();
    }
    @Override
    public TodoList getItem(int position) {
        return myTodoList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return myTodoList.get(position).getID_Emp();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.name_listview,null);
        TextView textView = (TextView)v.findViewById(R.id.lv_nickname);
        TextView textView1 = (TextView)v.findViewById(R.id.lv_telename);
        ImageView imageView=(ImageView)v.findViewById(R.id.name_ListView_Image);
//        TextView textView2 = (TextView)v.findViewById(R.id.admin_Password);

        TodoList todoList = myTodoList.get(position);
        textView.setText(todoList.getName_Emp());

        TodoList todoList1 = myTodoList.get(position);
        textView1.setText(todoList1.getNickname_Emp());

//        TodoList todoList2 = myTodoList.get(position);
//        imageView.setImageAlpha(Integer.parseInt(todoList2.getImage_Emp()));
//        TodoList todoList2 = myTodoList.get(position);
//        textView2.setText(todoList2.getPassword_admin());
        byte[] Image = TodoList.getImage_Emp();
        Bitmap bitmap = BitmapFactory.decodeByteArray(Image, 0, Image.length);
        imageView.setImageBitmap(bitmap);


        return v;
    }

}
