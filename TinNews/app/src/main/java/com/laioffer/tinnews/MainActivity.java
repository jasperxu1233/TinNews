package com.laioffer.tinnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;

import com.laioffer.tinnews.databinding.ActivityMainBinding;
import com.laioffer.tinnews.model.NewsResponse;
import com.laioffer.tinnews.network.NewsApi;
import com.laioffer.tinnews.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private NavController navController;
    private ActivityMainBinding binding;   //设置自动的binding键

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());  //binding拿到后面activity_main.xml的id
        setContentView(binding.getRoot());

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment); //拿到activity_mian.xml的fragment的控制权
        navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.navView, navController);  //将fragment的控制权和nav_view（bottom）联动，是的底部的按键有控制权
//        NavigationUI.setupActionBarWithNavController(this, navController); //使 actionbar拥有控制权
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }
}