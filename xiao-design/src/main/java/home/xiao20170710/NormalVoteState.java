package home.xiao20170710;

/**
 * Created by Xiao on 2017/7/10 0010.
 */
public class NormalVoteState implements State {

    public void vote(String user, String voteItem, VoteManager voteManager) {
        voteManager.getMapVote().put(user,voteItem); // 记录投票记录
        System.out.println("投票成功！");
    }
}
