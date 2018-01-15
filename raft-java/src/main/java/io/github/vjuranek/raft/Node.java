package io.github.vjuranek.raft;

import java.util.List;

/**
 * // TODO: Document this
 *
 * @author vjuranek
 */
public class Node<T> implements Server<T> {

    private Role role;
    private VolatileState volatileState;
    private PersistentState<T> persistState;
    private LeaderState leaderState;


    public Node() {
        role = Role.FOLLOWER;
        volatileState = new VolatileState(0, 0);
        persistState = new PersistentState<T>();
        leaderState = new LeaderState();
    }

    public AppendResult appendEntry(AppendEntry<T> entry) {
        AppendResult res = new AppendResult(persistState.getCurrentTerm(), false);
        if (persistState.getCurrentTerm() < entry.getTerm()) {
            persistState.setCurrentTerm(entry.getTerm());
        } else {
            res.setResult(updateLog(entry));
        }
        return res;
    }

    public VoteResult requestVote(VoteEntry entry) {
        return null;  // TODO: Customise this generated block
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    private boolean updateLog(AppendEntry<T> entry) {
        boolean success =  false;
        List<LogEntry<T>> log = persistState.getLog();
        try {
            LogEntry<T> prevEntry = log.get(entry.getPrevLogIndex());
            if (prevEntry.getTerm() != entry.getPrevLogTerm()) {
                for (int i = entry.getPrevLogIndex(); i < log.size(); i++) {
                    log.remove(i);
                }
            } else {
                int commitIndex = volatileState.getCommitIndex();
                if (commitIndex < entry.getLeaderCommit()) {
                    commitIndex = Math.min(entry.getLeaderCommit(), log.size());
                }
                log.add(commitIndex, new LogEntry(persistState.getCurrentTerm(), entry.getValue()));
            }
        } catch (IndexOutOfBoundsException e) {
            //no-op, success already set to false
        }
        return success;
    }
}
