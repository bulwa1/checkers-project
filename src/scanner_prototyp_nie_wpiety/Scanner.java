package scanner_prototyp_nie_wpiety;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Scanner {
    public static void main(String[] args) {
        final int doubleTable[][] = {
                {1,1,0,0,0,0},
                {0,1,0,0,0,1},
                {0,0,0,0,1,0},
                {0,0,0,0,0,1}
        };

        int numberOfColumns = countColumnSize(doubleTable[0]);
        int numberOfLayers = countLayersSize(doubleTable);




        for (int layers = 0; layers < numberOfLayers; layers++) {
            for (int columns = 0; columns < numberOfColumns; columns++)
                checkingIf1(doubleTable, layers, columns);
        }
    }


    private static void checkingIf1(int[][] doubleTable, int layers, int columns) {
        if (doubleTable[layers][columns] == 1)
            scannerOfDiagonal(doubleTable, layers, columns);
    }

    private static void scannerOfDiagonal(int[][] doubleTable, int layers, int columns) {


    }







    
    private static int countLayersSize(int[][] img){
        return img.length;
    }
    private static int countColumnSize(int[] img){
        return img.length;
    }
}
