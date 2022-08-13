package com.guqi.cn.model;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.guqi.cn.R;

public class DemoModelImageAdapter  {

    public DemoModelImageAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    //添加一个BindingAdapter注解，方法有两个参数，一个是控件，一个是图片加载url地址，这里注解imageUrl，在页面app调用的时候也是imageUrl，这两个地方保持一致
    @BindingAdapter("imageUrl")
    public static  void setImageInfo(ImageView image, String imgUrl){
        //使用Glide加载图片显示
        if (!TextUtils.isEmpty(imgUrl)) {
            Glide.with(image.getContext()).load(imgUrl).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(image);
        }
    }

}
