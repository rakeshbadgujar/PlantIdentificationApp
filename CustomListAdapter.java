package com.example.wilidflower;

/**
 * Created by USER on 2/6/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends BaseAdapter implements Filterable {

    private final Context context;
    private List<Flower> flowerList;
    LayoutInflater mInflater;
    private ItemFilter mFilter = new ItemFilter();

    public CustomListAdapter(Context context, List<Flower> flowers) {
        mInflater = LayoutInflater.from(context);
        this.context=context;
        this.flowerList = flowers;
    }

    @Override
    public int getCount() {
        return flowerList.size();
    }

    @Override
    public Object getItem(int position) {
        return flowerList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {

        Holder holder;

        if(view == null) {
            view=mInflater.inflate(R.layout.mylist, null,true);

            holder = new Holder();
            holder.mTitle = (TextView) view.findViewById(R.id.item);
            holder.mImage = (ImageView) view.findViewById(R.id.icon);
            holder.mDescription = (TextView) view.findViewById(R.id.textView1);

            view.setTag(holder);

        }else {
            holder = (Holder) view.getTag();
        }

        holder.mTitle.setText(flowerList.get(position).getName());
        Picasso.with(context).load(flowerList.get(position).getImageView()).into(holder.mImage);
        holder.mDescription.setText(flowerList.get(position).getDescription());

        return view;
    };


    @Override
    public Filter getFilter() {
        return mFilter;
    }


    private class ItemFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            String filterString = constraint.toString().toLowerCase();

            FilterResults results = new FilterResults();

            final List<Flower> list = flowerList;

            int count = list.size();
            final ArrayList<Flower> nlist = new ArrayList<Flower>(count);

            String filterableString ;

            for (int i = 0; i < count; i++) {
                filterableString = list.get(i).getName();
                if (filterableString.toLowerCase().contains(filterString)) {
                    nlist.add(list.get(i));
                }
            }

            results.values = nlist;
            results.count = nlist.size();

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            flowerList= (ArrayList<Flower>) results.values;
            notifyDataSetChanged();
        }
    }
}




class Holder {
    TextView mTitle;
    ImageView mImage;
    TextView mDescription;
}
