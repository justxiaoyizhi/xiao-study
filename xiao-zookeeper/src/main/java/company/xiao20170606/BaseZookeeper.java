package company.xiao20170606;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;

/**
 * Created by xiaoyizhi on 2017/6/6.
 */
public class BaseZookeeper {

    private static final String HOSTNAME = "127.0.0.1";
    private static final int SESSION_TIMEOUT = 1000;
    private static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        ZooKeeper zk = new ZooKeeper(HOSTNAME, SESSION_TIMEOUT, new Watcher() {
            public void process(WatchedEvent watchedEvent) {
                Event.KeeperState state = watchedEvent.getState();
                Event.EventType type = watchedEvent.getType();

                if(Event.KeeperState.SyncConnected == state) {
                    if(Event.EventType.None == type) {
                        latch.countDown();
                        System.out.println("zk has already connected");
                    }
                }
            }
        });

        latch.await();


        String s = zk.create("/xiao", "yizhi".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(s);

    }

}
