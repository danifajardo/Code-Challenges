package com.algrebraicchess;

import java.util.Map;

public class ChessToWords {

    //create a map with tha main pieces
    private static Map<Character, String> mainPieces = Map.of(
        'K',  "King",
        'Q', "Queen",
        'B', "Bishop",
        'N', "Knight",
        'R', "Rook"
    );
    //create a map with the main actions
    private static Map<Character, String> mainActions = Map.of(
        ' ', ", capturing en passant",
        '+', ", check",
        '#', ", checkmate",
        '=', " and promoted to",
        'x', " and captured"
    );

    public static String toWords(String move){
        //verify if the move is a castle
        if(move.contains("O-O")){
            if(move.contains("O-O-O")){
                return "A queenside castle.";
            }else{
                return "A kingside castle.";
            }
        }
        //
        char[] symbols = move.toCharArray();
        String phrase = "";
        //get the piece
        phrase += getPiece(symbols[0]);
        //get ranks and files
        char[] files = getFiles(symbols);
        char[] ranks = getRanks(symbols);
        //verify if there is an additional rank or file (Piece on rank.. or Piece on file ...)        
        if(files[1] != '\0'){
            if(!phrase.equals("Pawn")){
                phrase += " on file " + files[0];
            }
            files[0] = files[1];
        }else if(ranks[1] != '\0'){
            if(phrase != "Pawn"){
                phrase += " on rank " + ranks[0];
            }
            ranks[0] = ranks[1];
        }
        //add move to (file, rank)
        phrase += " moved to " + files[0] + ranks[0];
        //add actions
        phrase += getActions(symbols);
        //return
        return phrase + ".";
    }

    private static char[] getFiles(char[] symbols){
        //
        char[] files = new char[2];
        int countfiles = 0;
        //look for numbers in the array
        for (char currentSymbol : symbols) {
            if(currentSymbol >= 97 && currentSymbol <= 104 && countfiles < 2){
                files[countfiles] = currentSymbol;
                countfiles++;
            }
        }
        return files;
    }

    private static char[] getRanks(char[] symbols){
        //
        char[] ranks = new char[2];
        int countranks = 0;
        //look for numbers in the array
        for (char currentSymbol : symbols) {
            if(Character.isDigit(currentSymbol)){
                ranks[countranks] = currentSymbol;
                countranks++;
            }
        }
        return ranks;
    }

    private static String getPiece(char piece){
        //identify which piece is doing the move
        for (char currentPiece : mainPieces.keySet()) {
            if(currentPiece == piece){
                return mainPieces.get(currentPiece);
            }
        }
        //return pawn otherwise
        return "Pawn";
    }

    public static String getActions(char[] symbols){
        //
        String action = "";
        //identify which action is doing the piece
        for (int i = 0; i < symbols.length; i++) {
            if(mainActions.get(symbols[i]) != null){
                //codition for captures (normal or en passant)
                if(symbols[i] == 'x'){
                    //add normal capturing
                    action += mainActions.get(symbols[i]);
                    //look for en passant capured
                    for (int j = i; j < symbols.length; j++) {
                        if(symbols[j] == ' '){
                            //remove the normal captured
                            action = "";
                            action += mainActions.get(symbols[j]);
                            symbols[j] = '\0';
                        }
                    }

                //condition when the piece is promoted
                }else if(symbols[i] == '='){
                    action += mainActions.get(symbols[i]) + " " + getPiece(symbols[i+1]).toLowerCase();
                }else{
                    action += mainActions.get(symbols[i]);
                }
            }
        }
        //
        return action;
    } 


}
