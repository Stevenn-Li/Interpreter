import java.util.*;
import java.util.Scanner;
import java.io.*;
public class myinterpreter {
    
    public static boolean checkStringForInt2(String s){
        //if False, s is not an integer, if True, s is an integer
        //This method checks if string does not contain "push ____" and is just what's after the push
        boolean b = false;
        for (int i = 0; i < s.length(); i++){
            if ((s.substring(i,i+1).equals("-") ||
                    s.substring(i,i+1).equals("1") || 
                    s.substring(i,i+1).equals("2") || 
                    s.substring(i,i+1).equals("3") || 
                    s.substring(i,i+1).equals("4") || 
                    s.substring(i,i+1).equals("5") || 
                    s.substring(i,i+1).equals("6") || 
                    s.substring(i,i+1).equals("7") || 
                    s.substring(i,i+1).equals("8") || 
                    s.substring(i,i+1).equals("9") ||
                    s.substring(i,i+1).equals("0")  
                    )){
                b = true;
            }
            else{
                b = false;
                break;
            }
        }
        return b;
    }
    
    public static boolean checkStringForInt(String s){
        //False is good, True is bad
        boolean b = false;
        if (s.length() > 5){
            for (int i = 5; i < s.length(); i++){
                if ((   s.substring(i,i+1).equals("-") ||
                        s.substring(i,i+1).equals("1") || 
                        s.substring(i,i+1).equals("2") || 
                        s.substring(i,i+1).equals("3") || 
                        s.substring(i,i+1).equals("4") || 
                        s.substring(i,i+1).equals("5") || 
                        s.substring(i,i+1).equals("6") || 
                        s.substring(i,i+1).equals("7") || 
                        s.substring(i,i+1).equals("8") || 
                        s.substring(i,i+1).equals("9") ||
                        s.substring(i,i+1).equals("0")  
                        )){
                    b = true;
                }
                else{
                    b = false;
                    break;
                }
        }}        
        return b;
    }
      public static boolean checkStringForName(String s){
        //false is bad, true is good
        boolean b = false;
        if (s.length() > 5 && s.substring(0,4).equals("push")){
            if (s.substring(5,6).equals("_") || 
                    ((int)s.charAt(5) > 64 && (int)s.charAt(5) < 91) || 
                    ((int)s.charAt(5) > 96 && (int)s.charAt(5) < 123)){
                
                            for (int i = 5; i < s.length(); i++){
                                if (((int)s.charAt(i) > 47 && (int)s.charAt(i) < 58) ||
                                        ((int)s.charAt(i) > 64 && (int)s.charAt(i) < 91) ||
                                        ((int)s.charAt(i) > 96 && (int)s.charAt(i) < 123) ||
                                        ((int)s.charAt(i) == 95)){
                                    b = true;
                                }
                                else{
                                    b = false;
                                    return b;
                                }
                            }
            }
        }        
        return b;
    } 
    
      public static boolean checkStringForName2(String s){
          boolean b = false;
          if (s.substring(0,1).equals("_") || 
                  ((int)s.charAt(0) > 64 && (int)s.charAt(0) < 91) || 
                  ((int)s.charAt(0) > 96 && (int)s.charAt(0) < 123)){
              for (int i = 0; i < s.length(); i++){
                    if (((int)s.charAt(i) > 47 && (int)s.charAt(i) < 58) ||
                            ((int)s.charAt(i) > 64 && (int)s.charAt(i) < 91) ||
                            ((int)s.charAt(i) > 96 && (int)s.charAt(i) < 123) ||
                            ((int)s.charAt(i) == 95)){
                        b = true;
                    }
                    else{
                        b = false;
                        return b;
                    }
                }
          }
          return b;
      }
    public static boolean checkStringForString(String s){
        //so false = bad, true = good
        boolean b = false;
        if ((s.substring(5,6).equals("\"")) && (s.endsWith("\""))){
            b = true;
        }
        return b;
    }
    
    public static void pushh(ArrayList<Stack<String>> stacc2, int counter, String s, ArrayList<ArrayList<String>> als2){
            //adds an integer
            if ((checkStringForInt(s) == true) && (!((s).substring(5,6).equals("-")))){
                String toPush = s.substring(5,s.length());
                stacc2.get(counter).push(toPush);
            }
            //adds a negative integer
            else if ((checkStringForInt(s) == true) && ((s).substring(5,6).equals("-"))){
                String toPush = (s.substring(5, s.length()));
                stacc2.get(counter).push(toPush);
            }
            //adds a string
            else if (s.equals("push \":false:\"")){
            	stacc2.get(counter).push("\":false:\"");
            }
            else if (s.equals("push \":true:\"")){
            	stacc2.get(counter).push("\":true:\"");
            }
            else if (s.length() >= 7 && checkStringForString(s) == true && s.contains("\"")){                
                String toPushString = s.substring(6, s.length() - 1);
                stacc2.get(counter).push(toPushString);
                als2.get(counter).add(toPushString);
            }
            //push name
            else if (checkStringForName(s) == true && !s.contains("\"")){
                String toPush = s.substring(5, s.length());
                stacc2.get(counter).push(toPush);
            }
            else if (s.equals("push :true:")){
            	stacc2.get(counter).push(":true:");
            }
            else if (s.equals("push :false:")){
            	stacc2.get(counter).push(":false:");
            }
            //if none of those, it must be an error 
            else{
            	stacc2.get(counter).push(":error:");
            }
    }
    
    //4.3 COMPLETED METHOD 
    public static void pop(ArrayList<Stack<String>> stacc2, int counter){
        if (stacc2.get(counter).size() == 0){
        	stacc2.get(counter).push(":error:");
        }
        else{
        	stacc2.get(counter).pop();
        }
    }
    
    public static void add(ArrayList<Stack<String>> stacc2, int counter, ArrayList<HashMap<String,String>> hm2, ArrayList<ArrayList<String>> als2){
        if (stacc2.get(counter).size() < 2){
        	stacc2.get(counter).push(":error:");
        }
        else if (stacc2.get(counter).size() >= 2){
            
  /*          else if ( (checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == false) ||
                      (checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false && checkStringForName2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2))) == false
                      && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null) ||
                      (checkStringForName2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))) == false && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == false
                        && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null) ||
                      (checkStringForName2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))) == false && checkStringForName2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2))) == false
                      && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null)
                    ){
                stacc2.get(counter).push(":error:");
            } */
            if (stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":false:") ||
            		stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":false:")
                    || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":unit:") ||
                    stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":unit:") 
                    || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":error:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":error:") ||
                    (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false)
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == false)
                    || (als2.get(counter).size() > 0 && (als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)) || als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true 
                    && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2))
                            && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true 
                            && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) && 
                            (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":false:")
                            		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":unit:") ))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true 
                            && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) && 
                            (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":false:")
                            		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":unit:") ))
                    ){
                stacc2.get(counter).push(":error:");
            }
                //if adding name + int when name is top value
            else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) 
                        && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)))){
                    int firstNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                    int secondNum = Integer.parseInt(stacc2.get(counter).pop());
                    int total = firstNum + secondNum;
                    stacc2.get(counter).push(Integer.toString(total));
                }
                //if adding int + name when name is second value
                else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) 
                        && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))){
                    int firstNum = Integer.parseInt(stacc2.get(counter).pop());
                    int secondNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                    int total = firstNum + secondNum;
                    stacc2.get(counter).push(Integer.toString(total));
                }
                //if both are names 
                else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) 
                        && (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2))) &&
                        checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))) &&checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))){
                    int firstNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                    int secondNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                    int total = firstNum + secondNum;
                    stacc2.get(counter).push(Integer.toString(total));
                }
                else if ((checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true) && 
                        (checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true)){
                    int firstNum =  Integer.parseInt(stacc2.get(counter).pop());
                    int secondNum = Integer.parseInt(stacc2.get(counter).pop());
                    int total = firstNum + secondNum;
                    stacc2.get(counter).push(Integer.toString(total));
                }
                

        }
        else{
            stacc2.get(counter).push(":error:");
        }
    }
    
    public static void sub(ArrayList<Stack<String>> stacc2, int counter, ArrayList<HashMap<String,String>> hm2, ArrayList<ArrayList<String>> als2){
        if (stacc2.get(counter).size() < 2){
            stacc2.get(counter).push(":error:");
        }
        
        else if (stacc2.get(counter).size() >= 2){
            
            if (stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":false:") ||
                    stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":false:")
                    || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":unit:") ||
                    stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":unit:") ||
                    stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":error:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":error:") ||
                    (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false)
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == false)
                    || (als2.get(counter).size() > 0 && (als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)) || als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1))
                    && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2))
                            && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true 
                    && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) && 
                    (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":false:")
                    		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":unit:") ))
            || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true 
                    && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) && 
                    (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":false:")
                    		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":unit:") ))
                    ){
                stacc2.get(counter).push(":error:");
            }
            //if  name - int when name is top value
            else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) 
                    && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)))){
                int firstNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)));
                int secondNum = Integer.parseInt(stacc2.get(counter).get(stacc2.get(counter).size()-2));
                int total = secondNum - firstNum;
                stacc2.get(counter).pop();
                stacc2.get(counter).pop();
                stacc2.get(counter).push(Integer.toString(total));
            }
            //if  int - name when name is second value
            else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) 
                    && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))){
                int firstNum = Integer.parseInt(stacc2.get(counter).get(stacc2.get(counter).size()-1));
                int secondNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)));             
                int total = secondNum - firstNum;
                stacc2.get(counter).pop();
                stacc2.get(counter).pop();
                stacc2.get(counter).push(Integer.toString(total));
            }
            //if both are names 
            else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) 
                    && (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2))) &&
                    checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))) &&checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))){
                int firstNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)));
                int secondNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2))); 
                int total = secondNum - firstNum;
                stacc2.get(counter).pop();
                stacc2.get(counter).pop();
                stacc2.get(counter).push(Integer.toString(total));
            }
            else if ((checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true) && 
                    (checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true)){
                int firstNum =  Integer.parseInt(stacc2.get(counter).pop());
                int secondNum = Integer.parseInt(stacc2.get(counter).pop());
                int total = secondNum - firstNum;
                stacc2.get(counter).push(Integer.toString(total));
            }

            
    }
    else{
        stacc2.get(counter).push(":error:");
    }
    }
    
    public static void mul(ArrayList<Stack<String>> stacc2, int counter, ArrayList<HashMap<String,String>> hm2, ArrayList<ArrayList<String>> als2){
        if (stacc2.get(counter).size() < 2){
            stacc2.get(counter).push(":error:");
        }
        else if (stacc2.get(counter).size() >= 2){
            
            if (stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":false:") ||
                    stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":false:")
                    || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":unit:") ||
                    stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":unit:") ||
                    stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":error:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":error:") ||
                    (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false)
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == false)
                    || (als2.get(counter).size() > 0 && (als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)) || als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1))
                    && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2))
                            && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true 
                    && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) && 
                    (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":false:")
                    		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":unit:") ))
            || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true 
                    && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) && 
                    (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":false:")
                    		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":unit:") ))){
                stacc2.get(counter).push(":error:");
            }
                //if adding name * int when name is top value
            else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) 
                        && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)))){
                    int firstNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                    int secondNum = Integer.parseInt(stacc2.get(counter).pop());
                    int total = firstNum * secondNum;
                    stacc2.get(counter).push(Integer.toString(total));
                }
                //if adding int * name when name is second value
                else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) 
                        && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))){
                    int firstNum = Integer.parseInt(stacc2.get(counter).pop());
                    int secondNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                    int total = firstNum * secondNum;
                    stacc2.get(counter).push(Integer.toString(total));
                }
                //if both are names 
                else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) 
                        && (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2))) &&
                        checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))) &&checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))){
                    int firstNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                    int secondNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                    int total = firstNum * secondNum;
                    stacc2.get(counter).push(Integer.toString(total));
                }
                else if ((checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true) && 
                        (checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true)){
                    int firstNum =  Integer.parseInt(stacc2.get(counter).pop());
                    int secondNum = Integer.parseInt(stacc2.get(counter).pop());
                    int total = firstNum * secondNum;
                    stacc2.get(counter).push(Integer.toString(total));
                }
                
    }
    else{
        stacc2.get(counter).push(":error:");
    }
    }
    
    public static void div(ArrayList<Stack<String>> stacc2, int counter, ArrayList<HashMap<String,String>> hm2, ArrayList<ArrayList<String>> als2){
        if (stacc2.get(counter).size() < 2 || stacc2.get(counter).peek().equals("0")){
            stacc2.get(counter).push(":error:");
        }
        else if (stacc2.get(counter).size() >= 2){
         
          if (stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":false:") ||
                  stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":false:")
                  || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":unit:") ||
                  stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":unit:") ||
                  stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":error:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":error:") ||
                  (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false)
                  || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == false)
                  || (als2.get(counter).size() > 0 && (als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)) || als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
                  || stacc2.get(counter).peek().equals("0") || (hm2.get(counter).get(stacc2.get(counter).peek()) != null && hm2.get(counter).get(stacc2.get(counter).peek()).equals("0"))
                  || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1))
                  && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))))
                  || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2))
                          && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
                  || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true 
                  && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) && 
                  (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":false:")
                  		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":unit:") ))
          || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true 
                  && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) && 
                  (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":false:")
                  		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":unit:") ))){
              stacc2.get(counter).push(":error:");
          }
              //if adding name * int when name is top value
          else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) 
                      && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)))){
                  int firstNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                  int secondNum = Integer.parseInt(stacc2.get(counter).pop());
                  int total = secondNum / firstNum;
                  stacc2.get(counter).push(Integer.toString(total));
              }
              //if adding int * name when name is second value
              else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) 
                      && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))){
                  int firstNum = Integer.parseInt(stacc2.get(counter).pop());
                  int secondNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                  int total = secondNum / firstNum;
                  stacc2.get(counter).push(Integer.toString(total));
              }
              //if both are names 
              else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) 
                      && (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2))) &&
                      checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))) &&checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))){
                  int firstNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                  int secondNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                  int total = secondNum / firstNum;
                  stacc2.get(counter).push(Integer.toString(total));
              }
              else if ((checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true) && 
                      (checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true)){
                  int firstNum =  Integer.parseInt(stacc2.get(counter).pop());
                  int secondNum = Integer.parseInt(stacc2.get(counter).pop());
                  int total = secondNum/firstNum;
                  stacc2.get(counter).push(Integer.toString(total));
              }
        }
    else{
        stacc2.get(counter).push(":error:");
    }
  }
    
    public static void rem(ArrayList<Stack<String>> stacc2, int counter, ArrayList<HashMap<String,String>> hm2, ArrayList<ArrayList<String>> als2){
        if (stacc2.get(counter).size() < 2 || stacc2.get(counter).peek().equals("0")){
            stacc2.get(counter).push(":error:");
        }
        else if (stacc2.get(counter).size() >= 2){
          if (stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":false:") ||
                  stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":false:")
                  || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":unit:") ||
                  stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":unit:") ||
                  stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":error:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":error:") ||
                  (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false)
                  || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == false)
                  || (als2.get(counter).size() > 0 && (als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)) || als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2)))) 
                  || stacc2.get(counter).peek().equals("0") || (hm2.get(counter).get(stacc2.get(counter).peek()) != null && hm2.get(counter).get(stacc2.get(counter).peek()).equals("0")
                          || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1))
                          && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))))
                          || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2))
                                  && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))))
                  || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true 
                  && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) && 
                  (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":false:")
                  		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":unit:") ))
          || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true 
                  && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) && 
                  (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":false:")
                  		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":unit:") ))
                  ){
              stacc2.get(counter).push(":error:");
          }
              //if adding name * int when name is top value
          else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) 
                      && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)))){
                  int firstNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                  int secondNum = Integer.parseInt(stacc2.get(counter).pop());
                  int total = secondNum % firstNum;
                  stacc2.get(counter).push(Integer.toString(total));
              }
              //if adding int * name when name is second value
              else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) 
                      && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))){
                  int firstNum = Integer.parseInt(stacc2.get(counter).pop());
                  int secondNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                  int total = secondNum % firstNum;
                  stacc2.get(counter).push(Integer.toString(total));
              }
              //if both are names 
              else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) 
                      && (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2))) &&
                      checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))) &&checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))){
                  int firstNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                  int secondNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
                  int total = secondNum % firstNum;
                  stacc2.get(counter).push(Integer.toString(total));
              }
              else if ((checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true) && 
                      (checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true)){
                  int firstNum =  Integer.parseInt(stacc2.get(counter).pop());
                  int secondNum = Integer.parseInt(stacc2.get(counter).pop());
                  int total = secondNum%firstNum;
                  stacc2.get(counter).push(Integer.toString(total));
              }
        }
    else{
        stacc2.get(counter).push(":error:");
    }
    }
    
    public static void neg(ArrayList<Stack<String>> stacc2, int counter, ArrayList<HashMap<String,String>> hm2, ArrayList<ArrayList<String>> als2){
        if (stacc2.get(counter).isEmpty()){
            stacc2.get(counter).push(":error:");
        }
        else{ 
            if (stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":false:") ||
                    stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":unit:") ||
                    stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":error:")  ||
                    (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false)
                
                    || (als2.get(counter).size() > 0 && (als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)))) 
                    || checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1))
                && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)))
                || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true 
                && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) && 
                (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":false:")
                		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":unit:") ))
        ){
            stacc2.get(counter).push(":error:");
        }
        else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true 
                && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1))){
            int num = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))) * -1;
            String answer = Integer.toString(num);
            stacc2.get(counter).pop();
            stacc2.get(counter).push(answer);
        }
        else if (checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true){
            int firstNum = Integer.parseInt(stacc2.get(counter).pop()) * -1;
            String answer = Integer.toString(firstNum);
            stacc2.get(counter).push(answer);
        }
        else{
            stacc2.get(counter).push(":error:");
        }
        }
    }
    
    public static void swap(ArrayList<Stack<String>> stacc2, int counter){
        if (stacc2.get(counter).size() < 2){
            stacc2.get(counter).push(":error:");
        }
        else{
            String first = stacc2.get(counter).pop();
            String second = stacc2.get(counter).pop();
            stacc2.get(counter).push(first);
            stacc2.get(counter).push(second);
        }
    }
    
    public static void cat(ArrayList<Stack<String>> stacc2, int counter, ArrayList<HashMap<String,String>> hm2, ArrayList<ArrayList<String>> als2){
        if (stacc2.get(counter).size() < 2){
            stacc2.get(counter).push(":error:");
        }
        else if (stacc2.get(counter).size() >= 2){
            if (stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":false:") ||
                  stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":false:")
                  || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":unit:") ||
                  stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":unit:") || 
                  hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true &&
                (!(hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)))) && als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1))
                || (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true &&
                        (!(hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)))) && als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2))) ||
                (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true &&
                (!(hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)))) && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true &&
                (!(hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)))))
                  || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == false && (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2)))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false && (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)))))
                    ){
                stacc2.get(counter).push(":error:");
            }
            
            //if one is a name while string is top value
            else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true &&
                    hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2))) && als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1))){
                String first = stacc2.get(counter).pop();
                String second = hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1));
                stacc2.get(counter).pop();
                String answer = second + first;
                stacc2.get(counter).push(answer);
                als2.get(counter).add(answer);
            }
            //if one is a string while top value is a name
            else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))) && als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2))){
                String first = hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1));
                stacc2.get(counter).pop();
                String second = stacc2.get(counter).pop();
                String answer = second + first;
                stacc2.get(counter).push(answer);
                als2.get(counter).add(answer);
            }
            //if both are names
            else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && checkStringForName2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))) == true &&
                    hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && 
                    checkStringForName2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2))) == true &&
                            hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) &&
                    als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2))) && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)))){
                String first = hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1));
                String second = hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2));
                String answer = second + first;
                stacc2.get(counter).pop();
                stacc2.get(counter).pop();
                stacc2.get(counter).push(answer);
                als2.get(counter).add(answer);
            }    
            //if both are strings
            else if (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == false && 
                    checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false &&
                    als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)) &&
                     (als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
            {
                String first = stacc2.get(counter).pop();
                String second = stacc2.get(counter).pop();
                String answer = second + first;
                stacc2.get(counter).push(answer);
                als2.get(counter).add(answer);                
            }
        }
        else{
            stacc2.get(counter).push(":error:");
        }
    }
    
    public static void and(ArrayList<Stack<String>> stacc2, int counter, ArrayList<HashMap<String,String>> hm2, ArrayList<ArrayList<String>> als2){
        if (stacc2.get(counter).size() < 2){
            stacc2.get(counter).push(":error:");
        }
        
        //if top value is a boolean, second is a name
        else {
         if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":false:"))
                && ((stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":false:"))) && (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1))))
                && (!(als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))))
                ){
            boolean a = false;
            boolean b = false;
             if (stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:")){
                 a = true;
             }
             if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:")){
                 b = true;
             }
             boolean c = a && b;
             stacc2.get(counter).pop();
             stacc2.get(counter).pop();
             System.out.println("hello");
             if (c == true){
                 stacc2.get(counter).push(":true:");
             }
             else{
                 stacc2.get(counter).push(":false:");
             }
        }
        //if top value is a name, second is a boolean
         else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":false:"))
                 && ((stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":false:"))) && (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
                && (!(als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)))))
                ){
            boolean a = false;
            boolean b = false;
             if (stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":true:")){
                 a = true;
             }
             if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:")){
                 b = true;
             }
             boolean c = a && b;
             stacc2.get(counter).pop();
             stacc2.get(counter).pop();
             System.out.println("hello2");
             if (c == true){
                 stacc2.get(counter).push(":true:");
             }
             else{
                 stacc2.get(counter).push(":false:");
             }
        }
        //both are names consisting of boolean values
        else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null &&
                (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":false:"))
                && (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":false:"))
                && (!(als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)))))
                && (!(als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))))
                ){
            boolean a = false;
            boolean b = false;
                if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:")){
                    a = true;
                }
                if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:")){
                    b = true;
                }
            boolean c = a && b;
            stacc2.get(counter).pop();
            stacc2.get(counter).pop();
             System.out.println("hello3");
            if (c == true){
                stacc2.get(counter).push(":true:");
            }
            else{
                stacc2.get(counter).push(":false:");
            }
        }
        
        //straight up booleans
        else if ((stacc2.get(counter).get(stacc2.get(counter).size() -1).equals(":false:") && (stacc2.get(counter).get(stacc2.get(counter).size() -2)).equals(":false:")) ||
                ((stacc2.get(counter).get(stacc2.get(counter).size() - 1)).equals(":false:") && (stacc2.get(counter).get(stacc2.get(counter).size() - 2)).equals(":true:")) ||
                ((stacc2.get(counter).get(stacc2.get(counter).size() - 1)).equals(":true:") && (stacc2.get(counter).get(stacc2.get(counter).size() - 2)).equals(":true:")) ||
                ((stacc2.get(counter).get(stacc2.get(counter).size() - 1)).equals(":true:") && (stacc2.get(counter).get(stacc2.get(counter).size() - 2)).equals(":false:")) 
                && (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2)))) && (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1))))
                )
                {
           boolean a;
           boolean b;
           if ((stacc2.get(counter).get(stacc2.get(counter).size() -1)).equals(":false:")){
               a = false;
           }
               else{
                   a = true;
               }
           if ((stacc2.get(counter).get(stacc2.get(counter).size() -2)).equals(":false:")){
               b = false;
           }
               else{
                   b = true;
               }
               boolean c = a && b;
               stacc2.get(counter).pop();
               stacc2.get(counter).pop();
               System.out.println("hello4");
               if (c == true){
                   stacc2.get(counter).push(":true:");
               }
               else{
                   stacc2.get(counter).push(":false:");
               }
               }
       else{
           stacc2.get(counter).push(":error:");
       }
    }}
    //ch 2 add mul fm 
    public static void or(ArrayList<Stack<String>> stacc2, int counter, ArrayList<HashMap<String,String>> hm2, ArrayList<ArrayList<String>> als2){
        if (stacc2.get(counter).size() < 2){
            stacc2.get(counter).push(":error:");
        }
      //if top value is a boolean, second is a name
        else {
            if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":false:"))
                   && ((stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":false:"))) && (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1))))
                   && (!(als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))))
                   ){
               boolean a = false;
               boolean b = false;
                if (stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:")){
                    a = true;
                }
                if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:")){
                    b = true;
                }
                boolean c = a || b;
                stacc2.get(counter).pop();
                stacc2.get(counter).pop();
                System.out.println("hello");
                if (c == true){
                    stacc2.get(counter).push(":true:");
                }
                else{
                    stacc2.get(counter).push(":false:");
                }
           }
           //if top value is a name, second is a boolean
            else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":false:"))
                    && ((stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":false:"))) && (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
                   && (!(als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)))))
                   ){
               boolean a = false;
               boolean b = false;
                if (stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":true:")){
                    a = true;
                }
                if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:")){
                    b = true;
                }
                boolean c = a || b;
                stacc2.get(counter).pop();
                stacc2.get(counter).pop();
                System.out.println("hello2");
                if (c == true){
                    stacc2.get(counter).push(":true:");
                }
                else{
                    stacc2.get(counter).push(":false:");
                }
           }
           //both are names consisting of boolean values
           else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null &&
                   (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":false:"))
                   && (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":false:"))
                   && (!(als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)))))
                   && (!(als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))))
                   ){
               boolean a = false;
               boolean b = false;
                   if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:")){
                       a = true;
                   }
                   if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:")){
                       b = true;
                   }
               boolean c = a || b;
               stacc2.get(counter).pop();
               stacc2.get(counter).pop();
                System.out.println("hello3");
               if (c == true){
                   stacc2.get(counter).push(":true:");
               }
               else{
                   stacc2.get(counter).push(":false:");
               }
           }
           
           //straight up booleans
           else if ((stacc2.get(counter).get(stacc2.get(counter).size() -1).equals(":false:") && (stacc2.get(counter).get(stacc2.get(counter).size() -2)).equals(":false:")) ||
                   ((stacc2.get(counter).get(stacc2.get(counter).size() - 1)).equals(":false:") && (stacc2.get(counter).get(stacc2.get(counter).size() - 2)).equals(":true:")) ||
                   ((stacc2.get(counter).get(stacc2.get(counter).size() - 1)).equals(":true:") && (stacc2.get(counter).get(stacc2.get(counter).size() - 2)).equals(":true:")) ||
                   ((stacc2.get(counter).get(stacc2.get(counter).size() - 1)).equals(":true:") && (stacc2.get(counter).get(stacc2.get(counter).size() - 2)).equals(":false:")) 
                   && (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2)))) && (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1))))
                   )
                   {
              boolean a;
              boolean b;
              if ((stacc2.get(counter).get(stacc2.get(counter).size() -1)).equals(":false:")){
                  a = false;
              }
                  else{
                      a = true;
                  }
              if ((stacc2.get(counter).get(stacc2.get(counter).size() -2)).equals(":false:")){
                  b = false;
              }
                  else{
                      b = true;
                  }
                  boolean c = a || b;
                  stacc2.get(counter).pop();
                  stacc2.get(counter).pop();
                  System.out.println("hello4");
                  if (c == true){
                      stacc2.get(counter).push(":true:");
                  }
                  else{
                      stacc2.get(counter).push(":false:");
                  }
                  }
          else{
              stacc2.get(counter).push(":error:");
          }
       }}

    public static void not(ArrayList<Stack<String>> stacc2, int counter, ArrayList<HashMap<String,String>> hm2, ArrayList<ArrayList<String>> als2){
        if (stacc2.get(counter).size() < 1){
            stacc2.get(counter).push(":error:");
        }
        else{
            if (als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)) && als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1))){
                
            }
        else if (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null
                && (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":false:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:"))
                && (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1))))){
               if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:")){
                   stacc2.get(counter).pop();
                   stacc2.get(counter).push(":false:");
               }
               else{
                   stacc2.get(counter).pop();
                   stacc2.get(counter).push(":true:");
               }
        }
        else if (stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":false:") || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:") && 
                (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1))))){
            if ((stacc2.get(counter).get(stacc2.get(counter).size() -1)).equals(":false:")){
                stacc2.get(counter).pop();
                stacc2.get(counter).push(":true:");
            }
            else{
                stacc2.get(counter).pop();
                stacc2.get(counter).push(":false:");
        }
    }
        else{
            stacc2.get(counter).push(":error:");
        }
        }
    }
    public static void equal(ArrayList<Stack<String>> stacc2, int counter, ArrayList<HashMap<String,String>> hm2, ArrayList<ArrayList<String>> als2){
        if (stacc2.get(counter).size() < 2){
            stacc2.get(counter).push(":error:");
        }
        else {
            if (stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":false:") ||
                    stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":false:")
                    || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":unit:") ||
                    stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":unit:") 
                    || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":error:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":error:") ||
                    (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false)
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == false)
                    || (als2.get(counter).size() > 0 && (als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)) || als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true 
                    && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2))
                            && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true 
                    && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) && 
                    (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":false:")
                    		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":unit:") ))
            || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true 
                    && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) && 
                    (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":false:")
                    		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":unit:") ))
                    ){
                stacc2.get(counter).push(":error:");
            }
        else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) 
                && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)))){
            int firstNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
            int secondNum = Integer.parseInt(stacc2.get(counter).pop());
            int total = secondNum - firstNum;
            if (total == 0){
                stacc2.get(counter).push(":true:");
            }
            else{
                stacc2.get(counter).push(":false:");
            }
        }
        //if  int - name when name is second value
        else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) 
                && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))){
            int firstNum = Integer.parseInt(stacc2.get(counter).pop());
            int secondNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
            int total = secondNum - firstNum;
            if (total == 0){
                stacc2.get(counter).push(":true:");
            }
            else{
                stacc2.get(counter).push(":false:");
            }
        }
        //if both are names 
        else if (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) 
                && (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2))) &&
                checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))) &&checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)))){
            int firstNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
            int secondNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).pop()));
            int total = secondNum - firstNum;
            if (total == 0){
                stacc2.get(counter).push(":true:");
            }
            else{
                stacc2.get(counter).push(":false:");
            }
        }
        else if ((checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true) && 
                (checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true)){
            int firstNum =  Integer.parseInt(stacc2.get(counter).pop());
            int secondNum = Integer.parseInt(stacc2.get(counter).pop());
            int total = secondNum - firstNum;
            if (total == 0){
                stacc2.get(counter).push(":true:");
            }
            else{
                stacc2.get(counter).push(":false:");
            }
        }
        else{
           // stacc2.get(counter).push(":error:");
        }
        }
    }
                
    public static void lessThan(ArrayList<Stack<String>> stacc2, int counter, ArrayList<HashMap<String,String>> hm2, ArrayList<ArrayList<String>> als2){
        if (stacc2.get(counter).size() < 2){
            stacc2.get(counter).push(":error:");
        }
      //if top value is a name containing an int, and second is an int 
        else {
            if (stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":false:") ||
                    stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":false:")
                    || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":unit:") ||
                    stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":unit:") 
                    || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":error:") || stacc2.get(counter).get(stacc2.get(counter).size()-2).equals(":error:") ||
                    (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false)
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == false)
                    || (als2.get(counter).size() > 0 && (als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)) || als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true 
                    && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2))
                            && als2.get(counter).size() > 0 && als2.get(counter).contains(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2))))
                    || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 1)) == true 
                    && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1)) && 
                    (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":false:")
                    		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)).equals(":unit:") ))
            || (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size() - 2)) == true 
                    && hm2.get(counter).size() > 0 && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2)) && 
                    (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":true:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":false:")
                    		|| hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)).equals(":unit:") ))
                    ){
                stacc2.get(counter).push(":error:");
            }
            
        else if (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null
                 && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))) == true){
            int firstNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)));
            int second = Integer.parseInt(stacc2.get(counter).get(stacc2.get(counter).size()-2));
            if (firstNum > second){
                stacc2.get(counter).push(":true:");
            }
            else{
                stacc2.get(counter).push(":false:");
            }
        }
        //if top value is an int, and second is a name containing an int 
        else if (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null
                && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2))) == true){
           int second = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)));
           int firstNum = Integer.parseInt(stacc2.get(counter).get(stacc2.get(counter).size()-1));
           if (firstNum > second){
               stacc2.get(counter).push(":true:");
           }
           else{
               stacc2.get(counter).push(":false:");
           }
        }
        //if top two values are names containing integers
           else if (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)) != null
                && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1))) == true && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)) != null
                && checkStringForInt2(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2))) == true){
           int firstNum = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)));
           int second = Integer.parseInt(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2)));
           if (firstNum > second){
               stacc2.get(counter).push(":true:");
           }
           else{
               stacc2.get(counter).push(":false:");
           }
       }
           else if (checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true){
               int first = Integer.parseInt(stacc2.get(counter).pop());
               int second = Integer.parseInt(stacc2.get(counter).pop());
               if (first > second){
                   stacc2.get(counter).push(":true:");
               }
               else{
                   stacc2.get(counter).push(":false:");
               }
           }
           else{
               //stacc2.get(counter).push(":error:");
           }
        }
    }
    
    public static void bind(ArrayList<Stack<String>> stacc2, int counter, ArrayList<HashMap<String,String>> hm2, ArrayList<ArrayList<String>> als2){
        if (stacc2.get(counter).size() < 2){
            stacc2.get(counter).push(":error:");
        }
        /*  if 2nd to last value in stack is a name, we can start binding                     
         *     checks to see if the last value is an integer, a string which means it is already contained in the arraylist
         *     checks to see if it's a boolean, checks to see if it's a :unit:     
         * 
         */
        else if (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true &&
                ((checkStringForInt2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true || als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)) ||
                    stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":false:") || 
                    stacc2.get(counter).get(stacc2.get(counter).size()-1).equals(":unit:") || hm2.get(counter).keySet().contains(stacc2.get(counter).get(stacc2.get(counter).size()-2)))
                )){
            //binds name to a name
            if (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) 
                    && (!(als2.get(counter).contains(stacc2.get(counter).peek()))) &&  (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-2))))){
                //if top of stack name has a value we can bind it to second to top of stack name
                System.out.println("hello1");
                if (hm2.get(counter).keySet().contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)))
                {
                    hm2.get(counter).put(stacc2.get(counter).get(stacc2.get(counter).size()-2), hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1)));
                    stacc2.get(counter).pop();
                    stacc2.get(counter).pop();
                    stacc2.get(counter).push(":unit:");
                }
                else{
                    stacc2.get(counter).push(":error:");
                }
            }
            else{
            hm2.get(counter).put(stacc2.get(counter).get(stacc2.get(counter).size()-2), stacc2.get(counter).get(stacc2.get(counter).size()-1));
            stacc2.get(counter).pop();
            stacc2.get(counter).pop();
            stacc2.get(counter).push(":unit:");
            }
        }
        else{
            stacc2.get(counter).push(":error:");
        }
    }
    
    public static void iff(ArrayList<Stack<String>> stacc2, int counter, ArrayList<HashMap<String,String>> hm2, ArrayList<ArrayList<String>> als2){
        if (stacc2.get(counter).size() < 3){
            stacc2.get(counter).push(":error:");
        }
        else {
        	if ((checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-3)) == false &&
        			(!(stacc2.get(counter).get(stacc2.get(counter).size()-3).equals(":true:") || stacc2.get(counter).get(stacc2.get(counter).size()-3).equals(":false:"))))
        			|| (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-3)) == true && (hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-3)) == null ||
                       (!(hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-3)).equals(":false:") || hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-3)).equals(":true:")))) )
        			){
        		stacc2.get(counter).push(":error:");
        	} 		// if 3rd is a name boolean false, and 2nd is a name
        	else if (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-3)) == true && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-3)) != null
	                        && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-3)).equals(":false:") 
	                        && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true
	                		) {
	                    String s = hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2));
	                    stacc2.get(counter).pop();
	                    stacc2.get(counter).pop();
	                    stacc2.get(counter).pop();
	                    stacc2.get(counter).push(s);
	                }	 
	                // if 3rd is a name boolean false, and 2nd is not a name
	                else if (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-3)) == true && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-3)) != null
	                   
	                        && (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)))) && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-3)).equals(":false:") 
	                        && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == false
	                		){
	                		String s = stacc2.get(counter).get(stacc2.get(counter).size()-2);
	                		stacc2.get(counter).pop();
	                		stacc2.get(counter).pop();
	                		stacc2.get(counter).pop();
	                		stacc2.get(counter).push(s);
	                }
	                // if 3rd is a name boolean true, and 1st is a name
	                else if (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-3)) == true && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-3)) != null
	                        
	                        && (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)))) && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-3)).equals(":true:") 
	                        && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true
	                		
	                		){
	                		String s = hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1));
	                		stacc2.get(counter).pop();
	                		stacc2.get(counter).pop();
	                		stacc2.get(counter).pop();
	                		stacc2.get(counter).push(s);
	                }
	                // if 3rd is a name boolean true, and 1st is a non name
	                else if (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-3)) == true && hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-3)) != null
	                        
	                        && (!(als2.get(counter).contains(stacc2.get(counter).get(stacc2.get(counter).size()-1)))) &&hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-3)).equals(":true:") 
	                        && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false
	                		){
	                		String s = stacc2.get(counter).get(stacc2.get(counter).size()-1);
	                		stacc2.get(counter).pop();
	                		stacc2.get(counter).pop();
	                		stacc2.get(counter).pop();
	                		stacc2.get(counter).push(s);
	                }
	                // if 3rd is a non name boolean false, and 2nd is a name
	                else if (checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-3)) == false && (stacc2.get(counter).get(stacc2.get(counter).size()-3).equals(":false:"))
	                		&& checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-2)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-2))){
	                	String s = hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-2));
	                	stacc2.get(counter).pop();
	                	stacc2.get(counter).pop();
	                	stacc2.get(counter).pop();
	                	stacc2.get(counter).push(s);
	                }
	                // if 3rd is a non name boolean true, and 1st is a name
	                else if ((stacc2.get(counter).get(stacc2.get(counter).size()-3).equals(":true:"))
	                		&& checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == true && hm2.get(counter).containsKey(stacc2.get(counter).get(stacc2.get(counter).size()-1))){
	                	String s = hm2.get(counter).get(stacc2.get(counter).get(stacc2.get(counter).size()-1));
	                	stacc2.get(counter).pop();
	                	stacc2.get(counter).pop();
	                	stacc2.get(counter).pop();
	                	stacc2.get(counter).push(s);
	                }
	                // if 3rd is a non name boolean true, and 1st is non name
	                else if ((stacc2.get(counter).get(stacc2.get(counter).size()-3).equals(":true:")) && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false
	                		){
	                	System.out.println("YIKES");
	                	String s = stacc2.get(counter).get(stacc2.get(counter).size()-1);
	                	stacc2.get(counter).pop();
	                	stacc2.get(counter).pop();
	                	stacc2.get(counter).pop();
	                	stacc2.get(counter).push(s);
	                }
        	// if 3rd is a non name boolean false, and 2nd is also non name
	                else if ((stacc2.get(counter).get(stacc2.get(counter).size()-3).equals(":false:"))  && checkStringForName2(stacc2.get(counter).get(stacc2.get(counter).size()-1)) == false){
	                	String s = stacc2.get(counter).get(stacc2.get(counter).size()-2);
	                	stacc2.get(counter).pop();
	                	stacc2.get(counter).pop();
	                	stacc2.get(counter).pop();
	                	stacc2.get(counter).push(s);
	                }
	                		
	                		
        	}
    }
    
    
    public static void let(ArrayList<Stack<String>> astacc, int counter){
        //basically creates another instance of interpreter
        //copy and paste code to run current interpreter into this 
        //returns stacc2.peek() after end 
        //when enviroment = true, then run interpreter through stacc2 
    	Stack<String> stacc = new Stack<String>();
    	astacc.add(stacc);
    } 
    
    public static void end(ArrayList<Stack<String>> astacc, int counter){
    	if (counter > 0){
    		String s = astacc.get(counter).peek();
    		astacc.remove(counter-1);
    		astacc.get(counter-1).push(s);
    	}
    	else
    	{
    		astacc.get(counter).push(":error:");
    	}
    }
    public static void myinterpreter(String inputFile, String outputFile) throws IOException{
        PrintWriter pw = new PrintWriter(outputFile);
        Stack<String> stacc = new Stack<String>();
        HashMap<String,String> hm = new HashMap<String,String>();
        ArrayList<String> als = new ArrayList<String>();
        ArrayList<Stack<String>> stacc2 = new ArrayList<Stack<String>>(); // used for let..end 
        ArrayList<HashMap<String,String>> hm2 = new ArrayList<HashMap<String,String>>();
        ArrayList<ArrayList<String>> als2 = new ArrayList<ArrayList<String>>();
        stacc2.add(stacc);
        hm2.add(hm);
        als2.add(als);
        BufferedReader bf;
        bf = new BufferedReader(new FileReader(inputFile));
        int environment = 0;
        String s = "";
        while((s = bf.readLine()) != null){
            System.out.println(s);
            //System.out.println(s.length());
            if (s.length() >= 6 && s.substring(0,4).equals("push")){
                pushh(stacc2, environment,s,als2);
            }
            else if (s.equals("push :true:")){
                stacc2.get(environment).push(":true:");
            }
            else if (s.equals("push :false:")){
            	stacc2.get(environment).push(":false:");
            }
            else{
                
            }
            if (s.equals("pop")){
                pop(stacc2, environment);
            }
            if (s.equals("add")){
                add(stacc2, environment, hm2, als2);
            } 
            if (s.equals("sub")){
                sub(stacc2, environment, hm2, als2);
            }
            if (s.equals("mul")){
                mul(stacc2,environment, hm2 ,als2);
            }
            if (s.equals("div")){
                div(stacc2,environment, hm2,als2);
            }
            if (s.equals("rem")){
                rem(stacc2, environment, hm2, als2);
            }
            if (s.equals("neg")){
                neg(stacc2,environment, hm2 , als2);
            }
            if (s.equals("swap")){
                swap(stacc2, environment);
            }
            if (s.equals("cat")){
                cat(stacc2, environment, hm2, als2);
            }
            if (s.equals("and")){
                and(stacc2, environment, hm2, als2);
            }
            
            if (s.equals("or")){
                or(stacc2, environment, hm2 , als2);
            }
            if (s.equals("not")){
                not(stacc2, environment,hm2, als2);
            }
            if (s.equals("equal")){
                equal(stacc2, environment, hm2, als2);
            }
            if (s.equals("lessThan")){
                lessThan(stacc2, environment, hm2, als2 );
            }
            if (s.equals("bind")){
                bind(stacc2, environment,hm2,als2);
            }
            if (s.equals("if")){
                iff(stacc2, environment, hm2, als2);
            }
            if (s.equals("let")){
            	environment++;
                let( stacc2, environment);
            }
            if (s.equals("end")){
                end(stacc2, environment);
                environment--;
            }
            if (s.equals("quit")){
                while(!(stacc2.get(0).isEmpty())){
                    pw.println(stacc2.get(0).pop());
                }
            }
            else{
            
            }
            if (stacc2.size() > 0){
         //   	System.out.println(environment);
            System.out.println("stack:" + stacc2.get(environment));
          //  System.out.println("keys:" + hm2.get(environment).keySet());
          //  System.out.println("values" + hm2.get(environment).values());
          //  System.out.println("arraylist:" + als2);
            System.out.println();
            }  
           // System.out.println(stacc.size()); 
        }            
        bf.close();
        pw.close();
    }

    
    public static void main(String[] args) throws IOException{
       myinterpreter("/Users/Steven/Documents/workspace/CSE305/Interpreter/src/input20.txt", "outputFile.txt");

    }   
}