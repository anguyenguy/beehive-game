/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;


import business.BeeHive;
import entity.Bee;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author hp
 */
public class PRO192xA2Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BeeHive bh = null;      
        boolean keepRunning = true;
        Scanner s = new Scanner(System.in);
        int choice;
        while (keepRunning) {
            //menu
            System.out.println("--------------Bee hive--------------");
            System.out.println("\t1 – Create bee list");
            System.out.println("\t2 – Attack bees");
            System.out.println("\t3 - Exit");
            System.out.print("Enter your choice (1, 2 or 3): ");
            choice = s.nextInt();
            ArrayList<Bee> bees;
            switch (choice) {
                case 1:
                    bh = new BeeHive();
                    bh.init();//create 10 bees
                    bees = bh.getAllBees();
                    System.out.println("Bees details at the beginning:");
                    showBees(bees);
                    break;
                case 2:
                    if (bh == null) {
                        System.out.println("No bee!");
                    } else {   
                        bh.attackBees();//attach bees
                        bees = bh.getAllBees();  
                        System.out.println("Bees details at the moment:");
                        showBees(bees);
                    }
                    break;
                default:
                    keepRunning = false;
            }
        }

    }

    public static void showBees(ArrayList<Bee> bees) {
       //your code
    	for(int i=0; i<bees.size(); i++) {
    		System.out.print("  ");
    		System.out.printf("%-8d",i+1);
    		System.out.println(bees.get(i).toString());
    	}
    }

}
