package ca.mogkolpon.mysqlite;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by User-Gamer on 2/9/2017.
 */
public class A2 extends Fragment {
    public static A2 newInstance() {
        A2 fragment = new A2();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v2=inflater.inflate(R.layout.a2, container, false);

        final Button btnFlag1=(Button) v2.findViewById(R.id.a2_button1);
        btnFlag1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivityReminder=new Intent();
                newActivityReminder.setClass(getActivity(),JobRegister.class);
                startActivity(newActivityReminder);
            }
        });
//
        final Button btnFlag2=(Button) v2.findViewById(R.id.a2_button2);
        btnFlag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivityReminder=new Intent();
                newActivityReminder.setClass(getActivity(),JobShow.class);
//                newActivityReminder.putExtra("index","test");//ส่งค่าตัวหลังเป็น Value
                startActivity(newActivityReminder);
            }
        });
        return v2;

    }
}
