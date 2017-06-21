package home.xiao20170620;

/**
 * Created by Xiao on 2017/6/20.
 */
public class Main {

    public static void main(String[] args) {
        Human human = new Student();
        human = new Hair(human);
        human = new Clother(human);
        System.out.println(human.desc());
    }
}
