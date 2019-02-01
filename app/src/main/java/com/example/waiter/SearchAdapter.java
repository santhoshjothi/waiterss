package com.example.waiter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Filter;

import com.example.waiter.model.Food;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends ArrayAdapter<Food> {

        private Context context;
        private int resourceId;
        private List<Food> items, tempItems, suggestions;

        public SearchAdapter(@NonNull Context context, int resourceId, ArrayList<Food> items) {
                super(context, resourceId, items);
                this.items = items;
                this.context = context;
                this.resourceId = resourceId;
                tempItems = new ArrayList<>(items);
                suggestions = new ArrayList<>();
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = convertView;
                try {
                        if (convertView == null) {
                                LayoutInflater inflater = ((Activity) context).getLayoutInflater();
                                view = inflater.inflate(resourceId, parent, false);
                        }
                        Food fruit = getItem(position);
                        TextView name = (TextView) view.findViewById(R.id.label);
//                        ImageView imageView = view.findViewById(R.id.imageView);
//                        imageView.setImageResource(fruit.getImage());
                        name.setText(fruit.getmName().toString());
                } catch (Exception e) {
                        e.printStackTrace();
                }
                return view;
        }

        @Nullable
        @Override
        public Food getItem(int position) {
                return items.get(position);
        }

        @Override
        public int getCount() {
                return items.size();
        }

        @Override
        public long getItemId(int position) {
                return position;
        }

        @NonNull
        @Override
        public Filter getFilter() {
                return fruitFilter;
        }

        private Filter fruitFilter = new Filter() {
                @Override
                public CharSequence convertResultToString(Object resultValue) {
                        Food fruit = (Food) resultValue;
                        return fruit.getmName().toString();
                }

                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                        if (charSequence != null) {
                                suggestions.clear();
                                for (Food fruit: tempItems) {
                                        if (fruit.getmName().toLowerCase().startsWith(charSequence.toString().toLowerCase())) {
                                                suggestions.add(fruit);
                                        }
                                }

                                FilterResults filterResults = new FilterResults();
                                filterResults.values = suggestions;
                                filterResults.count = suggestions.size();
                                return filterResults;
                        } else {
                                return new FilterResults();
                        }
                }

                @Override
                protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                        ArrayList<Food> c = (ArrayList<Food>) filterResults.values;
                        if (filterResults != null && filterResults.count > 0) {
                                clear();
                                for (Food cust : c) {
                                        add(cust);
                                        notifyDataSetChanged();
                                }
                        } else {
                                clear();
                                notifyDataSetChanged();
                        }
                }
        };
}