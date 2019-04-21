package ZigZagConversion;


/**
 * 模拟题：
 *      模拟读数
 *          1.每列创建一个字符数组(或者字符串stringbuffer)
 *          2.一次遍历字符串
 *          3.按列读取字符串中字符(分为两种方式：竖直向下，以及斜向上（避免两种方式之间的重复）)
 *          4.将各列中的数组拼接起来，得到最终字符串结果
 * (注意边界条件)
 *  1.当字符串为空时或者为null时
 *  2.当输入列数大于或者等于字符串长度时，应保持字符串原样输出
 */
public class ZigZag {
    public static void main(String[] args) {
        String string="AA";
        System.out.println(convert(string,2));
    }
    public static String convert(String s,int numRows){
        if(s==null){
            return null;
        }
        if(s==""){
            return "";
        }
        if(numRows==1||s.length()<=numRows){
            return s;
        }
        int len=s.length();
        char[] chars=s.toCharArray();
        StringBuffer[] stringBuffers=new StringBuffer[len];
        for(int i=0;i<numRows;i++){
            stringBuffers[i]=new StringBuffer();
        }
        int i=0;
        //竖直向下
        while(i<len){
            for(int index=0;index<numRows&&i<len;index++){
                stringBuffers[index].append(chars[i++]);
            }
            for(int index=numRows-2;index>=1&&i<len;index--){
                stringBuffers[index].append(chars[i++]);
            }
        }
        for(int j=1;j<numRows;j++){
            stringBuffers[0].append(stringBuffers[j]);
        }
        String string=stringBuffers[0].toString();
        return string;
    }
}
