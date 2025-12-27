class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int[] count = new int[n];
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<long[]> busy = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? Long.compare(a[1], b[1]) : Long.compare(a[0], b[0])
        );
        PriorityQueue<Integer> freeRooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++) freeRooms.offer(i);
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                freeRooms.offer((int)busy.poll()[1]);
            }
            if (!freeRooms.isEmpty()) {
                int roomId = freeRooms.poll();
                count[roomId]++;
                busy.offer(new long[]{end, roomId});
            } else {
                long[] earliest = busy.poll();
                long freeTime = earliest[0];
                int roomId = (int)earliest[1];
                count[roomId]++;
                long duration = end - start;
                busy.offer(new long[]{freeTime + duration, roomId});
            }
        }
        int ans = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[ans]) {
                ans = i;
            }
        }
        return ans;
    }
}
