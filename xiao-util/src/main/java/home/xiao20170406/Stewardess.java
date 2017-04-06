package home.xiao20170406;

import lombok.AllArgsConstructor;

import java.util.List;

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
