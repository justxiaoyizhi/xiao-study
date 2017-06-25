package home.xiao20170625.abstractfactory;

/**
 * Created by Xiao on 2017/6/25.
 * 使用的是组合
 */
public class GXGClothes implements Clothes {

    private AbstractClothesFactory factory;

    public GXGClothes(AbstractClothesFactory factory) {
        this.factory = factory;
    }

    @Override
    public String desc() {
        String brand = factory.createBrand();
        String material = factory.createMaterial();
        return "brand:"+brand+"----material:"+material;
    }
}
