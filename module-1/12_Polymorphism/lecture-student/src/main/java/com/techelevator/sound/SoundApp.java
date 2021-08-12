package com.techelevator.sound;

import java.util.ArrayList;
import java.util.List;

public class SoundApp {
    public static void main(String[] args) {
        OneDirection oneD=new OneDirection();

        ISound oneDAsIterface = new OneDirection();
        System.out.println(oneDAsIterface.getItemName());

        ISound chainSaw = new Chainsaw();
        System.out.println(chainSaw.getItemName());

        List<ISound> myList = new ArrayList<>();
        myList.add(oneDAsIterface);
        myList.add(chainSaw);

        for (ISound item:myList){
            System.out.println(item.getItemName()+ " "+ item.makeSound());
        }



    }
}
