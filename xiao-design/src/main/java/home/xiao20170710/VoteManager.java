package home.xiao20170710;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Xiao on 2017/7/10 0010.
 * 环境类，Context
 */
public class VoteManager {
    /**
     *
     */
    public State state;

    /**
     * 投票的人（key）和投票的item（value）的集合map
     */
    private Map<String,String> mapVote = new HashMap<String, String>();

    public Map<String, String> getMapVote() {
        return mapVote;
    }

    /**
     * 投票的人（key）和投票的数量（value）的集合map
     */
    private Map<String,Integer> mapVoteCount = new HashMap<String, Integer>();


    public void request(String user, String voteItem) {
        Integer oldCount = mapVoteCount.get(user);
        if(oldCount == null) { //如果第一次进来是空的
            oldCount = 0;
        }
        oldCount++;
        mapVoteCount.put(user,oldCount);
        if(oldCount == 1) {
            state = new NormalVoteState();
        } else if (oldCount > 1 && oldCount <= 5) {
            state = new RepeatVoteState();
        } else if (oldCount > 5 && oldCount <= 8) {
            state = new SpiteVoteState();
        } else if (oldCount > 8) {
            state = new BlackVoteState();
        } else {
            // TODO:扩展
        }
        state.vote(user, voteItem,this);
    }
}
