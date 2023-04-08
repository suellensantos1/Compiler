package Compiler.SymbolTable;

import java.util.*;
import java.util.Map.Entry;

import Compiler.Lexical.Tokens.Word;
import Compiler.Lexical.Tag;

public class SymbolTable {

    private Hashtable<String, Word> words;

    public SymbolTable(){
        words = new Hashtable<String, Word>();
        //Insere palavras reservadas na HashTable
        reserve(new Word("program", Tag.PRG));
        reserve(new Word("begin", Tag.BEG));
        reserve(new Word("end", Tag.END));
        reserve(new Word("is", Tag.IS));
        reserve(new Word("type", Tag.TYPE));
        reserve(new Word("int", Tag.INT));
        reserve(new Word("float", Tag.FLOAT));
        reserve(new Word("char", Tag.CHAR));
        reserve(new Word("if", Tag.IF));
        reserve(new Word("then", Tag.THEN));
        reserve(new Word("else", Tag.ELSE));
        reserve(new Word("repeat", Tag.REPEAT));
        reserve(new Word("until", Tag.UNTIL));
        reserve(new Word("while", Tag.WHILE));
        reserve(new Word("do", Tag.DO));
        reserve(new Word("read", Tag.READ));
        reserve(new Word("write", Tag.WRITE));

    }

    /* Método para inserir palavras reservadas na HashTable */
    public void reserve(Word w) {
        words.put(w.getLexeme(), w); // lexema é a chave para entrada na
        //HashTable
    }
    
    public Word get(String s){
        return words.get(s);
    }

    public Word put(String s, Word w){
        return words.put(s, w);
    }

    public void printSymbolTable(){
        System.out.println();
        System.out.println("Symbol Table");
        for(Entry<String, Word> entry: words.entrySet()){
            System.out.println("\tChave: " + entry.getKey() + "\tLexeme: " 
                                + entry.getValue().getLexeme() + "\tTag: "
                                + Tag.getTagName(entry.getValue().getTag()));
        }
    }
}
