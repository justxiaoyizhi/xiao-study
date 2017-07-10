package home.xiao20170710;

/**
 * Created by Xiao on 2017/7/10 0010.
 */
public class Main {

    public static void main(String[] args){
        VoteManager voteManager = new VoteManager();
        for (int i = 0; i < 9; i++) {
            voteManager.request("xiaobai",VoteItemEnum.VoteItemEnum_A.getItem());
        }
    }

}
