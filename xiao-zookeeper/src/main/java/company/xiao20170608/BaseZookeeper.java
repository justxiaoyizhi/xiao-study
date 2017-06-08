package company.xiao20170608;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryNTimes;

/**
 * Created by xiaoyizhi on 2017/6/8.
 */
public class BaseZookeeper {

    /** Zookeeper info */
    private static final String ZK_ADDRESS = "localhost:2181";
    private static final String ZK_PATH = "/zktest";

    public static void main(String[] args) throws Exception {
        CuratorFramework framework = CuratorFrameworkFactory.newClient(ZK_ADDRESS, new RetryNTimes(10, 5000));
        framework.start();
        System.out.println("zk client start successfully!");
        String data1 = "hello";
        framework.create().
                creatingParentsIfNeeded().
                forPath(ZK_PATH, data1.getBytes());
    }
}
