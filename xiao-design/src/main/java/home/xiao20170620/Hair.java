package home.xiao20170620;

/**
 * Created by Xiao on 2017/6/20.
 */
public class Hair extends Decorator {

    private Human human;

    public Hair(Human human) {
        this.human = human;
    }

    @Override
    public String desc() {
        return human.desc()+"，我的头发是黑色的";
    }
}
