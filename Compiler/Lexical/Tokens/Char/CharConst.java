package Compiler.Lexical.Tokens.Char;

import Compiler.Lexical.Tag;
import Compiler.Lexical.Tokens.Word;

public class CharConst extends Word {
    public CharConst(char c) {
        super(c+"", Tag.CHAR_CONST);
    }
}
