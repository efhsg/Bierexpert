package nl.differentcook.bierexpert.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import nl.differentcook.bierexpert.R;
import nl.differentcook.bierexpert.component.BierexpertComponent;
import nl.differentcook.bierexpert.component.DaggerBierexpertComponent;
import nl.differentcook.bierexpert.lib.App;
import nl.differentcook.bierexpert.model.Bierexpert;
import nl.differentcook.bierexpert.model.IBierexpert;
import nl.differentcook.bierexpert.module.BierexpertModule;
import nl.differentcook.bierexpert.presenter.VindBierPresenter;

public class VindBierAcitivity extends Activity implements IVindBierView {

    private VindBierPresenter vindBierPresenter;
    private IBierexpert bierexpert;

    @BindView(R.id.biertypenSpinner)
    Spinner biertypen;

    @BindView(R.id.landenText)
    TextView landen;

    @BindView(R.id.merkenText)
    TextView merken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vind_bier);
        ButterKnife.bind(this);

        BierexpertComponent bierexpertComponent =
                DaggerBierexpertComponent.builder().bierexpertModule(new BierexpertModule()).build();

        bierexpert = bierexpertComponent.provideBierexpert();

        vindBierPresenter = new VindBierPresenter(this, bierexpert);
    }

    @OnItemSelected(R.id.biertypenSpinner)
    public void spinnerItemSelected(Spinner spinner, int position) {
        landen.setText("");
        merken.setText("");
    }

    @OnClick(R.id.vindLandenButton)
    public void landenButtonClicked(View view) {
        vindBierPresenter.laadLanden(String.valueOf((biertypen.getSelectedItem())));
    }

    @OnClick(R.id.vindMerkenButton)
    public void merkenButonClicked(View view) {
        vindBierPresenter.laadMerken(String.valueOf(biertypen.getSelectedItem()));
    }

    @Override
    public void toonLanden(List<String> landenLijst) {
        landen.setText(App.listToStringbuilder(landenLijst));
    }

    @Override
    public void toonGeenLanden() {
        landen.setText(R.string.geen_landen_gevonden);
    }

    @Override
    public void toonMerken(List<String> merkenLijst) {
        merken.setText(App.listToStringbuilder(merkenLijst));
    }

}
