package io.github.vjuranek.raft;

/**
 * // TODO: Document this
 *
 * @author vjuranek
 */
public class AppendEntry<T> {

    private int term;
    private String leaderId;
    private int prevLogIndex;
    private int prevLogTerm;
    private int leaderCommit;
    //private List<T> entries;
    private T value; //TODO: list of entries should be supported for efficiency

    public AppendEntry(int term, String leaderId, int prevLogIndex, int precLogTerm, int leaderCommit, T value) {
        this.term = term;
        this.leaderId = leaderId;
        this.prevLogIndex = prevLogIndex;
        this.prevLogTerm = precLogTerm;
        this.leaderCommit = leaderCommit;
        this.value = value;
    }

    public int getTerm() { return term; }

    public void setTerm(int term) {
        this.term = term;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }

    public int getPrevLogIndex() {
        return prevLogIndex;
    }

    public void setPrevLogIndex(int prevLogIndex) {
        this.prevLogIndex = prevLogIndex;
    }

    public int getPrevLogTerm() {
        return prevLogTerm;
    }

    public void setPrevLogTerm(int prevLogTerm) {
        this.prevLogTerm = prevLogTerm;
    }

    public int getLeaderCommit() {
        return leaderCommit;
    }

    public void setLeaderCommit(int leaderCommit) {
        this.leaderCommit = leaderCommit;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
