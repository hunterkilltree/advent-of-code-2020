// You are given N fractions, numbered from 0 to N-1. Your task is to count the number of 
// occurrences of the fraction that appears most often. Notice that two fractions may be equal even 
// if they have different representations; for example, 3/5 and 6/10 are equal. 
// You should not assume that floating point operations are precise. 
// Write a function: int solution(vector &X, vector &Y); that, given two arrays X and Y consisting 
//of N integers each (which represent the k-th fraction as X[k]/Y[k]) 
// returns the number of occurrences of the fraction that appears most often. Examples:
// 1. Given arrays X = [1, 2, 3, 4], Y = [2, 3, 6, 8], 
// the function should return 3 as fractions 1/2, 3/6, 4/8 are all equal to each other. 
// 2. Given arrays X = [3, 3, 4], Y = [5, 3, 4], the function should return 1, as no two fractions are equal.
// 3. Given arrays X = [4, 7, 1, 2], Y = [2, 14, 1, 2], 
// the function should return 2, as fractions 1/2 and 2/4 are equal.
// 4. Given arrays X = [1, 2, 3, 1, 2], Y = [2, 5, 6, 5, 10], the function should return 2
// Write an efficient algorithm for the following assumptions: - N is an integer within the range [1..100,000]; 
// - each element of array X is an integer within the range [0..2,000,000,000];
// - each element of array Y is an integer within 
// the range [1..2,000,000,000]; - arrays X and Y are of equal length.

// X = [1, 2, 3, 1, 2]
// Y = [2, 5, 6, 5, 10]
// loop though X and Y find common divider
// add to array paired =[[X, Y], ...] . find max equal paired => O(N^2)

import java.util.*;

public class EHB2 {
    public static void main(String[] args) {
        // int[] X = {3, 3, 4};
        // int[] Y = {5, 3, 4};
        int[] X = {1, 2, 3, 4};
        int[] Y = {2, 3, 6, 8};
        int result = solution(X, Y);

        System.out.println(result);
    }

    public static class Fraction {
        int x;
        int y;

        Fraction(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Fraction fraction = (Fraction) obj;
            return x == fraction.x && y == fraction.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int solution(int[] X, int[] Y) {
        Map<Fraction, Integer> fractionCount = new HashMap<>();
 
        int max = 0;
        int length = X.length;
        for (int i = 0; i < length; i++) {
            int commonDevider = gcd(X[i], Y[i]);
            int x = X[i] / commonDevider;
            int y = Y[i] / commonDevider;
            Fraction fraction = new Fraction(x, y);
            
            fractionCount.put(fraction, fractionCount.getOrDefault(fraction, 0) + 1);
            max = Math.max(max, fractionCount.get(fraction));
        }

        return max;
    }
    
}
