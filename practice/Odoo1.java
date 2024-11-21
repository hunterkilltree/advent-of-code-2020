// have the function ArithGeo(arr) take the array of numbers stored in arr 
// and return the string "Arithmetic" if the sequence follows an arithmetic pattern 
// or return "Geometric" if it follows a geometric pattern. 
// If the sequence doesn't follow either pattern return -1. 
// An arithmetic sequence is one where the difference between each of the numbers is consistent, 
// where as in a geometric sequence, each term after the first is multiplied by some constant or common ratio. 
// Arithmetic example: [2, 4, 6, 8] and Geometric example: [2, 6, 18, 54]. Negative numbers may be entered as parameters, 
// 0 will not be entered, and no array will contain all the same elements. 

// [ 5, 10, 15] => Arithmetic // difference between each of the numbers is consistent
// [ 2, 4, 16, 24] => -1

// [ 2, 6, 18, 54] => Geometric // term after the first is multiplied by some constant or common ratio.
public class Odoo1 {
    
    public static void main(String[] args) {
        // int[] arr = {2, 6, 18, 54}; // Geo
        int[] arr = {5, 10, 15}; // Arithmetic

        String result = solution(arr);
    
        System.out.println(result);
    }

    public static String solution(int[] arr) {
        if (isArithmetic(arr)) {
            return "Arithmetic";
        } else if(isGeo(arr)) {
            return "Geometric";

        } 
        return "-1";
    }

    private static boolean isGeo(int[] arr) {
        int ratio = arr[1] / arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] / arr[i] != ratio) {
                return false;
            }
        }
        return true;
    }

    private static boolean isArithmetic(int[] arr) {
        int diff = arr[1] - arr[0];
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] != diff) {
                return false;
            }
        }
        return true;
    }

}
