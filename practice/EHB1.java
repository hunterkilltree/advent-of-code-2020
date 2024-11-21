// N clients are waiting in line to collect their packages at the post office.
// Packages arrive at the post office one by one. For simplicity,
// we will number the packages from 1 to N in the order in which they arrive.
// Each client wants to collect a single package;
// the K-th client in the line (for K from 0 to N-1) wants to collect package number client|K.
// After a package arrives, one of the following events happens:
// if the first client in the line wants to collect the package, they pick it up and leave the line;
// otherwise, the package is put on the shelf.
// If the first client wants to collect a package from the shelf, they leave the line and collect the package.
// Please note that only the first client from the line can collect their package.
// How many packages will be stored on the shelf at the same time?
// given an array client, returns the maximum number of packages that will be stored on the shelf at the same time.
// Examples:
// For client = [3, 2, 4, 5, 1], the function should return 2.
// For client = [1, 2, 3, 4, 5], the function should return 0.
// For client = [3, 2, 7, 4, 5, 6, 1], the function should return 4.
// 1 <= N <= 100000

// How to solve this optimally?

class EHB1 {
    public static void main(String[] args) {
        // int[] client = { 3, 2, 4, 5, 1};
        int[] client = { 1, 2, 3, 4, 5};
        // int[] client = { 3, 2, 7, 4, 5, 6, 1};
        int result = solution(client);

        System.out.println(result);

    }

    public static int solution(int[] client) {
        int max = 0;
        int packageNum = 1;
        int numberOfPackagesInShelf = 0;

        for (int i = 0; i < client.length;) {
            if (client[i] < packageNum) { // user take package at shelf and leave line
                numberOfPackagesInShelf--;
                i++;
            } else if (client[i] == packageNum) { // user take at  post office and leave line
                packageNum++;
                i++;
            } else {
                numberOfPackagesInShelf++;
                packageNum++;
            }
            max = Math.max(numberOfPackagesInShelf, max);
      
        }
        return max;
    }
}