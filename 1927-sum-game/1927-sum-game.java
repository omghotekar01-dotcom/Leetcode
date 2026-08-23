class Solution {
    public boolean sumGame(String num) {
        int sumL = 0, sumR = 0;
        int qL = 0, qR = 0;
        int n = num.length();

        for (int i = 0; i < n; i++) {
            char c = num.charAt(i);
            if (i < n / 2) {
                if (c == '?') qL++;
                else sumL += c - '0';
            } else {
                if (c == '?') qR++;
                else sumR += c - '0';
            }
        }

        // If the total number of '?' is odd, Alice always wins.
        if ((qL + qR) % 2 != 0) return true;

        // Check if sum difference can be balanced by remaining '?' pairs
        int sumDiff = sumL - sumR;
        int qDiff = qR - qL;

        return 2 * sumDiff != 9 * qDiff;
    }
}