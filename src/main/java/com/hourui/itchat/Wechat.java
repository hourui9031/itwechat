package com.hourui.itchat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hourui.itchat.controller.LoginController;
import com.hourui.itchat.core.MsgCenter;
import com.hourui.itchat.face.IMsgHandlerFace;

public class Wechat {
    private static final Logger LOG = LoggerFactory.getLogger(Wechat.class);
    private IMsgHandlerFace msgHandler;

    public Wechat(IMsgHandlerFace msgHandler, String qrPath) {
        System.setProperty("jsse.enableSNIExtension", "false"); // 防止SSL错误
        this.msgHandler = msgHandler;

        // 登陆
        LoginController login = new LoginController();
        login.login(qrPath);
    }

    public void start() {
        LOG.info("+++++++++++++++++++开始消息处理+++++++++++++++++++++");
        new Thread(new Runnable() {
            @Override
            public void run() {
                MsgCenter.handleMsg(msgHandler);
            }
        }).start();
    }
}
