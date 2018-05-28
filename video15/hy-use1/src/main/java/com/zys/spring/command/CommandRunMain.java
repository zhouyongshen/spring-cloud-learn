package com.zys.spring.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import rx.Observable;
import rx.Observer;

import java.util.concurrent.TimeUnit;

public class CommandRunMain {
    public static void main(String[] args) throws InterruptedException {
        RunCommand c1 = new RunCommand("observe");
        c1.observe();

        RunCommand c2 = new RunCommand("toObservable");
        Observable<String> ob = c2.toObservable();
        ob.subscribe(new Observer<String>() {
            public void onCompleted() {
                System.out.println("config complete");
            }

            public void onError(Throwable throwable) {

            }

            public void onNext(String s) {
                System.out.println("####   " + s);
            }
        });

        TimeUnit.SECONDS.sleep(1);


    }

    static class RunCommand extends HystrixCommand<String> {

        String msg;

        protected RunCommand(String msg) {
            super(HystrixCommandGroupKey.Factory.asKey("testRunCommand"));
            this.msg = msg;
        }

        protected String run() throws Exception {
            System.out.println("---------" + msg);
            return "success";
        }
    }
}
