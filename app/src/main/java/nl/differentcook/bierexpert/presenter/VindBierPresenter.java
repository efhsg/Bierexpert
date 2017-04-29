package nl.differentcook.bierexpert.presenter;


import nl.differentcook.bierexpert.view.IVindBierView;


/**
 * Created by esg on 29/04/2017.
 */

public class VindBierPresenter {

    private IVindBierView view;

    public VindBierPresenter(IVindBierView view) {
        this.view = view;
    }

    public void laadLanden(String bierType) {
        //@TODO haal de landen op en toon in view
    }

    public void laadMerken(String bierType) {
        //@TODO haal de merken op en toon in view
    }

}
