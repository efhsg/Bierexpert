package nl.differentcook.bierexpert.presenter;


import java.util.List;

import nl.differentcook.bierexpert.component.BierexpertComponent;
import nl.differentcook.bierexpert.component.DaggerBierexpertComponent;
import nl.differentcook.bierexpert.model.IBierexpert;
import nl.differentcook.bierexpert.module.BierexpertModule;
import nl.differentcook.bierexpert.view.IVindBierView;


/**
 * Created by esg on 29/04/2017.
 */

public class VindBierPresenter {

    private IVindBierView bierView;
    private IBierexpert bierexpert;

    public VindBierPresenter(IVindBierView bierView, IBierexpert bierexpert) {
        this.bierView = bierView;
        this.bierexpert = bierexpert;
    }

    public VindBierPresenter(IVindBierView bierView) {
        this.bierView = bierView;
        this.bierexpert = (DaggerBierexpertComponent.builder().build()).provideBierexpert();
    }

    public void laadLanden(String bierType) {
        List<String> landenList = bierexpert.getLanden(bierType);
        if (landenList.size() == 0) {
            bierView.toonGeenLanden();
        } else {
            bierView.toonLanden(landenList);
        }

    }

    public void laadMerken(String bierType) {
        bierView.toonMerken(bierexpert.getMerken(bierType));
    }

}
