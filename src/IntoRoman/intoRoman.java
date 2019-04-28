package IntoRoman;

public class intoRoman {
    public static void main(String[] args) {
        System.out.println(toRoman(1994));
    }
    public static String toRoman(int num){
        StringBuffer stringBuffer=new StringBuffer();
        int [] template={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String [] strings={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0;i<strings.length;i++){
            while(num>=template[i]){
                stringBuffer.append(strings[i]);
                num-=template[i];
            }
        }
        return stringBuffer.toString();
    }
}
