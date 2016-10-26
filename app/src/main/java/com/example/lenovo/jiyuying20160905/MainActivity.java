package com.example.lenovo.jiyuying20160905;

import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Xml;
import android.view.View;
import android.widget.ListView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class MainActivity extends AppCompatActivity {

    private ListView lv;
    private List<Student> list=new ArrayList<Student>();
    private Student s;
    private String name;
//android.os.Handler handler=new android.os.Handler(){
//    @Override
//    public void handleMessage(Message msg) {
//        super.handleMessage(msg);
//    }
//};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);

       new Thread(
               new Runnable() {
                   @Override
                   public void run() {
                       setData();
                   }
               }
       ).start();
    }
    public void setData(){
        XmlPullParser parser = Xml.newPullParser();
        try {
            URL url=new URL("http://172.17.29.120/localuser/loupengfei/kaoshi/student.xml");
            try {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();
                if(connection.getResponseCode()==200){
                    InputStream inputStream = connection.getInputStream();
                    try {
                        parser.setInput(inputStream,"utf-8");
                        int eventType = parser.getEventType();
                        while(eventType!=XmlPullParser.END_DOCUMENT){
                            switch (eventType){
                                case XmlPullParser.START_TAG:
                                    name = parser.getName();
                                    if("student".equals(name)){
                                        s = new Student();
                                        String value = parser.getAttributeValue(0);
                                        s.xuehao=value.trim();
                                    }
                                    if("name".equals(name)){
                                        String n = parser.nextText().trim();
                                        s.name=n;
                                    }
                                    if("address".equals(name)){
                                        String a = parser.nextText().trim();
                                        s.address=a;
                                    }
                                    if("phone".equals(name)){
                                        String p = parser.nextText().trim();
                                        s.phone=p;
                                    }
                                    if("tel".equals(name)){
                                        String t = parser.nextText().trim();
                                        s.tel=t;
                                    }
                                    if("school".equals(name)){
                                        String sc = parser.nextText().trim();
                                        s.school=sc;
                                    }
                                    break;
                                case XmlPullParser.END_TAG:
                                    name=parser.getName();
                                    if("student".equals(name)){
                                        list.add(s);
                                        System.out.print(list);
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {
                                                lv.setAdapter(new MyAdapter(MainActivity.this,list));

                                            }
                                        });
//                                        Message message=new Message();
//                                        message.obj=list;
//                                           handler.sendMessage(msg);
                                    }
                                    break;
                            }
                            eventType=parser.next();
                        }
                    } catch (XmlPullParserException e) {
                        e.printStackTrace();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
