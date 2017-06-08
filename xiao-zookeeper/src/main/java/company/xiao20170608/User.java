package company.xiao20170608;

import java.io.Serializable;

/**
 * Created by xiaoyizhi on 2017/6/8.
 */
public class User implements Serializable {

    private static final long serialVersionUID = -1324544420714892547L;

    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
