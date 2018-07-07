package cn.hitstone.rest;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HystrixStoresRest {

    @GetMapping("/stores/{id}")
    @HystrixCommand(fallbackMethod = "defaultStores")
    public String getStores(@PathVariable String id) {
        //do stuff that might fail
        //System.out.println("something useful");
        if(System.currentTimeMillis() % 2==0){
            throw new RuntimeException("do stuff that might fail:"+ id);
        }else {
            return "ok";
        }

    }

    @GetMapping("/stores/{id}/timeout")
    @HystrixCommand(fallbackMethod = "defaultStores")
    public String getStoresTimeOut(@PathVariable String id) throws InterruptedException {
        //do stuff that might fail
        //System.out.println("something useful");

        //表示请求线程总超时时间，如果超过这个设置的时间hystrix就会调用fallback方法。value的参数为毫秒，默认值为1000ms。
        Thread.sleep(2000L);
        return "never return this:"+ id;

    }
    @GetMapping("/stores/{id}/notTimeout")
    @HystrixCommand(fallbackMethod = "defaultStores")
    public String getStoresNotTimeOut(@PathVariable String id) throws InterruptedException {
        //do stuff that might fail
        //System.out.println("something useful");

        //表示请求线程总超时时间，如果超过这个设置的时间hystrix就会调用fallback方法。value的参数为毫秒，默认值为1000ms。
        Thread.sleep(900L);
        return "do not timeout:"+ id;

    }

    public String defaultStores(@PathVariable String id) {

        //System.out.println("something useful:"+id);
        return "ok,fallbackMethod:"+id/* something useful */;
    }
}