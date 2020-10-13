package com.main.stutyGroupManagement;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class sever_Communication extends AsyncTask<String, Void, String> {

    /*
    //서버 커뮤니케이션 클래스 기본구조
    sever_Communication severCommunication = new sever_Communication();
    severCommunication.setSetURL("createdatabase.php");//서버주소
    severCommunication.createData("키워드","키값","키워드","키값");//데이터생성 "키워드" "키값" ... 순
    severCommunication.setSetMessage("아무거나 주세요");//백그라운드 띄울 메세지
    severCommunication.setContext(this);
    severCommunication.execute();
     */

    /*
    현재 android 키값은 key로 고정임.
    url : createdatabase.php
    키워드 dataBaseName, android
    url : deletedatabase.php
    키워드 dataBaseName, android
    */
    String setMessage;
    Context context;
    ProgressDialog logindialog;
    String URL;
    String data;
    private String TAG="server_Communication";

    public void createData(String... dataString){
        String data="";
        boolean temp=true;
        for(int i=0;i<dataString.length-1;i++){
            if(temp){
                data=data+dataString[i]+"=";
                temp=!temp;
            }
            else {
                data = data + dataString[i] + "&";
                temp=!temp;
            }
        }
        data=data+dataString[dataString.length-1];
        Log.d(TAG, "createData: "+data);
        this.data = data;
    }

    public void setSetURL(String string){
        this.URL="http://ec2-54-180-81-106.ap-northeast-2.compute.amazonaws.com/"+string;
    }
    public void setContext(Context context) {
        this.context = context;
    }

    public void setSetMessage(String setMessage) {
        this.setMessage = setMessage;
    }

    protected void onPreExecute() {
        logindialog = new ProgressDialog(context);
        logindialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        logindialog.setMessage(setMessage);
        logindialog.show();
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String result) {
        logindialog.dismiss();
        super.onPostExecute(result);
        Log.d(TAG, "Data Post - App : " + result);
    }



    @Override
    protected String doInBackground(String... params) {

        try {
            URL url = new URL(URL);//주소입력
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setReadTimeout(5000);//5초내 무 응답시 예외처리
            httpURLConnection.setConnectTimeout(5000);//5초내 연결 불가시 예외처리
            httpURLConnection.setDoInput(true);                         // 서버에서 읽기 모드 지정
            httpURLConnection.setDoOutput(true);                       // 서버로 쓰기 모드 지정
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8"); // Accept-Charset 설정.
            httpURLConnection.setRequestProperty("Context_Type", "application/x-www-form-urlencoded;cahrset=UTF-8");
// 전송 방식은 POST
            httpURLConnection.connect();
            OutputStream out = new BufferedOutputStream(httpURLConnection.getOutputStream());

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out, "UTF-8"));
            writer.write(data);
            writer.flush();
            writer.close();
            out.close();
            int responseStatusCode = httpURLConnection.getResponseCode();//응답

            Log.d(TAG, "POST response code - " + responseStatusCode);

            InputStream inputStream;
            if(responseStatusCode == HttpURLConnection.HTTP_OK) {//정상응답
                inputStream = httpURLConnection.getInputStream();
            }
            else{
                inputStream = httpURLConnection.getErrorStream();//에러
            }


            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");//수신값 저장
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuilder sb = new StringBuilder();
            String line = null;

            while((line = bufferedReader.readLine()) != null){
                sb.append(line);
            }

            Log.d(TAG, "doInBackground: "+sb.toString());
            bufferedReader.close();

            return sb.toString();


        } catch (Exception e) {

            Log.d(TAG, "InsertData: Error ", e);

            return new String("Error: " + e.getMessage());
        }
    }
}
