package io.github.vjuranek.raft;

/**
 * // TODO: Document this
 *
 * @author vjuranek
 */
public class Node<T> {

    private Role role;
    private PersistentState<T> persistState;
    private LeaderState leaderState;


    public Node() {
        role = Role.FOLLOWER;
        persistState = new PersistentState<T>();
        leaderState = new LeaderState();
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
