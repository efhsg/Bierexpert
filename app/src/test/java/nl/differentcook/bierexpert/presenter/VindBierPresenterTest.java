package nl.differentcook.bierexpert.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import nl.differentcook.bierexpert.model.IBierexpert;
import nl.differentcook.bierexpert.view.IVindBierView;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by esg on 30/04/2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class VindBierPresenterTest {

    private final String BIERTYPE = "Pils";
    private final List<String> VEEL_LANDEN = Arrays.asList("Nederland", "België", "Duitsland");
    private final List<String> VEEL_MERKEN = Arrays.asList("Grolsch", "Bavaria", "Leffe", "Westmalle");

    private VindBierPresenter vindBierPresenter;

    @Mock
    private IBierexpert bierexpert;

    @Mock
    private IVindBierView bierview;

    @Before
    public void setUp() throws Exception {
        vindBierPresenter = new VindBierPresenter(bierview, bierexpert);
    }

    @Test
    public void laadLandenGevonden() throws Exception {

        //given
        when(bierexpert.getLanden(BIERTYPE)).thenReturn(VEEL_LANDEN);

        //when
        vindBierPresenter.laadLanden(BIERTYPE);

        //then
        verify(bierview).toonLanden(VEEL_LANDEN);

    }

    @Test
    public void laadGeenLandenGevonden() throws Exception {

        //when
        vindBierPresenter.laadLanden(BIERTYPE);

        //then
        verify(bierview).toonGeenLanden();

    }

    @Test
    public void laadMerken() throws Exception {

        //given
        when(bierexpert.getMerken(BIERTYPE)).thenReturn(VEEL_MERKEN);

        //when
        vindBierPresenter.laadMerken(BIERTYPE);

        //then
        verify(bierview).toonMerken(VEEL_MERKEN);

    }

}