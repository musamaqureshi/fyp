package org.yuri.afinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Button managementButton = (Button) findViewById(R.id.managementButton);

//        if(e1.equals("admin")){
//
//                        managementButton.setEnable(false);
//
//                    }
//
//        Intent intent = getIntent();
//        String id = intent.getStringExtra("id");
////        String password = intent.getStringExtra("password");
////        String message = "Welcome," + id;
//
//
//        if(id.equals("admin")){
//            managementButton.setVisibility(View.GONE);
//        }


        noticeListView = (ListView) findViewById(R.id.noticeListView);
        noticeList = new ArrayList<Notice>();
        noticeList.add(new Notice("Final Project CS492", "USAMA QURESHI", "01/05/2020"));
        noticeList.add(new Notice("REPORTS", "USAMA QURESHI", "02/05/2020"));
        noticeList.add(new Notice("MAY 11 PRESENTATION", "NAMES UPDATE", "011/05/2020"));
        noticeList.add(new Notice("Project REMARKS", "GRADES ADDED", "11/05/2020"));
        noticeList.add(new Notice("ASSIGNMENT & CLASS NOTES & PRESENTATIONS", "DATES", "01/05/2020"));
        noticeList.add(new Notice("Midterm grades have been announced!", "UPDATED AND FINAL", "12/05/2020"));
        noticeList.add(new Notice("CLASS Updatess", "INFORMATION", "12/05/2020"));

        adapter = new NoticeListAdapter(getApplicationContext(), noticeList);
        noticeListView.setAdapter(adapter);


//        final Button userButton = (Button) findViewById(R.id.userButton);
        final Button myInfoButton = (Button) findViewById(R.id.myInfoButton);
        final Button myTeacherButton = (Button) findViewById(R.id.myTeacherButton);
        final Button courseRegistrationButton = (Button) findViewById(R.id.courseRegister);
//        final Button newsButton = (Button) findViewById(R.id.newsButton);

        myTeacherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TeacherActivity.class));
            }
        });
        courseRegistrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CourseRegistrationActivity.class));
            }
        });

        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);


//
//        userButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                notice.setVisibility(View.GONE);
//
//
//
////                userButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//                myInfoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
////                newsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//
//                FragmentManager fragmentManager = getSupportFragmentManager();
//
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragment,new UserFragment());
//                fragmentTransaction.commit();
//
//            }
//        });

        //
        myInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);


//                userButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                myInfoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//                newsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, new MyinfoFragment());
                fragmentTransaction.commit();

            }
        });

        //

//        newsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                notice.setVisibility(View.GONE);
//
//
//
//
//                userButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//                myInfoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//                newsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//
//                FragmentManager fragmentManager = getSupportFragmentManager();
//
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragment,new NewsFragment());
//                fragmentTransaction.commit();
//
//            }
//        });


    }


    private long lastTimeBackPressed;

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() - lastTimeBackPressed < 1500) {
            finish();
            return;

        }
        Toast.makeText(this, "Press the 'back' button once more to exit.", Toast.LENGTH_LONG);
        lastTimeBackPressed = System.currentTimeMillis();
    }

}