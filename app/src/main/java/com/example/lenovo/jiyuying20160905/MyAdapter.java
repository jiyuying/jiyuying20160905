package com.example.lenovo.jiyuying20160905;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lenovo on 2016/9/5.
 */
public class MyAdapter extends BaseAdapter{
    Context context;
    List<Student> list;
    public MyAdapter(Context context, List<Student> list) {
        this.context=context;
        this.list=list;

    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(context,R.layout.item,null);
        TextView xuehao= (TextView) v.findViewById(R.id.xuehao);
        TextView name= (TextView) v.findViewById(R.id.name);
        TextView school= (TextView) v.findViewById(R.id.school);
        TextView tel= (TextView) v.findViewById(R.id.tel);
        TextView phone= (TextView) v.findViewById(R.id.phone);
        TextView add= (TextView) v.findViewById(R.id.add);

        Student stu = list.get(position);
       xuehao.setText(stu.xuehao);
        name.setText(stu.name);
        school.setText(stu.school);
        tel.setText("手机号："+stu.tel);
        phone.setText("固定电话"+stu.phone);
        add.setText(stu.address);







        return v;
    }
}
