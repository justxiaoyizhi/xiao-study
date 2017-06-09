package company.xiao20170608;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.serialize.SerializableSerializer;
import org.I0Itec.zkclient.serialize.ZkSerializer;
import org.apache.zookeeper.CreateMode;

/**
 * Created by xiaoyizhi on 2017/6/8.
 */
public class ZkClientZookeeper {

    /**
     * Zookeeper info
     */
    private static final String ZK_ADDRESS = "localhost:2181";
    private static final String ZK_PATH = "/zkclient";

    public static void main(String[] args) {
        createNode();
        //getUser();
    }

    private static void createNode() {
        ZkClient zkClient = new ZkClient(ZK_ADDRESS, 1000, 1000, new SerializableSerializer());
        User user = new User();
        user.setId(001L);
        user.setName("xiaoming");
        String result = zkClient.create(ZK_PATH, user, CreateMode.PERSISTENT);
        System.out.println(result);
    }

    public static void getUser() {
        ZkClient zkClient = new ZkClient(ZK_ADDRESS, 1000, 1000, new SerializableSerializer());
        User user = zkClient.readData(ZK_PATH);
        System.out.println(user);
    }
}
