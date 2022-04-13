package com.example.libary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MyAdapter extends ArrayAdapter<Book_category> {
    private int resourceId;
    public MyAdapter(Context context,int textViewResourceId, List<Book_category> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book_category bc=getItem(position);
        View view;
        ViewHolder viewHolder;

        if(convertView==null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.bookname=(TextView) view.findViewById(R.id.book_name);
            viewHolder.bookauthor=(TextView) view.findViewById(R.id.book_author);
            viewHolder.bookprice=(TextView) view.findViewById(R.id.book_price);
            viewHolder.bookcategory=(TextView) view.findViewById(R.id.book_category);
            view.setTag(viewHolder);
        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag(); // 重新获取ViewHolder
        }
        viewHolder.bookname.setText(bc.getName());
        viewHolder.bookauthor.setText(bc.getAuthor());
        viewHolder.bookprice.setText(bc.getPrice());
        viewHolder.bookcategory.setText(bc.getCategoryName());
//
        return view;
    }
    class ViewHolder{
        TextView bookname;
        TextView bookauthor;
        TextView bookprice;
        TextView bookcategory;
}
}
