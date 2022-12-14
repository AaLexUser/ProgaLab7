package com.lapin.common.network.objimp;

import com.lapin.common.data.User;
import com.lapin.network.AccessType;
import com.lapin.network.obj.NetObj;
import com.lapin.network.obj.NetObjBodyKeys;

import java.io.Serializable;
import java.util.HashMap;

public class RequestCommand extends NetObj implements Serializable {
    public RequestCommand(HashMap<NetObjBodyKeys,Object> body){
        super(body);
    }
    public RequestCommand(String command, String arg, Serializable argObj, User user){
        super(setBody(command,arg,argObj,user));
    }
    private static HashMap<NetObjBodyKeys,Object> setBody(String command, String arg, Serializable argObj, User user){
        HashMap<NetObjBodyKeys, Object> body = new HashMap<>();
        body.put(RequestBodyKeys.COMMAND_NAME, command);
        body.put(RequestBodyKeys.ARG, arg);
        body.put(RequestBodyKeys.ARG_OBJ, argObj);
        body.put(RequestBodyKeys.USER,user);
        return body;
    }
    public AccessType getAccessType(){
        return (AccessType) super.getBody().get(RequestBodyKeys.ACCESS_TYPE);
    }
    public String getCmd(){
        return (String) super.getBody().get(RequestBodyKeys.COMMAND_NAME);
    }
    public String getArg(){
        return (String) super.getBody().get(RequestBodyKeys.ARG);
    }
    public Serializable argObj(){
        return (Serializable) super.getBody().get(RequestBodyKeys.ARG_OBJ);
    }
    public User getUser(){return (User) super.getBody().get(RequestBodyKeys.USER);}
}
