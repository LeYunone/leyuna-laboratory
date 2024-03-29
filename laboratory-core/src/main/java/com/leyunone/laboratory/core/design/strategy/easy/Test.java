package com.leyunone.laboratory.core.design.strategy.easy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.leyunone.laboratory.core.util.SpringUtil;

/**
 * @author LeYuna
 * @email 365627310@qq.com
 * @date 2022-09-08
 */
@SpringBootApplication
public class Test {

    public static void main(String[] args) {
        SpringApplication.run(Test.class, args);
        ServiceEnum serviceEnum = ServiceEnum.valueOf(1);
        if(serviceEnum == null){
            //没有在枚举中匹配到处理器，说明业务参数不合法或者没有添加对应的业务枚举
            return;
        }
        BaseService bean = SpringUtil.getBean(serviceEnum.getProcessor(), BaseService.class);
        if(bean == null){
            //没有从spring容器中获取到对应处理器到实例，属于异常情况，检查枚举配置和处理器是否正确注入spring容器
            return;
        }
        //交给对应到处理器去处理
        String test = bean.test();
        System.out.println(test);
    }

    public static String doService(String order) {
        if ("type1".equals(order)) {
            return "执行业务逻辑1 - service1.test()";
        } else if ("type2".equals(order)) {
            return "执行业务逻辑2 - service2.test()";
        }else if ("type3".equals(order)) {
            return "执行业务逻辑3 - service3.test()";
        }else if ("type4".equals(order)) {
            return "执行业务逻辑4 - service4.test()";
        }
        return "不在处理的逻辑中返回业务错误";
    }
}
