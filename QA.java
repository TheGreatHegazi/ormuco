import java.util.Locale;
import java.util.Scanner;

//Question A
//Your goal for this question is to
// write a program that accepts two lines (x1,x2) and (x3,x4) on
// the x-axis and returns whether they overlap. As an example,
// (1,5) and (2,6) overlaps but not (1,5) and (6,8).
public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in).useLocale(Locale.CANADA);
        double[] x = new double[4];

        System.out.println("This program accepts 2 segments and checks if they intersect");
        for(int i =1; i < 5; i++ ) {
            System.out.println("X"+i+": ");

            x[i-1] =  input.nextDouble();;
            System.out.println(x[i-1]);
        }

        if( (x[0] > x[1])){
            double temp = x[0];
            x[0] = x[1];
            x[1] = temp;
        }

        if( (x[2]> x[3])){
            double  temp = x[2];
            x[2] = x[3];
            x[3] = temp;
        }
        for (int i = 0; i < x.length; i++)
            System.out.println(x[i]);
		// This checks if the x1 is between  x3 and x4, then checks if x2 is between x3 and x4, 
        // then checks if 
        if(    x[0] >= x[2] && x[0] <= x[3] 
        	|| x[1] >= x[2] && x[1] <= x[3] 
        	|| x[2] >= x[0] && x[2] <= x[1] 
        	|| x[3] >= x[0] && x[3] <= x[1] ){
            System.out.println("The lines intersect!");
            return;
        }

        System.out.println("The lines do not intersect!");
        return;
  }
}
