package com.mitrais.training;

public abstract class Gadget implements GadgetInterface{
    protected String deviceType;
    private String gadgetName="";
    private String processorName;
    private Integer ram;
    private Integer numberOfCpuCores;
    private Integer storageSize;
    private Boolean isPortable;
    private Boolean isOn;

    public Gadget(String processorName, Integer numberOfCpuCores,Integer ram, Integer storageSize) {
        this.processorName = processorName;
        this.ram = ram;
        this.numberOfCpuCores = numberOfCpuCores;
        this.storageSize = storageSize;
    }

    public void restart() {
        shutDown();
        turnOn();
    }

    public void showProperties(){
        if(!this.gadgetName.equals("")){
            System.out.println("GadgetName : "+this.gadgetName);
        }
        System.out.println("Processor : "+this.processorName);
        System.out.println("RAM : "+this.ram);
        System.out.println("Number of CPU Cores : "+this.numberOfCpuCores);
        System.out.println("Internal Storage Size : "+this.storageSize);
        System.out.println("This devices is " + (this.isPortable?"":"not ")+"portable");
        System.out.println();
    }

    public void setPortable(Boolean portable) {
        isPortable = portable;
    }

    public void setOn(Boolean on) {
        isOn = on;
    }

    public void turnOn(){
        System.out.println("Booting");
        this.isOn=true;
        System.out.println("Welcome");
    }

    public void shutDown(){
        System.out.println("Shutting down...");
        this.isOn=false;
    }

    public String getGadgetName() {
        return gadgetName;
    }

    public void setGadgetName(String gadgetName) {
        this.gadgetName = gadgetName;
    }


    public String getProcessorName() {
        return processorName;
    }

    public Integer getRam() {
        return ram;
    }

    public Integer getNumberOfCpuCores() {
        return numberOfCpuCores;
    }

    public Integer getStorageSize() {
        return storageSize;
    }

    public Boolean getPortable() {
        return isPortable;
    }

    public Boolean getOn() {
        return isOn;
    }
}
