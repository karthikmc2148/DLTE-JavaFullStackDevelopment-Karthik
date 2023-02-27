package assignment;

import lombok.Data;

import java.util.Arrays;
import java.util.Scanner;

public class GenericsWithString {
    public static void main(String[] args) {
     Generics<String> generics = new Generics<String>();
     generics.addNewObjects();
     generics.FindAndReplace();
    }
}
@Data
class Generics<T>{
     private T[] list;



    Scanner scanner = new Scanner(System.in);
    public void addNewObjects(){
        System.out.println("Enter the String Objects:");
        for(int  index = 0;index<list.length; index++){
           list[index]= (T) scanner.toString();
        }
    }
   public  void FindAndReplace(){
        System.out.println("Enter the value that is needed to be found and also enter the element to be repaced:");
        T value = (T) scanner.toString();
        T replace =(T)scanner.toString();
       for(int  index = 0;index<list.length; index++) {
           if(value.equals(list[index])){
               System.out.println("found at index : "+index);
               list[index]=replace;
               break;
           }

       }
       System.out.println("element replaced successfully!!");

       }
}