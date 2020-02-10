import java.util.Scanner;
import java.util.Locale;

//Question B
//The goal of this question is to write a software library that accepts
// 2 version string as input and returns whether one is greater than, equal,
// or less than the other. As an example: “1.2” is greater than “1.1”.
// Please provide all test cases you could think of.
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.CANADA);
        System.out.println("This program takes in 2 strings of numbers or letters  ( whitespaces are ignored ) and compares them");
        System.out.print("First string: ");
        String first = input.nextLine();
        first = first.toLowerCase().replaceAll("\\s+", "");
        System.out.print("Second string: ");
        String second = input.nextLine();
        second = second.toLowerCase().replaceAll("\\s+", "");
        // compareTo check the unicode of each letter in
        // the string and compares it to the other string in unicode
        int compare = first.compareTo(second);
        // if compareTo is zero then that means they are equal
        if(compare == 0){
            System.out.print(first +" is equal to "+ second );
            return;
        // if its bigger than zero then first is greater than second
        }else if ( compare > 0){
            System.out.print(first+" is greater than "+ second);
            return;
        // finally if it returns a negative number then that means second is bigger than first.
        }else{
            System.out.print(first+" is smaller than "+ second);
            return;
        }
    }
}
