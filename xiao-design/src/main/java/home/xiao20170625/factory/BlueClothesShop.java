package home.xiao20170625.factory;

/**
 * Created by Xiao on 2017/6/25.
 */
public class BlueClothesShop extends ClothesShop {
    @Override
    public Clothes createClothes(String size) {
        if("L".equals(size)) {
            return new BlueLSizeClothes();
        } else if("M".equals(size)) {
            return new BlueMSizeClothes();
        }
        return null;
    }
}
