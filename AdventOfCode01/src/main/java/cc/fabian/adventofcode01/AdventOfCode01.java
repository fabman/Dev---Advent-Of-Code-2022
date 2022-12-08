/**
 *
 * --- Day 1: Calorie Counting ---
 * https://adventofcode.com/2022/day/1
 * 
 * Santa's reindeer typically eat regular reindeer food, but they need a lot of 
 * magical energy to deliver presents on Christmas. For that, their favorite 
 * snack is a special type of star fruit that only grows deep in the jungle. 
 * The Elves have brought you on their annual expedition to the grove where the fruit grows.

 * To supply enough magical energy, the expedition needs to retrieve a minimum 
 * of fifty stars by December 25th. Although the Elves assure you that the grove 
 * has plenty of fruit, you decide to grab any fruit you see along the way, just in case.

 * Collect stars by solving puzzles. Two puzzles will be made available on each 
 * day in the Advent calendar; the second puzzle is unlocked when you complete 
 * the first. Each puzzle grants one star. Good luck!

 * The jungle must be too overgrown and difficult to navigate in vehicles or 
 * access from the air; the Elves' expedition traditionally goes on foot. 
 * As your boats approach land, the Elves begin taking inventory of their supplies. 
 * One important consideration is food - in particular, the number of Calories 
 * each Elf is carrying (your puzzle input).

 * The Elves take turns writing down the number of Calories contained by the 
 * various meals, snacks, rations, etc. that they've brought with them, 
 * one item per line. Each Elf separates their own inventory from the previous 
 * Elf's inventory (if any) by a blank line.
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
