package com.ll;

import java.util.HashMap;
import java.util.Map;

public class Rq {
    String cmd;
    String action;
    Map<String, String> paramMaps = new HashMap<>();

    public Rq(String cmd){
        this.cmd = cmd;
        String[] cmdBits = cmd.split("\\?", 2);
        this.action = cmdBits[0];
        if(cmdBits.length == 1){
            return;
        }

        String queryStr = cmdBits[1];

        String[] queryStrBits = queryStr.split("&");
        for (int i = 0; i < queryStrBits.length; i++) {
            String[] queryParamBits = queryStrBits[i].split("=", 2);
            paramMaps.put(queryParamBits[0], queryParamBits[1]);
        }
    }

    public String getAction(){
        return action;
    }

    public int getParamAsInt(String id, int defaultValue){
        try{
            return Integer.parseInt(paramMaps.get(id));
        } catch(NumberFormatException e){
            return defaultValue;
        }
    }
}
