package nl.differentcook.bierexpert.presenter;


import java.util.Collections;
import java.util.List;

import nl.differentcook.bierexpert.model.Bierexpert;
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
        bierexpert = new Bierexpert();
    }

    public VindBierPresenter(IVindBierView bierView, IBierexpert bierexpert) {
        this.bierView = bierView;
        this.bierexpert = bierexpert;
    }

    public void laadLanden(String bierType) {
        List<String> landenList = bierexpert.getLanden(bierType);
        if (landenList == Collections.EMPTY_LIST) {
            bierView.toonGeenLanden();
        }
        else {
            bierView.toonLanden(landenList);
        }

    }

    public void laadMerken(String bierType) {
        bierView.toonMerken(bierexpert.getMerken(bierType));
    }

}
