package nl.differentcook.bierexpert.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

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
        TextView landen = (TextView) findViewById(R.id.landenText);
        Spinner color = (Spinner) findViewById(R.id.biertypenSpinner);
        String beerType = String.valueOf(color.getSelectedItem());

        List<String> landenLijst = new ArrayList<String>();
        switch (beerType) {
            case "Blond":
                landenLijst.add("België");
                landenLijst.add("Duitsland");
                landenLijst.add("Nederland");
                break;
            case "Geuze":
                landenLijst.add("België");
                break;
            case "Lentebok":
                landenLijst.add("Nederland");
                break;
            case "Pils":
                landenLijst.add("België");
                landenLijst.add("Denemarken");
                landenLijst.add("Duitsland");
                landenLijst.add("Nederland");
                landenLijst.add("Tsjechië");
                break;
            case "Tripel":
                landenLijst.add("België");
                landenLijst.add("Nederland");
                break;
            case "Weizen":
                landenLijst.add("Duitsland");
                landenLijst.add("Nederland");
                break;
        }

        StringBuilder landenFormatted = new StringBuilder();
        for (String land : landenLijst) {
            landenFormatted.append(land).append('\n');
        }
        landen.setText(landenFormatted);
    }

    public void vindMerken(View view) {
        TextView merken = (TextView) findViewById(R.id.merkenText);
        Spinner color = (Spinner) findViewById(R.id.biertypenSpinner);
        String beerType = String.valueOf(color.getSelectedItem());

        List<String> merkenLijst = new ArrayList<String>();
        switch (beerType) {
            case "Blond":
                merkenLijst.add("Affligem");
                merkenLijst.add("Jopen");
                merkenLijst.add("Leffe");
                merkenLijst.add("Wieninger");
                break;
            case "Geuze":
                merkenLijst.add("Belle-Vue");
                break;
            case "Lentebok":
                merkenLijst.add("Bavaria");
                merkenLijst.add("De Leckere");
                break;
            case "Pils":
                merkenLijst.add("Carlsberg");
                merkenLijst.add("Grolsch");
                merkenLijst.add("Jupiler");
                merkenLijst.add("Pinkus");
                merkenLijst.add("Urquell");
                break;
            case "Tripel":
                merkenLijst.add("Grimbergen");
                merkenLijst.add("Westmalle");
                break;
            case "Weizen":
                merkenLijst.add("Erdinger");
                merkenLijst.add("PaulanerK");
                break;
        }

        StringBuilder merkenFormatted = new StringBuilder();
        for (String merk : merkenLijst) {
            merkenFormatted.append(merk).append('\n');
        }
        merken.setText(merkenFormatted);

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
