package com.antsix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /**
     * Could not autowire. No beans of XXX type found
     */
    @Autowired(required = false)
    private StateMachine<States, Events> stateMachine;


    /**
     * 在run函数中，我们定义了整个流程的处理过程，
     * 其中start()就是创建这个订单流程，根据之前的定义，该订单会处于待支付状态，
     * 然后通过调用sendEvent(Events.PAY)执行支付操作，
     * 最后通过掉用sendEvent(Events.RECEIVE)来完成收货操作
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        stateMachine.start();
        stateMachine.sendEvent(Events.PAY);
        stateMachine.sendEvent(Events.RECEIVE);
    }

}

