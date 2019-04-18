import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
	public List<Integer> pancakeSort(int[] A) {
        //���ӶȽϴ��㷨���ҵ��������ֵkλ��poi,��תpoi,�����ŷ�תk�����������,���Ҵδ�ģ��ظ�����;
        int maxValue=A.length-1;
        List<Integer> list= new ArrayList<>();
        int j=0;
        for(int i=1;i<A.length;i++)
        {
            j=findPosition(A,maxValue);
            if(maxValue==j)
            {
                maxValue--;
            }
            else
            {
            	if(j!=1)
                {
            		list.add(j);
            		swap(A,j);
                }
                list.add(maxValue);
                swap(A,maxValue);
                maxValue--;
            }
        }
        return list;
    }
    
    //Ѱ�ҵ�ǰԪ���������е�λ��
    public int findPosition(int [] numArray,int value)
    {
        int i;
        for(i=1;i<numArray.length;i++)
        {
            if(value==numArray[i])
                break;
        }
        return i;
    }
    
    //��ת
    public void swap(int [] numArray,int position)
    {
        int begin=1;
        int i;
        while(position>begin)
        {
            i=numArray[position];
            numArray[position]=numArray[begin];
            numArray[begin]=i;
            position--;
            begin++;
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] list= {0,3,2,4,1};
		Solution sol=new Solution();
		List<Integer> Nodelist=new ArrayList<>();
		Nodelist=sol.pancakeSort(list);
		Iterator<Integer> iterator=Nodelist.iterator();
		while(iterator.hasNext())
		{
			System.out.print(iterator.next());
		}
	}

}
