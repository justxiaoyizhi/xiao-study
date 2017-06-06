import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by xiaoyizhi on 2017/6/6.
 */
public class Main {

    public static void main(String[] args){
        // 加载applicationContext.xml
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"});

        System.out.println("start dubbo");
        while (true) {
            Thread.yield();
        }
    }
}
