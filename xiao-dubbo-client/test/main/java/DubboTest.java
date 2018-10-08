import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.rpc.service.GenericException;
import com.alibaba.dubbo.rpc.service.GenericService;
import company.xiao20170606.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class DubboTest {

    @Reference
    private DemoService demoService;

    @Test
    public void testSay() {
        // 引用远程服务
// 该实例很重量，里面封装了所有与注册中心及服务提供方连接，请缓存
        ReferenceConfig<GenericService> reference = new ReferenceConfig<GenericService>();
        // 弱类型接口名
        reference.setInterface("company.xiao20170606.DemoService");
        reference.setVersion("1.0.0.dev");
        reference.setGroup("xiao");
// 声明为泛化接口
        reference.setGeneric(true);

        // 用com.alibaba.dubbo.rpc.service.GenericService可以替代所有接口引用
        GenericService genericService = reference.get();
        Object object = null;
        object = genericService.$invoke("sayHello", new String[]{"java.lang.String"}, new Object[]{"xiao"});

        System.out.println(object);
    }

    @Test
    public void testSay1() {
        String result = demoService.sayHello("xiao");

        System.out.println(result);
    }

}