package com.mitrais.training.GadgetObjects;

import com.mitrais.training.Gadget;

public class PersonalComputer extends Gadget {

    public PersonalComputer(String processorName, Integer numberOfCpuCores, Integer ram, Integer storageSize) {
        super(processorName, numberOfCpuCores, ram, storageSize);
        this.setPortable(false);
        this.deviceType="Computer";
    }

    @Override
    public void turnOn() {
        System.out.println("Booting into Windows");
        this.setOn(true);
        System.out.println("Welcome");
    }

    public void turnOn(String os){
        System.out.println("Booting into "+os);
    }
}
