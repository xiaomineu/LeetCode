package strStr;

public class strStr {
    public static void main(String[] args) {
        String haystack="hello";
        String needle="ll";
        System.out.println(str(haystack,needle));
    }
    public static int str(String haystack,String needle){
        if(needle.length()==0){
            return 0;
        }
        for(int i=0;i<haystack.length()-needle.length()+1;i++){
            if(haystack.substring(i,i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
