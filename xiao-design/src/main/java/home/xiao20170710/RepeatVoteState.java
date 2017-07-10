package home.xiao20170710;

/**
 * Created by Xiao on 2017/7/10 0010.
 */
public class RepeatVoteState implements State {

    public void vote(String user, String voteItem, VoteManager voteManager) {
        System.out.println("请不要重复投票！！");
    }
}
