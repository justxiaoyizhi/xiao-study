package home.xiao20170626;

/**
 * Created by Xiao on 2017/6/26.
 */
public class StaticMethod {

    private StaticMethod() {

    }

    private static class SingleInstance {
        private static StaticMethod method = new StaticMethod();
    }

    public static StaticMethod getInstance() {
        return SingleInstance.method;
    }


}
