package home.xiao20170406;

import java.util.ArrayList;

/**
 * Created by Xiao on 2017/4/6.
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Phone> phoneNote = new ArrayList<Phone>();
        Stewardess stewardess = new Stewardess(phoneNote);

        Buyer xh = new Buyer("小红");
        Buyer xm = new Buyer("小米");
        Buyer xb = new Buyer("小白");


        phoneNote.add(xh);
        phoneNote.add(xm);
        phoneNote.add(xb);

        stewardess.stock();
    }
}
