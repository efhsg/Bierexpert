package nl.differentcook.bierexpert.model;

import java.util.ArrayList;
import java.util.List;


public class Bierexpert implements BierexpertInterface {

    private String type;

    public Bierexpert(String type) {
        this.type = type;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public List<String> getLanden() {
        List<String> landenLijst = new ArrayList<String>();
        switch (type) {
            case "Blond":
                landenLijst.add("België");
                landenLijst.add("Duitsland");
                landenLijst.add("Nederland");
                break;
            case "Geuze":
                landenLijst.add("België");
                break;
            case "Lentebok":
                landenLijst.add("Nederland");
                break;
            case "Pils":
                landenLijst.add("België");
                landenLijst.add("Denemarken");
                landenLijst.add("Duitsland");
                landenLijst.add("Frankrijk");
                landenLijst.add("Nederland");
                landenLijst.add("Tsjechië");
                break;
            case "Tripel":
                landenLijst.add("België");
                landenLijst.add("Nederland");
                break;
            case "Weizen":
                landenLijst.add("Duitsland");
                landenLijst.add("Nederland");
                break;
        }
        return landenLijst;
    }

    @Override
    public List<String> getMerken() {
        List<String> merkenLijst = new ArrayList<String>();
        switch (type) {
            case "Blond":
                merkenLijst.add("Affligem");
                merkenLijst.add("Jopen");
                merkenLijst.add("Leffe");
                merkenLijst.add("Wieninger");
                break;
            case "Geuze":
                merkenLijst.add("Belle-Vue");
                break;
            case "Lentebok":
                merkenLijst.add("Bavaria");
                merkenLijst.add("De Leckere");
                break;
            case "Pils":
                merkenLijst.add("Carlsberg");
                merkenLijst.add("Grolsch");
                merkenLijst.add("Jupiler");
                merkenLijst.add("Pinkus");
                merkenLijst.add("Urquell");
                break;
            case "Tripel":
                merkenLijst.add("Grimbergen");
                merkenLijst.add("Westmalle");
                break;
            case "Weizen":
                merkenLijst.add("Erdinger");
                merkenLijst.add("PaulanerK");
                break;
        }
        return merkenLijst;
    }

}
