package com.example.lesson3_customed_listview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CityAdapter extends ArrayAdapter<City> {

    private List<City> cities;
    private Context context;

    public CityAdapter(@NonNull Context context, List<City> cities) {
        super(context, R.layout.item_city, cities);
        this.context = context;
        this.cities = cities;
    }

    static class ViewContainer{
        TextView lblCity;
        ImageView imgCity;
        CheckBox chkSelected;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        ViewContainer viewContainer = null;
        if(view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_city, parent, false);
            viewContainer = new ViewContainer();
            viewContainer.lblCity = view.findViewById(R.id.lblCity);
            viewContainer.imgCity = view.findViewById(R.id.imgCity);
            viewContainer.chkSelected = view.findViewById(R.id.chkSelected);
            viewContainer.chkSelected.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Toast.makeText(context, "checked: " + compoundButton.isChecked(), Toast.LENGTH_SHORT).show();
                    cities.get((Integer) compoundButton.getTag()).setSelected(compoundButton.isChecked());
                }
            });

            view.setTag(viewContainer);
        }else{
            viewContainer = (ViewContainer)view.getTag();
        }

        City city = cities.get(position);
        viewContainer.chkSelected.setTag(position);
        viewContainer.lblCity.setText(city.getName());
        viewContainer.imgCity.setImageResource(city.getImage());
        viewContainer.chkSelected.setChecked(city.isSelected());
        return view;
    }
}
