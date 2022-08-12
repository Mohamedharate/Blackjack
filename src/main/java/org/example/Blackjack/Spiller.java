package org.example.Blackjack;
import java.util.Scanner;

public class Spiller extends Person {
    Scanner input = new Scanner(System.in);
    public Spiller() {
        super.setNavn("Spiller");
    }
    public void velg(Dekk dekk){

        int  valg = 0;
        boolean getNum = true;

        while(getNum){

            try{
                System.out.println("Velg: 1) Hit eller 2) Stand");
                valg = input.nextInt();
                getNum = false;

            }
            catch(Exception e){
                System.out.println("Invalid");
                input.next();
            }
        }
       if (valg == 1) {

            this.hit(dekk);
            if(this.getHand().getValue()>20){
                return;
            }
            else{
                this.velg(dekk);
            }
        } else {
            System.out.println("Spilleren stands.");
        }

    }


}
