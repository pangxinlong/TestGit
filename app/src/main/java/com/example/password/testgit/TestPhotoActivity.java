package com.example.password.testgit;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by password on 15-10-13.
 * Description TODO
 */
public class TestPhotoActivity extends Activity implements View.OnClickListener {

    public static final String IMAGE_SAVE_PATH = "/test";

    

    private static final int REQUEST_CODE_CAMERA = 3003;

    private static final int REQUEST_CODE_LOCAL = 3001;

    private static final int REQUEST_CODE_CLIP = 3005;

    private Button camera;

    private Button photo;

    private ImageView mImageView;

    private String cameraPicPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_photo);

        camera = (Button) findViewById(R.id.btn_camera);
        photo = (Button) findViewById(R.id.btn_photo);
        mImageView=(ImageView)findViewById(R.id.iv_image);

        camera.setOnClickListener(this);
        photo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_camera:
                cameraAction();
                break;
            case R.id.btn_photo:
                galleryAction();
                break;
            default:
                break;
        }
    }

    private void cameraAction() {
        String cameraSavePath = IMAGE_SAVE_PATH;
        File savedir = new File(cameraSavePath);
        if (!savedir.exists()) {
            savedir.mkdirs();
        }
        String fileName = "photo_temp.jpg";
        File out = new File(cameraSavePath, fileName);
        cameraPicPath = out.getAbsolutePath();
        Uri uri = Uri.fromFile(out);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
        this.startActivityForResult(intent,
                REQUEST_CODE_CAMERA);
    }

    private void galleryAction() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("image/*");
        this.startActivityForResult(Intent.createChooser(intent, "选择图片"),
                REQUEST_CODE_LOCAL);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case REQUEST_CODE_CAMERA:
                    cameraResult();
                    break;
                case REQUEST_CODE_LOCAL:
                    photoResult(data);
                    break;
                case REQUEST_CODE_CLIP:
                    Bitmap bmp = data.getParcelableExtra("data");
                    mImageView.setImageBitmap(bmp);
                    break;
            }
        }
    }
    private static final String IMAGE_FILE_LOCATION = "file:///sdcard/temp.jpg";
    /**
     * 相机信息返回
     */
    private void cameraResult() {
        Uri imageUri = Uri.parse(IMAGE_FILE_LOCATION);
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        intent.putExtra("crop", "true");
        this.startActivityForResult(intent,
                REQUEST_CODE_CLIP);
    }

    private void photoResult(final Intent data) {

        if (data == null) {
            return;
        }
        Uri thisUri = data.getData();
        if (thisUri != null) {
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(thisUri, "image/*");
            // crop为true是设置在开启的intent中设置显示的view可以剪裁
            intent.putExtra("crop", "true");

            // aspectX aspectY 是宽高的比例
            intent.putExtra("aspectX", mImageView.getWidth());
            intent.putExtra("aspectY", mImageView.getHeight());

            // outputX,outputY 是剪裁图片的宽高
            intent.putExtra("outputX", mImageView.getWidth());
            intent.putExtra("outputY", mImageView.getHeight());
            intent.putExtra("return-data", true);
            intent.putExtra("noFaceDetection", true);
            System.out.println("22================");
            startActivityForResult(intent, REQUEST_CODE_CLIP);
        }
    }
}
