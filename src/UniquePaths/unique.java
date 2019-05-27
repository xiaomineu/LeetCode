package UniquePaths;

public class unique {
    public static void main(String[] args) {
        System.out.println(route(28,12));
    }
    private static int route(int m,int n){
        int [][] template=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    template[i][j]=1;
                }else{
                    template[i][j]=template[i-1][j]+template[i][j-1];
                }
            }
        }
        return template[m-1][n-1];
    }
}
