import java.util.*;
class RSA
{
	public static void main(String args[])
		{
			Scanner in=new Scanner(System.in);
			System.out.println("enter the message to be encrypted");
			String message=in.nextLine();
			int p,q,e;
			System.out.println("enter the value of p");
			p=in.nextInt();
			System.out.println("enter the value of q");
			q=in.nextInt();
			int n=p*q;
			System.out.println("n is"+n);
			int fn=(p-1)*(q-1);
			System.out.println("fn is"+fn);
			do{
				System.out.println("enter the value of e< & relatively prime to "+fn);
				e=in.nextInt();
			  }while(gcd(e,fn)!=1);
			  System.out.println("the value of e is"+e);
			  System.out.println("the public key is {"+e+","+n+"}");
			  int d;
			  int k=1;
			  while((((fn*k)+1)%e)!=0)
			  {
			  		k++;
			  }
			  d=((fn*k)+1)/e;
			  System.out.println("d is"+d);
			  int msglen=message.length();
			  int[] msg =new int[msglen];
			  int a;
			  String dec="";
			  System.out.println("encrypting_____");
			  for(int i=0;i<msglen;i++)
			  {	
			  		a=(int)(message.charAt(i));
			  		msg[i]=enc(a,e,n);
			  }
			  System.out.println("the cipher text is:");
			  for(int i=0;i<msglen;i++)
			  		System.out.print(msg[i]+" ");
			  System.out.println();
			  System.out.println("the decrypted message is");
			  for(int i=0;i<msglen;i++)
              {
              		a=enc(msg[i],d,n);
              		dec+=(char)a;
              }
              System.out.println(dec);
          }	
      public static int gcd(int m,int n)
      {
      		int r;
      		while(n!=0)
      		{
      			r=m%n;
      			m=n;
      			n=r;
      		}
      	return m;
      }
      public static int enc(int m,int e,int n)
      {
      		int r=1;
      		for(int i=0;i<e;i++)
      			r=(r*m)%n;
      		return r;
      }
 }   							
