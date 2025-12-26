class Solution {
    public int bestClosingTime(String customers) {
        int totalY = 0;
        
        // Count total 'Y'
        for (char c : customers.toCharArray()) {
            if (c == 'Y') totalY++;
        }
        
        int penalty = totalY; // closing at hour 0
        int minPenalty = penalty;
        int bestHour = 0;
        
        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty--; // one less customer after closing
            } else {
                penalty++; // open but no customer
            }
            
            if (penalty < minPenalty) {
                minPenalty = penalty;
                bestHour = i + 1;
            }
        }
        
        return bestHour;
    }
}
