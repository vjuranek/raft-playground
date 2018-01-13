package io.github.vjuranek.raft;

/**
 * // TODO: Document this
 *
 * @author vjuranek
 */
public class VoteResult {

    private int term;
    private boolean voteGranted;

    public VoteResult(int term, boolean voteGranted) {
        this.term = term;
        this.voteGranted = voteGranted;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public boolean isVoteGranted() {
        return voteGranted;
    }

    public void setVoteGranted(boolean voteGranted) {
        this.voteGranted = voteGranted;
    }
}
