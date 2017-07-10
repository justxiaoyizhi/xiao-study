package home.xiao20170625.abstractfactory;

/**
 * Created by Xiao on 2017/6/25.
 */
public class Main {

    public static void main(String[] args) {
        ClothesShop shop = new ClothesShop();
        String gxg = shop.sellClothes("GXG");
        System.out.println(gxg);
    }
}
