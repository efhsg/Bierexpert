package nl.differentcook.bierexpert.presenter;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import nl.differentcook.bierexpert.model.IBierexpert;
import nl.differentcook.bierexpert.view.IVindBierView;

import static org.junit.Assert.*;

/**
 * Created by esg on 30/04/2017.
 */
public class VindBierPresenterTest {
    @Test
    public void laadLanden() throws Exception {

        //given
        IVindBierView bierview = new MockView();
        IBierexpert bierexpert = new MockBierexpert();

        //when
        VindBierPresenter vindBierPresenter = new VindBierPresenter(bierview, bierexpert);
        vindBierPresenter.laadLanden("Pils");

        //then
        assertTrue(((MockView) bierview).passed);

    }

    @Test
    public void laadMerken() throws Exception {

        //given
        IVindBierView bierview = new MockView();
        IBierexpert bierexpert = new MockBierexpert();

        //when
        VindBierPresenter vindBierPresenter = new VindBierPresenter(bierview, bierexpert);
        vindBierPresenter.laadMerken("Blond");

        //then
        assertTrue(((MockView) bierview).passed);

    }

    private class MockView implements IVindBierView {

        boolean passed;

        @Override
        public void toonLanden(List<String> landenLijst) {
            passed = (landenLijst.size() == 3);
        }

        @Override
        public void toonMerken(List<String> merkenLijst) {
            passed = (merkenLijst.size() == 2);
        }
    }

    private class MockBierexpert implements IBierexpert {
        @Override
        public List<String> getLanden(String type) {
            return Arrays.asList("Nederland", "België", "Duitsland");
        }

        @Override
        public List<String> getMerken(String type) {
            return Arrays.asList("Grolsch", "Leffe");
        }
    }
}