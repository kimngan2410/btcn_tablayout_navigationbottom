package com.example.btcn_tablayout_bottomnavigation;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.btcn_tablayout_bottomnavigation.Adapter.AdapterViewPager;
import com.example.btcn_tablayout_bottomnavigation.Fragment.AccountFragment;
import com.example.btcn_tablayout_bottomnavigation.Fragment.BankFragment;
import com.example.btcn_tablayout_bottomnavigation.Fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPager2 view_paper;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    BottomNavigationView  bottom_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        view_paper = findViewById(R.id.view_paper);
        bottom_navigation = findViewById(R.id.bottom_navigation);


        fragmentArrayList.add(new HomeFragment());
        fragmentArrayList.add(new BankFragment());
        fragmentArrayList.add(new AccountFragment());

        AdapterViewPager adapterViewPager = new AdapterViewPager(this,fragmentArrayList);
        //setAdapter
        view_paper.setAdapter(adapterViewPager);
        view_paper.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottom_navigation.getMenu().findItem(R.id.menuHome).setChecked(true);
                        break;
                    case 1:
                        bottom_navigation.getMenu().findItem(R.id.menuBank).setChecked(true);
                        break;
                    case 2:
                        bottom_navigation.getMenu().findItem(R.id.menuAccount).setChecked(true);
                        break;
                }
                super.onPageSelected(position);
            }
        });

        bottom_navigation.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.menuHome){
                    view_paper.setCurrentItem(0, true);
                } else if (itemId == R.id.menuBank) {
                    view_paper.setCurrentItem(1, true);
                } else if (itemId == R.id.menuAccount) {
                    view_paper.setCurrentItem(2, true);
                }
                return true;
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}