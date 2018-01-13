package io.github.vjuranek.raft;

/**
 * // TODO: Document this
 *
 * @author vjuranek
 */
public interface Server<T> {

    public AppendResult appendEntry(AppendEntry<T> entry);
    public VoteResult requestVote(VoteEntry entry);

}
