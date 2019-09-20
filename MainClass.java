import java.util.*;

class MainClass {
	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Enter Data Word");
		String orig_dw = keyboard.next();

		System.out.println("Enter Generating Polynomial");
		String orig_gp = keyboard.next();

		int dw_length = orig_dw.length();
		int gp_length = orig_gp.length();

		String appended_dw = orig_dw;
		for(int i = 0; i < gp_length - 1; i++)
		{
			appended_dw += "0";
		}

		//DEBUGGING MODE
		System.out.println(orig_dw);
		System.out.println(orig_gp);
		System.out.println(dw_length);
		System.out.println(gp_length);
		System.out.println(appended_dw);
	

		String initial_checksum = crc_func(appended_dw, orig_gp);

		String verify_dw = orig_dw + initial_checksum;

		String final_checksum = crc_func(verify_dw, orig_gp);

		int flag = 0;
		for(int i = 0; i < final_checksum.length(); i++)
		{
			if(final_checksum.charAt(i) != '0')
			{
				flag = 1;
			}
		}
		if(flag == 1)
		{
			System.out.println("Error detected");
		}
		else
			System.out.println("No error detected");
	}
	
	public static String crc_func(String dataWord, String generatingPolynomial)
	{
		 
	}
	
	public static String xor_func(String dataword_part, String gp)
	{
		String result = "";
		for(int i = 0; i < gp.length(); i++)
		{
			
		}
	}
}
