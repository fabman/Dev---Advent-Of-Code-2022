/**
 *
 * --- Day 1: Calorie Counting ---
 * https://adventofcode.com/2022/day/1
 *
 */
package cc.fabian.adventofcode01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Fabián
 *
 *
 */
public class AdventOfCode01 {

    public static void main(String[] args) {

        Scanner inputData = null;

        try {
            inputData = new Scanner(new File("..\\..\\..\\..\\..\\input.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");
        }

        double currentSum = 0;
        double lastSum = 0;
        while (inputData.hasNextLine()) {
            String lineRead = inputData.nextLine();
            if (lineRead == "") {
                lastSum = (currentSum>lastSum)?currentSum:lastSum;
                currentSum = 0;
            } else {
                currentSum += Integer.parseInt(lineRead);
            }
        }
        System.out.printf( "%.0f", lastSum );
    }
}
