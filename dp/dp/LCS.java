package dp;
import java.util.Stack;
import java.util.Scanner;

public class LCS {

	public static int lcs_length(String X, String Y) {
		/*
		 * fill in your code here
		 * Note: return the length of LCS, instead of c and b
		 */
//		First initialize the length of our strings
		int m = X.length();
		int n = Y.length();

//		init tables
//		tc  = table "c"
//		tb	= table "b' here we store directions

		int[][] tc = new int[m + 1][n + 1];
		char[][] tb = new char[m + 1][n + 1];

//		fill in using i and j indexes
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (X.charAt(i - 1) == Y.charAt(j - 1)) {  // Thanks for the hint
					tc[i][j] = tc[i - 1][j - 1] + 1;
					tb[i][j] = ')';  // ')' = diagonal arrow
				} else if (tc[i - 1][j] >= tc[i][j - 1]) {
					tc[i][j] = tc[i - 1][j];
					tb[i][j] = '^';
				} else {
					tc[i][j] = tc[i][j - 1];
					tb[i][j] = '<';
				}
			}

		}
		return tc[m][n];

	}

	public static void main (String[]args){
		// TODO Auto-generated method stub
		System.out.println(LCS.lcs_length("ABCBDAB", "BDCABA"));
		System.out.println(LCS.lcs_length("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", "GTCGTTCGGAATGCCGTTGCTCTGTAAA"));

//		Another example:
		System.out.println("\n Here is another case");

		System.out.println(LCS.lcs_length("BADFEWFEOEIUDAB", "BABAJKS"));
		System.out.println(LCS.lcs_length("ACCGGTCGAGTGLIJDBNVKEURYFICWUBEBVGCCGAA", "GTCGSUDBVHAEBVIUSASADVGTAAA"));

	}
}