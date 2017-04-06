package home.xiao20170406;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by Xiao on 2017/4/6.
 * 买家必须要实现这个电话的接口，不然不然接受到消息
 */
@Data
@AllArgsConstructor
public class Buyer implements Phone {

    private String name;

    /**
     * 收到电话时
     */
    public void dosth() {
        System.out.println(name+"说：嗯，马上去买");
    }
}
