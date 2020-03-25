package com.example.baiKiemTra;

import android.content.Intent;
import android.os.Bundle;

import com.example.baiKiemTra.ui.LogoutFragment;
import com.example.baiKiemTra.ui.MonanFragment;
import com.example.baiKiemTra.ui.DoanhthuFragment;
import com.example.baiKiemTra.ui.BananFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.util.Log;
import android.view.View;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ArrayList<model> arrayList;
    menuAdapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler_view);
        arrayList=new ArrayList<>();
        adapter =new menuAdapter(arrayList,getApplicationContext());
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Layout2.class);
                startActivity(intent);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
//                setContentView(R.layout.additem);
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

       if(savedInstanceState == null) {

           MonanFragment homeFragment=new MonanFragment();
           FragmentManager manager=getSupportFragmentManager();
           manager.beginTransaction().replace(R.id.content_main_frag,homeFragment,homeFragment.getTag()).commit();
           navigationView.setCheckedItem(R.id.monan);

       }

        initItem();
       addItem();

    }

    private void addItem() {
        Intent intent=getIntent();
        arrayList= (ArrayList<model>) intent.getSerializableExtra("array");
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        Log.d("aaa","ok");
    }

    public void  initItem(){
        //RecyclerView recyclerView=(RecyclerView)findViewById(R.id.recycler_view);
        //recyclerView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        arrayList.add(new model("Cua nằm trên đĩa",R.drawable.m6,"99999"));
        arrayList.add(new model("Đậu thập cẩm",R.drawable.m7,"99999"));
        arrayList.add(new model("Kim chi đỏ",R.drawable.m8,"99999"));
        arrayList.add(new model("Bò xào mì ý",R.drawable.m9,"99999"));
        arrayList.add(new model("Nem cuốn tôm bay",R.drawable.m11,"99999"));
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.sua) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()){
            case R.id.monan:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main_frag,new MonanFragment()).commit();
                break;
            case R.id.banan:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main_frag,new BananFragment()).commit();
                break;
            case R.id.doanhthu:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main_frag,new DoanhthuFragment()).commit();
                break;
            case R.id.logout:
                getSupportFragmentManager().beginTransaction().replace(R.id.content_main_frag,new LogoutFragment()).commit();

                break;

        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
