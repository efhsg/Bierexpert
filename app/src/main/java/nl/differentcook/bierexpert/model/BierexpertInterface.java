package nl.differentcook.bierexpert.model;

import java.util.List;

/**
 * Created by esg on 29/04/2017.
 */

public interface BierexpertInterface {
    String getType();

    void setType(String type);

    List<String> getLanden();

    List<String> getMerken();
}
