package com.kellonge.demo.hystrix;

import com.kellonge.demo.hystrix.controller.SlowController;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import org.apache.log4j.Logger;

/**
 * Created by kellonge on 16/9/9.
 */
public class RequestCommand extends HystrixCommand<String> {
    Logger logger = Logger.getLogger(RequestCommand.class);

    private String path;

    protected RequestCommand(String path) {
        super(HystrixCommandGroupKey.Factory.asKey(path));
        this.path = path;
    }

    @Override
    protected String run() throws Exception {
        String url = "http://localhost:8080" + path;
        logger.info("request to " + url);
        return HttpURLConnectionUtils.get(url);
    }
}
