package com.doubleC.grape.business.find.database.daapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.doubleC.grape.R;
import com.doubleC.grape.business.find.database.bean.GrapeDataBaseBean;

public class DataBaseAdapter extends BaseAdapter{
    
    private List<GrapeDataBaseBean> list;
    private LayoutInflater inflater;
    
    public DataBaseAdapter(Context context,List<GrapeDataBaseBean> list) {
        this.list = list;
        inflater = LayoutInflater.from(context);
    }
    
    @Override
    public int getCount() {
        return list==null?0:list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(null==convertView){
            convertView = inflater.inflate(R.layout.database_test_itme,null);
            holder = new ViewHolder();
            holder.id = (TextView) convertView.findViewById(R.id.database_test1_id);
            holder.name = (TextView) convertView.findViewById(R.id.database_test1_name);
            holder.description = (TextView) convertView.findViewById(R.id.database_test1_description);
            
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        
        holder.id.setText(String.valueOf(list.get(position).getId()));
        holder.name.setText(list.get(position).getName());
        holder.description.setText(list.get(position).getDescription());
        
        return convertView;
    }

    private class ViewHolder{
        private TextView id;
        private TextView name;
        private TextView description;
    }
    
}
