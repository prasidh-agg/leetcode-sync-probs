class Solution {
    public String sortVowels(String s) {
        char[] arr = s.toCharArray();
        char[] vowelArr = new char[arr.length];
        int counter = 0;
        String vowels = "aeiouAEIOU";
        
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (vowels.contains(String.valueOf(c))) {
                vowelArr[counter++] = c;
                arr[i] = ' '; // Update the original array to mark the position of the vowel
            }
        }

        Arrays.sort(vowelArr, 0, counter);

        int i = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == ' ') {
                arr[j] = vowelArr[i++];
            }
        }

        return new String(arr);
    }
}

