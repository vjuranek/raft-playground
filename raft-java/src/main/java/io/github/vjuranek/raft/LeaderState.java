package io.github.vjuranek.raft;

import java.util.HashMap;
import java.util.Map;

/**
 * // TODO: Document this
 *
 * @author vjuranek
 */
public class LeaderState {

    private Map<String, Integer> nextIndex;
    private Map<String, Integer> matchIndex;

    public LeaderState() {
        this.nextIndex = new HashMap<String, Integer>();
        this.matchIndex = new HashMap<String, Integer>();
    }

    public LeaderState(int numSevers) {
        this.nextIndex = new HashMap<String, Integer>(numSevers);
        this.matchIndex = new HashMap<String, Integer>(numSevers);
    }

    public LeaderState(Map<String, Integer> nextIndex, Map<String, Integer> matchIndex) {
        this.nextIndex = nextIndex;
        this.matchIndex = matchIndex;
    }

    public void updateNextIndex(String serverId, Integer index) throws IllegalArgumentException {
        if (nextIndex.containsKey(serverId) && nextIndex.get(serverId) > index) {
            throw new IllegalArgumentException(String.format("Next index %d cannot be lower than current index %d", index, nextIndex.get(serverId)));
        }
        nextIndex.put(serverId, index);
    }

    public void updateMatchIndex(String serverId, Integer index) throws IllegalArgumentException {
        if (matchIndex.containsKey(serverId) && matchIndex.get(serverId) > index) {
            throw new IllegalArgumentException(String.format("Match index %d cannot be lower than current index %d", index, matchIndex.get(serverId)));
        }
        matchIndex.put(serverId, index);
    }
}
