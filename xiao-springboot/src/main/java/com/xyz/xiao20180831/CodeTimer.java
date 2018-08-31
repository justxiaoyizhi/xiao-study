package com.xyz.xiao20180831;

import java.lang.annotation.*;


/**
 * Description: 代码执行计时器，最后日志info级别呈现的效果如下
 * value默认是方法名称，可以通过value参数自定义
 * execTime就是执行代码的时间了，ms为单位
 * +--------------------------------------------+
 * |   ${value}耗时${execTime}ms
 * +--------------------------------------------+
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CodeTimer {

    String value() default "";

}
