package CompareVersionNumbers;

public class compareVersion {
    public static void main(String[] args) {
        String version1="0.1";
        String version2="1.1";
        System.out.println(compare(version1,version2));
    }
    private static int compare(String version1,String version2){
        if(version1==null||version2==null||version1.length()==0||version2.length()==0){
            return 0;
        }
        //"." "\" "|"是特殊字符串，需要使用转义
        String[] list=version1.split("[.]");
        String[] list2=version2.split("[.]");
        int len1=list.length;
        int len2=list2.length;
        for(int i=0;i<Math.max(len1,len2);i++){
            int val1=i<len1?Integer.parseInt(list[i]):0;
            int val2=i<len2?Integer.parseInt(list2[i]):0;
            if(val1>val2){
                return 1;
            }
            if(val1<val2)
                return -1;
        }
        return 0;
    }
}
