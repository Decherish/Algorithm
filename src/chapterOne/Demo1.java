package chapterOne;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Demo1 {

	// 1.1.3题
	public static void test() {
		StdOut.print("输入3个数字：");
		int a = StdIn.readInt();
		int b = StdIn.readInt();
		int c = StdIn.readInt();
		if (a == b && b == c) {
			StdOut.println("equal");
		} else {
			StdOut.println("not equal");
		}
	}

	// 1.1.5题
	public static void cmpDouble(double x, double y) {
		if (0 < x && x < 1 && 0 < y && y < 1) {
			StdOut.println("true");
		} else {
			StdOut.println("false");
		}
	}

	// 1.1.9题
	public static String toBinaryString(int n) {
		String s = "";
		for (int i = n; i > 0; i /= 2) {
			s = (i % 2) + s;
		}
		return s;
	}

	// 1.1.11题
	public static void printBooleanArr(int x, int y) {
		boolean[][] bList = new boolean[x][y];
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				bList[i][j] = StdRandom.bernoulli(0.5);
			}
		}
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (bList[i][j]) {
					StdOut.print("*");
				} else {
					StdOut.print(" ");
				}
			}
		}
	}

	// 1.1.13题
	public static int[][] printArr(int[][] arr) {
		int[][] a = new int[arr[0].length][arr.length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				a[j][i] = arr[i][j];
			}
		}
		return a;

	}

	// 1.1.14题
	public static int lg(int n) {
		int i = 0;
		for (int s = 2; s <= n; s *= 2) {
			i++;
		}
		return i;
	}

	// 1.1.15题
	public static int[] histogram(int[] arr, int M) {
		int[] a = new int[M];
		for (int i = 0; i < M; i++) {
			int temp = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == i) {
					temp += 1;
				}
			}
			a[i] = temp;
		}
		return a;

	}

	// 1.1.19题
	public static long F1(long n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		long s0 = 0, s1 = 1, s2 = 0;
		for (int i = 2; i < n; i++) {
			s2 = s1 + s0;
			s1 = s0;
			s0 = s2;
		}
		return s2;
	}

	// 1.1.20
	public static double logN(double n) {
		if (n <= 1) {
			return 0.0;
		}
		return Math.log(n) + logN(n - 1);
	}

	// 1.1.21
	public static void show(int n) {
		String[] name = new String[n];
		int[] grade = new int[n];
		int[] grade2 = new int[n];
		for (int i = 0; i < n; i++) {
			name[i] = StdIn.readString();
			grade[i] = StdIn.readInt();
			grade2[i] = StdIn.readInt();
		}
		for (int i = 0; i < n; i++) {
			System.out.printf("|%4s|%4d|%4d|%6.3f|\n", name[i], grade[i],
					grade2[i], (float) (grade[i] / grade2[i]));
		}
	}

	// 1.1.22
	public static int rank(int[] a, int k) {
		return rank(k, a, 0, a.length - 1, 0);
	}

	public static int rank(int key, int[] a, int lo, int hi, int depth) {
		for (int i = 0; i < depth; i++) {
			System.out.printf(" ");
		}
		System.out.println("lo=" + lo + ",hi=" + hi);
		if (lo > hi) {
			return -1;
		}
		int mid = lo + (hi - lo) / 2;
		if (key < a[mid]) {
			return rank(key, a, lo, mid - 1, depth + 1);
		} else if (key > a[mid]) {
			return rank(key, a, mid + 1, hi, depth + 1);
		} else {
			return mid;
		}
	}

	// 1.1.24 && 1.1.25
	public static int gcd(int a, int b) {
		StdOut.print("a=" + a + ",b=" + b + "\n");
		if (b == 0 || a == 0) {
			return 1;
		}
		if (a < b) {
			int temp = a;
			a = b;
			b = a;
		}
		if (a % b == 0) {
			return b;
		} else {
			return gcd(b, a % b);
		}
	}

	// 1.1.27
	public static double[][] binomial(int N, int k, double p) {
		double[][] array = new double[N + 1][k + 1];
		// 给二维数组初始化第一列，避免下面执行时出现数组下标越界
		array[0][0] = 1.0;
		for (int i = 1; i < N + 1; i++)
			array[i][0] = array[i - 1][0] * (1 - p);
		for (int i = 1; i < N + 1; i++)
			for (int j = 1; j <= i && j < k + 1; j++)
				array[i][j] = (1 - p) * array[i - 1][j] + p
						* array[i - 1][j - 1];
		return array;
	}

	// 1.1.28
	public static int[] BinarySearch(int[] whitelist) {
		ArrayList<Integer> aList = new ArrayList<Integer>();
		for (int i = 0; i < whitelist.length - 1; i++) {
			if (whitelist[i] != whitelist[i + 1]) {
				aList.add(whitelist[i]);
			}
		}
		aList.add(whitelist.length - 1);
		whitelist = new int[aList.size()];
		for (int i = 0; i < aList.size(); i++) {
			whitelist[i] = aList.get(i);
		}
		return whitelist;
	}

	// 1.1.29
	public static int rank(int key, int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < key) {
				count++;
			} else {
				break;
			}
		}
		return count;
	}

	public static int count(int key, int[] a) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == key) {
				count++;
			} else if (a[i] > key) {
				break;
			}
		}
		return count;
	}

	// 1.1.30
	public static void test2() {
		int N = StdIn.readInt();
		boolean[][] a = new boolean[N][N];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (gcd(i, j) == 1) {
					a[i][j] = true;
				} else {
					a[i][j] = false;
				}
			}
		}
	}

	// 1.1.35
	public static double[] Prob() {
		int SIDES = 6;
		double[] dist = new double[2 * SIDES + 1];
		for (int i = 1; i <= SIDES; i++)
			for (int j = 1; j <= SIDES; j++)
				dist[i + j] += 1.0;
		for (int k = 2; k <= 2 * SIDES; k++) {
			dist[k] /= 36.0;
		}
		return dist;
	}

	public static double[] testPro(double N) {
		int SIDES = 6;
		double[] b = new double[2 * SIDES + 1];
		double t = N;
		while (N > 0) {
			int m = 1 + (int) (Math.random() * 6);
			int n = 1 + (int) (Math.random() * 6);
			b[m + n] += 1.0;
			N--;
		}
		for (int i = 2; i <= SIDES * 2; i++) {
			b[i] /= t;
		}
		return b;
	}

	public static void showPro() {
		int SIDES = 6;
		double N = 64;
		double[] a = Prob();
		double[] b = new double[SIDES * 2 + 1];
		int p = 0;
		while (p == 0) {
			b = testPro(N);
			p = 1;
			for (int i = 2; i < SIDES * 2; i++) {
				if (Math.abs(a[i] - b[i]) > .0001) {
					p = 0;
					break;
				}
			}
			N *= 2;
		}
		System.out.println("Test Times " + N);
		for (int i = 0; i <= SIDES * 2; i++) {
			System.out.println(i + " " + a[i] + " " + b[i]);
		}
	}

	// 1.1.36
	public static void shuffle(int[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int r = i + StdRandom.uniform(N - i);
			int temp = a[i];
			a[i] = a[r];
			a[r] = temp;
		}
	}

	public static void shuffleTest(int M, int N) {
		int[] a = new int[M];
		int[][] b = new int[M][M];
		for (int i = 0; i < N; i++) {
			for (int h = 0; h < M; h++) {
				a[h] = h;
			}
			shuffle(a);
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < M; k++) {
					if (j == a[k]) {
						b[j][k]++;
					}
				}
			}
		}
		for (int i = 0; i < M; i++)
			for (int j = 0; j < M; j++) {
				StdOut.print(b[i][j] + " ");
				if (j == M - 1)
					StdOut.println();
			}

	}

	public static void main(String[] args) {

	}
}
