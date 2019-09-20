import java.util.*;
class lab3
{
        public static void main(String[] args)
        {
                int n=0;
                Thread t =new Thread();
                Scanner in =new Scanner(System.in);
                System.out.println("enter the number of packect");
                int pac=in.nextInt();
                System.out.println("enter the output rate");
                int op=in.nextInt();
                System.out.println("enter  the bucket size");
                int siz=in.nextInt();
                System.out.println("enter the timer");
                int timer=in.nextInt();
                int[] input=new int[pac+1];
                for(int i=1;i<=pac;i++)
                {
                        Random r =new Random();
                        int h=r.nextInt(1000);
                        input[i]=h%(siz*100);
                        System.out.println("packet"+i+"size:"+input[i]);
                }
                for(int i=1;i<=pac;i++)
                {
                        System.out.println("packet "+i+" arriving");
                        if(input[i]>siz)
                                System.out.println("packet to large.....non confirming");
                        else if(n+input[i]>siz)
                        {
                                System.out.println("non confirming packet.....bucket overflow");
                        }
                        else
                        {
                        n+=input[i];
                        try{
                        for(int j=1;j<=timer;j++)
                        {
                                Thread.sleep(1000);
                                if(n>op)
                                {

