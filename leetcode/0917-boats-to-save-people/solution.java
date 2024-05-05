class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int l = 0, r = people.length - 1;
        int boats = 0;

        while(people[r] >= limit){
            boats++; 
            r--;        
        }

        while (l <= r) {

            if (people[l] + people[r] <= limit) {
                l++; // only increment the left pointer if the lightest person can join the heaviest person
            }
            r--; // decrement the right pointer as the heaviest person is always placed in a boat
            boats++; // a boat is used in each iteration
        }
        return boats;
    }
}

