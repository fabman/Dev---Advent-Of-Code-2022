/**
 *
 * --- Day 1: Calorie Counting --- part 02
 * https://adventofcode.com/2022/day/1#part2
 * 
 * --- Part Two ---
 * By the time you calculate the answer to the Elves' question, they've already 
 * realized that the Elf carrying the most Calories of food might eventually run out of snacks.
 * To avoid this unacceptable situation, the Elves would instead like to know 
 * the total Calories carried by the top three Elves carrying the most Calories. 
 * 
 * That way, even if one of those Elves runs out of snacks, they still have two backups.
 * In the example above, the top three Elves are the fourth Elf (with 24000 Calories), 
 * then the third Elf (with 11000 Calories), then the fifth Elf (with 10000 Calories). 
 * 
 * The sum of the Calories carried by these three elves is 45000.
 * Find the top three Elves carrying the most Calories. 
 * How many Calories are those Elves carrying in total?
 *
 */
package cc.fabian.adventofcode02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Fabián
 *
 *
 */
public class AdventOfCode02 {

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
