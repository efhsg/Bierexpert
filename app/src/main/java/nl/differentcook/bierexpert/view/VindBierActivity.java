package nl.differentcook.bierexpert.view;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import nl.differentcook.bierexpert.R;
import nl.differentcook.bierexpert.lib.Appl;
import nl.differentcook.bierexpert.model.Bierexpert;

public class VindBierActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vind_bier);
        ((Spinner) findViewById(R.id.biertypenSpinner)).setOnItemSelectedListener(new BiertypeSpinnerActivity());
    }

    public void vindLanden(View view) {
        Spinner bierType = (Spinner) findViewById(R.id.biertypenSpinner);
        Bierexpert bierexpert = new Bierexpert(String.valueOf(bierType.getSelectedItem()));
        ((TextView) findViewById(R.id.landenText)).setText(Appl.listToStringbuilder(bierexpert.getLanden()));
    }

    public void vindMerken(View view) {
        Spinner bierType = (Spinner) findViewById(R.id.biertypenSpinner);
        Bierexpert bierexpert = new Bierexpert(String.valueOf(bierType.getSelectedItem()));
        ((TextView) findViewById(R.id.merkenText)).setText(Appl.listToStringbuilder(bierexpert.getMerken()));
    }


    public class BiertypeSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            wisSelecties(view);
            Log.i(Appl.getTag(), "Biertype: " + parent.getItemAtPosition(pos).toString());
        }

        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    private void wisSelecties(View view) {
        ((TextView) (findViewById(R.id.landenText))).setText("");
        ((TextView) (findViewById(R.id.merkenText))).setText("");
    }

}