import java.util.*;
class Leaky
{
	public static void main(String []args)
	{
		Scanner in=new Scanner(System.in);
		int csize=0;
		System.out.println("enter the no of packets");
		int  n=in.nextInt();
		System.out.println("enter the bucket size");
		int  size=in.nextInt();
		System.out.println("enter the output rate");
		int  or=in.nextInt();
		System.out.println("enter the timer");
		int  timer=in.nextInt();
		Random r=new Random();
		for(int i=0;i<n;i++)
		{
			int psize=r.nextInt(size+100);
			System.out.println("new packet arrived");
			System.out.println("packet number: "+(i+1)+", packet size="+psize);
			if(psize>size)
			{
				System.out.println("packet too large....\nnon confirming packet");
			}
			else if((psize+csize)>size)
			{
				System.out.println("bucket overflow....\nnon confirming packet");
			}
			else
			{
				csize+=psize;
			}
			for(int j=0;j<timer;j++)
			{
				if(size>or)
				{
					System.out.println(or+" bytes transmitted");
					csize=or;
				}
				else if(csize==0)
				{
					System.out.println("bucket empty...\n no bytes to transmit");
				}
				else
				{
					System.out.println("remaining "+csize+" bytes transmitted");
					csize=0;
				}
			}
			System.out.println("timer expired");
			if(csize!=0)
			{
				System.out.println(csize+" bytes still remain in the bucket");
			}
		}
		System.out.println("no more new packets");
		if(csize!=0)
		{
			System.out.println("transmission of "+csize+" bytes remaining in bucket is starting");
		}
		while(csize>0)
		{
			if(csize>or)
			{
				System.out.println(or+" bytes transmited");
				csize=or;
			}
			else
			{
				System.out.println("remaining "+csize+" bytes transmitted");
				csize=0;
			}
		}
		System.out.println("bucket empty.....\n transmission complete");
	}
}
