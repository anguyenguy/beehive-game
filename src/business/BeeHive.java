/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import entity.QueenBee;
import entity.Bee;
import entity.WorkerBee;
import entity.Drone;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author hp
 */
public class BeeHive {
    private ArrayList<Bee> listBee;
    private boolean hasQueen;
    private boolean isAllDied;

    public void init() {
        //create list of 10 bees  of Queen, Drone and Worker types
        //in each bee, type and health attributes are randomly chosen
        this.listBee = new ArrayList<>();
        
        // create only one queen bee
        this.hasQueen=false;
        
        this.isAllDied = false;
        
        //your code
        Random rand = new Random();
        for(int i=0; i<10; i++) {
        	int n = rand.nextInt(2);
        	switch(n) {
        	case 0: 
        		if(!this.hasQueen) {
        			QueenBee queenBee = new QueenBee();
            	    this.listBee.add(queenBee);
            	    this.hasQueen=true;
            	    break;
        		}else {
        			i=i-1;
        			break;
        		}
        		
        	case 1: 
        		WorkerBee workerBee = new WorkerBee();
        	    this.listBee.add(workerBee);
        	    break;
        	case 2: 
        		Drone drone = new Drone();
        	    this.listBee.add(drone);
        	    break;
        	}
        }
    }

    public ArrayList<Bee> getAllBees() {
        return listBee;
    }

    //attach all bees
    public void attackBees() {
        //your code
    	
    	// Check is all bees dead , if it not yet, we still call damage function
    	int count =0;
    	for(int i=0; i<this.listBee.size();i++) {
    		if(!this.listBee.get(i).isAlive()) count++;
    	}
    	if(count==this.listBee.size()) {
    		System.out.println("===============");
    		System.out.println("All bees are dead");
    		System.out.println("===============");
    	}else {
    		for(int i=0; i<this.listBee.size();i++) {
        		this.listBee.get(i).damage();
        	}
    	}
    	
    	
    	
    	
    }
}
