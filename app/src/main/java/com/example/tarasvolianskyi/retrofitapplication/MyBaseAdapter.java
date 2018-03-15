package com.example.tarasvolianskyi.retrofitapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tarasvolianskyi on 15.03.18.
 */

public class MyBaseAdapter extends BaseAdapter {

    private class ViewHolder {
        TextView tvIdOfOneItem;
        TextView tvTimeOfOneItem;
        TextView tvTextOfOneItem;
        ImageView ivImageUrlOfOneItem;
    }

    private List<Message> data;
    private Context context;
    private LayoutInflater inflater;

    public MyBaseAdapter(List<Message> data, Context context) {
        this.data = data;
        this.context = context;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override

    public View getView(int position, View view, ViewGroup viewGroup) {
        View v;
        ViewHolder viewHolder;
        if (view == null) {
            v = inflater.inflate(R.layout.view_of_item, viewGroup, false);
            viewHolder = new ViewHolder();


            viewHolder.tvIdOfOneItem = (TextView)
                    view.findViewById(R.id.tvIdOfOneItem);
            viewHolder.tvTimeOfOneItem = (TextView)
                    view.findViewById(R.id.tvTimeOfOneItem);
            viewHolder.tvTextOfOneItem = (TextView)
                    view.findViewById(R.id.tvTextOfOneItem);
            viewHolder.ivImageUrlOfOneItem = (ImageView)
                    view.findViewById(R.id.ivImageUrlOfOneItem);
            v.setTag(viewHolder);

        } else {
            v = view;
            viewHolder = (ViewHolder) v.getTag();
        }

        viewHolder.tvIdOfOneItem.setText(String.valueOf(data.get(position).getId()));
        viewHolder.tvTimeOfOneItem.setText(String.valueOf(data.get(position).getTime()));
        viewHolder.tvTextOfOneItem.setText(data.get(position).getText());
        //ivImageUrlOfOneItem.setImageResource(currentMessage.getImage());

        return v;

    }
}
