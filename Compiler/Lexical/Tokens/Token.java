package Compiler.Lexical.Tokens;

public class Token {

    public final int tag; //constante que representa o token

    public Token(int t) {
        tag = t;
    }

    public String toString() {
        return "" + tag;
    }

    public int getTag() {
        return tag;
    }
    
}
