package DefangingAnIPAddress;

public class defangIPAddr {
    public static void main(String[] args) {
        String address="1.1.1.1";
        System.out.println(defangIPAdd(address));
    }
    public static String defangIPAdd(String address){
        StringBuffer stringBuffer=new StringBuffer();
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)=='.'){
                stringBuffer.append("[");
                stringBuffer.append(address.charAt(i));
                stringBuffer.append("]");
            }else
                stringBuffer.append(address.charAt(i));
        }
        return stringBuffer.toString();
    }
}
