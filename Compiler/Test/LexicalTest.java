package Compiler.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import Compiler.Lexical.*;
import Compiler.Lexical.Tokens.Token;
import Compiler.SymbolTable.SymbolTable;

public class LexicalTest {
    public static void main(String[] args) {
        if(args.length < 1){
            System.out.println("Usage: java LexicalTest {testcases filenames}");
            return;
        }
        Lexer lexer;
        SymbolTable symbolTable = new SymbolTable();
        for(int i=0; i < args.length; i++){            
            try{
                lexer = new Lexer(args[i], symbolTable);
                Token t = lexer.scan();
                while(t.getTag()!=Tag.EOF){
                    System.out.println("Lexema: " + t.toString()+"\t\tTag: " + Tag.getTagName(t.getTag()));
                    t = lexer.scan(); 
                }
                symbolTable.printSymbolTable();
            } catch(FileNotFoundException e) {
                System.out.println("File: " + args[i] + " not found.");
            } catch(IOException e){
                System.out.println("Something went wrong while reading the file: "+ args[i]);
            }
        }

    }
}
