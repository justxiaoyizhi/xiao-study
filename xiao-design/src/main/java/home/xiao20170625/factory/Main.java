package home.xiao20170625.factory;

/**
 * Created by Xiao on 2017/6/25.
 */
public class Main {

    public static void main(String[] args) {
        ClothesShop shop = new RedClothesShop();
        String desc = shop.sellClothes("L");
        System.out.println(desc);
        shop = new BlueClothesShop();
        desc = shop.sellClothes("L");
        System.out.println(desc);
    }
}
