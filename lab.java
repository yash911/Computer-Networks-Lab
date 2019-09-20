import java.util.*;
class lab
{
	public static void main(String[] args)
	{
		String g,dw,tdw,ret,res;
		int lg,ld,flag=1;
		Scanner in =new Scanner(System.in);
		System.out.println("enter the generator and the data word");
		g=in.next();
		dw=in.next();
		ld=dw.length();
		lg=g.length();
		tdw=dw;
		for(int i=0;i<lg-1;i++)
			tdw=tdw.concat("0");
		System.out.println("modified data word:"+tdw);
		ret=crc(tdw,g,lg,ld);
		System.out.println("check sum :"+ret);
		tdw=dw+ret;
		System.out.println("final code word:"+tdw);
		System.out.println("sending........");
		System.out.println("receiving......");
		System.out.println("enter the recieved data");
		res=in.next();
		ret=crc(res,g,lg,ld);
		System.out.println("check sum :"+ret);
		for(int i=0;i<lg-1;i++)
		if(ret.charAt(i)=='0')
			flag=0;
		else
		{
			flag=1;
			break;
		}
		if(flag==0)
			System.out.println("no error");
		else
			System.out.println("error");
	}
	public static String crc(String tdw,String g,int lg,int ld)
	{
		int e=lg;
		String cs=tdw.substring(0,lg); 
		while(e<=lg+ld-1)
		{
		if(cs.charAt(0)=='1')
			cs=XOR(cs,g,lg);
		cs=rem(cs,lg);
		if(e<lg+ld-1)
		cs+=tdw.charAt(e);
		e++;
		}
		return cs;
	}
	
	public static String XOR(String a,String b,int lg)
	{
		String v="";
		for(int i=0;i<lg;i++)
			v+=(a.charAt(i)==b.charAt(i))?'0':'1';
		return v;	
	}	
	public static String rem(String a,int lg)
	{
		String v="";
		for(int i=1;i<lg;i++)
			v+=a.charAt(i);
		return v;
	}	
}
