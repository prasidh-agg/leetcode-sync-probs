class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int students_0 = 0, students_1 = 0;
        for(int student : students){
            if(student == 0) students_0++;
            else students_1++;
        }

        for(int i = 0; i < sandwiches.length; i++){
            if(sandwiches[i] == 0 && students_0 > 0){
                students_0--;
            }
            else if(sandwiches[i] == 1 && students_1 > 0){
                students_1--;
            }
            else{
                break;
            }
        }
        return students_0 + students_1;
    }
}
