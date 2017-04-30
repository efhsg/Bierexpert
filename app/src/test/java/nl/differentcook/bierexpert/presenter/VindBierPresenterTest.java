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
        VindBierPresenter vindBierPresenter = new VindBierPresenter(bierview);
        vindBierPresenter.laadLanden("Pils");

        //then
        assertEquals(true, ((MockView) bierview).passed);

    }

    @Test
    public void laadMerken() throws Exception {

        assertEquals(4, 2 + 2);

    }

    private class MockView implements IVindBierView {

        boolean passed;

        @Override
        public void toonLanden(List<String> landenLijst) {
            passed = true;
        }

        @Override
        public void toonMerken(List<String> merkenLijst) {
            passed = true;
        }
    }

    private class MockBierexpert implements IBierexpert {
        @Override
        public String getType() {
            return null;
        }

        @Override
        public void setType(String type) {

        }

        @Override
        public List<String> getLanden() {
            return Arrays.asList("Nederland", "België", "Duitsland");
        }

        @Override
        public List<String> getMerken() {
            return null;
        }
    }
}