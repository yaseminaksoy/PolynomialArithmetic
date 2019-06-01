/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package PolynomialArithmetic;

//import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 *
 * @file Test.java
 * @description collecting polynomials that read from the file
 * @assignment homework1
 * @date 09.03.2019
 * @author yaseminaksoy yasemiiinaksoy@gmail.com
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        LinkedList<String> list = new LinkedList<>();
        File file = new File("data.txt");
        Scanner dosya = new Scanner(file);
        int value = dosya.nextInt();    //first line is x value
        System.out.println("x value to be calculated = " + value);
        int polynomialCount = 0;
        while (dosya.hasNextLine()) {
            String row = dosya.nextLine();
            if (row.contains(",") && !row.contains("*")) {
                String dataList[] = row.split(",");
                dataList[1] = dataList[1].substring(1);
                list.add(dataList[0], dataList[1]);

            } else {
                polynomialCount++;
            }

        }
        System.out.println("Sum of Polynomials = " + list.total(value));
        System.out.println("Total Number of Polynomials = " + (polynomialCount - 1));
        list.print();

    }

}
