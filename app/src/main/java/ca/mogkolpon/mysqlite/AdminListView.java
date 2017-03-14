package ca.mogkolpon.mysqlite;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User-Gamer on 2/19/2017.
 */

public class AdminListView extends BaseAdapter {
    private static Activity activity;
    private static LayoutInflater inflater;
    ArrayList<TodoList> myTodoList;

    public AdminListView(Activity activity,ArrayList<TodoList> mtTodoList) {
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
        return myTodoList.get(position).getID_admin();
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        v = inflater.inflate(R.layout.admin_list_view,null);
        TextView textView = (TextView)v.findViewById(R.id.admin_Name);
        TextView textView1 = (TextView)v.findViewById(R.id.admin_Username);
        TextView textView2 = (TextView)v.findViewById(R.id.admin_Password);

        TodoList todoList = myTodoList.get(position);
        textView.setText(todoList.getName_admin());

        TodoList todoList1 = myTodoList.get(position);
        textView1.setText(todoList1.getUsername_admin());

        TodoList todoList2 = myTodoList.get(position);
        textView2.setText(todoList2.getPassword_admin());

        return v;
    }
}
