import java.util.Scanner;

public class Crc{
    static int n, m, msb, i, j, k, g[], d[], z[], r[];
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the no of bits in data word");
        n = s.nextInt();
        System.out.println("Enter the no of bits in generating polynomial");
        m = s.nextInt();

        d = new int[m + n];
        g = new int[n];

        System.out.println("Enter data word");
        for ( i = 0; i < n; i++) {
            d[i] = s.nextInt();
        }

        System.out.println("Enter generating polynomial");
        for ( i = 0; i < m; i++) {
            g[i] = s.nextInt();
        }

        crcEval();

        boolean flag = true;
        for ( i = n; i < n+ m - 1; i++) {
            if(r[i] == 1){
                flag = false;
            }
        }
        if(flag){
            System.out.println("No Error");
        }
        else{
            System.out.println("Error detected");
        }

    }

    private static void crcEval(){
        r = new int[m+n];
        for (i = 0; i < m; i++) {
            r[i] = d[i];
        }
        z = new int[m];
        for (i = 0; i < n; i++) {
            k = 0;
            msb = r[i];
            for (j = i; j < m; j++){
                if(msb == 0){
                    r[j] = r[j] ^ z[k];
                }                
                else{
                    r[j] = r[j] ^ g[k];
                }
                k++;
            }
            r[m + i] = d[m + i];
        }
        System.out.println("Check sum is: " );
        for (i = n; i < m+n-1; i++) {
            d[i] = r[i];
            System.out.print(d[i] + " ");
        }
        System.out.println();
    }
}
