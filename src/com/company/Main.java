package com.company;
import static com.company.ColourGraph.*;

import java.io.*;
import java.util.Scanner;
import com.company.ColourGraph.*;

public class Main {

    public static void main(String[] args) {
        String[] colorArray = new String[300];
        File file = new File(System.getProperty("user.dir") + "/INPUT//dothi.txt");
        Scanner sc = null;
        try {
            //Đọc dữ liệu từ file test.txt
            sc = new Scanner(file);
            int V = sc.nextInt();
            ColourGraph colourGraph = new ColourGraph(V+1);


            PrintWriter writer = new PrintWriter(new File(System.getProperty("user.dir") + "/OUTPUT//result.dot"));
            writer.println("Graph{");
            while (sc.hasNextInt()) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                colourGraph.addEdge(x,y);
                writer.println(x +" -- "+y+";");
            }
            //In danh sach cac canh ra file result.dot

            colouringGraph(colourGraph);
            sc.close();
            //To mau cac dinh

            sc = new Scanner(new File(System.getProperty("user.dir")+ "/INPUT//rbg.txt "));
            int i = 0;
            while(i<100){
                colorArray[i] = Integer.toHexString(sc.nextInt()) +
                        (Integer.toHexString(sc.nextInt())) +Integer.toHexString(sc.nextInt());
                sc.nextLine();
                sc.nextLine();
                sc.nextLine();
                sc.nextLine();
                i=i+1;
            }
            //Tao ra ÂraayString chua cac ma mau
            System.out.println(colourGraph.verticeColor[3]);
            for (int j = 0; j < V+1;j++){
                writer.println(j + "[ fillcolor = \"# " + colorArray[colourGraph.verticeColor[j]]
                        +"\" , style=filled ];");
            }
            writer.println("}");
            writer.flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

