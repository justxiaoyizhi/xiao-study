package home.xiao20170625.abstractfactory;

/**
 * Created by Xiao on 2017/6/25.
 */
public class GXGClothesFactory implements AbstractClothesFactory {

    @Override
    public String createMaterial() {
        return "尼龙";
    }

    @Override
    public String createBrand() {
        return "GXG";
    }
}
