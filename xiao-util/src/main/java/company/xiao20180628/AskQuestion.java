package company.xiao20180628;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AskQuestion {

    String questionName() default "";

}
