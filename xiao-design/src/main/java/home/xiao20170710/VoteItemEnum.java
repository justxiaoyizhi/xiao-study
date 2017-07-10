package home.xiao20170710;

/**
 * Created by Xiao on 2017/7/10 0010.
 */
public enum VoteItemEnum {

    VoteItemEnum_A("1","A"),
    VoteItemEnum_B("2","B"),
    VoteItemEnum_C("3","C"),
    VoteItemEnum_D("4","D");

    private String id;
    private String item;

    VoteItemEnum(String id, String item) {
        this.id = id;
        this.item = item;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
