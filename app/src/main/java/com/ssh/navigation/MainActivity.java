package com.ssh.navigation;

import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentContainerView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;


import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration; // AppBarConfiguration을 저장할 변수
    private NavController navController; // NavController를 저장할 변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // nav_host_fragment를 찾아서 NavHostFragment를 얻고, 해당 NavHostFragment의 NavController를 가져온다.
        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        NavController navController = navHostFragment.getNavController();

        // NavController를 기반으로 AppBarConfiguration을 만들고, ActionBar와 NavController를 연결한다.
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    // Action Bar의 뒤로가기 버튼이 눌렸을 때 호출되는 메소드
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration);
    }
}

/*
해당 코드는 기존 코드에서 NavHostFragment와 NavController를 가져오는 방식을 변경하였고, onSupportNavigateUp() 메소드에서 super.onSupportNavigateUp()을 호출하지 않도록 수정한 것입니다.

NavHostFragment를 찾아서 NavController를 가져옵니다.

getSupportFragmentManager()를 사용하여 현재 Activity의 FragmentManager를 가져옵니다.
findFragmentById(R.id.nav_host_fragment)를 사용하여 NavHostFragment를 가져옵니다.
getNavController()를 사용하여 NavController를 가져옵니다.
NavController를 기반으로 AppBarConfiguration를 만들고, ActionBar와 NavController를 연결합니다.

AppBarConfiguration를 만들 때 navController.getGraph()를 사용하여 그래프를 가져옵니다.
NavigationUI.setupActionBarWithNavController()를 사용하여 ActionBar와 NavController를 연결합니다.
onSupportNavigateUp() 메소드에서 super.onSupportNavigateUp()을 호출하지 않도록 수정합니다.

기존 코드에서는 super.onSupportNavigateUp()을 호출하도록 되어 있습니다.
이를 호출하지 않도록 수정한 이유는, NavigationUI.navigateUp() 메소드에서 뒤로가기 버튼 처리를 하기 때문입니다. */

/* public class MainActivity extends AppCompatActivity {

    AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


    }

    @Override
    public boolean onSupportNavigateUp(){
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }
}
*/







