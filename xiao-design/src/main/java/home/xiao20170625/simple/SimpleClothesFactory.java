package home.xiao20170625.simple;

/**
 * Created by Xiao on 2017/6/25.
 */
public class SimpleClothesFactory {

    public static Clothes createClothes(String color) {
        if("red".equals(color)) {
            return new RedClothes();
        } else if("blue".equals(color)) {
            return new BlueClothes();
        } else {
            return null;
        }
    }
}
