package com.ruler.fighting;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ruler.fighting.adapter.VpFragmentAdapter;
import com.ruler.fighting.fragment.CollectFragment;
import com.ruler.fighting.fragment.HomeFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.vp)
    ViewPager mVp;
    @BindView(R.id.tab)
    TabLayout mTab;
    private VpFragmentAdapter fragmentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
        fragmentArrayList.add(new HomeFragment());
        fragmentArrayList.add(new CollectFragment());

        fragmentAdapter = new VpFragmentAdapter(getSupportFragmentManager(), fragmentArrayList);
        mVp.setAdapter(fragmentAdapter);
        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("首页").setIcon(R.mipmap.ic_launcher);
        mTab.getTabAt(1).setText("收藏").setIcon(R.mipmap.ic_launcher);
    }


}
