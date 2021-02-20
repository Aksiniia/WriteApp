package com.example.write.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.write.R;
import com.example.write.fragment.DocumentsFragment;
import com.example.write.fragment.ReaderFragment;
import com.example.write.fragment.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView mainBottomNav = findViewById(R.id.mainBottomNav);
        mainBottomNav.setOnNavigationItemSelectedListener(item -> {
            if (mainBottomNav.getSelectedItemId() == item.getItemId())
                return false;

            switch (item.getItemId()) {
                case R.id.navDocuments: {
                    changeFragment(new DocumentsFragment());

                    break;
                }

                case R.id.navReader: {
                    changeFragment(new ReaderFragment());

                    break;
                }

                default: {
                    changeFragment(new SettingsFragment());

                    break;
                }
            }

            return true;
        });

        changeFragment(new DocumentsFragment());
    }

    private void changeFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainFrame, fragment)
                .commit();
    }
}