package com.techelevator;

import java.util.List;

public class PlayerTracker {

    public static void main(String[] args) {
        PlayerTracker tracker = new PlayerTracker();
        tracker.run();
    }

    private void run() {

        Roster roster = new Roster();
        Player kevin =new Player("Kevin", "Teos", 11, 0.0);
        Player stacy =new Player("Stacy", "McGrath", 12, 0.0);

        roster.addPlayer(kevin);
        roster.addPlayer(stacy);



        Player foundPlayer = roster.searchPlayer(11);

        if (foundPlayer != null) {
            System.out.println(foundPlayer.getJerseyNumber());
        }

        //print of list
        List<Player> rosterList = roster.getRosterList();

        for (Player player : rosterList) {
            System.out.println("Player: " + player.getJerseyNumber() + ": "  + player.getFirstName() + " " + player.getLastName());
        }


    }

}
