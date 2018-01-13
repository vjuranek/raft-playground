package io.github.vjuranek.raft;

import java.util.ArrayList;
import java.util.List;

/**
 * // TODO: Document this
 *
 * @author vjuranek
 */
public class PersistentState<T> {

    private int currentTerm;
    private String votedFor;
    private List<T> log;

    public PersistentState() {
        this.currentTerm = 0;
        this.votedFor = null;
        log = new ArrayList<T>();
    }

    public int getCurrentTerm() {
        return currentTerm;
    }

    public void setCurrentTerm(int currentTerm) throws IllegalArgumentException {
        if (currentTerm <= this.currentTerm) {
            throw new IllegalArgumentException(String.format("Cannot set term to %d which is lower or equal to current term %d", currentTerm, this.currentTerm));
        }
        this.currentTerm = currentTerm;
    }

    public String getVotedFor() {
        return votedFor;
    }

    public void setVotedFor(String votedFor) {
        this.votedFor = votedFor;
    }

    public List<T> getLog() {
        return log;
    }

    public void setLog(List<T> log) {
        this.log = log;
    }
}
