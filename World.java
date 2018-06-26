import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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



abstract class Animal
{
	protected double x;
	protected double y;
	protected int ts;
	protected double health;
	protected int turn;
	protected int num;
	
	public Animal(double a, double b, int c, double d,int n)
	{
		this.x=a;
		this.y=b;
		this.ts=c;
		this.health=d;
		this.num=n;
		this.turn=0;
	}
	
	public abstract double taketurn(Animal one, Animal two, Grassland o, Grassland t);
}



class Herbivore extends Animal
{
	private double gc;
	
	public Herbivore(double a, double b, int c, double d, double e, int n)
	{
		super(a,b,c,d,n);
		this.gc=e;
	}
	
	
	public double taketurn(Animal one, Animal two, Grassland o, Grassland t)
	{
		if(one.health<=0 && two.health<=0)
		{
			
			double a=Math.sqrt((this.x-o.getx())*(this.x-o.getx())+(this.y-o.gety())*(this.y-o.gety()));
			double b=Math.sqrt((this.x-t.getx())*(this.x-t.getx())+(this.y-t.gety())*(this.y-t.gety()));
			
			
			if(a<=o.getradius() || b<=t.getradius())
			{
				
				if(a<=o.getradius())
				{
					x+=5*((t.getx()-x)/b);
					y+=5*((t.gety()-y)/b);
				}
				
				else
				{
					x+=5*((o.getx()-x)/a);
					y+=5*((o.gety()-y)/a);
				}
			}		
			
			else
			{
				Random rand=new Random();
				int w=rand.nextInt(100)+1;
				if(w<=50)
				{
					if(a>b)
					{
						x+=5*((t.getx()-x)/b);
						y+=5*((t.gety()-y)/b);
					}
					
					else
					{
						x+=5*((o.getx()-x)/a);
						y+=5*((o.gety()-y)/a);
					}
				}
			}
				
		}
		
		
		else if(   ((this.x*this.x+this.y*this.y-o.getradius()*o.getradius())>0) && ((this.y*this.y+this.x*this.x-t.getradius()*t.getradius())>0)  )
		{
			Random rand=new Random();
			int w=rand.nextInt(100)+1;
			
			if(w>=6)
			{
				Random rand2=new Random();
				int v=rand2.nextInt(100)+1;
				
				if(v<=65)
				{
					double a=Math.sqrt((this.x-o.getx())*(this.x-o.getx())+(this.y-o.gety())*(this.y-o.gety()));
					double b=Math.sqrt((this.x-t.getx())*(this.x-t.getx())+(this.y-t.gety())*(this.y-t.gety()));
					
					if(a<b)
					{
						x+=5*((o.getx()-x)/a);
						y+=5*((o.gety()-y)/a);
					}
					
					else
					{
						x+=5*((t.getx()-x)/b);
						y+=5*((t.gety()-y)/b);
					}
					
				}
				
				else
				{
					
					double a=Math.sqrt((this.x-one.x)*(this.x-one.x)+(this.y-one.y)*(this.y-one.y));
					double b=Math.sqrt((this.x-two.x)*(this.x-two.x)+(this.y-two.y)*(this.y-two.y));
					
					if(one.health<0)
					{
						x-=4*((two.x-x)/b);
						y-=4*((two.y-y)/b);
					}
					
					else if(two.health<0)
					{
						x-=4*((one.x-x)/a);
						y-=4*((one.y-y)/a);
					}
					
					else
					{
						
						if(a<b)
						{
							x-=4*((one.x-x)/a);
							y-=4*((one.y-y)/a);
						}
						
						else
						{
							x-=4*((two.x-x)/b);
							y-=4*((two.y-y)/b);
						}
					}
				}		
			}
		}
		
		
		
		else if(((this.x*this.x+this.y*this.y-o.getradius()*o.getradius())<=0) || ((this.y*this.y+this.x*this.x-t.getradius()*t.getradius())<=0))
		{
			
			if(((this.x*this.x+this.y*this.y-o.getradius()*o.getradius())<=0))
			{
				
				if(o.getgrass()>=this.gc)
				{
					
					Random r=new Random();
					int h=r.nextInt(100)+1;
					
					if(h<=90)
					{
						this.health+=(this.health/2);
						o.setgrass(o.getgrass()-this.gc);
					}
					
					else
					{
						this.health-=25;
						
						Random q=new Random();
						int i=q.nextInt(100)+1;
						
						double a=Math.sqrt((this.x-one.x)*(this.x-one.x)+(this.y-one.y)*(this.y-one.y));
						double b=Math.sqrt((this.x-two.x)*(this.x-two.x)+(this.y-two.y)*(this.y-two.y));
						
						if(i<=50)
						{
							
							if(one.health<0)
							{
								x-=2*((two.x-x)/b);
								y-=2*((two.y-b)/b);
							}
							
							else if(two.health<0)
							{
								x-=2*((one.x-x)/a);
								y-=2*((one.y-b)/a);
							}
							
							else if(a<b)
							{
								x-=2*((one.x-x)/a);
								y-=2*((one.y-y)/a);
							}
							
							else
							{
								x-=2*((two.x-x)/b);
								y-=2*((two.y-y)/b);
							}
						}
						
						else
						{
							
							double dist=Math.sqrt(((t.getx()-x)*(t.getx()-x))+((t.gety()-y)*(t.gety()-y)));
							
							x+=3*((t.getx()-x)/dist);
							y+=3*((t.gety()-y)/dist);
						}
						
					}
					
				}
				
				else
				{
					Random r=new Random();
					int h=r.nextInt(100)+1;
					
					if(h<=20)
					{
						this.health+=(this.health/5);
						o.setgrass(0);
					}
					
					else
					{
						
						this.health-=25;
						
						Random q=new Random();
						int i=q.nextInt(100)+1;
						
						if(i<=70)
						{
						
							double a=Math.sqrt((this.x-one.x)*(this.x-one.x)+(this.y-one.y)*(this.y-one.y));
							double b=Math.sqrt((this.x-two.x)*(this.x-two.x)+(this.y-two.y)*(this.y-two.y));
						
							if(one.health<0)
							{
								x-=4*((two.x-x)/b);
								y-=4*((two.y-y)/b);
							}
							
							else if(two.health<0)
							{
								x-=4*((one.x-x)/a);
								y-=4*((one.y-y)/a);
							}
							
							else
							{
								if(a<b)
								{
									x-=4*((one.x-x)/a);
									y-=4*((one.y-y)/a);
								}
								
								else
								{
									x-=4*((two.x-x)/b);
									y-=4*((two.y-y)/b);
								}
							}
						}
						
						else
						{
							
							double dist=Math.sqrt(((t.getx()-x)*(t.getx()-x))+((t.gety()-y)*(t.gety()-y)));
							
							x+=2*((t.getx()-x)/dist);
							y+=2*((t.gety()-y)/dist);
							
						}
					}
				}
				
			}
			
			
			else
			{
				if(t.getgrass()>=this.gc)
				{
					Random r=new Random();
					int h=r.nextInt(100)+1;
					if(h<=90)
					{
						this.health+=(this.health/2);
						t.setgrass(t.getgrass()-this.gc);
					}
					
					else
					{
						this.health-=25;
						
						Random q=new Random();
						int i=q.nextInt(100)+1;
						
						double a=Math.sqrt((this.x-one.x)*(this.x-one.x)+(this.y-one.y)*(this.y-one.y));
						double b=Math.sqrt((this.x-two.x)*(this.x-two.x)+(this.y-two.y)*(this.y-two.y));
						
						if(i<=50)
						{
							
							if(one.health<0)
							{
								x-=2*((two.x-x)/b);
								y-=2*((two.y-y)/b);
							}
							
							else if(two.health<0)
							{
								x-=2*((one.x-x)/a);
								y-=2*((one.y=y)/a);
							}
							
							else
							{
								if(a<b)
								{
									x-=2*((one.x-x)/a);
									y-=2*((one.y-y)/a);
								}
								
								else
								{
									x-=2*((two.x-x)/b);
									y-=2*((two.y-y)/b);
								}
							}
							
						}
						
						else
						{
							
							double dist=Math.sqrt(((o.getx()-x)*(o.getx()-x))+((o.gety()-y)*(o.gety()-y)));
							
							
							x+=3*((o.getx()-x)/dist);
							y+=3*((o.gety()-y)/dist);
						}	
					}	
				}
				
				else
				{
					
					Random r=new Random();
					int h=r.nextInt(100)+1;
					
					if(h<=20)
					{
						this.health+=(this.health/5);
						t.setgrass(0);
					}
					
					else
					{
						this.health-=25;
						
						Random q=new Random();
						int i=q.nextInt(100)+1;
						
						if(i<=70)
						{
						
							double a=Math.sqrt((this.x-one.x)*(this.x-one.x)+(this.y-one.y)*(this.y-one.y));
							double b=Math.sqrt((this.x-two.x)*(this.x-two.x)+(this.y-two.y)*(this.y-two.y));
							
							
							if(one.health<0)
							{
								x-=4*((two.x-x)/b);
								y-=4*((two.y-y)/b);
							}
							
							else if(two.health<0)
							{
								x-=4*((one.x-x)/a);
								y-=4*((one.y-y)/a);
							}
							
							else
							{
								if(a<b)
								{
									x-=4*((one.x-x)/a);
									y-=4*((one.y-y)/a);
								}
								
								else
								{

									x-=4*((two.x-x)/b);
									y-=4*((two.y-y)/b);
								}
							}
						}
						
						else
						{
							
							double dist=Math.sqrt(((o.getx()-x)*(o.getx()-x))+((o.gety()-y)*(o.gety()-y)));
							x+=2*((o.getx()-x)/dist);
							y+=2*((o.gety()-y)/dist);
						
						}
					}
				}
			}	
		}
		
		
		
		if(((this.x*this.x+this.y*this.y-o.getradius()*o.getradius())<=0) || ((this.y*this.y+this.x*this.x-t.getradius()*t.getradius())<=0))
			this.turn=0;
		
		else
			this.turn++;
			
			
		if(this.turn>7)
			this.health-=5;
		
		if(this.health>0)
		{
			return this.health;
		}
			
		else
			return -1;
		
		
		
	}
}


class Carnivore extends Animal
{
	public Carnivore(double a, double b, int c, double d, int n)
	{
		super(a,b,c,d,n);
	}
	
	public double taketurn(Animal one, Animal two, Grassland o, Grassland t)
	{
		
		if(one.health<=0 && two.health<=0)
		{
			if(((this.x*this.x+this.y*this.y-o.getradius()*o.getradius())>0) && ((this.y*this.y+this.x*this.x-t.getradius()*t.getradius())>0))
				this.health-=60;
		}
		
		else if( (Math.sqrt((this.x-one.x)*(this.x-one.x)+(this.y-one.y)*(this.y-one.y))<=1 && one.health>0) || (Math.sqrt((this.x-two.x)*(this.x-two.x)+(this.y-two.y)*(this.y-two.y))<=1 && two.health>0))
		{
			
			double q=Math.sqrt((this.x-one.x)*(this.x-one.x)+(this.y-one.y)*(this.y-one.y));
			double w=Math.sqrt((this.x-two.x)*(this.x-two.x)+(this.y-two.y)*(this.y-two.y));
			
			
			if(q<=1 && w<=1)
			{

				
				if(one.health<0)
				{
					this.health+=(0.66*two.health);
					two.health=0;
				}
				
				else if(two.health<0)
				{
					this.health+=(0.66*one.health);
					one.health=0;
				}
				
				
				else
				{
					if(q>w)
					{
						this.health+=(0.66*two.health);
						two.health=0;
					}
						
					else
					{
						this.health+=(0.66*one.health);
						one.health=0;
					}
				}
					
			}
			
			else if(q<=1)
			{
				this.health+=(0.66*one.health);
				one.health=0;
			}
				
			
			else if(w<=1)
			{
				this.health+=(0.66*two.health);
				two.health=0;
			}
		}
		
		
		else if(((this.x*this.x+this.y*this.y-o.getradius()*o.getradius())>0) && ((this.y*this.y+this.x*this.x-t.getradius()*t.getradius())>0))
		{
			Random d=new Random();
			int u=d.nextInt(100)+1;
			
			if(u<=92)
			{
				double a=Math.sqrt((this.x-one.x)*(this.x-one.x)+(this.y-one.y)*(this.y-one.y));
				double b=Math.sqrt((this.x-two.x)*(this.x-two.x)+(this.y-two.y)*(this.y-two.y));
				
				if(one.health<0)
				{
					x+=4*((two.x-x)/b);
					y+=4*((two.y-y)/b);
				}
				
				else if(two.health<0)
				{
					x+=4*((one.x-x)/a);
					y+=4*((one.y-y)/a);
				}
				
				else
				{
					if(a<b)
					{
						x+=4*((one.x-x)/a);
						y+=4*((one.y-y)/a);
					}
					
					else
					{
						x+=4*((two.x-x)/b);
						y+=4*((two.y-y)/b);
					}
				}
			}
			
			else
			{
				this.health-=60;
			}
		}
		
		else if(((this.x*this.x+this.y*this.y-o.getradius()*o.getradius())<=0) || ((this.y*this.y+this.x*this.x-t.getradius()*t.getradius())<=0))
		{
			
			Random d=new Random();
			int u=d.nextInt(100)+1;
			
			if(u<=75)
			{
				double a=Math.sqrt((this.x-one.x)*(this.x-one.x)+(this.y-one.y)*(this.y-one.y));
				double b=Math.sqrt((this.x-two.x)*(this.x-two.x)+(this.y-two.y)*(this.y-two.y));
				
				
				if(one.health<0)
				{
					x+=2*((two.x-x)/b);
					y+=2*((two.y-y)/b);
				}
				
				else if(two.health<0)
				{
					x+=2*((one.x-x)/a);
					y+=2*((one.y-y)/a);
				}
				
				else
				{
					if(a<b)
					{
						x+=2*((one.x-x)/a);
						y+=2*((one.y-y)/a);
					}
					
					else
					{
						x+=2*((two.x-x)/b);
						y+=2*((two.y-y)/b);
					}
				}
				
			}
			
			else
			{
				this.health-=30;
			}
		}
		
		
		
		
		if((Math.sqrt((this.x-one.x)*(this.x-one.x)+(this.y-one.y)*(this.y-one.y))<=5 && one.health>0) || (Math.sqrt((this.x-two.x)*(this.x-two.x)+(this.y-two.y)*(this.y-two.y))<=5 && two.health>0))	
			this.turn=0;
		
		else
			this.turn++;
		
		
		if(this.turn>7)
			this.health-=6;
		
		if(this.health>0)
		{
			return this.health;
		}
		
		else
			return -1;
		
	}
	
	
}


class Grassland
{
	private double x;
	private double y;
	private double radius;
	private double grassavail;
	
	public Grassland(double a, double b, double c, double d)
	{
		this.x=a;
		this.y=b;
		this.radius=c;
		this.grassavail=d;
	}
	
	public double getx()
	{
		return x;
	}
	
	public double gety()
	{
		return y;
	}
	
	public double getradius()
	{
		return radius;
	}
	
	public double getgrass()
	{
		return grassavail;
	}
	
	public void setgrass(double g)
	{
		grassavail=g;
	}
	
}



public class World 
{
	
	int time;
	int maxtimest;
	Comparator<Animal> comp= new AnimalComparator();
	PriorityQueue<Animal> Q=new PriorityQueue<Animal>(4, comp);
	
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		World ob=new World();
		System.out.println("Enter Total Final Time for Simulation: ");
		ob.time=Reader.nextInt();
		
		System.out.println("Enter x, y, centre, radius and Grass Available for First Grassland: ");
		String in1=Reader.reader.readLine();
		String word1[]=in1.split(" ");
		Grassland gl1=new Grassland(Double.parseDouble(word1[0]),Double.parseDouble(word1[1]),Double.parseDouble(word1[2]),Double.parseDouble(word1[3]));
		
		System.out.println("Enter x, y, centre, radius and Grass Available for Second Grassland: ");
		String in2=Reader.reader.readLine();
		String word2[]=in2.split(" ");
		Grassland gl2=new Grassland(Double.parseDouble(word2[0]),Double.parseDouble(word2[1]),Double.parseDouble(word2[2]),Double.parseDouble(word2[3]));
		
		System.out.println("Enter Health and Grass Capacity for Herbiwores: ");
		String in3=Reader.reader.readLine();
		String word3[]=in3.split(" ");
		
		System.out.println("Enter x, y position and timestamp for First Herbivore: ");
		String in4=Reader.reader.readLine();
		String word4[]=in4.split(" ");
		Herbivore h1=new Herbivore(Double.parseDouble(word4[0]),Double.parseDouble(word4[1]),Integer.parseInt(word4[2]),Double.parseDouble(word3[0]),Double.parseDouble(word3[1]),1);
		
		System.out.println("Enter x, y position and timestamp for Second Herbivore: ");
		String in5=Reader.reader.readLine();
		String word5[]=in5.split(" ");
		Herbivore h2=new Herbivore(Double.parseDouble(word5[0]),Double.parseDouble(word5[1]),Integer.parseInt(word5[2]),Double.parseDouble(word3[0]),Double.parseDouble(word3[1]),2);
		
		System.out.println("Enter Health for Carnivore: ");
		double ch=Reader.nextDouble();
		
		System.out.println("Enter x, y position and timestamp for First Carnivore: ");
		String in6=Reader.reader.readLine();
		String word6[]=in6.split(" ");
		Carnivore c1=new Carnivore(Double.parseDouble(word6[0]),Double.parseDouble(word6[0]),Integer.parseInt(word6[2]),ch,1);
		
		System.out.println("Enter x, y position and timestamp for Second Carnivore: ");
		String in7=Reader.reader.readLine();
		String word7[]=in7.split(" ");
		Carnivore c2=new Carnivore(Double.parseDouble(word7[0]),Double.parseDouble(word7[0]),Integer.parseInt(word7[2]),ch,2);
		
		ob.Q.add(h1);
		ob.Q.add(h2);
		ob.Q.add(c1);
		ob.Q.add(c2);
		
		
		
//		System.out.println(ob.Q.remove().ts);
//		System.out.println(ob.Q.remove().ts);
//		System.out.println(ob.Q.remove().ts);
//		System.out.println(ob.Q.remove().ts);		
		
		
		System.out.println("The Simulation Begins - ");
		
		int turns=0;
		ob.maxtimest=Math.max(Math.max(Integer.parseInt(word4[2]),Integer.parseInt(word5[2])),Math.max(Integer.parseInt(word6[2]),Integer.parseInt(word7[2])));
		
		while(ob.Q.size()!=0 && turns<=ob.time)
		{
			
			Animal an=ob.Q.remove();
			
			
			double p;
			if(an instanceof Herbivore)
			{
				if(an.num==1)
					System.out.println("It is First Herbivore");
				else
					System.out.println("It is Second Herbivore");
				p=an.taketurn(c1,c2,gl1,gl2);
				if(p>0)
				{
					System.out.println("Its health after taking turn is: "+p);
					Random newts=new Random();
					int nts=newts.nextInt(ob.time-ob.maxtimest)+ob.maxtimest;
					
					if(nts<ob.time-1)
					{
						ob.maxtimest=nts;
						an.ts=nts;
						an.health=p;
						an.turn++;
						ob.Q.add(an);
					}
					
				}
				
				else
				{
					System.out.println("It is dead");
				}
			}

			else
			{
				if(an.num==1)
					System.out.println("It is First Carnivore");
				else
					System.out.println("It is Second Carnivore");
				
				p=an.taketurn(h1, h2, gl1, gl2);
				if(p>0)
				{
					System.out.println("Its health after taking turn is: "+p);
					Random newts=new Random();
					int nts=newts.nextInt(ob.time-ob.maxtimest)+ob.maxtimest;
					if(nts<ob.time-1)
					{
						ob.maxtimest=nts;
						an.ts=nts;
						an.health=p;
						an.turn++;
						ob.Q.add(an);
					}
				}
				
				else
				{
					System.out.println("It is dead");
				}
			}
				
			turns++;
		}
	}

}

class AnimalComparator implements Comparator<Animal>
{
	@Override
	public int compare(Animal one, Animal two)
	{
		if(one.ts==two.ts)
		{
			if(one.health==two.health)
			{
				if((one instanceof Herbivore && two instanceof Herbivore) || (one instanceof Carnivore && two instanceof Carnivore))
				{
					if(Math.sqrt(one.x*one.x + one.y*one.y) < Math.sqrt(two.x*two.x + two.y*two.y))
					{
						return -1;
					}
					
					else
						return 1;
				}
				
				else if(one instanceof Herbivore)
				{
					return -1;
				}
				
				else
					return 1;
			}
			
			else if(one.health<two.health)
			{
				return 1;
			}
			
			else
				return -1;
		}
		
		else if(one.ts>two.ts)
			return 1;
		else
			return -1;
			
	}
}
