/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PolynomialArithmetic;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
/**
 *
 * @file LinkedList.java
 * @description collecting polynomials that read from the file
 * @assignment homework1
 * @date 09.03.2019
 * @author yaseminaksoy yasemiiinaksoy@gmail.com
 */
public class LinkedList<T>{
     private Node<T> head;

    void add(T coefficient, T power) {
        Node<T> newNode = new Node<>(coefficient, power);
        Node<T> temp = head;

        if (head == null) {
            head = newNode;
        } else {
            while (temp != null) {

                int coef = Integer.parseInt(temp.power.toString());   //coefficient of the current temp on the list
                if (coef < Integer.parseInt(newNode.power.toString())) {  //add first
                    newNode.next = head;
                    head = newNode;
                    break;
                }
                else if (coef > Integer.parseInt(newNode.power.toString())) {
                    if (temp.next != null && Integer.parseInt(temp.next.power.toString()) < Integer.parseInt(newNode.power.toString())) { //insert data 
                        newNode.next = temp.next;
                        temp.next = newNode;
                        break;
                    } else if (temp.next == null) { //add last
                        temp.next = newNode;
                        break;
                    } else {
                        temp = temp.next;
                    }

                }
                 
                else {
                    addSecond(temp, newNode);   //if coefficients are equals, it adds to temp's under list
                    break;
                }

            }

        }
    }

    void addSecond(Node<T> tmpList, Node<T> newNode) {  
        tmpList.tmp2 = tmpList;
        while (tmpList.tmp2.nodeNext != null) {
            tmpList.tmp2 = tmpList.tmp2.nodeNext; 
        }
        tmpList.tmp2.nodeNext = newNode;  //newNode added to under of the list
        tmpList.tmp2 = newNode;

    }

    void print() {
        Node<T> tmp = head; //for the main list 
        Node<T> secondTemp; //for the under of the list

        while (tmp != null) {
            secondTemp = tmp;
            System.out.print(tmp.coefficient + "x^" + tmp.power + " + ");
            while (secondTemp.nodeNext != null) {
                System.out.print(secondTemp.nodeNext.coefficient + "x^" + secondTemp.nodeNext.power + " + ");
                secondTemp = secondTemp.nodeNext;
            }
            tmp = tmp.next;
        }
        System.out.println("null");
    }

    BigInteger
         total(int x) {  //same method as print, collecting polynomials
        Node<T> tmp = head; 
        Node<T> secondTemp; 
        BigInteger total = BigInteger.valueOf(0);
        while (tmp != null) {
            secondTemp = tmp;
            int coefficient = Integer.parseInt(tmp.coefficient.toString());
            int power = Integer.parseInt(tmp.power.toString());
            total = total.add(BigInteger.valueOf((long)(Math.pow(x, power) * coefficient)));
            while (secondTemp.nodeNext != null) {
                int secondCoef = Integer.parseInt(secondTemp.nodeNext.coefficient.toString());
                int secondPower = Integer.parseInt(secondTemp.nodeNext.power.toString());
                total = total.add(BigInteger.valueOf((long)(Math.pow(x, secondPower) * secondCoef)));
                secondTemp = secondTemp.nodeNext;

            }
            tmp = tmp.next;
        }
        return total;
    }
}
