package com.example.libary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.litepal.LitePal;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createDatabase = findViewById(R.id.create_database);
        Button addData = findViewById(R.id.add_data);
        Button addexistData=findViewById(R.id.add_data_exist);
        Button deleleData = findViewById(R.id.delete_data);
        Button main = findViewById(R.id.main);

        createDatabase.setOnClickListener(this);
        addData.setOnClickListener(this);
        addexistData.setOnClickListener(this);
        deleleData.setOnClickListener(this);
        main.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.create_database:
                LitePal.getDatabase();
                Toast.makeText(MainActivity.this, "创建数据库成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.add_data:

                Book b1= new Book();
                b1.setId(1);
                b1.setAuthor("曹雪芹");
                b1.setName("《红楼梦》");
                b1.setPages(186);
                b1.setPrice(56);
                b1.save();

                Book b2 = new Book();
                b2.setId(2);
                b2.setAuthor("吴承恩");
                b2.setName("《水浒传》");
                b2.setPages(200);
                b2.setPrice(80);
                b2.save();

                Book b3 = new Book();
                b3.setId(3);
                b3.setAuthor("罗贯中");
                b3.setName("《三国演义》");
                b3.setPages(256);
                b3.setPrice(46);
                b3.save();

                Book b4 = new Book();
                b4.setId(4);
                b4.setAuthor("施耐庵");
                b4.setName("《西游记》");
                b4.setPages(520);
                b4.setPrice(80);
                b4.save();

                Category c1=new Category();
                c1.setId(1);
                c1.setCategoryName("中国名著");
                c1.setCategoryCode(12345);
                c1.getBookList().add(b1);
                c1.getBookList().add(b2);
                c1.getBookList().add(b3);
                c1.getBookList().add(b4);
                c1.save();
                Category c2=new Category();
                c2.setId(2);
                c2.setCategoryName("儿童读物");
                c2.setCategoryCode(54321);
                c2.save();
                Toast.makeText(MainActivity.this, "添加数据成功", Toast.LENGTH_SHORT).show();
                break;
/*            case R.id.select_data:

                List<Book> books = LitePal.findAll(Book.class);
                List<Category> Cs=LitePal.findAll(Category.class);

                for (Book book : books) {
                    Log.d("数据库目前数据", "book name is" + book.getName());
                   *//* Log.d("this", "book auther is" + book.getBookAuthor());
                    Log.d("this", "book pages is" + book.getBookPages());
                    Log.d("this", "book press is" + book.getBookPrice());*//*
                }
                for (Category c: Cs) {
                    Log.d("qqq", "Category name is" + c.getCategoryName());
                    List<Book> b = c.getBooks();
                    for (Book bl:b){
                    Log.d("qqq", "book name is" + bl.getName());
                        Log.d("qqq", "Category name is" + c.getCategoryName());}
                   *//* Log.d("this", "book auther is" + book.getBookAuthor());
                    Log.d("this", "book pages is" + book.getBookPages());
                    Log.d("this", "book press is" + book.getBookPrice());*//*
                }
                break;*/

            case R.id.add_data_exist:
                Intent intent1 = new Intent();
                intent1.setClass(MainActivity.this,addBookActivity.class);
                startActivity(intent1);
                break;

            case R.id.delete_data:
                LitePal.deleteAll(Book.class,"id>=?","1");//删除book表中，价格大于4的书
                LitePal.deleteAll(Category.class,"id>=?","1");
                Toast.makeText(MainActivity.this,"删除数据成功",Toast.LENGTH_SHORT).show();
                break;
            case R.id.main:

                Intent intent = new Intent();
                intent.setClass(MainActivity.this,BookActivity.class);
                startActivity(intent);


        }
    }

}