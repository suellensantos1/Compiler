package Compiler.Lexical.Tokens.Char;

import Compiler.Lexical.*;
import Compiler.Lexical.Tokens.Word;

public class StringConst extends Word{
    public StringConst(String s){
        super(s, Tag.STRING_CONST);
    } 
}
