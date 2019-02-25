package com.mitrais.training.GadgetObjects;

import com.mitrais.training.Gadget;

public class Smartphone extends Gadget {

    public Smartphone(String cpuName, Integer numOfCores, Integer ram, Integer storageSize){
        super(cpuName,numOfCores,ram,storageSize);
        this.setPortable(true);
        this.deviceType="Smartphone";
    }

    @Override
    public void turnOn() {
        System.out.println("Booting into Android Operating system");
    }

    public void makeACall(String someOne) {
        System.out.println("Calling "+someOne +" ...");
    }

    @Override
    public void restart(){
        System.out.println("This smartphone doesn't have restart feature");
    }

    public void sendSMS(String someOne, String message) {
        System.out.println("Send text message to "+someOne +" ...");
        System.out.println("Message : "+message+" was sent!");
        System.out.println();
    }

}
