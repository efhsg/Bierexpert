package nl.differentcook.bierexpert.model;

import java.util.List;

/**
 * Created by esg on 29/04/2017.
 */

public interface IBierexpert {

    List<String> getLanden(String type);

    List<String> getMerken(String type);
}
