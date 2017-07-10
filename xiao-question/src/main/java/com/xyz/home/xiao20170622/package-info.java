/**
 * Created by Xiao on 2017/6/22.
 * Spring 容器中的 Bean 是有生命周期的，Spring 允许在 Bean 在初始化完成后以及 Bean 销毁前执行特定的操作，常用的设定方式有以下三种：
 * 通过实现 InitializingBean/DisposableBean 接口来定制初始化之后/销毁之前的操作方法；
 * 通过 <bean> 元素的 init-method/destroy-method属性指定初始化之后 /销毁之前调用的操作方法；
 * 在指定方法上加上@PostConstruct 或@PreDestroy注解来制定该方法是在初始化之后还是销毁之前调用*
 */
package com.xyz.home.xiao20170622;