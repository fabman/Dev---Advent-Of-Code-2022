/**
 *
 * --- Day 2: Rock Paper Scissors ---
 * https://adventofcode.com/2022/day/2
 *
 * The Elves begin to set up camp on the beach. To decide whose tent gets to
 * be closest to the snack storage, a giant Rock Paper Scissors tournament is already in progress.
 *
 * Rock Paper Scissors is a game between two players. Each game contains many rounds;
 * in each round, the players each simultaneously choose one of Rock, Paper, or
 * Scissors using a hand shape. Then, a winner for that round is selected:
 * Rock defeats Scissors, Scissors defeats Paper, and Paper defeats Rock.
 * If both players choose the same shape, the round instead ends in a draw.
 *
 * Appreciative of your help yesterday, one Elf gives you an encrypted strategy
 * guide (your puzzle input) that they say will be sure to help you win.
 * "The first column is what your opponent is going to play: 
 * --------------------------------------------
 * A for Rock, B for Paper, and C for Scissors.
 * --------------------------------------------
 * The second column--" Suddenly, the Elf is called away to help with someone's tent.
 *
 * The second column, you reason, must be what you should play in response:
 * --------------------------------------------
 * X for Rock, Y for Paper, and Z for Scissors.
 * --------------------------------------------
 * Winning every time would be suspicious, so the responses must 
 * have been carefully chosen.
 *
 * The winner of the whole tournament is the player with the highest score.
 * Your total score is the sum of your scores for each round.
 * The score for a single round is the score 
 * ------------------------------------------------------------------------
 * for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors) 
 * plus the score for the outcome of the round 
 * (0 if you lost, 3 if the round was a draw, and 6 if you won).
 * ------------------------------------------------------------------------
 * Since you can't be sure if the Elf is trying to help you or trick you,
 * you should calculate the score you would get if you were to follow
 * the strategy guide.
 *
 */
package cc.fabian.adventofcode02_part01;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 *
 * @author fabman
 */
public class AdventOfCode02_part01 {

    public static void main(String[] args) {

        Scanner scan = null;

        try {
            scan = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        int totalScore = 0;
        
        while (scan.hasNextLine()) {
            String[] values = (scan.nextLine()).split("\\s");

            int whoWonValue = checkWhoWins(values[0], values[1]);
            int gestureValue = getGestureValue(values[1]);
            // System.out.printf("%s %s %d %d\n", values[0], values[1],whoWonValue, gestureValue );
            totalScore += whoWonValue;
            totalScore += gestureValue;
            
        }
        
        System.out.println("Total: " + totalScore );

    }
    
    public static short checkWhoWins( String him, String you ) {
        // A Rock, B Paper, C Scissors.
        // X Rock, Y Paper, Z Scissors.
        // 0 lost, 3 draw, 6 won
        if ( "X".equals(you) && "A".equals(him) ) return 3;
        if ( "X".equals(you) && "B".equals(him) ) return 0;
        if ( "X".equals(you) && "C".equals(him) ) return 6;
        
        if ( "Y".equals(you) && "A".equals(him) ) return 6;
        if ( "Y".equals(you) && "B".equals(him) ) return 3;
        if ( "Y".equals(you) && "C".equals(him) ) return 0;
        
        if ( "Z".equals(you) && "A".equals(him) ) return 0;
        if ( "Z".equals(you) && "B".equals(him) ) return 6;
        if ( "Z".equals(you) && "C".equals(him) ) return 3;
        
        return -100;
    }
    
    public static short getGestureValue( String you ) {
        // 1 Rock , 2 Paper, 3 Scissors
        if ( "X".equals(you)  ) return 1;
        if ( "Y".equals(you)  ) return 2;
        if ( "Z".equals(you)  ) return 3;
        
        return -100;
    }
}
