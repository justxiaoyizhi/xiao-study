package home.xiao20170620;

/**
 * Created by Xiao on 2017/6/20.
 */
public class Clother extends Decorator {

    private Human human;

    public Clother(Human human) {
        this.human = human;
    }

    @Override
    public String desc() {
        return human.desc()+"，我的衣服是件T恤";
    }
}
