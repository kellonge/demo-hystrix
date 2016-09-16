package com.kellonge.demo.hystrix;

import java.util.List;
import java.util.concurrent.Future;

import com.kellonge.demo.hystrix.commons.PrintInterval;
import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

/**
 * Created by kellonge on 16/9/9.
 */
@Component
public class SimpleCommandRunner implements CommandLineRunner {
    Logger logger = Logger.getLogger(SimpleCommandRunner.class);

    @Override
    public void run(String... strings) throws Exception {
        //instanceo command
        RequestCommand command = new RequestCommand("/normal/now");

        //excute
        //means the result will return immediately
        PrintInterval.start();
        for (int i = 0; i < 10; i++) {
            logger.info("excute result " + command.execute());
        }
        PrintInterval.end();

        //queue
        //hystrix will put the reuslt in a `future` var, so that the request can invoke at sametime
        PrintInterval.start();
        List<Future<String>> futures = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            Future<String> queue = command.queue();
            futures.add(queue);
        }
        for (Future<String> future : futures) {
            logger.info("excute result " + future.get());
        }
        PrintInterval.end();
    }
}
