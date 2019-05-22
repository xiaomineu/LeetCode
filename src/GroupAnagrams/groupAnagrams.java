package GroupAnagrams;

import java.util.*;

public class groupAnagrams {
    public static void main(String[] args) {
        String[] str={"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(group(str));
    }

    /**
     * 字符串数组中，不同字符排列的字符串为一个List
     *1.不同排列字符串所对应有序字符串相等，可以作为key值，将string转换为char[]数组，排列后，作为key
     *2.map中是否有该键（没有）创建List值，将key对应value添加入List,将(key,list)add进map中
     * 3.map.values返回有个容器，含有所有values
     * 4.list.addAll(map.values);
     * @param str
     * @return
     */
    private static List<List<String>> group(String[] str) {
        List<List<String>> list = new ArrayList<>();
        if (str.length <= 0) {
            return list;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : str) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String sampleString = new String(chars);
            List<String> stringsList = map.get(sampleString);
            if (stringsList == null) {
                stringsList = new ArrayList<>();
            }
            stringsList.add(s);
            map.put(sampleString, stringsList);
        }
        list.addAll(map.values());
        return list;
    }
}
