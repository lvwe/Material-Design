package com.example.yls.mddome;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView tv;
    private EditText edtName, edtPassword;
    private FloatingActionButton fabSearch, fabAdd;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawerLayout;
    private ImageView imgToolbar, imgNavHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
//        View decorView = getWindow().getDecorView();
//        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(option);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.hide();
//        if (Build.VERSION.SDK_INT >= 21) {
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            getWindow().setStatusBarColor(Color.TRANSPARENT);
//        }

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);

//        getWindow().getDecorView()
//                .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);

        Toast.makeText(this, ""+Build.VERSION.SDK_INT, Toast.LENGTH_SHORT).show();



        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_item_home:
                        Toast.makeText(MainActivity.this, "首页被点击了", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.navigation_item_blog:
                        Toast.makeText(MainActivity.this, "我的博客被点击了", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.navigation_item_about:
                        Toast.makeText(MainActivity.this, "关于被点击了", Toast.LENGTH_SHORT).show();
                        break;
                }
                item.setChecked(true);
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                return false;
            }
        });
//        Toolbar toolbar = (Toolbar) findViewById(R.id.appbar);
//        setSupportActionBar(toolbar);
    }

//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
//            View decorView = getWindow().getDecorView();
//            decorView.setSystemUiVisibility(
//                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
//                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                            | View.SYSTEM_UI_FLAG_FULLSCREEN
//                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
//        }
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//
//    }

    private void initViews() {
        tv = (TextView) findViewById(R.id.tv_hello);
        edtName = (EditText) findViewById(R.id.edt_name);
        edtPassword = (EditText) findViewById(R.id.edt_password);
        fabSearch = (FloatingActionButton) findViewById(R.id.fab_search);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        fabAdd = (FloatingActionButton) findViewById(R.id.fab);
        imgToolbar = (ImageView) findViewById(R.id.img_toolbar);

        View navigationView = mNavigationView.inflateHeaderView(R.layout.navigation_header);
        imgNavHead = (ImageView) navigationView.findViewById(R.id.iv);
        imgToolbar.setOnClickListener(this);
        imgNavHead.setOnClickListener(this);
        fabSearch.setOnClickListener(this);
        fabAdd.setOnClickListener(this);
        tv.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_toolbar:
                mDrawerLayout.openDrawer(Gravity.LEFT);
                break;
            case R.id.iv:
                Toast.makeText(MainActivity.this, "头像被点击了", Toast.LENGTH_SHORT).show();
                mDrawerLayout.closeDrawer(Gravity.LEFT);
                break;
            case R.id.fab:
                Snackbar.make(v, "FAB", Snackbar.LENGTH_LONG)
                        .setAction("cancel", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //这里的单击事件代表点击消除Action后的响应事件
                                tv.setTextColor(Color.BLUE);
                            }
                        })
                        .show();
                break;
            case R.id.fab_search:
                tv.setTextColor(Color.RED);
                Intent intent = new Intent(MainActivity.this, CoordinatorLayoutActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_hello:
                Snackbar.make(tv, "SnackbarClicked", Snackbar.LENGTH_SHORT).setAction("ACTION", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(MainActivity.this, "Sackbar on clicked", Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(Color.RED).show();
                break;

        }
    }
}
