package Compiler.Lexical;

import java.io.*;
import Compiler.SymbolTable.SymbolTable;


public class Lexer {

    public static int line = 1; //contador de linhas
    private char ch = ' '; //caractere lido do arquivo
    private FileReader file;
    private SymbolTable symbolTable;

    /* Método construtor */
    public Lexer(String fileName) throws FileNotFoundException {
        try {
            file = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado");
            throw e;
        }
        //Insere palavras reservadas na HashTable
        symbolTable = new SymbolTable();
        symbolTable.reserve(new Word("program", Tag.PRG));
        symbolTable.reserve(new Word("begin", Tag.BEG));
        symbolTable.reserve(new Word("end", Tag.END));
        symbolTable.reserve(new Word("is", Tag.IS));
        symbolTable.reserve(new Word("type", Tag.TYPE));
        symbolTable.reserve(new Word("int", Tag.INT));
        symbolTable.reserve(new Word("float", Tag.FLOAT));
        symbolTable.reserve(new Word("char", Tag.CHAR));
        symbolTable.reserve(new Word("if", Tag.IF));
        symbolTable.reserve(new Word("then", Tag.THEN));
        symbolTable.reserve(new Word("else", Tag.ELSE));
        symbolTable.reserve(new Word("repeat", Tag.REPEAT));
        symbolTable.reserve(new Word("until", Tag.UNTIL));
        symbolTable.reserve(new Word("while", Tag.WHILE));
        symbolTable.reserve(new Word("do", Tag.DO));
        symbolTable.reserve(new Word("read", Tag.READ));
        symbolTable.reserve(new Word("write", Tag.WRITE));
    }

    /*Lê o próximo caractere do arquivo*/
    private void readch() throws IOException {
        ch = (char) file.read();
    }

    /* Lê o próximo caractere do arquivo e verifica se é igual a c*/
    private boolean readch(char c) throws IOException {
        readch();
        if (ch != c) {
            return false;
        }
        ch = ' ';
        return true;
    }

    public Token scan() throws IOException {
        //Desconsidera delimitadores na entrada
        for (;; readch()) {
            if (ch == ' ' || ch == '\t' || ch == '\r' || ch == '\b') {
                continue;
            } else if (ch == '\n') {
                line++; //conta linhas
            } else {
                break;
            }
        }
        switch (ch) {
            //Operadores
            case '&':
                if (readch('&')) {
                    return Word.and;
                } else {
                    return new Token('&');
                }
            case '|':
                if (readch('|')) {
                    return Word.or;
                } else {
                    return new Token('|');
                }
            case '=':
                if (readch('=')) {
                    return Word.eq;
                } else {
                    return new Token('=');
                }
            case '<':
                if (readch('=')) {
                    return Word.le;
                } else {
                    return new Token('<');
                }
            case '>':
                if (readch('=')) {
                    return Word.ge;
                } else {
                    return new Token('>');
                }
        }
        //Números
        if (Character.isDigit(ch)) {
            double value = 0;
            double Decimal = 0;
            int NrDecimais = 10;
            boolean semDecimal = true;
            do {
                if(ch == '.'){
                    semDecimal = false;
                }
                if(semDecimal = true){
                    value = 10 * value + Character.digit(ch, 10);
                }else{
                    Decimal = Decimal/10 + Character.digit(ch, 10)/NrDecimais;
                    NrDecimais *= 10;
                }
                readch();
            } while (Character.isDigit(ch)|| (ch == '.' && semDecimal));
            value += Decimal/10;
            return new Num(value);
        }
        //Identificadores
        if (Character.isLetter(ch)) {
            StringBuffer sb = new StringBuffer();
            do {
                sb.append(ch);
                readch();
            } while (Character.isLetterOrDigit(ch));
            String s = sb.toString();
            Word w =  symbolTable.get(s);
            if (w != null) {
                return w; //palavra já existe na HashTable
            }
            w = new Word(s, Tag.ID);
            symbolTable.put(s, w);
            return w;
        }

        //Caracteres não especificados
        Token t = new Token(ch);
        ch = ' ';
        return t;
    }
}
