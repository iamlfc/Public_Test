package com.ruanmeng.project_model.UpLoadPic;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.ruanmeng.project_model.R;

import java.io.FileNotFoundException;

public class TextPhotoActivity extends AppCompatActivity {

    private ImageView imageView;
    private int TAKE_PHOTO = 1;   //拍照
    private int GET_PHOTO = 2;    //取照片

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_photo);
        //获取ImageView控件
        imageView = (ImageView) findViewById(R.id.takePhoto_imageView);

        /*
         * 拍照取图
         */
        findViewById(R.id.takePhoto_bt1).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                //设置拍照意图
                Intent mIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(mIntent, TAKE_PHOTO);

            }
        });

        /*
         * 相册取图
         */
        findViewById(R.id.takePhoto_bt2).setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, GET_PHOTO);

            }
        });

    }

    //接受回传值
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        {  //回传值接受成功

            if (requestCode == TAKE_PHOTO) {    //拍照取图

                Bundle bundle = data.getExtras();   //获取data数据集合
                Bitmap bitmap = (Bitmap) bundle.get("data");        //获得data数据
                Log.i("TAG", "拍照回传bitmap：" + bitmap);
                imageView.setImageBitmap(bitmap);

            }

            if (requestCode == GET_PHOTO) {     //相册取图

                ContentResolver contentResolver = getContentResolver();
                try {
                    Bitmap bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(data.getData()));
                    Log.i("TAG", "从相册回传bitmap：" + bitmap);
                    imageView.setImageBitmap(bitmap);

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }

        }

    }

}
