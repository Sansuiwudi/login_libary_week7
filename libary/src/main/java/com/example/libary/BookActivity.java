package com.example.libary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import org.litepal.LitePal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookActivity extends AppCompatActivity {

    String  name ;
    String Author ;
    String Price;
    String CategoryName;


    public ListView listView;


    public List<Book_category> arrayList= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        getlitepalData();
        MyAdapter adapter=new MyAdapter(BookActivity.this,R.layout.book_item,arrayList);
        listView =(ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }


    private void getlitepalData() {

        List<Category> categories=LitePal.findAll(Category.class);

        for (Category category : categories) {
            //取出数据库的每一项数据

            List<Book> books = category.getBooks();
            for (Book book:books){
                name = book.getName();
                Author = book.getAuthor();
                Price = String.valueOf(book.getPrice());
                CategoryName=category.getCategoryName();
                Book_category book_category=new Book_category(name,Author,Price,CategoryName);
                arrayList.add(book_category);
            }

        }

    }
}