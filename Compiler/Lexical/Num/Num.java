package Compiler.Lexical.Num;

import Compiler.Lexical.Token;

public abstract class Num extends Token {

    public final Number value;

    public Num(Number value, int tag) {
        super(tag);
        this.value = value;
    }

    public String toString() {
        return "" + value;
    }

    public Number getValue(){
        return this.value;
    }
}
