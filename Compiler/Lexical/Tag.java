package Compiler.Lexical;

import java.util.HashMap;

public class Tag {

    public final static int 
            //Palavras reservadas
            PRG = 256,
            BEG = 257,
            END = 258,
            IS = 259,
            TYPE = 260,
            INT = 261,
            FLOAT = 262,
            CHAR = 263,
            IF = 264,
            THEN = 265,
            ELSE = 266,
            REPEAT = 267,
            UNTIL = 268,
            WHILE = 269,
            DO = 270,
            READ = 271,
            WRITE = 272,
            //Operadores e pontuação

            EQ = 288,
            GE = 289,
            LE = 290,
            NE = 291,
            AND = 294,
            OR = 295,
            
            //Outros tokens
            INT_CONST = 300,
            FLOAT_CONST = 301,
            ID = 302,
            CHAR_CONST = 303,
            STRING_CONST = 304,
            
            //Fim de arquivo e token inválido
            EOF= -1,
            INVALID = -2; 

        private static HashMap<Integer, String> tagNames;

        static{
            tagNames = new HashMap<Integer, String>();
            tagNames.put(PRG, "PROGRAM");
            tagNames.put(BEG, "BEGIN");
            tagNames.put(END, "END");
            tagNames.put(IS, "IS");
            tagNames.put(TYPE, "TYPE");
            tagNames.put(INT, "INT");
            tagNames.put(FLOAT, "FLOAT");
            tagNames.put(CHAR, "CHAR");
            tagNames.put(IF, "IF");
            tagNames.put(THEN, "THEN");
            tagNames.put(ELSE, "ELSE");
            tagNames.put(REPEAT, "REPEAT");
            tagNames.put(UNTIL, "UNTIL");
            tagNames.put(WHILE, "WHILE");
            tagNames.put(DO, "DO");
            tagNames.put(READ, "READ");
            tagNames.put(WRITE, "WRITE");
            tagNames.put(EQ, "EQUAL");
            tagNames.put(GE, "GREATER EQUAL");
            tagNames.put(LE, "LESS EQUAL");
            tagNames.put(NE, "NOT EQUAL");
            tagNames.put(AND, "AND");
            tagNames.put(OR, "OR");
            tagNames.put(INT_CONST, "INT CONSTANT");
            tagNames.put(FLOAT_CONST, "FLOAT CONSTANT");
            tagNames.put(INT_CONST, "INT CONSTANT");
            tagNames.put(ID, "ID");
            tagNames.put(CHAR_CONST, "CHAR CONSTANT");
            tagNames.put(STRING_CONST, "STRING CONSTANT");
            tagNames.put(EOF, "END OF FILE");
            tagNames.put((int)'.', "DOT");
            tagNames.put((int)';', "SEMI COLON");
            tagNames.put((int)',', "COLON");
            tagNames.put((int)'=', "ASSIGN");
            tagNames.put((int)'(', "OPEN PAR");
            tagNames.put((int)')', "CLOSE PAR");
            tagNames.put((int)'!', "NOT");
            tagNames.put((int)'-', "SUB");
            tagNames.put((int)'>', "GREATER");
            tagNames.put((int)'<', "LESS");
            tagNames.put((int)'+', "ADD");
            tagNames.put((int)'*', "MUL");
            tagNames.put((int)'/', "DIV");
        
        }

        public static String getTagName(int tag){
            return tagNames.get(tag);
        }
}
