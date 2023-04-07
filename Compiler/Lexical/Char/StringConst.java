package Compiler.Lexical.Char;

import Compiler.Lexical.*;

public class StringConst extends Word{
    public StringConst(String s){
        super(s, Tag.STRING_CONST);
    } 
}
