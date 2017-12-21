package nl.differentcook.bierexpert.lib;

import java.util.List;

/**
 * Created by esg on 28/04/2017.
 */

public class Appl {

    public static String getTag() {
        String tag = "";
        final StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        for (int i = 0; i < ste.length; i++) {
            if (ste[i].getMethodName().equals("getTag")) {
                tag = "(" + ste[i + 1].getFileName() + ":" + ste[i + 1].getLineNumber() + ")";
            }
        }
        return tag;
    }

    public static StringBuilder listToStringbuilder(List<String> list) {
        StringBuilder builtString = new StringBuilder();
        for (String item : list) {
            builtString.append(item).append('\n');
        }
        return builtString;
    }
}
