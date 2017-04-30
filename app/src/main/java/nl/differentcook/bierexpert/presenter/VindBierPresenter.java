package nl.differentcook.bierexpert.presenter;


import nl.differentcook.bierexpert.model.IBierexpert;
import nl.differentcook.bierexpert.view.IVindBierView;


/**
 * Created by esg on 29/04/2017.
 */

public class VindBierPresenter {
    
    private IVindBierView bierView;
    private IBierexpert bierexpert;

    public VindBierPresenter(IVindBierView view) {
        this.bierView = view;
    }

    public VindBierPresenter(IVindBierView bierView, IBierexpert bierexpert) {
        this.bierView = bierView;
        this.bierexpert = bierexpert;
    }


    public void laadLanden(String bierType) {
        //@TODO haal de landen op en toon in view
    }

    public void laadMerken(String bierType) {
        //@TODO haal de merken op en toon in view
    }

}
