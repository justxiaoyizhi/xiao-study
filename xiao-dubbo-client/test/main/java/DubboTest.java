import com.alibaba.dubbo.config.annotation.Reference;
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
        String result = demoService.sayHello("xiao");
        System.out.println(result);
    }

}