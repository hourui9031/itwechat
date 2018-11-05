package com.hourui.itchat.service.impl;

import com.hourui.itchat.bean.BaseMsg;
import com.hourui.itchat.face.IMsgHandlerFace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;


public class SimpleDemo implements IMsgHandlerFace{

    private static Logger logger= LoggerFactory.getLogger(SimpleDemo.class);
    public static int count=0;

    @Override
    public String textMsgHandle(BaseMsg msg) {
       /* File file = new File("D:\\hourui159.txt");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(msg.getText()).append("+\\r\\n");
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(stringBuilder.toString());
            fileWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }*/
        return null;
    }

    @Override
    public String picMsgHandle(BaseMsg msg) {
        return null;
    }

    @Override
    public String voiceMsgHandle(BaseMsg msg) {
        return null;
    }

    @Override
    public String viedoMsgHandle(BaseMsg msg) {
        return null;
    }

    @Override
    public String nameCardMsgHandle(BaseMsg msg) {
        return null;
    }

    @Override
    public void sysMsgHandle(BaseMsg msg) {

    }

    @Override
    public String verifyAddFriendMsgHandle(BaseMsg msg) {
        return null;
    }

    @Override
    public String mediaMsgHandle(BaseMsg msg) {
        File file = new File("D:\\hourui159.txt");
        String url = msg.getUrl();
        String replace = url.replace("amp;", "");
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(System.getProperty("line.separator")).append("\'\"").append(replace).append("\"\'").append("+\',\'+");
        try {
            FileWriter fileWriter = new FileWriter(file,true);
            fileWriter.write(stringBuffer.toString());
            fileWriter.close();
            count=(count+1);
            logger.info("=========================第"+count+"条");
        }catch (Exception e){
            e.printStackTrace();
        }
        return replace;
    }
}
