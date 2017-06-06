import company.xiao20170606.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiaoyizhi on 2017/6/6.
 */
public class Main {

    public static void main(String[] args){
        // 加载applicationContext.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

        DemoService service = (DemoService) context.getBean("demoService");
        String msg = service.sayHello("xiaoyizhi");
        System.out.println(msg);
    }
}
