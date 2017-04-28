package nl.differentcook.bierexpert.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import nl.differentcook.bierexpert.R;
import nl.differentcook.bierexpert.lib.App;

public class VindBierActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vind_bier);
        Spinner spinner = (Spinner) findViewById(R.id.biertypenSpinner);
        spinner.setOnItemSelectedListener(new BiertypeSpinnerActivity());
    }


    public void vindLanden(View view) {
        TextView brands = (TextView) findViewById(R.id.landenText);
        Spinner color = (Spinner) findViewById(R.id.biertypenSpinner);
        String beerType = String.valueOf(color.getSelectedItem());

/*        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }*/
        brands.setText("vindLandenClick");
    }

    public void vindMerken(View view) {
        TextView brands = (TextView) findViewById(R.id.merkenText);
        Spinner color = (Spinner) findViewById(R.id.biertypenSpinner);
        String beerType = String.valueOf(color.getSelectedItem());

/*        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }*/
        brands.setText("vindMerkenClick");
    }

    public class BiertypeSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            wisSelecties(view);
            Log.i(App.getTag(), "Gekozen type: " + parent.getItemAtPosition(pos).toString());
        }

        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    private void wisSelecties(View view) {
        ((TextView) (findViewById(R.id.landenText))).setText("");
        ((TextView) (findViewById(R.id.merkenText))).setText("");
    }
}
