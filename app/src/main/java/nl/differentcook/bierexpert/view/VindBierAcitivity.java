package nl.differentcook.bierexpert.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import nl.differentcook.bierexpert.R;
import nl.differentcook.bierexpert.presenter.VindBierPresenter;
import nl.differentcook.bierexpert.lib.App;
import nl.differentcook.bierexpert.model.Bierexpert;
import nl.differentcook.bierexpert.model.IBierexpert;

public class VindBierAcitivity extends Activity implements IVindBierView {

    private IBierexpert bierexpert = new Bierexpert("");

    private VindBierPresenter vindBierPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vind_bier);
        ((Spinner) findViewById(R.id.biertypenSpinner)).setOnItemSelectedListener(new BiertypeSpinnerActivity());

        vindBierPresenter = new VindBierPresenter(this);

    }

    public void landenButtonClicked(View view) {
        vindBierPresenter.laadLanden(String.valueOf(((Spinner) findViewById(R.id.biertypenSpinner)).getSelectedItem()));
    }

    @Override
    public void toonLanden(List<String> landenLijst) {
        ((TextView) findViewById(R.id.landenText)).setText(App.listToStringbuilder(landenLijst));
    }

    public void merkenButonClicked(View view) {
        vindBierPresenter.laadMerken(String.valueOf(((Spinner) findViewById(R.id.biertypenSpinner)).getSelectedItem()));
/*
        Spinner bierType = (Spinner) findViewById(R.id.biertypenSpinner);
        vindBierPresenter.laadLanden(String.valueOf(bierType.getSelectedItem()));
        bierexpert = new Bierexpert(String.valueOf(bierType.getSelectedItem()));
        ((TextView) findViewById(R.id.merkenText)).setText(App.listToStringbuilder(bierexpert.getMerken()));
*/
    }

    @Override
    public void toonMerken(List<String> merkenLijst) {
/*
        Spinner bierType = (Spinner) findViewById(R.id.biertypenSpinner);
        bierexpert = new Bierexpert(String.valueOf(bierType.getSelectedItem()));
        ((TextView) findViewById(R.id.merkenText)).setText(App.listToStringbuilder(bierexpert.getMerken()));
*/
    }

    public class BiertypeSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            wisSelecties(view);
//            Log.i(App.getTag(), "Biertype: " + parent.getItemAtPosition(pos).toString());
        }

        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    private void wisSelecties(View view) {
        ((TextView) (findViewById(R.id.landenText))).setText("");
        ((TextView) (findViewById(R.id.merkenText))).setText("");
    }

}
