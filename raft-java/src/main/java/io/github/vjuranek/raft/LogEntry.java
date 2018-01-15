package io.github.vjuranek.raft;

/**
 * // TODO: Document this
 *
 * @author vjuranek
 */
public class LogEntry<T> {

    private int term;
    private T value;

    public LogEntry(int term, T value) {
        this.term = term;
        this.value = value;
    }

    public int getTerm() {
        return term;
    }

    public void setTerm(int term) {
        this.term = term;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
