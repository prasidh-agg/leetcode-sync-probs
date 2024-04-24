class Solution {
    public void fillNeighbors(Queue<String> q, StringBuilder curr, Set<String> set){
        for(int i = 0; i < 4; i++){
            char ch = curr.charAt(i);
            
            char dec = (ch == '0') ? '9' : (char) (ch - 1);
            char inc = (ch == '9') ? '0' : (char) (ch + 1);

            curr.setCharAt(i, dec);
            String decStr = curr.toString();
            if(!set.contains(decStr)){
                set.add(decStr);
                q.add(decStr);
            }

            curr.setCharAt(i, inc);
            String incString = curr.toString();
            if(!set.contains(incString)){
                set.add(incString);
                q.add(incString);
            }

            curr.setCharAt(i, ch);
        }
    }
    public int openLock(String[] deadends, String target) {
        String start = "0000";
        Set<String> set = new HashSet<>();
        for(String deadend : deadends ){
            set.add(deadend);
        }
        if (set.contains(start)) {
            return -1;
        }
        Queue<String> q = new LinkedList<>();
        q.add(start);
        int level = 0;
        while(!q.isEmpty()){
            int n = q.size();
            //process all elements in curr level 
            while(n-- > 0){
                String curr = q.poll();
                if(curr.equals(target)){
                    return level;
                }
                StringBuilder currBuilder = new StringBuilder(curr);
                fillNeighbors(q, currBuilder, set);
            }
            level++;
        }
        return -1;
    }
}
