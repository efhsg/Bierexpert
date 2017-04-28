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
import nl.differentcook.bierexpert.model.Bierexpert;
import nl.differentcook.bierexpert.model.BierexpertInterface;

public class VindBierActivity extends Activity {

    private BierexpertInterface bierexpert = new Bierexpert("");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vind_bier);
        ((Spinner) findViewById(R.id.biertypenSpinner)).setOnItemSelectedListener(new BiertypeSpinnerActivity());
    }

    public void vindLanden(View view) {
        Spinner bierType = (Spinner) findViewById(R.id.biertypenSpinner);
        bierexpert.setType(String.valueOf(bierType.getSelectedItem()));
        ((TextView) findViewById(R.id.landenText)).setText(App.listToStringbuilder(bierexpert.getLanden()));
    }

    public void vindMerken(View view) {
        Spinner bierType = (Spinner) findViewById(R.id.biertypenSpinner);
        bierexpert = new Bierexpert(String.valueOf(bierType.getSelectedItem()));
        ((TextView) findViewById(R.id.merkenText)).setText(App.listToStringbuilder(bierexpert.getMerken()));
    }


    public class BiertypeSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            wisSelecties(view);
            Log.i(App.getTag(), "Biertype: " + parent.getItemAtPosition(pos).toString());
        }

        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    private void wisSelecties(View view) {
        ((TextView) (findViewById(R.id.landenText))).setText("");
        ((TextView) (findViewById(R.id.merkenText))).setText("");
    }

}
