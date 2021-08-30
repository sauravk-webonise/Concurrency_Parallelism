package com.dining.entity;

import java.util.Random;

public class Philosopher extends Thread
{
    private int myName;
    private Semaphore chopsticks[];

    public Philosopher(int myName,Semaphore chopsticks[]){
        this.myName=myName;
        this.chopsticks=chopsticks;
    }

    public void run()
    {
        while(true){
            System.out.println("philosopher "+ myName+" thinking");
            try{
                Thread.sleep(new Random().nextInt(100)+50);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Philosopher "+myName+" hungry.");

            chopsticks[myName].p(); //Acquire right chopstick
            System.out.println("Philosopher takes the chopstick: "+myName);

            chopsticks[(myName+1)%5].p(); //Acquire left chopstick
            System.out.println("Philosopher takes the chopstick: "+(myName+1)%5);

            System.out.println("Philosopher "+myName+" eating");
            try{
                Thread.sleep(new Random().nextInt(100)+50);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            chopsticks[myName].v();// release right chopstick
            System.out.println("Philosopher releases the chopstick: "+myName);

            chopsticks[(myName+1)%5].v();//release left chopstick
            System.out.println("Philosopher releases the chopstick: "+(myName+1)%5);

        }
    }
}
