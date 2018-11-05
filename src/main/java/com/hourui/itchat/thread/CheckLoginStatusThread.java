package  com.hourui.itchat.thread;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hourui.itchat.core.Core;
import com.hourui.itchat.utils.SleepUtils;
public class CheckLoginStatusThread implements Runnable{
    private static Logger LOG = LoggerFactory.getLogger(CheckLoginStatusThread.class);
    private Core core = Core.getInstance();

    @Override
    public void run() {
        while (core.isAlive()) {
            long t1 = System.currentTimeMillis(); // 秒为单位
            if (t1 - core.getLastNormalRetcodeTime() > 60 * 1000) { // 超过60秒，判为离线
                core.setAlive(false);
                LOG.info("微信已离线");
            }
            SleepUtils.sleep(10 * 1000); // 休眠10秒
        }
    }
}
