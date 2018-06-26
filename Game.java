import java.io.*;
import java.lang.*;
import java.util.*;


class Reader 
{
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input));
        tokenizer = new StringTokenizer("");
    }
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() ); 
    }
    
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}	


class Creature
{
	
	protected int var;
	protected String name;
	protected int power;
	protected int health;
	protected int cost;
	protected int asset;
	
	public Creature()
	{
		
	}
	
	public Creature(String n, int c, int a, int p, int h)
	{
		name=n;
		cost=c;
		asset=a;
		power=p;
		health=h;
	}
	
	
	public int attack(Creature a)
	{
		Random rand = new Random();
		int x = rand.nextInt(this.power+1);
		a.health-=x;
		return x;
	}
}


class Human extends Creature
{
	public Human(String name, int cost, int asset, int power, int health)
	{
		super(name, cost, asset, power, health);
	}
}

class Dragon extends Creature
{
	public Dragon(String name, int cost, int asset, int power, int health)
	{
		super(name, cost, asset, power, health);
	}
	
	@Override
	public int attack(Creature a)
	{
		super.attack(a);
		Random rand = new Random();
		int x = rand.nextInt(100)+1;
		if(x<=15)
			a.health-=25;
		return x;
	}
}

class Deamon extends Creature
{
	public Deamon(String name, int cost, int asset, int power, int health)
	{
		super(name, cost, asset, power, health);
	}
	
	@Override
	public int attack(Creature a)
	{
		int val=super.attack(a);
		Random rand = new Random();
		int x = rand.nextInt(100)+1;
		if(x<=50)
			a.health-=val;
		return x;
	}
}

class Wolf extends Creature
{
	public Wolf(String name, int cost, int asset, int power, int health)
	{
		super(name, cost, asset, power, health);
	}
}

class IceDragon extends Dragon
{
	public IceDragon(String name, int cost, int asset, int power, int health)
	{
		super(name, cost, asset, power, health);
	}
	
	@Override
	public int attack(Creature a)
	{
		super.attack(a);
		Random rand = new Random();
		int x = rand.nextInt(100)+1;
		if(x<=5)
			a.health-=rand.nextInt(this.power+1);
		return x;
	}
	
}

class FireDragon extends Dragon
{
	public FireDragon(String name, int cost, int asset, int power, int health)
	{
		super(name, cost, asset, power, health);
	}
}


class Team
{
	private int cost;
	ArrayList<Creature> arr=new ArrayList<Creature>();
	
	public void setCost(int c)
	{
		cost=c;
	}
	
	public int getCost()
	{
		return cost;
	}
	
}


public class Game 
{

	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		
		Team objTeamA= new Team();
		Team objTeamB= new Team();
		
		System.out.println("Enter team Good's total money: ");
		objTeamA.setCost(Reader.nextInt());
		
		System.out.println("Enter team Bad's total money: ");
		objTeamB.setCost(Reader.nextInt());
		
		System.out.println("Enter cost, asset , power and health for Human: ");
		String in1=Reader.reader.readLine();
		String word1[]=in1.split(" ");
		
		
		System.out.println("Enter cost, asset , power and health for Fire Dragon: ");
		String in2=Reader.reader.readLine();
		String word2[]=in2.split(" ");
		
		
		System.out.println("Enter cost, asset , power and health for Ice Dragon: ");
		String in3=Reader.reader.readLine();
		String word3[]=in3.split(" ");
		
		
		System.out.println("Enter cost, asset , power and health for Deamon: ");
		String in4=Reader.reader.readLine();
		String word4[]=in4.split(" ");
		
		
		System.out.println("Enter cost, asset , power and health for Wolf: ");
		String in5=Reader.reader.readLine();
		String word5[]=in5.split(" ");
		
		
		

		
		int minimum=Math.min(Integer.parseInt(word1[0]),Integer.parseInt(word2[0]));
		int m=Math.min(minimum, Integer.parseInt(word5[0]));
		
		int option=0;
		while(objTeamA.getCost()>=m && option!=4)
		{
			System.out.println("Select Creatures For Team Good: ");
			System.out.println("1. Human");
			System.out.println("2. Fire Dragon");
			System.out.println("3. Wolf");
			System.out.println("4. Exit Selection");
			
			option=Reader.nextInt();
			
			switch(option)
			{
				case 1: System.out.println("Enter name of Human: ");
						String n=Reader.next();
						Human obj=new Human(n,Integer.parseInt(word1[0]),Integer.parseInt(word1[1]),Integer.parseInt(word1[2]),Integer.parseInt(word1[3]));
						objTeamA.arr.add(obj);
						objTeamA.setCost(objTeamA.getCost()-Integer.parseInt(word1[0]));
						break;
						
				case 2: System.out.println("Enter name of Fire Dragon: ");
						String p=Reader.next();
						FireDragon obj1=new FireDragon(p,Integer.parseInt(word2[0]),Integer.parseInt(word2[1]),Integer.parseInt(word2[2]),Integer.parseInt(word2[3]));
						objTeamA.arr.add(obj1);
						objTeamA.setCost(objTeamA.getCost()-Integer.parseInt(word2[0]));
						break;
				
				case 3: System.out.println("Enter name of Wolf: ");
						String q=Reader.next();
						Wolf obj2=new Wolf(q,Integer.parseInt(word5[0]),Integer.parseInt(word5[1]),Integer.parseInt(word5[2]),Integer.parseInt(word5[3]));
						objTeamA.arr.add(obj2);
						objTeamA.setCost(objTeamA.getCost()-Integer.parseInt(word5[0]));
						break;
				
				case 4: break;
			}
		}
		
		
		
		
		int m2=Math.min(Integer.parseInt(word3[0]),Integer.parseInt(word4[0]));
		
		int option2=0;
		while(objTeamB.getCost()>=m2 && option2!=3)
		{
			System.out.println("Select Creatures For Team Bad: ");
			System.out.println("1. Daemon");
			System.out.println("2. Ice Dragon");
			System.out.println("3. Exit Selection");
			
			option2=Reader.nextInt();
			
			switch(option2)
			{
				case 1: System.out.println("Enter name of Daemon: ");
						String n=Reader.next();
						Deamon obj=new Deamon(n,Integer.parseInt(word4[0]),Integer.parseInt(word4[1]),Integer.parseInt(word4[2]),Integer.parseInt(word4[3]));
						objTeamB.arr.add(obj);
						objTeamB.setCost(objTeamB.getCost()-Integer.parseInt(word4[0]));
						break;
						
				case 2: System.out.println("Enter name of Ice Dragaon: "); 
						String p=Reader.next();
						IceDragon obj1=new IceDragon(p,Integer.parseInt(word3[0]),Integer.parseInt(word3[1]),Integer.parseInt(word3[2]),Integer.parseInt(word3[3]));
						objTeamB.arr.add(obj1);
						objTeamB.setCost(objTeamB.getCost()-Integer.parseInt(word3[0]));
						break;
				
				case 3: break;
			}	
		}
		
		
		
		
		
		
		
		
		
		System.out.println("The War Begins - ");
		int RC=1;
		int temp1=1,temp2=1;
		

		Creature param1=new Creature();
		Creature param2=new Creature();
		
		while(true)
		{
			 if( (objTeamA.arr.size()==0 && objTeamA.getCost()<m) || (objTeamB.arr.size()==0 && objTeamB.getCost()<m2) )
				 break;
			 
			 
			 
			 if(temp1==1)
			 {
				 System.out.println("Enter Creature from Good’s Team to fight in the war - ");
				 String a=Reader.next(); 
				 
				 for(int l=0; l<objTeamA.arr.size(); l++)
				 {
					 if((objTeamA.arr.get(l).name).equals(a))
					 {
						 param1=new Creature();
						 param1=objTeamA.arr.get(l);
						 objTeamA.arr.remove(l);
					 }
				 }
			 }
			 
			 
			 if(temp2==1)
			 {
				 System.out.println("Enter Creature from Bad’s Team to fight in the war - ");
				 String b=Reader.next();
				 
				 for(int h=0; h<objTeamB.arr.size(); h++)
				 {
					 if((objTeamB.arr.get(h).name).equals(b))
					 {
						 param2=new Creature();
						 param2=objTeamB.arr.get(h);
						 objTeamB.arr.remove(h);
					 }
				 }
			 }

			 
			 
			 
			 while(true)
			 {
				 
				 System.out.println("Round "+RC);
				 
				 
				 param1.attack(param2);
				 
				 param2.attack(param1);
				 
				 
				 
				 if(param1.health>0 && param2.health>0)
				 {
					 System.out.println("No winner or loser");
					 System.out.println("Money of Team Good: "+objTeamA.getCost());
					 System.out.println("Money of Team Bad: "+objTeamB.getCost());
					 temp1=2;
					 temp2=2;
					 RC++;
					 continue;
				 }
				 
				 else if(param1.health<=0 && param2.health<=0)
				 {
					 System.out.println("No winner or loser");
					 System.out.println("Money of Team Good: "+objTeamA.getCost());
					 System.out.println("Money of Team Bad: "+objTeamB.getCost());
					 temp1=1;
					 temp2=1;
					 RC++;
					 break;
				 }
				 
				 else
				 {
					 if(param2.health>0 && param1.health<0)
					 {
						 System.out.println(param1.name+" lose in Round "+RC);
						 temp1=1;
						 temp2=2;
						 RC++;
						 objTeamB.setCost(objTeamB.getCost()+param2.asset);
						 System.out.println("Money of Team Good: "+objTeamA.getCost());
						 System.out.println("Money of Team Bad: "+objTeamB.getCost());
					 }
						 
					 else
					 {
						 System.out.println(param2.name+" lose in Round "+RC);
						 temp1=2;
						 temp2=1;
						 RC++;
						 objTeamA.setCost(objTeamA.getCost()+param1.asset);
						 System.out.println("Money of Team A: "+objTeamA.getCost());
						 System.out.println("Money of Team B: "+objTeamB.getCost());
					 }
						 
					 break;
				 } 
			 }
			 
			if( (objTeamA.arr.size()==0 && objTeamA.getCost()<m) || (objTeamB.arr.size()==0 && objTeamB.getCost()<m2) )
				 break;
			
			
			int opt=0;
			while(objTeamA.getCost()>=m && opt!=4)
			{
				System.out.println("Select Creatures For Team Good: ");
				System.out.println("1. Human");
				System.out.println("2. Fire Dragon");
				System.out.println("3. Wolf");
				System.out.println("4. Exit Selection");
						
				opt=Reader.nextInt();
						
				switch(opt)
				{
					case 1: System.out.println("Enter name of Human: ");
							String n=Reader.next();
							Human obj=new Human(n,Integer.parseInt(word1[0]),Integer.parseInt(word1[1]),Integer.parseInt(word1[2]),Integer.parseInt(word1[3]));
							objTeamA.arr.add(obj);
							objTeamA.setCost(objTeamA.getCost()-Integer.parseInt(word1[0]));
							break;
									
					case 2: System.out.println("Enter name of Fire Dragon: ");
							String p=Reader.next();
							FireDragon obj1=new FireDragon(p,Integer.parseInt(word2[0]),Integer.parseInt(word2[1]),Integer.parseInt(word2[2]),Integer.parseInt(word2[3]));
							objTeamA.arr.add(obj1);
							objTeamA.setCost(objTeamA.getCost()-Integer.parseInt(word2[0]));
							break;
							
					case 3: System.out.println("Enter name of Wolf: ");
							String q=Reader.next();
							Wolf obj2=new Wolf(q,Integer.parseInt(word5[0]),Integer.parseInt(word5[1]),Integer.parseInt(word5[2]),Integer.parseInt(word5[3]));								objTeamA.arr.add(obj2);
							objTeamA.setCost(objTeamA.getCost()-Integer.parseInt(word5[0]));
							break;
							
					case 4: break;
				}
			}
			
			
			int opt2=0;
			while(objTeamB.getCost()>=m2 && opt2!=3)
			{
				System.out.println("Select Creatures For Team Bad: ");
				System.out.println("1. Daemon");
				System.out.println("2. Ice Dragon");
				System.out.println("3. Exit Selection");
				
				opt2=Reader.nextInt();
				
				switch(opt2)
				{
					case 1: System.out.println("Enter name of Daemon: ");
							String n=Reader.next();
							Deamon obj=new Deamon(n,Integer.parseInt(word4[0]),Integer.parseInt(word4[1]),Integer.parseInt(word4[2]),Integer.parseInt(word4[3]));
							objTeamB.arr.add(obj);
							objTeamB.setCost(objTeamB.getCost()-Integer.parseInt(word4[0]));
							break;
							
					case 2: System.out.println("Enter name of Ice Dragaon: "); 
							String p=Reader.next();
							IceDragon obj1=new IceDragon(p,Integer.parseInt(word3[0]),Integer.parseInt(word3[1]),Integer.parseInt(word3[2]),Integer.parseInt(word3[3]));
							objTeamB.arr.add(obj1);
							objTeamB.setCost(objTeamB.getCost()-Integer.parseInt(word3[0]));
							break;
					
					case 3: break;
				}	
			}
				 
		}
		
		if(objTeamA.getCost()<m && objTeamA.arr.size()==0)
		{
			System.out.println("Team Bad wins the war. The money the team has is "+objTeamB.getCost());
		}
		
		else
		{
			System.out.println("Team Good wins the war. The money the team has is "+objTeamA.getCost());
		}

	}

}
