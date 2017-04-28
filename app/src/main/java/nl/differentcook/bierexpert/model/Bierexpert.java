package nl.differentcook.bierexpert.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by esg on 27/04/2017.
 */

public class Bierexpert {
    public List<String> getBrands(String color) {
        List<String> brands = new ArrayList<String>();
        if (color.equals("amber")) {
            brands.add("Jack Amber");
            brands.add("Red Moose");
        } else {
            brands.add("Jail Pale Ale");
            brands.add("Gout Stout");
        }
        return brands;
    }
}