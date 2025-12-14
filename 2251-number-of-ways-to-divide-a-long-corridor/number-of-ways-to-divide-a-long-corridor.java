class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        long ans = 1;
        List<Integer> seats = new ArrayList<>();
        for (int i = 0; i < corridor.length(); i++) {
            if (corridor.charAt(i) == 'S') {
                seats.add(i);
            }
        }
        if (seats.size() == 0 || seats.size() % 2 != 0) {
            return 0;
        }
        for (int i = 2; i < seats.size(); i += 2) {
            int gap = seats.get(i) - seats.get(i - 1);
            ans = (ans * gap) % MOD;
        }     
        return (int) ans;
    }
}
