package org.example.Blackjack;

import java.util.Objects;


enum KortSorter {
    SPAR,
    KLØVER,
    HJERTER,
    RUTER
}
public class Kort {

    private KortSorter kortType;
    private int verdi;

    public Kort(KortSorter kortType, int verdi) {
        this.kortType = kortType;
        this.verdi = verdi;
    }

    @Override
    public String toString() {
        return
                 "[" + kortType + "]" + "(" + verdi + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kort)) return false;
        Kort kort = (Kort) o;
        return verdi == kort.verdi && kortType == kort.kortType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kortType, verdi);
    }

    public KortSorter getKortType() {
        return kortType;
    }

    public void setKortType(KortSorter kortType) {
        this.kortType = kortType;
    }

    public int getVerdi() {
        return verdi;
    }

    public void setVerdi(int verdi) {
        this.verdi = verdi;
    }
}

