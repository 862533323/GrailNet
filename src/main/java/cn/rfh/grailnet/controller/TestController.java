package cn.rfh.grailnet.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class TestController {
    @RequestMapping("/test")
    public String tst(){
        return "success";
    }
    @RequestMapping(value = "/pushTest",produces = "text/event-stream;charset=UTF-8")
    public String pushTest(){
        Random random = new Random();
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "data:Testing " + random.nextInt() + "\n\n";
    }
}
