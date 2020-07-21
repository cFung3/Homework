package com.example.homework1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;

//Did not use in the program

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import org.opencv.android.InstallCallbackInterface;
import org.opencv.android.LoaderCallbackInterface;

//Did not use in the program

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    //Casper Fung
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        final int[] count = {1};
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!OpenCVLoader.initDebug()) {
                    Log.d("Casper Fung", "Error OpenCV");
                } else {
                    Log.d("Casper Fung", "OpenCV OK");
                }
                Point firstPoint = new Point(0,0);
                Point secondPoint = new Point(0,500);
                Point thirdPoint = new Point(500,500);
                Point fourthPoint = new Point(500, 0);
                Scalar lineColor = new Scalar(50,50,255,255);
                //R, G, B, Transparencies
                int lineWidth = 30;
                Mat img = null;
                if (count[0] == 1){
                    try{
                        img = Utils.loadResource(MainActivity.this,R.drawable.uni, CvType.CV_8UC4);
                        //Put image file here
                        Imgproc.line(img, firstPoint, secondPoint, lineColor, lineWidth);
                        //Draw the line first
                        Bitmap bitmap = Bitmap.createBitmap(img.width(), img.height(), Bitmap.Config.ARGB_8888);
                        //Set the variable amd find variable
                        Utils.matToBitmap(img, bitmap);
                        //Convert Mat to Bitmap
                        ImageView imgView = findViewById(R.id.imageView);
                        //Set the variable
                        imgView.setImageBitmap(bitmap);
                        //Put the Bitmap into imageView
                        count[0]++;
                        //Change count to 2 in order to run the next loop
                        Log.d("Casper Fung",""+count[0]);
                        //For debugging
                    } catch (IOException e){
                        e.printStackTrace();
                        //Prevent from the App from crashing
                    }
                }
                else if (count[0] == 2){
                    try{
                        img = Utils.loadResource(MainActivity.this,R.drawable.uni, CvType.CV_8UC4);
                        Imgproc.line(img, firstPoint, secondPoint, lineColor, lineWidth);
                        //For the first line to not disappear
                        Imgproc.line(img, secondPoint, thirdPoint, lineColor, lineWidth);
                        Bitmap bitmap = Bitmap.createBitmap(img.width(), img.height(), Bitmap.Config.ARGB_8888);
                        Utils.matToBitmap(img, bitmap);
                        ImageView imgView = findViewById(R.id.imageView);
                        imgView.setImageBitmap(bitmap);
                        count[0]++;
                        Log.d("Casper Fung",""+count[0]);
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
                else if (count[0] == 3){
                    try{
                        img = Utils.loadResource(MainActivity.this,R.drawable.uni, CvType.CV_8UC4);
                        Imgproc.line(img, firstPoint, secondPoint, lineColor, lineWidth);
                        Imgproc.line(img, secondPoint, thirdPoint, lineColor, lineWidth);
                        Imgproc.line(img, thirdPoint, fourthPoint, lineColor, lineWidth);
                        Bitmap bitmap = Bitmap.createBitmap(img.width(), img.height(), Bitmap.Config.ARGB_8888);
                        Utils.matToBitmap(img, bitmap);
                        ImageView imgView = findViewById(R.id.imageView);
                        imgView.setImageBitmap(bitmap);
                        count[0]++;
                        Log.d("Casper Fung",""+count[0]);
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
                else if (count[0] == 4){
                    try{
                        img = Utils.loadResource(MainActivity.this,R.drawable.uni, CvType.CV_8UC4);
                        Imgproc.line(img, firstPoint, secondPoint, lineColor, lineWidth);
                        Imgproc.line(img, secondPoint, thirdPoint, lineColor, lineWidth);
                        Imgproc.line(img, thirdPoint, fourthPoint, lineColor, lineWidth);
                        Imgproc.line(img, fourthPoint, firstPoint, lineColor, lineWidth);
                        Bitmap bitmap = Bitmap.createBitmap(img.width(), img.height(), Bitmap.Config.ARGB_8888);
                        Utils.matToBitmap(img, bitmap);
                        ImageView imgView = findViewById(R.id.imageView);
                        imgView.setImageBitmap(bitmap);
                        count[0]++;
                        Log.d("Casper Fung",""+count[0]);
                    } catch (IOException e){
                        e.printStackTrace();
                    }
                }
                //count[0]++;
                Log.d("Casper Fung",""+count[0]);
            }
        });
    }
}