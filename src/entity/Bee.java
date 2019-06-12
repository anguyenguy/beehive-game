/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Random;

/**
 *
 * @author hp
 */
public class Bee {
    private String type;
    private byte health;
    private boolean alive;

    public Bee() {
        //init
        //your cote
    	this.health=100;
    	this.alive = true;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte getHealth() {
        return health;
    }

    public void setHealth(byte health) {
        this.health = health;
        //update the alive status when the health value changed
        //your code
        if(this.getType()=="Queen" && this.health<20) {
        	this.alive= false;
        }
        if(this.getType()=="Drone" && this.health<50) {
        	this.alive= false;
        }
        if(this.getType()=="Worker" && this.health<70) {
        	this.alive= false;
        }
       
    }   
    
    public boolean isAlive(){
        return this.alive;
    }  

    //attack this bee
    public void damage() {
        //your code
    	Random rand = new Random();
    	int n = 1+rand.nextInt(99);
    	if(this.isAlive()) {
    		this.setHealth((byte)(this.getHealth()-n));
    	}
    	// Set health = 0 if value of health <0
    	if(this.getHealth()<0) {
    		this.setHealth((byte)0);
    	}
    	
    }

    @Override
    public String toString() {
        String beeDetails ="Bee details";
        //your code
        beeDetails = String.format("%-15s", this.getType())
        		+String.format("%-15s", this.getHealth());
       if(this.isAlive()) {
    	   beeDetails=beeDetails+String.format("%-15s", "alive");
       }else beeDetails=beeDetails+String.format("%-15s", "dead");
        return beeDetails;
    }
}
