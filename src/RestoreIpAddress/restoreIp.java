package RestoreIpAddress;

import java.util.ArrayList;
import java.util.List;

public class restoreIp {
    public static void main(String[] args) {
        String s="010010";
        System.out.println(restore(s));
    }
    //回溯依次选择符合条件ip
    private static List<String> restore(String s){
        List<String>list=new ArrayList<>();
        if(s.length()<4||s.length()>12){
            return list;
        }
        StringBuilder stringBuilder=new StringBuilder("");
        int count=0;
        Ip(s,list,0,count,stringBuilder);
        return list;
    }
    private static void Ip(String s,List<String> list,int position,int count,StringBuilder stringBuilder){
        if(count==4||position==s.length()){
            if(count==4&&position==s.length()){
                list.add(stringBuilder.toString());
            }
            return;
        }
        for(int i=position+1;i<=s.length();i++){
            //ip数值应在0--255范围中
            if(Integer.valueOf(s.substring(position,i))>=0&&Integer.valueOf(s.substring(position,i))<=255){
                //若为整数,需要保持数位相同
                int num=Integer.valueOf(s.substring(position,i));
                if(num<10&&s.substring(position,i).length()!=1){
                    break;
                }else if(num>=10&&num<100&&s.substring(position,i).length()!=2){
                    break;
                }else if(num>=100&&num<1000&&s.substring(position,i).length()!=3){
                    break;
                }else{
                    stringBuilder.append(s.substring(position,i));
                    if(count<=2){
                        stringBuilder.append(".");
                    }
                    Ip(s,list,i,count+1,stringBuilder);
                    if(count<=2){
                        stringBuilder.delete(stringBuilder.length()-1,stringBuilder.length());
                    }
                    stringBuilder.delete(stringBuilder.length()-i+position,stringBuilder.length());
                }
            }else
                break;
        }
    }
}
