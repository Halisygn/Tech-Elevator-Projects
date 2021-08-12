package com.techelevator.sounds;

import com.sun.net.httpserver.Filter;

import java.time.chrono.IsoChronology;
import java.util.*;

public class SoundApp {

    public static void main(String[] args) {


        OneDirection oneD = new OneDirection();
        Chainsaw c = new Chainsaw();



        ISound oneDAsInterface = new OneDirection();
        System.out.println(oneDAsInterface.getItemName());

        ISound chainSaw = new Chainsaw();
        System.out.println(chainSaw.getItemName());


        List<ISound> myList = new ArrayList<>();
        myList.add(oneDAsInterface);
        myList.add(chainSaw);

        for (ISound item : myList) {
            System.out.println(item.getItemName() + "  " + item.makeSound());

            if (item instanceof Chainsaw) {
                Chainsaw ch = (Chainsaw) item;
                ch.setStarted(true);
            }
        }

        List<Object> myObjects = new ArrayList<>();
        myObjects.add(oneDAsInterface);
        myObjects.add(chainSaw);

        for (Object o : myObjects) {
            System.out.println(((ISound) o).makeSound());
        }





    }

}
