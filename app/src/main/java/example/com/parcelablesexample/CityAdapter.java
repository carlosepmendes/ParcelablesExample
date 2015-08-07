package example.com.parcelablesexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Carlos Mendes on 05-08-2015.
 */
public class CityAdapter extends ArrayAdapter<City>{

    public CityAdapter(Context context, ArrayList<City> resource) {
        super(context,0, resource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        City city = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_city, parent, false);
        }

        TextView versionNameView = (TextView) convertView.findViewById(R.id.list_item_name);
        versionNameView.setText(city.name);

        TextView versionNumberView = (TextView) convertView.findViewById(R.id.list_item_country);
        versionNumberView.setText(city.country);
        return convertView;
    }

}
