package com.mitrais.training.GadgetObjects;

import com.mitrais.training.Gadget;

public class Laptop extends Gadget {


    public Laptop(String processorName, Integer numberOfCpuCores, Integer ram, Integer storageSize) {
        super(processorName, numberOfCpuCores, ram, storageSize);
        this.setPortable(true);
        this.deviceType="Laptop";
    }

    @Override
    public void turnOn() {
        super.turnOn();
    }

    public void turnOn(String os){
        System.out.println("Booting into "+os +" on Laptop");
    }

}
