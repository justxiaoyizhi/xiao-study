package company.xiao20170828;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Xiao on 2017/8/28.
 */
public class Retry {

    public static void main(String[] args) {

        Callable<Long> callable = new Callable<Long>() {
            Long num = 2L;
            public Long call() throws Exception {
                System.out.println("sso");
                return num++;
            }
        };

        Retryer<Long> retryer = RetryerBuilder.<Long>newBuilder()
                .retryIfResult(Predicates.not(Predicates.equalTo(4L)))
                .retryIfExceptionOfType(IOException.class)
                .retryIfRuntimeException()
                .withRetryListener(new RetryListener() {
                    public <V> void onRetry(Attempt<V> attempt) {
                        if(attempt.getResult().equals(4L)) {
                            System.out.println("result");
                        } else {
                            System.out.println("falseResult");
                        }
                    }
                })
                .withWaitStrategy(WaitStrategies.fixedWait(10L, TimeUnit.SECONDS))//设置每次重试间隔
                .withStopStrategy(StopStrategies.stopAfterAttempt(5))
                .build();
        try {
            retryer.call(callable);
        } catch (RetryException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
