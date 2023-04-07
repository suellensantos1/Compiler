package Compiler.Lexical.Tokens.Num;

import Compiler.Lexical.Tag;

public class FloatConst extends Num {
    public FloatConst(double value){
        super(value, Tag.FLOAT_CONST);
    }
}
