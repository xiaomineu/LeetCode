package TextJustification;

import java.util.ArrayList;
import java.util.List;

//模拟题
//贪心将字符串数组压入一个数组中，记录个数
//记录字符串个数，每次压入时，比较插入最少空格与字符串长度之和
//将剩余空间用空格填充，填充均匀，除最后一行
public class fullJustify {
    public static void main(String[] args) {
        String[] words={"What","must","be","acknowledgment","shall","be"};
        System.out.println(fullJustify(words,16));
    }
    private static List<String> fullJustify(String[] words,int maxWidth){
        List<String> list=new ArrayList<>();
        int count=1;
        int currentLength=0;
        for(int i=0;i<words.length;i++){
            if(currentLength+words[i].length()+count-1<=maxWidth){
                count++;
                currentLength+=words[i].length();
            }else{
                insertString(list,words,i-count+1,i-1,count-1,currentLength,maxWidth);
                i=i-1;
                count=1;
                currentLength=0;
            }
        }
        if(currentLength>0){
            lastLint(list,words,words.length-count+1,words.length-1,currentLength,maxWidth);
        }
        return list;
    }
    private static void insertString(List<String> list,String[] words,int first,int last,int count,int currentLength,int maxWidth){
        int space=maxWidth-currentLength;
        int Number=count-1;
        int average;
        StringBuilder stringBuilder=new StringBuilder();
        if(Number!=0){
            average=space/Number;
            int still=average*Number==space?0:space-(average*Number);
            int change=1;
            for(int i=first;i<=last;i++){
                if(i==last){
                    stringBuilder.append(words[i]);
                    break;
                }
                stringBuilder.append(words[i]);
                for(int j=0;j<average;j++){
                    stringBuilder.append(" ");
                }
                if(change<=still){
                    stringBuilder.append(" ");
                    change++;
                }
            }
        }else{
            average=space;
            stringBuilder.append(words[first]);
            for(int i=0;i<average;i++){
                stringBuilder.append(" ");
            }
        }
        list.add(stringBuilder.toString());
    }
    private static void lastLint(List<String> list,String[] words,int first,int last,int currentLength,int maxWidth){
        StringBuilder stringBuilder=new StringBuilder();
        int space=maxWidth-currentLength;
        for(int i=first;i<=last;i++){
            if(i==last){
                stringBuilder.append(words[i]);
                while(space>0){
                    stringBuilder.append(" ");
                    space--;
                }
            }else{
                stringBuilder.append(words[i]);
                stringBuilder.append(" ");
                space--;
            }
        }
        list.add(stringBuilder.toString());
    }
}
