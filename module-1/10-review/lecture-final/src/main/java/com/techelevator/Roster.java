package com.techelevator;

import java.util.*;

public class Roster {

    // if we wanted to create an initial roster with a list of player
//    public Roster(List<PLayer> players) {
//        // loop through list and add each player to the map
//    }

    private Map<Integer, Player> rosterMap = new HashMap<>();

    public void addPlayer(Player player) {
        rosterMap.put(player.getJerseyNumber(), player );
    }

    public void removePlayer(int jerseyNumber) {
        rosterMap.remove(jerseyNumber);
    }

    /**
     * This checks for existence of a player
     * @param jerseyNumber - jersey number of player to search for
     * @return Player if found, if not found returns null
     */
    public Player searchPlayer(int jerseyNumber) {

        return rosterMap.get(jerseyNumber);

    }

    public List<Player> getRosterList() {

        List<Player> roster = new ArrayList<>();

        Set<Integer> keys = rosterMap.keySet();

        for (Integer key : keys) {
            roster.add(rosterMap.get(key));
        }

        return roster;

    }

}
