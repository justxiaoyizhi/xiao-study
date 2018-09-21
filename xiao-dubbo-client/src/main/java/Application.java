import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by xiaoyizhi on 2017/6/6.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"company"})
public class Application {

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}
