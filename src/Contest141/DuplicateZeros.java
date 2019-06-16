package Contest141;

public class DuplicateZeros {
    public static void main(String[] args) {
        int[] arr={0,0,0,0,0};
        duplicateZeros(arr);
    }
    private static void duplicateZeros(int[] arr){
        int[] template=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            template[i]=arr[i];
        }
        int index=0;
        for(int i=0;i<arr.length;i++){
            if(template[index]==0){
                arr[i++]=template[index];
                if(i<arr.length){
                    arr[i]=template[index];
                }
            }else
                arr[i]=template[index];
            index++;
        }
    }
}
