package ru.timofeeva;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        if(args == null || args.length == 0){
            System.out.println("Please add the path to file, when calling the program...");
            return;
        }
        String filePath = args[0];
        Map<String, Counter> countOfPeople = new TreeMap<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filePath));
            while (scanner.hasNextLine()) {
                String keyCounterIn = scanner.next();
                String keyCounterOut = scanner.nextLine().trim();
                process(countOfPeople, keyCounterIn, keyCounterOut);
            }
            scanner.close();
        }catch(FileNotFoundException e){
            System.out.println("File " + filePath + " not found");
            return;
        }finally {
            if(scanner != null){
                scanner.close();
            }
        }
        Counter prevCounter = null;
        int totalCnt = 0;
        int maxCnt = 0;
        for (Map.Entry entry: countOfPeople.entrySet()){
            if (prevCounter != null){
                prevCounter.setTimeTo((String) entry.getKey());
            }
            Counter currentCounter = (Counter)entry.getValue();
            totalCnt += currentCounter.getInCnt() - currentCounter.getOutCnt();
            currentCounter.setCnt(totalCnt);
            //System.out.println("Key: " + entry.getKey() + " Value: "+ entry.getValue());
            prevCounter = currentCounter;
            if (maxCnt < totalCnt ){
                maxCnt = totalCnt;
            }
        }
        System.out.println("Max count of people inside the bank is: " + maxCnt + ". In following intervals: ");
        for(Map.Entry entry: countOfPeople.entrySet()){
            Counter counter = (Counter)entry.getValue();
            totalCnt += counter.getInCnt() - counter.getOutCnt();
            if( totalCnt == maxCnt){
                System.out.println("from " + entry.getKey() + " to " + counter.getTimeTo() + ".");

            }
        }

    }

    public static void process(Map<String, Counter> map, String inTime, String outTime)throws FileNotFoundException{
        Counter inCounter = map.get(inTime);
        if(inCounter == null){
            map.put(inTime, new Counter(1,0));

        }else {
            inCounter.addIn();
        }
        Counter outCounter = map.get(outTime);
        if (outCounter == null){
            map.put(outTime,new Counter(0,1));

        }else {
            outCounter.addOut();
        }
    }
}
