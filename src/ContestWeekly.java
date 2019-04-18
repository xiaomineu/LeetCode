import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ContestWeekly {
	
	public List<String> commonChars(String[] A)
	{
			int [] f=new int[26];
			Arrays.fill(f,99999);
			for(String x:A)
			{
				int [] lf=new int[26];
				Arrays.fill(lf, 0);
				for(char c:x.toCharArray())
				{
					lf[c-'a']++;//当前字符串字节重复次数;
				}
				for(int i=0;i<26;i++)
				{
					f[i]=Math.min(f[i], lf[i]);
				}
			}
			LinkedList<String> list=new LinkedList<>();
			
			for(int i=0;i<26;i++)
			{
				for(int j=0;j<f[i];j++)
				{
					list.add(""+(char)('a'+i));
				}
			}
			return list;
	}

	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContestWeekly cs=new ContestWeekly();
		String [] A= {"abbdklll","listabblll","abbdjllll"};
		List<String> list=new LinkedList<>();
		list=cs.commonChars(A);
		for(String c:list)
		{
			System.out.println(c);
		}
		
	}

}
