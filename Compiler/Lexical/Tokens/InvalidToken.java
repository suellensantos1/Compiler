package Compiler.Lexical.Tokens;

import Compiler.Lexical.Tag;

public class InvalidToken extends Word {
    public InvalidToken(String s){
        super(s, Tag.INVALID);
    } 
}
