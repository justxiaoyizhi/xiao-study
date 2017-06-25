package home.xiao20170625.abstractfactory;

/**
 * Created by Xiao on 2017/6/25.
 */
public class JackJonesClothesFactory implements AbstractClothesFactory {

    @Override
    public String createMaterial() {
        return "棉布";
    }

    @Override
    public String createBrand() {
        return "Jack Jones";
    }
}
