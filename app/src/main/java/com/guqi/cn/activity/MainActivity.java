package com.guqi.cn.activity;

import android.Manifest;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.guqi.cn.R;
import com.guqi.cn.activity.base.BaseActivity;
import com.guqi.cn.activity.base.BasicActivity;
import com.guqi.cn.model.DemoModel;
import com.guqi.cn.model.DemoModelClick;
import com.guqi.cn.view.LordingDialog;

import java.util.List;

import butterknife.BindView;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {

    @BindView(R.id.tv_xingMing)
    TextView tvXingMing;
    @BindView(R.id.tv_nianling)
    TextView tvNianling;
    @BindView(R.id.tv_xingbie)
    TextView tvXingbie;
    @BindView(R.id.iv_image)
    ImageView ivImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] perms = {
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.WRITE_EXTERNAL_STORAGE};
        EasyPermissions.requestPermissions(MainActivity.this, "申请开启app需要的权限", 0, perms);

        tvXingMing.setText("果果");
        tvNianling.setText("20");
        tvXingbie.setText("男");
        String imageUrl = "https://pics5.baidu.com/feed/f9198618367adab4b1f5853d3fd707148701e4b0.jpeg?token=9a09a0393bc7d28b96fb68a7b1cd5695\"";
        Glide.with(this).load(imageUrl).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(ivImage);
//
//        ActivityMainBinding activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main_1);
//
//        DemoModel demoModel = new DemoModel();
//        demoModel.setNianLing("20");
//        demoModel.setXingBie("女");
//        demoModel.setXingMing("果果");
//
//        activityMainBinding.setGeRenXinXi(demoModel);
//
//        activityMainBinding.setEvent(new DemoModelClick(this));
//        activityMainBinding.setImageData("https://pics5.baidu.com/feed/f9198618367adab4b1f5853d3fd707148701e4b0.jpeg?token=9a09a0393bc7d28b96fb68a7b1cd5695");
//        LordingDialog lordingDialog = new LordingDialog(MainActivity.this);
//        lordingDialog.setTextMsg("数据加载中,请稍后...");
//        lordingDialog.show();

        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("加载中，请稍后...");

        progressDialog.show();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//
//
//                lordingDialog.show();
//                try {
//                    Thread.sleep(2000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                //lordingDialog.dismiss();
//            }
//
//        }).start();

    }

    @Override
    public int getContentViewResId() {
        return R.layout.activity_main_1;
    }

    @Override
    public boolean showToolBar() {
        return true;
    }

    @Override
    protected void initToolbar() {
        super.initToolbar();
        tv_title.setText("关于我们");
        tv_title.setTextSize(17);
        tv_title.setTextColor(getResources().getColor(R.color.black));

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
