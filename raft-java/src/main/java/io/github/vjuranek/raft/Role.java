package io.github.vjuranek.raft;

/**
 * List of possible node states.
 *
 * @author vjuranek
 */
public enum Role {
    CANDIDATE,
    FOLLOWER,
    LEADER;
}
