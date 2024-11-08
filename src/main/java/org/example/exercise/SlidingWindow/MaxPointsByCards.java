package org.example.exercise.SlidingWindow;

/**
 * Max Points You Can Obtain From Cards
 * DESCRIPTION (credit Leetcode.com)
 * Given an array of integers representing the value of cards, write a function to calculate the maximum score you can achieve by selecting exactly k cards from either the beginning or the end of the array.
 *
 * For example, if k = 3, then you have the option to select:
 *
 * the first three cards,
 * the last three cards,
 * the first card and the last two cards
 * the first two cards and the last card
 * EXAMPLES
 * Example 1: Input:
 *
 * cards = [2,11,4,5,3,9,2]
 * k = 3
 * Output:
 *
 * 17
 * Explanation:
 *
 * Selecting the first three cards from the beginning (2 + 11 + 4) gives a total of 17.
 * Selecting the last three cards (3 + 9 + 2) gives a total of 14.
 * Selecting the first card and the last two cards (2 + 9 + 2) gives a total of 13.
 * Selecting the first two cards and the last card (2 + 11 + 2) gives a total of 15.
 * So the maximum score is 17.
 */
public class MaxPointsByCards {

    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalScore = 0;
        int minSubArray = 0;

        for(int i=0, currScore=0; i<n; i++){
            totalScore += cardPoints[i];
            currScore += cardPoints[i];
            if(i<n-k){
                minSubArray += cardPoints[i];
            }
            else{
                currScore -= cardPoints[i-(n-k)];
                minSubArray = Math.min(minSubArray, currScore);
            }

        }
        return totalScore-minSubArray;

    }

    public static void main(String[] args) {
        int[] input = new int[] {2,11,4,5,3,9,2};
        System.out.println(maxScore(input, 3));
    }
}
