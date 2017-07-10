package home.xiao20170625.factory;

/**
 * Created by Xiao on 2017/6/25.
 */
public abstract class ClothesShop {

    public abstract Clothes createClothes(String size);

    public String sellClothes(String size) {
        Clothes clothes = createClothes(size);
        return clothes.desc();
    }

}
