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
package cc.fabian.adventofcode01_part2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author Fabián
 *
 *
 */
public class AdventOfCode01_part2 {

    public static void main(String[] args) {

        Integer currentElfSum = 0;
        Stack<Integer> stackOfSums = new Stack<>();

        Scanner inputData = null;

        try {
            inputData = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException ex) {
            System.out.println("File not Found");
        }

        while (inputData.hasNextLine()) {
            String lineRead = inputData.nextLine();
            if (lineRead.equals("")) {
                insertElfInStack(currentElfSum, 3, stackOfSums);
                currentElfSum = 0;
            } else {
                currentElfSum += Integer.parseInt(lineRead);
            }
        }

        // Print the total sum of the biggest three elements.
        int sumTotal = 0;
        for (int el : stackOfSums) { sumTotal += el; }
        System.out.printf("Top three total Sum: %d\n", sumTotal);
    }

    /**
     *
     * @param elf
     * @param maxStackSize
     * @param stackOfSums
     */
    public static void insertElfInStack(int elf, int maxStackSize, Stack<Integer> stackOfSums) {

        // If there's no elements add the first one
        if (stackOfSums.isEmpty()) {  stackOfSums.add(elf); }

        for (int i = 0; i < stackOfSums.size(); i++) {
            if (elf > stackOfSums.get(i)) {
                stackOfSums.insertElementAt(elf, i);
                return;
            }
        }
        
        if ( stackOfSums.size() > maxStackSize ) { stackOfSums.removeElementAt( stackOfSums.size()-1 );}

    }

}
