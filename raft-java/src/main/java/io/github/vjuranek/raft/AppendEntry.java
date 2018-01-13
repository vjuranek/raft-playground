package io.github.vjuranek.raft;

import java.util.List;

/**
 * // TODO: Document this
 *
 * @author vjuranek
 */
public class AppendEntry<T> {

    private int term;
    private String leaderId;
    private int prevLogIndex;
    private int precLogTerm;
    private int leaderCommit;
    private List<T> entries;

    public AppendEntry(int term, String leaderId, int prevLogIndex, int precLogTerm, int leaderCommit, List<T> entries) {
        this.term = term;
        this.leaderId = leaderId;
        this.prevLogIndex = prevLogIndex;
        this.precLogTerm = precLogTerm;
        this.leaderCommit = leaderCommit;
        this.entries = entries;
    }

    public int getTerm() {
        return term;
    }

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

    public int getPrecLogTerm() {
        return precLogTerm;
    }

    public void setPrecLogTerm(int precLogTerm) {
        this.precLogTerm = precLogTerm;
    }

    public int getLeaderCommit() {
        return leaderCommit;
    }

    public void setLeaderCommit(int leaderCommit) {
        this.leaderCommit = leaderCommit;
    }

    public List<T> getEntries() {
        return entries;
    }

    public void setEntries(List<T> entries) {
        this.entries = entries;
    }
}
