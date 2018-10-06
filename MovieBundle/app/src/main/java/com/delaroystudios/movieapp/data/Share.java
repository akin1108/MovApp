package com.delaroystudios.movieapp.data;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class Share {
    public static String shareToExternal(Bitmap bitmap) {

        String shared = null;
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        File sname = Environment.getExternalStorageDirectory() ;

        File file = new File(sname.getAbsoluteFile(), "temp.jpg") ;
        try{
            file.createNewFile();
            FileOutputStream out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes);
            out.write(bytes.toByteArray());
            shared = "success";
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return shared;
    }

}
