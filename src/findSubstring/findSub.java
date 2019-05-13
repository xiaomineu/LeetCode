package findSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class findSub {
    public static void main(String[] args) {
//        String s="pjzkrkevzztxductzzxmxsvwjkxpvukmfjywwetvfnujhweiybwvvsrfequzkhossmootkmyxgjgfordrpapjuunmqnxxdrqrfgkrsjqbszgiqlcfnrpjlcwdrvbumtotzylshdvccdmsqoadfrpsvnwpizlwszrtyclhgilklydbmfhuywotjmktnwrfvizvnmfvvqfiokkdprznnnjycttprkxpuykhmpchiksyucbmtabiqkisgbhxngmhezrrqvayfsxauampdpxtafniiwfvdufhtwajrbkxtjzqjnfocdhekumttuqwovfjrgulhekcpjszyynadxhnttgmnxkduqmmyhzfnjhducesctufqbumxbamalqudeibljgbspeotkgvddcwgxidaiqcvgwykhbysjzlzfbupkqunuqtraxrlptivshhbihtsigtpipguhbhctcvubnhqipncyxfjebdnjyetnlnvmuxhzsdahkrscewabejifmxombiamxvauuitoltyymsarqcuuoezcbqpdaprxmsrickwpgwpsoplhugbikbkotzrtqkscekkgwjycfnvwfgdzogjzjvpcvixnsqsxacfwndzvrwrycwxrcismdhqapoojegggkocyrdtkzmiekhxoppctytvphjynrhtcvxcobxbcjjivtfjiwmduhzjokkbctweqtigwfhzorjlkpuuliaipbtfldinyetoybvugevwvhhhweejogrghllsouipabfafcxnhukcbtmxzshoyyufjhzadhrelweszbfgwpkzlwxkogyogutscvuhcllphshivnoteztpxsaoaacgxyaztuixhunrowzljqfqrahosheukhahhbiaxqzfmmwcjxountkevsvpbzjnilwpoermxrtlfroqoclexxisrdhvfsindffslyekrzwzqkpeocilatftymodgztjgybtyheqgcpwogdcjlnlesefgvimwbxcbzvaibspdjnrpqtyeilkcspknyylbwndvkffmzuriilxagyerjptbgeqgebiaqnvdubrtxibhvakcyotkfonmseszhczapxdlauexehhaireihxsplgdgmxfvaevrbadbwjbdrkfbbjjkgcztkcbwagtcnrtqryuqixtzhaakjlurnumzyovawrcjiwabuwretmdamfkxrgqgcdgbrdbnugzecbgyxxdqmisaqcyjkqrntxqmdrczxbebemcblftxplafnyoxqimkhcykwamvdsxjezkpgdpvopddptdfbprjustquhlazkjfluxrzopqdstulybnqvyknrchbphcarknnhhovweaqawdyxsqsqahkepluypwrzjegqtdoxfgzdkydeoxvrfhxusrujnmjzqrrlxglcmkiykldbiasnhrjbjekystzilrwkzhontwmehrfsrzfaqrbbxncphbzuuxeteshyrveamjsfiaharkcqxefghgceeixkdgkuboupxnwhnfigpkwnqdvzlydpidcljmflbccarbiegsmweklwngvygbqpescpeichmfidgsjmkvkofvkuehsmkkbocgejoiqcnafvuokelwuqsgkyoekaroptuvekfvmtxtqshcwsztkrzwrpabqrrhnlerxjojemcxel";
//        String[] words={"dhvf","sind","ffsl","yekr","zwzq","kpeo","cila","tfty","modg","ztjg","ybty","heqg","cpwo","gdcj","lnle","sefg","vimw","bxcb"};
//        String s="wordgoodgoodgoodbestword";
//       String [] words={"word","good","best","good"};
        String s="barfoothefoobarman";
        String[] words={"foo","bar"};
        System.out.println(findIndex(s,words));
    }
    public  static List<Integer> findIndex(String s,String[] words){
        List<Integer> list=new ArrayList<>();
        if(words.length==0){
            return list;
        }
        if(s.length()<words[0].length()){
            return list;
        }
        //将字符串数组中字符以及次数存为map
        Map<String,Integer> template=new HashMap<>();
        for(String string:words){
            template.put(string,template.getOrDefault(string,0)+1);
        }
        int nums=words.length;
        int length=words[0].length();
        //字符串起始位置，循环次数为单个字符长度
        for(int i=0;i<length;i++){
            Map<String,Integer> current=new HashMap<>();
            int size=0;
            int begin=i;
            for(int j=i;j<s.length()-length+1;j+=length){
                String str=s.substring(j,j+length);
                if(template.containsKey(str)){
                    current.put(str,current.getOrDefault(str,0)+1);
                    size++;
                    begin=begin==-1?j:begin;//记录开始位置
                    if(size==nums){
                        if(current.equals(template)){
                            list.add(begin);
                        }
                        size--;
                        current.put(s.substring(begin,begin+length),current.get(s.substring(begin,begin+length))-1);
                        begin+=length;
                    }
                }else{
                    begin=-1;
                    current.clear();
                    size=0;
                }
            }
        }
        return list;
    }
}
