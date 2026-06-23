// CF - Heapify 1

import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        
        while(t-- > 0) {
            
            int n = sc.nextInt();
            boolean isPossible = true;
            
            for (int i = 1; i <= n; i++) {
                int currVal = sc.nextInt();
                
                if (!isPossible) {
                    continue;
                }
                
                int indexBase = i;
                while (indexBase%2 == 0) {
                    indexBase = indexBase/2;
                }
                
                int valueBase = currVal;
                while (valueBase%2 == 0) {
                    valueBase = valueBase/2;
                }
                
                if (indexBase != valueBase) {
                    isPossible = false;
                }
            }
            
            if (isPossible) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        
        sc.close();
    }
}
