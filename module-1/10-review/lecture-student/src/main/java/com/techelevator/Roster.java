package com.techelevator;

import java.util.*;

public class Roster {

    private Map<Integer, Player> rosterMap = new HashMap<>();

    public void addPlayer(Player player) {
        rosterMap.put(player.getJerseyNumber(), player);
    }

    public void remove(int jerseyNumber) {
        rosterMap.remove(jerseyNumber);
    }

    public Player searchPlayer(int jerseyNumber) {
        return rosterMap.get(jerseyNumber);
    }

    public List<Player> getRosterList() {
//        List<Player> roster=new ArrayList<>(rosterMap.values());
//        return roster;
        List<Player> roster = new ArrayList<>();
        Set<Integer> keys = rosterMap.keySet();
        for (Integer key : keys) {
            roster.add(rosterMap.get(key));
        }
        return roster;
    }
}
