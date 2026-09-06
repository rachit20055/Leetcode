class Solution {
    public boolean checkValidString(String s) {
        int minOpen=0;
        int maxOpen=0;
        for(int i=0;i<s.length();i++){
            switch (s.charAt(i)) {
                case '(' -> {
                    minOpen++;
                    maxOpen++;
                }
                case ')' -> {
                    minOpen--;
                    maxOpen--;
                }
                default -> {
                    minOpen--;
                    maxOpen++;
                }
            }
            if(maxOpen<0)
            {
                return false;
            }
            minOpen=Math.max(minOpen,0);
        }
        return minOpen==0;
    }
    public static void main(String[] args){
        Solution s=new Solution();
        String str="(*)";
        boolean result=s.checkValidString(str);
        System.out.println(result);
    }
}