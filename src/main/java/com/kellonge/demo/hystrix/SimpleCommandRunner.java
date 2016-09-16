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

        //excute
        //means the result will return immediately
        logger.info("excute");
        PrintInterval.start();
        for (int i = 0; i < 10; i++) {
            logger.info("excute result " + new RequestCommand("/normal/now").execute());
        }
        PrintInterval.end();

        //queue
        //hystrix will put the reuslt in a `future` var, so that the request can invoke at sametime
        logger.info("queue");
        PrintInterval.start();
        List<Future<String>> futures = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            Future<String> queue = new RequestCommand("/normal/now").queue();
            futures.add(queue);
        }
        for (Future<String> future : futures) {
            logger.info("excute result " + future.get());
        }
        PrintInterval.end();


        //observe
        //do request when call and handle result in hytrix thread poll
        logger.info("observe");
        PrintInterval.start();
        for (int i = 0; i < 10; i++) {
            new RequestCommand("/normal/now").observe().forEach(x -> logger.info("excute result " + x));
        }
        PrintInterval.end();

        //make sure above request has finish
        Thread.sleep(1000L);

        //toObservable
        //do request after call,return to main thread immediately
        logger.info("toObservable");
        PrintInterval.start();
        for (int i = 0; i < 10; i++) {
            new RequestCommand("/normal/now").toObservable().forEach(x -> logger.info("excute result " + x));
        }
        PrintInterval.end();
    }
}
