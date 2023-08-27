class Solution {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();
        Character[] chars = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        set.addAll(Arrays.asList(chars));

        char[] arr = s.toCharArray();
        int l = 0, r = s.length() - 1;
        while(l < r){
            while(l < r && !set.contains(arr[l])){
                l++;
            }
            while(l < r && !set.contains(arr[r])){
                r--;
            }
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        } 
        return new String(arr);
    }
}
