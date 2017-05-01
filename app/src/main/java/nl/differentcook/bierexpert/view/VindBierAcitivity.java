package nl.differentcook.bierexpert.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import nl.differentcook.bierexpert.R;
import nl.differentcook.bierexpert.lib.App;
import nl.differentcook.bierexpert.presenter.VindBierPresenter;

public class VindBierAcitivity extends Activity implements IVindBierView {

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

    @Override
    public void toonGeenLanden() {
        ((TextView) findViewById(R.id.landenText)).setText(R.string.geen_landen_gevonden);
    }

    public void merkenButonClicked(View view) {
        vindBierPresenter.laadMerken(String.valueOf(((Spinner) findViewById(R.id.biertypenSpinner)).getSelectedItem()));
    }

    @Override
    public void toonMerken(List<String> merkenLijst) {
        ((TextView) findViewById(R.id.merkenText)).setText(App.listToStringbuilder(merkenLijst));
    }

    public class BiertypeSpinnerActivity extends Activity implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent, View view,
                                   int pos, long id) {
            wisSelecties();
        }

        public void onNothingSelected(AdapterView<?> parent) {
        }
    }

    private void wisSelecties() {
        ((TextView) (findViewById(R.id.landenText))).setText("");
        ((TextView) (findViewById(R.id.merkenText))).setText("");
    }

}
