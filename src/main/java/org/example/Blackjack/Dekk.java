package org.example.Blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dekk {

    private ArrayList<Kort> dekk;

    public Dekk(){
        dekk = new ArrayList<Kort>();
    }

    public List<Kort> genererKortstokk(){

        for(KortSorter kortSorter : KortSorter.values()){
            for(int j = 2; j <= 10; j++){
                dekk.add(new Kort(kortSorter,j));
            }
            for(int k = 1;k<=3;k++){
                dekk.add(new Kort(kortSorter,10));
            }
            dekk.add(new Kort(kortSorter,11));
        }
        return dekk;
    }

    public void stokkKortStokk(){
        Collections.shuffle(this.dekk);
    }

    public Kort takeCard(){

        Kort cardToTake = dekk.get(0);

        dekk.remove(0);

        return cardToTake;

    }


}
