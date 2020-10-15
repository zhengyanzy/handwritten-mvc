package com.tyshawn.framework;

import com.tyshawn.framework.helper.*;
import com.tyshawn.framework.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 */
public final class HelperLoader {

    /**
     * 加载这五个类, 目的是为了执行类里的静态代码块
     */
    public static void init() {
        Class<?>[] classList = {
            //ClassHelper,获取基础包下的所有的类，存放ClassHelper.CLASS_SET【Set<Class<?>> CLASS_SET】
            ClassHelper.class,
            //将@Service和@Controller注解的bean存放到BeanHelper.BEAN_MAP【Map<Class<?>, Object> BEAN_MAP】
            BeanHelper.class,
            //创建代理对象替换BeanHelper.BEAN_MAP原来的对象
            AopHelper.class,
            //给BeanHelper.BEAN_MAP对象注入属性
            IocHelper.class,
            //handleMapping
            ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}