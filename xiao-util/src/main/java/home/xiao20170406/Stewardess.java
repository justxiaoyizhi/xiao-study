package home.xiao20170406;

import com.google.common.base.Splitter;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Xiao on 2017/4/6.
 * 商店里的女服务员
 */
@AllArgsConstructor
public class Stewardess {

    /**
     * 一本电话本，记录客户手机号
     */
    private List<Phone> phones;


    public void stock() {
        System.out.println("进货了！！！");
        for (Phone phone : phones) {
            phone.dosth();
        }
    }
}
