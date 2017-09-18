package project2;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Calculator 
 * This class provides the methods for building 
 * and populating the numerical array as well as calculating 
 * the max, min, and average values.  
 */
public class Calculator {
    public static ArrayList<Double> numberList;
    static int rMax = 107;
    static int rMin = -20;
    static int rTotal = 25;
    static double max;
    static double min;
    static double ave;

    /**
     * Calculator
     * This constructor initializes the arrayList to hold 
     * the randomly created values as well as the 
     * arrayLists' statistical variables.  
     */
    public Calculator(){
        numberList = new ArrayList();
        numberList.clear();
        max = 0;
        min = 0;
        ave = 0;
    }

    public void populateArray(){      
        //Total Array Values
        int range = (rMax - (rMin));
        double tmp = 0;
        
        for(int i = 0; i < rTotal ; i++){
            tmp = (double)(Math.random() * range) + rMin;  
            numberList.add(tmp);
        }
    }
    
    /**
     * Math Engine
     * This method calculates the max and min values in the
     * array by sorting them and selecting the first and last 
     * indexes respectively.  The average is calculated by 
     * iterating through the array, adding the values and 
     * dividing by the array size.  
     */
    public void mathEngine(){

        //Get Max/Min
        Collections.sort(numberList);
        
        //max = last index, min = first index
        max = numberList.get(numberList.size() - 1);
        min = numberList.get(0);
        
        //Get Average
        double total = 0;
        for(int i = 0; i < numberList.size(); i++){
            total += numberList.get(i);
        }
        ave = (total/numberList.size());
    }
    
    /**
     * Format String
     * This method formats the output values of 
     * max, min, and average to a float of 2 decimals and
     * converts the float value to a string for display in
     * the GUI.
     * @param d The value to be formatted
     * @return String of the formatted value
     */
    private static String formatStr(double d){
        String str = String.format("%3.2f", d);
        return str;
    }
    
    /**
     * Get Maximum Value
     * @return The formatted maximum value.  
     */
    public static String getMax(){
        return formatStr(max);
    }
    
    /**
     * Get Minimum Value
     * @return The formatted minimum value.  
     */
    public static String getMin(){
        return formatStr(min);
    }
    
    /**
     * Get Average Value
     * @return The formatted average value.  
     */
    public static String getAverage(){
        return formatStr(ave);
    }  
}
