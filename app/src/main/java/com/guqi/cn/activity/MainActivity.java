package com.guqi.cn.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;

import com.guqi.cn.R;
import com.guqi.cn.databinding.ActivityMainBinding;
import com.guqi.cn.model.DemoModel;
import com.guqi.cn.model.DemoModelClick;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        DemoModel demoModel = new DemoModel();
        demoModel.setNianLing("20");
        demoModel.setXingBie("女");
        demoModel.setXingMing("果果");

        activityMainBinding.setGeRenXinXi(demoModel);

        activityMainBinding.setEvent(new DemoModelClick(this));
        activityMainBinding.setImageData("https://pics5.baidu.com/feed/f9198618367adab4b1f5853d3fd707148701e4b0.jpeg?token=9a09a0393bc7d28b96fb68a7b1cd5695");



        String[] perms = {
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        EasyPermissions.requestPermissions(MainActivity.this, "申请开启app需要的权限", 0, perms);

    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

        for (int i = 0; i < perms.size(); i++) {
            Log.i("MainActivity", "通过的当前权限:" + perms.get(i));
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        for (int i = 0; i < perms.size(); i++) {
            Log.i("MainActivity", "拒绝的当前权限:" + perms.get(i));
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

    }
}
