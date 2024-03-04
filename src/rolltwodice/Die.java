package rolltwodice;

/*
Ingen ændringer fra RollOneDie.
- Opgave 1.1: Metoden her kan tilskrive en værdi til begge terninger.
*/
public class Die {
    private int faceValue;

    public Die() {
        faceValue = 0;
    }

    public int getFaceValue() {
        return faceValue;
    }

    public void roll() {
        faceValue = (int) (Math.random() * 6) + 1;
    }
}
