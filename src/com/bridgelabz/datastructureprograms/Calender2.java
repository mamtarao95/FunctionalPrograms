package com.bridgelabz.datastructureprograms;

public class Calender2 {
	
	        public static void main(String[] args)
	        {
	            int month=Integer.parseInt(args[0]);
	            int year=Integer.parseInt(args[1]);
	            String[][] a=new String[6][7];
	            int day=1;
	            String[] months = {"","January", "February", "March","April", "May", "June",
	                "July", "August", "September","October", "November", "December"};

	            String[] days = {" S"," M"," T"," W","Th"," F"," Sa"};
	            for(int i=0;i<6;i++) {
	                for(int j=0;j<7;j++)
	                {
	                    a[i][j]="  ";
	                }
	            }
	            for(int i=0;i<6;i++) {
	                for(int j=0;j<7;j++)
	                {
	                    if(dateValidator(day,month,year))
	                    {
	                        j=dayStart(day,month,year);
	                        if(day<10)
	                        {
	                            a[i][j]=" "+day++;
	                        }
	                        else
	                        {
	                            a[i][j]=""+day++;
	                        }
	                    }
	                }
	            }
	            System.out.println(months[month]+" "+year);
	            System.out.println("");
	            for(int i=0;i<7;i++)
	            {
	                System.out.print(days[i]+" ");
	            }
	            System.out.println();
	            for(int i=0;i<6;i++)
	            {
	                for(int j=0;j<7;j++)
	                {
	                    System.out.print(a[i][j]+" ");
	                }
	                System.out.println();
	            }
	        }
	
	public static boolean dateValidator(int day,int month,int year)
	{
	    boolean b=false;
	    if((month==4||month==6||month==9||month==11)&&(day>30))
	    {
	        b=false;
	    }
	    else if(month==2)
	    {
	        if(year%100==0)
	        {
	            if((year%400!=0)&&day>28){
	                b=false;}
	            else if((year%400==0)&&day>29) {
	                b=false;}
	            else
	                b=true;
	            }
	        }
	    if(year%100!=0)
	    {
	        if((year%4!=0)&&day>28){
	            b=true;}
	        else if((year%4==0)&&day>29) {
	            b=false;}
	        else
	        {
	            b=true;
	        }
	    }
	     if(day>31) {
	        b=false;
	    }
	    else
	    {
	        b=true;
	    }
	    return b;
	}
	public static int dayStart(int day,int month,int year)
	{
	    int y0 = year - (14 - month) / 12;
	    int x = y0 + (y0 / 4) - (y0 / 100) + (y0 / 400);
	    int m0 = month + 12 * ((14 - month) / 12) - 2;
	    return ((day + x + (31 * m0) / 12) % 7);
	}


}
