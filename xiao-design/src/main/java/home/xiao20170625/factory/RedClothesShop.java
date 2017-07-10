package home.xiao20170625.factory;

/**
 * Created by Xiao on 2017/6/25.
 */
public class RedClothesShop extends ClothesShop {


    @Override
    public home.xiao20170625.factory.Clothes createClothes(String size) {
        if("L".equals(size)) {
            return new RedLSizeClothes();
        } else if("M".equals(size)) {
            return new RedMSizeClothes();
        }
        return null;
    }
}
