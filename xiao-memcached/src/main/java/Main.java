import net.spy.memcached.AddrUtil;
import net.spy.memcached.ConnectionFactoryBuilder;
import net.spy.memcached.MemcachedClient;
import net.spy.memcached.auth.AuthDescriptor;
import net.spy.memcached.auth.PlainCallbackHandler;
import net.spy.memcached.internal.OperationFuture;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * Created by Xiao on 2018/1/29.
 */
public class Main {

    public static void main(String[] args) {

        final String host = "localhost";//控制台上的“内网地址”
        final String port = "11211"; //默认端口 11211，不用改
        final String username = "";//控制台上的“访问账号”
        final String password = "";//邮件中提供的“密码”

        MemcachedClient cache = null;
        try {
//            AuthDescriptor ad = new AuthDescriptor(new String[]{"PLAIN"}, new PlainCallbackHandler(username, password));
            cache = new MemcachedClient(
                    new ConnectionFactoryBuilder().setProtocol(ConnectionFactoryBuilder.Protocol.BINARY)
//                            .setAuthDescriptor(ad)
                            .build(),
                    AddrUtil.getAddresses(host + ":" + port));

//            cache.set("gw", 10 * 60, 20);
            long re = cache.incr("pw", 1, 1, 10 * 60);
            System.out.println("===1===" + re);
            re = cache.incr("pw", 1, 1, 10 * 60);
            System.out.println("===2===" + re);
            re = cache.incr("pw", 1, 1, 10 * 60);
            System.out.println("===3===" + re);
            String pw = (String)cache.get("pw");
            System.out.println(pw);
            cache.delete("pw");
            re = cache.incr("pw", 1, 1, 10 * 60);
            System.out.println("===4===" + re);

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (cache != null) {
            cache.shutdown();
        }

    }
}
