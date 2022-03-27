package com.aayush.graph;

public class FindNumberOfIslandMatrix {

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

		char[][] grid1 = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '0', '0' } };

		char[][] grid2 = { { '0', '1' }, { '1', '0' }, { '1', '1' }, { '1', '0' } };

		char[][] grid3 = { { '1', '0', '0', '0', '0', '1', '0', '0', '0', '1' },
				{ '1', '0', '1', '1', '1', '1', '1', '0', '0', '1' },
				{ '1', '1', '1', '1', '1', '0', '0', '0', '1', '0' },
				{ '1', '1', '1', '0', '1', '0', '0', '1', '0', '1' },
				{ '0', '1', '0', '1', '0', '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '0', '0', '1', '1', '1', '1', '0' },
				{ '0', '0', '1', '1', '0', '0', '0', '1', '0', '0' } };

		 System.out.println(numIslands(grid));
		 System.out.println(numIslands(grid1));
		 System.out.println(numIslands(grid2));
		System.out.println(numIslands(grid3));

	}

	public static int numIslands(char[][] M) {

		int ROW = M.length;
		int COL = M[0].length;
		int count = 0;
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (M[i][j] == '1') {
					M[i][j] = '0';
					count++;
					DFS(M, i + 1, j, ROW, COL); // right side traversal
					DFS(M, i - 1, j, ROW, COL); // left side traversal
					DFS(M, i, j + 1, ROW, COL); // upward side traversal
					DFS(M, i, j - 1, ROW, COL); // downward side traversal
					DFS(M, i + 1, j + 1, ROW, COL); // upward-right side traversal
					DFS(M, i - 1, j - 1, ROW, COL); // downward-left side traversal
					DFS(M, i + 1, j - 1, ROW, COL); // downward-right side traversal
					DFS(M, i - 1, j + 1, ROW, COL); // upward-left side traversal
				}
			}
		}
		return count;

	}

	static void DFS(char[][] M, int i, int j, int ROW, int COL) {

		// Base condition
		// if i less than 0 or j less than 0 or i greater than ROW-1 or j greater than
		// COL- or if M[i][j] != 1 then we will simply return
		if (i < 0 || j < 0 || i > (ROW - 1) || j > (COL - 1) || M[i][j] != '1') {
			return;
		}

		if (M[i][j] == '1') {
			M[i][j] = '0';
			DFS(M, i + 1, j, ROW, COL); // right side traversal
			DFS(M, i - 1, j, ROW, COL); // left side traversal
			DFS(M, i, j + 1, ROW, COL); // upward side traversal
			DFS(M, i, j - 1, ROW, COL); // downward side traversal
			DFS(M, i + 1, j + 1, ROW, COL); // upward-right side traversal
			DFS(M, i - 1, j - 1, ROW, COL); // downward-left side traversal
			DFS(M, i + 1, j - 1, ROW, COL); // downward-right side traversal
			DFS(M, i - 1, j + 1, ROW, COL); // upward-left side traversal
		}
	}
}
