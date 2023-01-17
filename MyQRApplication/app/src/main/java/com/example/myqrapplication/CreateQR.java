package com.example.myqrapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextClock;

import com.example.conn.ApiClient;
import com.example.conn.CommonMethod;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import org.json.JSONException;
import org.json.JSONObject;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class CreateQR extends AppCompatActivity {
    private ImageView iv;
    private String text;
    Date time;
    TextClock clock;
    String lecture_code;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_qr);

        ApiClient.setBASEURL("http://192.168.0.10/middle/");
        CommonMethod com = new CommonMethod();



        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM-dd-HH:mm");
        String getTime = sdf.format(date);


        JSONObject object = new JSONObject();

        iv = findViewById(R.id.qrcode);
        clock = findViewById(R.id.clock);

        try {
            clock.setText(object.getString("name"));

        } catch (JSONException e) {
            e.printStackTrace();

        }
        com.sendPost("lecture", new CommonMethod.CallBackResult() {
            @Override
            public void result(boolean isResult, String data) {

            }
        });
        /*SUBJECT_CODE 큐알에 이것도 들어가야함*/
        text = getTime + lecture_code;

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try{
            //바코드 생성
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,200,200);
            //바코드엔코더 생성
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            //엔코더로 생성한 코드를 비트멥 객체에 넣기
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            iv.setImageBitmap(bitmap);
        }catch (Exception e){}
    }
}