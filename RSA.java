import java.util.*;
class RSA{
	public static void main(String[] args){
		Scanner in=new Scanner(System.in);	
		System.out.println("Enter the message to be encrypted");
		String message=in.nextLine();
		int p,q,e;
		System.out.println("Enter the value of p ");
		p=in.nextInt();
		System.out.println("Enter the value of q");
		q=in.nextInt();
		int n=p*q;
		System.out.println("n is "+n);
		int fn=(p-1)*(q-1);
		System.out.println("phi is "+fn);
		do{
			System.out.println("Enter the value of e which is less than and relatively prime to "+fn);
			 e=in.nextInt();
		}while(gcd(e,fn)!=1);
		System.out.println("The value of e is "+e);
		System.out.println("The public key is {"+e+","+n+"} ");
		int d;
		int k=1;
		while((((fn*k)+1)%e)!=0)
		{
				k++;
		}
		//System.out.println(k);
		d=((fn*k)+1)/e;
		//System.out.println("d is "+d);
		System.out.println("The private key is {"+d+","+n+"} ");
		int msglen=message.length();
		int[] msg=new int[msglen];
		int a;
		String dec="";
		System.out.println("---Encrypting---");
		for(int i=0;i<msglen;i++)
		{
			a=(int)(message.charAt(i));
			msg[i]=enc(a,e,n);
		}
		System.out.println("The Cipher text is:");
		for(int i=0;i<msglen;i++)
			System.out.print(msg[i]+" ");
			System.out.println();	
		System.out.println("The decrypted message is");
		for(int i=0;i<msglen;i++)
		{
			a=enc(msg[i],d,n);
			msg[i]=a;
			dec+=(char)msg[i];
		}
		System.out.println(dec);
	}
	public static int gcd(int m,int n)
	{
		int r;
		while(n!=0){
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
		
		

