package home.xiao20170710;

/**
 * Created by Xiao on 2017/7/10 0010.
 */
public interface State {

    void vote(String user, String voteItem, VoteManager voteManager);

}
