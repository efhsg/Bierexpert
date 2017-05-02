package nl.differentcook.bierexpert.presenter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import nl.differentcook.bierexpert.model.IBierexpert;
import nl.differentcook.bierexpert.view.IVindBierView;

import static org.junit.Assert.*;

/**
 * Created by esg on 30/04/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class VindBierPresenterTest {

    @Mock
    IBierexpert bierexpert;

    @Mock
    IVindBierView bierview;

    @Test
    public void laadLandenGevonden() throws Exception {

        //given
        List<String> landenLijst = Arrays.asList("Nederland", "België", "Duitsland");
        Mockito.when(bierexpert.getLanden("Pils")).thenReturn(landenLijst);

        //when
        VindBierPresenter vindBierPresenter = new VindBierPresenter(bierview, bierexpert);
        vindBierPresenter.laadLanden("Pils");

        //then
        Mockito.verify(bierview).toonLanden(landenLijst);

    }

    @Test
    public void laadGeenLandenGevonden() throws Exception {

        //when
        VindBierPresenter vindBierPresenter = new VindBierPresenter(bierview, bierexpert);
        vindBierPresenter.laadLanden("Pils");

        //then
        Mockito.verify(bierview).toonGeenLanden();

    }

    @Test
    public void laadMerken() throws Exception {

        //given
        List<String> merkenLijst = Arrays.asList("Grolsch", "Leffe");
        Mockito.when(bierexpert.getMerken("Blond")).thenReturn(merkenLijst);

        //when
        VindBierPresenter vindBierPresenter = new VindBierPresenter(bierview, bierexpert);
        vindBierPresenter.laadMerken("Blond");

        //then
        Mockito.verify(bierview).toonMerken(merkenLijst);

    }

}