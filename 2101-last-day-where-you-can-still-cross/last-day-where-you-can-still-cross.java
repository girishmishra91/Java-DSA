class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 1, right = row * col, ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCross(row, col, cells, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private boolean canCross(int row, int col, int[][] cells, int day) {
        int[][] grid = new int[row][col];

        // mark water
        for (int i = 0; i < day; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }

        Queue<int[]> q = new LinkedList<>();

        // add all top-row land cells
        for (int j = 0; j < col; j++) {
            if (grid[0][j] == 0) {
                q.offer(new int[]{0, j});
                grid[0][j] = 1;
            }
        }

        // BFS
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];

            if (x == row - 1) return true;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < row && ny < col && grid[nx][ny] == 0) {
                    grid[nx][ny] = 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}
