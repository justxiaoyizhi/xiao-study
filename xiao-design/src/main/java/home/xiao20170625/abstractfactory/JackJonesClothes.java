package home.xiao20170625.abstractfactory;

/**
 * Created by Xiao on 2017/6/25.
 */
public class JackJonesClothes implements Clothes {

    private AbstractClothesFactory factory;

    public JackJonesClothes(AbstractClothesFactory factory) {
        this.factory = factory;
    }

    @Override
    public String desc() {
        String brand = factory.createBrand();
        String material = factory.createMaterial();
        return "brand:"+brand+"----material:"+material;
    }
}
