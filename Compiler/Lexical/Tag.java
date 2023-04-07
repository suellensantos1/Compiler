package Compiler.Lexical;

public class Tag {

    public final static int //Palavras reservadas
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
            NUM = 300,
            ID = 301,
            
            //Fim de arquivo e token inválido
            EOF= -1,
            INVALID = -2; 
}
