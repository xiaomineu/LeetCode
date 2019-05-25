package LengthOfLastWord;

public class lengthOfLastWord {
    public static void main(String[] args) {
        String s="a ";
        System.out.println(lengthOfLastWord(s));
    }
    private static int lengthOfLastWord(String s){
        int length=0;
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==' '&&length!=0){
                break;
            }else if(s.charAt(i)==' '){
                continue;
            }
            else{
                length++;
            }
        }
        return length;
    }
}
