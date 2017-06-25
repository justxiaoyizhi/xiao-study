package home.xiao20170625.simple;

/**
 * Created by Xiao on 2017/6/25.
 */
public class Main {
    public static void main(String[] args) {
        ClothesShop shop = new ClothesShop();
        String result = shop.sellClothes("red");
        System.out.println(result);
    }
}
