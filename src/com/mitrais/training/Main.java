package com.mitrais.training;

import com.mitrais.training.GadgetObjects.Laptop;
import com.mitrais.training.GadgetObjects.PersonalComputer;
import com.mitrais.training.GadgetObjects.Smartphone;
import com.mitrais.training.Helper.DatabaseBridge;
import com.mitrais.training.Helper.ThreadExample;

import java.io.IOException;
import java.util.*;

public class Main {
    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int selection;
        while (true) {
            System.out.println("Hi, please kindly select one of the items below :");
            System.out.print(
                    "0. Object Oriented Demo\n" +
                            "1. Fundamental\n" +
                            "2. Java Collection Framework\n" +
                            "3. JDBC Connection\n" +
                            "4. Java Stream\n" +
                            "5. Java Thread\n" +
                            "6. Exit\n");
            selection = safeIntegerInput("Your Selection : ");

            if (selection == 6) {
                break;
            }

            switch (selection) {
                case 0:
                    javaOop();
                    break;
                case 1:
                    javaFundamental();
                    break;
                case 2:
                    javaCollection();
                    break;
                case 3:
                    DatabaseBridge db=new DatabaseBridge();
                    db.connect();
                    break;
                case 4:
                    javaStream();
                    break;
                case 5:
                    ThreadExample thread=new ThreadExample("Contoh");
                    thread.run();
                    break;
            }
        }
    }

    private static void javaStream(){
        int selection;
        String outputText;
        System.out.println(
                "1. File Writer\n" +
                        "2. File Reader");
        selection = safeIntegerInput("Your Selection : ");
        Stream stream=new Stream();
        switch (selection){
            case 1:
                stream.fileWriter("Tes");
                break;
            case 2:
                try {
                    stream.fileReader();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

        }
    }

    private static void javaCollection(){
        System.out.println("1. List (Array List Demo) and iteration\n" +
                "2. Set (Hash set Demo) and iteration\n" +
                "3. Map (Hashmap Demo) and iteration");
        int selection=safeIntegerInput("Your selection : ");

        switch (selection){
            case 1:
                Set<String> items=CollectionDemo.hashSetDemo();
                for(String item:items){
                    System.out.println(item);
                }
                System.out.println();
                break;
            case 2:
                List listItems=CollectionDemo.arrayListDemo();
                for (Object listItem : listItems) {
                    System.out.println(listItem);
                }
                break;
            case 3:
                Map mapItems=CollectionDemo.hashMapDemo();
                Iterator itemIterator=mapItems.entrySet().iterator();
                while(itemIterator.hasNext()){
                    Map.Entry itemPair=(Map.Entry) itemIterator.next();
                    System.out.println(itemPair.getKey()+" : "+itemPair.getValue());
                    itemIterator.remove();
                }
                break;
        }
    }

    private static void javaFundamental() {
        /*Classic array (without List / ArrayList*/
        int gadgetCount;
        Gadget[] manyGadgets;

        gadgetCount = safeIntegerInput("Amount of gadgets : ");

        manyGadgets = new Gadget[gadgetCount];

        for (int i = 0; i < manyGadgets.length; i++) {
            String name;
            String cpu;
            Integer cores;
            Integer ram;
            Integer storage;
            Gadget item;
            int type;
            System.out.print(
                    "Select Gadget Type\n" +
                            "1. Smartphone\n" +
                            "2. Laptop\n" +
                            "3. Personal Computer\n");

            type=safeIntegerInput("Your Selection : ");

            scanner.nextLine();

            System.out.print("Device name: ");
            name=scanner.nextLine();

            System.out.print("CPU Family : ");
            cpu=scanner.nextLine();

            cores=safeIntegerInput("CPU Core : ");
            ram=safeIntegerInput("RAM Size");
            storage=safeIntegerInput("Storage Size: ");

            switch (type){
                case 1:
                    item=new Smartphone(cpu,cores,ram,storage);
                    item.setGadgetName(name);
                    manyGadgets[i]=item;
                    break;
                case 2:
                    item=new Laptop(cpu,cores,ram,storage);
                    item.setGadgetName(name);
                    manyGadgets[i]=item;
                    break;
                case 3:
                    item=new PersonalComputer(cpu,cores,ram,storage);
                    item.setGadgetName(name);
                    manyGadgets[i]=item;
                    break;
            }
        }

        /*Show the inserted data here...*/
        for (int i = 0; i < manyGadgets.length; i++) {
            manyGadgets[i].showProperties();
        }
    }

    private static void javaOop() {
        Smartphone smartphone = new Smartphone("Snapdragon 855", 8, 8, 128);
        Laptop officeLaptop = new Laptop("Intel Core i5 8250U", 4, 8, 256);
        PersonalComputer officePC = new PersonalComputer("Intel Core i3 3220", 2, 8, 500);

        System.out.println("Smartphone Object :");
        smartphone.restart();
        smartphone.shutDown();
        smartphone.turnOn();
        smartphone.makeACall("Winda");
        smartphone.sendSMS("Robert", "Hi Robert");
        smartphone.showProperties();
        System.out.println();

        System.out.println("Laptop With Mac Object :");
        officeLaptop.turnOn();
        officeLaptop.restart();
        officeLaptop.shutDown();
        officeLaptop.turnOn("macintosh");
        officeLaptop.showProperties();
        System.out.println();

        System.out.println("PC with linux OS :");
        officePC.restart();
        officePC.shutDown();
        officePC.turnOn("linux ubuntu");
        officePC.showProperties();
        System.out.println();

        System.out.println("PC");
        officePC.restart();
        officePC.shutDown();
        officePC.turnOn();
        officePC.showProperties();
    }

    private static int safeIntegerInput(String message){
        boolean isValid=true;
        int userInput=0;
        do{
            /*Loop if there was an exception*/
            try{
                isValid=true;
                System.out.print(message);
                userInput=scanner.nextInt();
            }catch (InputMismatchException e){
                /*Print exception message and program is still running*/
                scanner.nextLine();
                isValid=false;
                e.printStackTrace();
            }
        }while(!isValid);
        return userInput;
    }
}
