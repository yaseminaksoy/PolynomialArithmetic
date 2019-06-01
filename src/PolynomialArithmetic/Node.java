/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PolynomialArithmetic;

/**
 *
 * @file Node.java
 * @description collecting polynomials that read from the file
 * @assignment homework1
 * @date 09.03.2019
 * @author yaseminaksoy yasemiiinaksoy@gmail.com
 */
public class Node<T> {
    Node<T> nodeNext;    //each node have bottom node for the state of equality of powers
    Node<T> next;   
    Node<T> tmp2; //temp for the bottom of the list
    T coefficient;
    T power;
    

    public Node(T katsayi, T kuvvet) {
        this.next = null;
        this.coefficient = katsayi;
        this.power = kuvvet;
    }

}
