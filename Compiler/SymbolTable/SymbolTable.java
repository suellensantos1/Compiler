package Compiler.SymbolTable;

import java.util.*;

import Compiler.Lexical.Tokens.Word;

public class SymbolTable {

    private Hashtable<String, Word> words;

    public SymbolTable(){
        words = new Hashtable<String, Word>();

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
}
