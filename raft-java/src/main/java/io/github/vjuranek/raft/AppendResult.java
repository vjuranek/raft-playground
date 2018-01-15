package io.github.vjuranek.raft;

/**
 * Result of Append entry RPC call.
 *
 * @author vjuranek
 */
public class AppendResult {

    private int term;
    private boolean result;

    public AppendResult() {
    }

    public AppendResult(int term, boolean result) {
        this.term = term;
        this.result = result;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
