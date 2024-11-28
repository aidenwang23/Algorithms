import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Algorithms {
    private static File f;
    private static Scanner s;
    public static void main(String[] args) throws FileNotFoundException {
        f = new File("Numbers.txt");
        int odds = odds();
        int evens = evens();
        int twoDigits = twoDigits();
        int fiveHundredGreater = fiveHundredGreater();
        int gratest = greatest();
        int least = least();
        int sum = sum();
        double mean = mean();
        ArrayList<Integer> mode = mode();
        System.out.println("Odd Numbers: " + odds);
        System.out.println("Even Numbers: " + evens);
        System.out.println("Two Digits: " + twoDigits);
        System.out.println("Greater Than 500: " + fiveHundredGreater);
        System.out.println("Greatest Number: " + gratest);
        System.out.println("Least Number: " + least);
        System.out.println("Sum: " + sum);
        System.out.println("Mean: " + mean);
        System.out.println("Mode: " + mode);
        s.close();
    }

    public static int odds() throws FileNotFoundException{
        s = new Scanner(f);
        int odds = 0;
        while (s.hasNext()) {
            if (s.nextInt() % 2 != 0)
                odds++;
        }
        return odds;
    }

    public static int evens() throws FileNotFoundException{
        s = new Scanner(f);
        int evens = 0;
        while (s.hasNext()) {
            if (s.nextInt() % 2 == 0)
                evens++;
        }
        return evens; 
    }

    public static int twoDigits() throws FileNotFoundException{
        s = new Scanner(f);
        int twoDigits = 0;
        while (s.hasNext()) {
            int num = s.nextInt();
            if (num <= 99 && num >= 10)
                twoDigits++;
        }
        return twoDigits; 
    }

    public static int fiveHundredGreater() throws FileNotFoundException{
        s = new Scanner(f);
        int fiveHundredGreater = 0;
        while (s.hasNext()) {
            if (s.nextInt() > 500)
                fiveHundredGreater++;
        }
        return fiveHundredGreater; 
    }

    public static int greatest() throws FileNotFoundException{
        s = new Scanner(f);
        int greatest = 0;
        while (s.hasNext()) {
            int num = s.nextInt();
            if (num > greatest)
                greatest = num;
        }
        return greatest; 
    }

    public static int least() throws FileNotFoundException{
        s = new Scanner(f);
        int least = s.nextInt();
        while (s.hasNext()) {
            int num = s.nextInt();
            if (num < least)
                least = num;
        }
        return least; 
    }

    public static int sum() throws FileNotFoundException{
        s = new Scanner(f);
        int sum = 0;
        while (s.hasNext()) {
           sum+=s.nextInt();
        }
        return sum; 
    }

    public static double mean() throws FileNotFoundException{
        s = new Scanner(f);
        double sum = 0;
        int count = 0;
        while (s.hasNext()) {
           sum+=s.nextInt();
           count++;
        }
        return sum/count; 
    }

    public static ArrayList<Integer> mode() throws FileNotFoundException{
        s = new Scanner(f);
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> frequencies = new ArrayList<>();
        ArrayList<Integer> mode = new ArrayList<>();
        while (s.hasNextInt()) {
            int num = s.nextInt();
            if (numbers.contains(num)) {
                int index = numbers.indexOf(num);
                frequencies.set(index, frequencies.get(index) + 1);
            } 
            else {
                numbers.add(num);
                frequencies.add(1);
            }
        }
        int maxFrequency = 0;
        for (int i = 0; i < frequencies.size(); i++) {
            if (frequencies.get(i) > maxFrequency) {
                maxFrequency = frequencies.get(i);
                mode.clear();
                mode.add(numbers.get(i));
            } 
            else if (frequencies.get(i) == maxFrequency) {
                mode.add(numbers.get(i));
            }
        }
        return mode; 
    }
}