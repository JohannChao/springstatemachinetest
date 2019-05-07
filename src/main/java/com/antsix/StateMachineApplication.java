package com.antsix;

import com.antsix.common.StatemachineService;
import com.antsix.common.TurnstileEvents;
import com.antsix.common.TurnstileStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.statemachine.StateMachine;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@ComponentScan(basePackages={"com.antsix"})
public class StateMachineApplication  implements CommandLineRunner {

    @Autowired
    private StatemachineService statemachineService;

    public static void main(String[] args) {
        SpringApplication.run(StateMachineApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        Map<String, Object> context = new HashMap<>(16);
        context.put("context", "some code");
        statemachineService.execute(1, TurnstileEvents.PUSH, context);
        statemachineService.execute(1, TurnstileEvents.PUSH, context);
        statemachineService.execute(1, TurnstileEvents.COIN, context);
        statemachineService.execute(1, TurnstileEvents.COIN, context);

    }
}
