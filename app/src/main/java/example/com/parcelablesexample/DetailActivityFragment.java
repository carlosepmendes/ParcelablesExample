package example.com.parcelablesexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class DetailActivityFragment extends Fragment {

    static final String DETAIL = "DETAIL";
    static final String POS = "POS";

    private ArrayList<City> myList;
    int i;
    public DetailActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.fragment_detail, container, false);

        Bundle arguments = getArguments();

        if (arguments != null) {

            myList = arguments.getParcelableArrayList(DETAIL);
            i = arguments.getInt(POS);
            TextView text = (TextView) rootView.findViewById(R.id.textView);
            text.setText(myList.get(i).name);
        }



        return rootView;
    }

}
