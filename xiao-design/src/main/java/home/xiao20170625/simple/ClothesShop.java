package home.xiao20170625.simple;

/**
 * Created by Xiao on 2017/6/25.
 */
public class ClothesShop {

    public String sellClothes(String color) {
        Clothes clothes = SimpleClothesFactory.createClothes(color);
        return clothes.getColor();
    }
}
