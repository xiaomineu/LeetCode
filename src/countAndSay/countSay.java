package countAndSay;

public class countSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(5));
    }

    /**
     * 数字转换为字符串
     * 数字表示上一个数字出现频率
     * @param n 该数字所表示字符串
     * @return 返回字符串值
     *
     * 1.递归基：1对应“1”
     * 2.递归向上传参：2对应“11”表示其中1出现频率为1
     * 3.统计传递字符串各数字出现频率，创建新字符串拼接频率以及对应数字
     */
    public static String countAndSay(int n){
        StringBuffer stringBuffer=sub(n);
        return new String(stringBuffer);
    }
    public static StringBuffer sub(int n){
        if(n==1){
            StringBuffer s=new StringBuffer("1");
            return s;
        }else{
            StringBuffer stringBuffer=sub(n-1);
            char template=stringBuffer.charAt(0);
            int count=1;
            StringBuffer stringBuffer1=new StringBuffer();
            for(int i=1;i<stringBuffer.length();i++){
                if(template==stringBuffer.charAt(i)){
                    count++;
                }else{
                    stringBuffer1.append(count);
                    stringBuffer1.append(template);
                    count=1;
                }
                template=stringBuffer.charAt(i);
            }
            stringBuffer1.append(count);
            stringBuffer1.append(template);
            return stringBuffer1;
        }
    }
}
