package com.hourui.itchat;

import com.hourui.itchat.face.IMsgHandlerFace;
import com.hourui.itchat.service.impl.SimpleDemo;

public class SimpleTest {

    public static void main(String[] args) {
        String path="D:\\";
        IMsgHandlerFace iMsgHandlerFace=new SimpleDemo();
        Wechat wechat =new Wechat(iMsgHandlerFace,path);
        wechat.start();
    }

}
