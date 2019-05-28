package validNumber;

public class number {
    public static void main(String[] args) {
        String s=" +434e9f";
        System.out.println(isValue(s));
    }
    private static boolean isValue(String s){
        boolean in=true;
        s=s.trim();
        try{
            double d=Double.parseDouble(s);
            /**
             * if (var6 >= var5 || var6 == var5 - 1 && (var0.charAt(var6) == 'f' || var0.charAt(var6) == 'F' || var0.charAt(var6) == 'd' || var0.charAt(var6) == 'D')) {
             *      if (var13) {
             *          return var1 ? A2BC_NEGATIVE_ZERO : A2BC_POSITIVE_ZERO;
             *   }
             */
            if(s.charAt(s.length()-1)=='f'||s.charAt(s.length()-1)=='D'){
                in=false;
            }
        }catch (Exception e){
            in=false;
        }
     return in;
    }
}
