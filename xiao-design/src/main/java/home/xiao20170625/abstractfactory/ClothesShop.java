package home.xiao20170625.abstractfactory;

/**
 * Created by Xiao on 2017/6/25.
 */
public class ClothesShop {
    public Clothes createClothes(String item) {
        if("GXG".equals(item)) {
            AbstractClothesFactory factory = new GXGClothesFactory();
            return new GXGClothes(factory);
        } else if("Jack Jones".equals(item)) {
            AbstractClothesFactory factory = new JackJonesClothesFactory();
            return new JackJonesClothes(factory);
        }
        return null;
    }

    public String sellClothes(String item) {
        Clothes clothes = createClothes(item);
        return clothes.desc();
    }
}
