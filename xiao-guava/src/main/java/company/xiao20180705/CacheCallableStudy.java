package company.xiao20180705;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * 使用callable缓存
 *
 * @author xiao
 * @create 2016-12-20 13:02
 **/
public class CacheCallableStudy {

    private Cache<String,Person> cache = CacheBuilder.newBuilder().maximumSize(100).build();

    public static void main(String[] args) throws ExecutionException {

        CacheCallableStudy ccs = new CacheCallableStudy();
        ccs.cache.getIfPresent("007");
        ccs.cache.get("007", new Callable<Person>() {
            @Override
            public Person call() throws Exception {
                return new Person("007","周星驰");
            }
        });
        System.out.println(ccs.cache.getIfPresent("007"));
    }
}
