import java.util.*;
import java.lang.*;
import java.io.*;

class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0) {
		    int n = sc.nextInt();
		       
		    int j = 1;
		    int ans = 1;
		    for(int i = 2; i<n && j <= n; i++) {
		        j+=i;
		        
		        if(j==n) {
		            ans = i;
		            break;
		        }
		        
		        if(j < n) ans = i;
		        if(j > n) break;
		    }
		    
		    System.out.println(ans);
		}
		
		sc.close();
	}
}
