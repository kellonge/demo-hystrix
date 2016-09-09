package com.kellonge.demo.hystrix;

import org.apache.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by kellonge on 16/9/9.
 */
@Component
public class SimpleCommandRunner implements CommandLineRunner {
    Logger logger = Logger.getLogger(SimpleCommandRunner.class);

    @Override
    public void run(String... strings) throws Exception {
        logger.info(new RequestCommand("/normal/now").execute());
    }
}
