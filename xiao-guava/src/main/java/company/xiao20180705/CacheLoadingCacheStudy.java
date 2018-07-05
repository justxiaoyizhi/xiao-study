package company.xiao20180705;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

/**
 * 缓存学习
 *
 * @author xiao
 * @create 2016-12-20 11:16
 **/
@Slf4j
public class CacheLoadingCacheStudy {

    private LoadingCache<String,Person> loadingCache;

    public CacheLoadingCacheStudy() {
        init();
    }

    private void init() {
        CacheLoader<String,Person> loader = new CacheLoader<String, Person>() {
            @Override
            public Person load(String key) throws Exception {
                log.info("从mysql取数据");
                Thread.sleep(2000);
                log.info("取完数据");

                Person person = new Person(key,"其他人");

                if("001".equals(key)) {
                    person.setName("zhangsan");
                    return person;
                }
                if("007".equals(key)) {
                    person.setName("zhouxinchi");
                    return person;
                }
                return person;
            }
        };
        loadingCache = CacheBuilder.newBuilder().maximumSize(100).build(loader);
    }

    /**
     * 如果存在就返回,否则就返回null
     * @param key
     * @return
     */
    public Person getIfPresentloadingCache(String key) {
        return loadingCache.getIfPresent(key);
    }

    public Person getCacheKeyloadingCache(String key) throws ExecutionException {
        return loadingCache.get(key);
    }

    public void putloadingCache(String key, Person value) {
        log.info("put message");
        loadingCache.put(key,value);
    }


    public static void main(String[] args) throws ExecutionException {
        Person person;
        CacheLoadingCacheStudy s = new CacheLoadingCacheStudy();

        System.out.println("==============getLoad:111==============");
        person = s.getCacheKeyloadingCache("111");
        System.out.println(person);

        System.out.println("==============getPresent:112==============");
        person = s.getIfPresentloadingCache("112");
        System.out.println(person);

        System.out.println("==============getLoad:007==============");
        person = s.getCacheKeyloadingCache("007");
        System.out.println(person);

        System.out.println("==============getLoad:007==============");
        person = s.getCacheKeyloadingCache("007");
        System.out.println(person);

        System.out.println("==============putGetPresent:001==============");
        s.putloadingCache("001",new Person("001","lisi"));
        person = s.getIfPresentloadingCache("001");
        System.out.println(person);

        System.out.println("==============putLoad:112==============");
        person = s.getCacheKeyloadingCache("112");
        System.out.println(person);
    }

}

@Setter
@Getter
@AllArgsConstructor
class Person {
    private String id;
    private String name;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
