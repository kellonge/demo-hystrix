package com.kellonge.demo.hystrix;

import com.netflix.hystrix.HystrixObservableCommand;
import org.apache.log4j.Logger;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.Observable;

/**
 * Created by kellonge on 16/9/9.
 */
public class RequestObservableCommand extends HystrixObservableCommand<String> {
    Logger logger = Logger.getLogger(RequestObservableCommand.class);

    private String path;

    protected RequestObservableCommand(String path) {
        super(HystrixCommandGroupKey.Factory.asKey(path));
        this.path = path;
    }
 
    @Override
    protected Observable<String> construct() {
        return null;
    }
}
