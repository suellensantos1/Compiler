public class Num extends Token {

    public final double value;

    public Num(double value) {
        super(Tag.NUM);
        this.value = value;
    }

    public String toString() {
        return "" + value;
    }
}
