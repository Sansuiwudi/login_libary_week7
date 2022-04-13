package com.example.libary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import org.litepal.LitePal;
public class addBookActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);
        Button add1=findViewById(R.id.add1);
        Button add2=findViewById(R.id.add2);
        Button re_turn=findViewById(R.id.re_main);
        add1.setOnClickListener(this);
        add2.setOnClickListener(this);
        re_turn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add1:
                Book b1= new Book();
                b1.setId(6);
                b1.setAuthor("安徒生");
                b1.setName("《格林童话》");
                b1.setPages(166);
                b1.setPrice(15);
                b1.save();
                Category c1=new Category();
                c1.setId(2);
                c1.setCategoryName("儿童读物");
                c1.setCategoryCode(54321);
                c1.getBookList().add(b1);
                c1.save();
                Toast.makeText(addBookActivity.this, "添加数据成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add2:
                Book b2= new Book();
                Category a=new Category();
                b2.setId(5);
                b2.setAuthor("蒲松龄");
                b2.setName("《聊斋志异》");
                b2.setPages(250);
                b2.setPrice(20);
                b2.save();

                a.setId(1);
                a.setCategoryName("中国名著");
                a.setCategoryCode(12345);
                a.getBookList().add(b2);
                a.update(1);

                a.save();
                Toast.makeText(addBookActivity.this, "添加数据成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.re_main:
                Intent intent = new Intent();
                intent.setClass(addBookActivity.this,BookActivity.class);
                startActivity(intent);
        }
    }
}