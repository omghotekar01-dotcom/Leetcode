class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        char[] answer = new char[n];
        int i = 0;

        // Match target's prefix for as long as possible.
        while (i < n) {
            int current = target.charAt(i) - 'a';

            if (freq[current] == 0) {
                break;
            }

            answer[i] = target.charAt(i);
            freq[current]--;
            i++;
        }

        // Try making the first differing position larger.
        if (i < n && placeGreater(answer, i, target, freq)) {
            fillSmallestSuffix(answer, i + 1, freq);
            return new String(answer);
        }

        // Backtrack and increase the rightmost possible position.
        for (int position = i - 1; position >= 0; position--) {
            freq[answer[position] - 'a']++;

            if (placeGreater(answer, position, target, freq)) {
                fillSmallestSuffix(answer, position + 1, freq);
                return new String(answer);
            }
        }

        return "";
    }

    private boolean placeGreater(
        char[] answer,
        int position,
        String target,
        int[] freq
    ) {
        int current = target.charAt(position) - 'a';

        for (int letter = current + 1; letter < 26; letter++) {
            if (freq[letter] > 0) {
                answer[position] = (char) ('a' + letter);
                freq[letter]--;
                return true;
            }
        }

        return false;
    }

    private void fillSmallestSuffix(
        char[] answer,
        int position,
        int[] freq
    ) {
        for (int letter = 0; letter < 26; letter++) {
            while (freq[letter] > 0) {
                answer[position++] = (char) ('a' + letter);
                freq[letter]--;
            }
        }
    }
}