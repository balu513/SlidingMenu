package com.afbb.balakrishna.playslipproj;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

import com.afbb.balakrishna.playslipproj.fragments.NavListFragment;
import com.afbb.balakrishna.playslipproj.fragments.PaySlipsFragment;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;


public class MainActivity extends ActionBarActivity {

    private SlidingMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureSlidingMenu();
        addFragment(new PaySlipsFragment());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void configureSlidingMenu() {
        // configure the SlidingMenu
        menu = new SlidingMenu(this);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        menu.setShadowWidthRes(R.dimen.shadow_width);
        menu.setShadowDrawable(R.drawable.shadow);
        menu.setBehindOffsetRes(R.dimen.slidingmenu_offset);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.menu_frame);

        NavListFragment navFragment = new NavListFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.menu_frame, navFragment)
                .commit();
    }

    public void addFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framelayout, fragment);
        ft.commit();

    }
    public void replaceFragment(Fragment fragment) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framelayout, fragment);
        ft.addToBackStack(null);
        ft.commit();

    }

    public void replaceFragment(Fragment fragment, int pos) {
        Bundle bundle = new Bundle();
        bundle.putInt("Pos", pos);
        fragment.setArguments(bundle);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.framelayout, fragment);
        ft.addToBackStack(null);
        ft.commit();

    }

    @Override
    public void onBackPressed() {
        if (menu.isMenuShowing()) {
            menu.showContent();
        } else {
            super.onBackPressed();
        }
    }

    public void closeSlider() {
        if (menu.isMenuShowing()) {
            menu.showContent();
        }
    }


}
