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
public class A1 extends Fragment {

    public static A1 newInstance() {
        A1 fragment = new A1();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.a1, container, false);

        final Button btnFlag=(Button) rootView.findViewById(R.id.a1_button1);
        btnFlag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivityReminder=new Intent();
                newActivityReminder.setClass(getActivity(),NameRegister.class);
                newActivityReminder.putExtra("index","test");//ส่งค่าตัวหลังเป็น Value
                startActivity(newActivityReminder);
            }
        });

        final Button btnFlag2=(Button) rootView.findViewById(R.id.a1_button2);
        btnFlag2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newActivityReminder=new Intent();
                newActivityReminder.setClass(getActivity(),NameShow.class);
//                newActivityReminder.putExtra("index","test");//ส่งค่าตัวหลังเป็น Value
                startActivity(newActivityReminder);
            }
        });

        return rootView;
    }


//    public void clickSignIn(View view) {
//        Button btn_ok2 = (Button)findViewById(R.id.button3);
//        Intent intent = new Intent(MainActivity.this,NameRegister.class);
//        startActivity(intent);
//    }

}
