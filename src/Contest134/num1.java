package Contest134;

public class num1 {
    public static void main(String[] args) {
        int [] list=numMovesStones(3,5,1);
        System.out.println(list[0]);
        System.out.println(list[1]);
    }
    public static int[] numMovesStones(int a,int b,int c){
        int left=a+1;
        int right=c-1;
        int [] result=new int[2];
        if(a>b-2&&b>c-2){
            result[0]=0;
            result[1]=0;
            return result;
        }
        boolean [] flag=new boolean[101];
        flag[a]=true;
        flag[b]=true;
        flag[c]=true;
        int leftMaxCount=0;
        while(left<=b-1){
            if(flag[left]!=true){
                leftMaxCount++;
            }
            left++;
        }
        int rightMaxCount=0;
        while(right>=b+1){
            if(flag[right]!=true){
                rightMaxCount++;
            }
            right--;
        }
        result[1]=leftMaxCount+rightMaxCount;
        int leftMin=0;
        left=a+1;
        while(left<=b-1){
            if(flag[left]!=true){
                leftMin=1;
            }
            left++;
        }
        int rightMin=0;
        right=c-1;
        while(right>=b+1){
            if(flag[right]!=true){
                rightMin=1;
            }
            right--;
        }
        result[0]=leftMin+rightMin;
        return result;
    }
}
