package com.example.sambal.app2fetchinstalledappdetails_sambal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Sambal on 2/15/2018.
 */

public class MyAdapter extends BaseAdapter {
    private LayoutInflater layoutInflater;
    private List<ListMembersApp> listStorage;

    public MyAdapter(Context context, List<ListMembersApp> customizedListView) {
        layoutInflater =(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        listStorage = customizedListView;
    }

    @Override
    public int getCount() {
        return listStorage.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder listViewHolder;
        if(convertView == null){
            listViewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.activity_list_members_app, parent, false);

            listViewHolder.textInListView = convertView.findViewById(R.id.itemAppDetails);

            convertView.setTag(listViewHolder);
        }else{
            listViewHolder = (ViewHolder)convertView.getTag();
        }
        listViewHolder.textInListView.setText((CharSequence) listStorage.get(position).getItemAppDetails());

        return convertView;
    }

    static class ViewHolder{

        TextView textInListView;
    }
}

