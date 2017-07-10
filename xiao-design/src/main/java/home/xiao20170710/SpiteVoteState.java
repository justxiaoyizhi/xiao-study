package home.xiao20170710;

/**
 * Created by Xiao on 2017/7/10 0010.
 */
public class SpiteVoteState implements State {

    public void vote(String user, String voteItem, VoteManager voteManager) {
        String item = voteManager.getMapVote().get(user);
        if(item != null) {
            voteManager.getMapVote().remove(user);
        }
        System.out.println("你已经被禁止投票,并且投票已经无效");
    }
}
