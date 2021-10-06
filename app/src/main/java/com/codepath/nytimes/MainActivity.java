package com.codepath.nytimes;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView menu_bottom_navigation_View;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menu_bottom_navigation_View = findViewById(R.id.bottom_navigation);

        menu_bottom_navigation_View.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                switch (item.getItemId()) {
                    case R.id.mnuBestSellerBooks:
                        Toast.makeText(MainActivity.this, "BestSellers", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.mnuHome:
                        Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();

                        break;
                    case R.id.mnuSearchArticles:
                        Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                    break;
                    case R.id.mnuSettings:
                        Toast.makeText(MainActivity.this, "Settings", Toast.LENGTH_SHORT).show();
                        default:
                        break;
                }
                return true;
            }


        });
    }
}
