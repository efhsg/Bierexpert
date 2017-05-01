package nl.differentcook.bierexpert.view;

import android.view.View;

import java.util.List;

/**
 * Created by esg on 29/04/2017.
 */

public interface IVindBierView {
    void toonLanden(List<String> landenLijst);

    void toonGeenLanden();

    void toonMerken(List<String> merkenLijst);
}
