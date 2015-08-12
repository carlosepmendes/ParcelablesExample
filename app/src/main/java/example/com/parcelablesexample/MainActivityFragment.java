package example.com.parcelablesexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private CityAdapter cityAdapter;

    private ArrayList<City> cityArrayList;

    public MainActivityFragment() {
    }

    //This will be our fake data
    City[] cities = {
            new City("Ponta Delgada", "Portugal", "https://upload.wikimedia.org/wikipedia/commons/9/91/Portas_p_delgada.jpg" ),
            new City("Luanda","Angola","http://perlbal.hi-pi.com/blog-images/504025/gd/1224795445/LUANDA-ANGOLA.jpg"),
            new City("São Paulo","Brasil","http://blog.luz.vc/wp-content/uploads/2013/05/S%C3%A3o-Paulo.jpg"),
            new City("Maputo","Moçambique","https://upload.wikimedia.org/wikipedia/commons/c/cf/2010-10-18_10-56-01_Mozambique_Maputo_Aeroporto_%E2%80%9DB%E2%80%9D.jpg")
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null || !savedInstanceState.containsKey("cities")) {
            cityArrayList = new ArrayList<>(Arrays.asList(cities));

        }
        else {
            cityArrayList = savedInstanceState.getParcelableArrayList("cities");
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_main, container, false);

        cityAdapter = new CityAdapter(getActivity(), cityArrayList);

        //set the adaptor
        final ListView listView = (ListView) rootView.findViewById(R.id.listview_city);
        listView.setAdapter(cityAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Bundle extras = new Bundle();
                extras.putParcelableArrayList("cities", cityArrayList);
                extras.putInt("position", i);

                ((Callback)getActivity())
                        .onItemSelected(extras);

            }
        });

        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("cities", cityArrayList);
    }

    /**
     * A callback interface that all activities containing this fragment must
     * implement. This mechanism allows activities to be notified of item
     * selections.
     */
    public interface Callback {
        /**
         * DetailFragmentCallback for when an item has been selected.
         */
        public void onItemSelected(Bundle extra);
    }

}
