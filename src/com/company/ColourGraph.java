package com.company;

import java.util.LinkedList;

public class ColourGraph {
    int V;
    int[] verticeColor;

    LinkedList<Integer> adjListArray[];

    // constructor
    ColourGraph(int V) {
        this.V = V;

        adjListArray = new LinkedList[V];
        verticeColor = new int[V];
        //store Edge by LinkedList
        for (int i = 0; i < V; i++) {
            adjListArray[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertice1, int vertice2) {
        adjListArray[vertice1].add(vertice2);
        adjListArray[vertice2].add(vertice1);
    }

    static boolean checkRegularGraph(ColourGraph colourGraph) {
        int i = colourGraph.adjListArray[1].size();
        for (LinkedList linkedList : colourGraph.adjListArray) {
            if (linkedList.size() != i) {
                return false;
            }
        }
        return true;
    }

    //ktra do thi co la do thi chinh quy

    void colourVertice(int vertice, int colour) {
        verticeColor[vertice] = colour;
    }

    boolean checkcolorVertice(int i){
        for (int j : adjListArray[i] ) {
            if(verticeColor[i] == verticeColor[j]){
                return false;
            }
        }
        return true;
    }
    static void colouringGraph(ColourGraph colourGraph) {
        if (!checkRegularGraph(colourGraph)) {
            for (int h = 1; h < colourGraph.V; h++) {
                colourGraph.colourVertice(h, 0);
            }
            colourGraph.colourVertice(0,1);

            for(int i =0; i < colourGraph.V; i++  ){
                int j = 1;
                while (true) {
                    colourGraph.colourVertice(i , j);
                    if (colourGraph.checkcolorVertice(i)){
                        colourGraph.colourVertice(i,j);
                        break;
                    }
                    j++;
                }
            }
            // to mau cho do thi khong chinh quy
        }
    }
}

