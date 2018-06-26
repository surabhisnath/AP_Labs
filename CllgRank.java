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


class Mess
{
	private float av;
	private float nut;
	private float hy;
	private float del;
	
	
	public Mess(float a, float b, float c, float d)
	{
		av=a;
		nut=b;
		hy=c;
		del=d;
	}
	
	
	public float getav()
	{
		return av;
	}
	
	public float getnut()
	{
		return nut;
	}
	
	public float gethy()
	{
		return hy;
	}
	
	public float getdel()
	{
		return del;
	}
	
	
	
}


class Hostel
{
	private float rmcond;
	private float studfac;
	private float clean;
	private float rec;
	
	public Hostel(float a, float b, float c, float d)
	{
		rmcond=a;
		studfac=b;
		clean=c;
		rec=d;
	}
	
	public float getrmcond()
	{
		return rmcond;
	}
	
	public float getstudfac()
	{
		return studfac;
	}
	
	public float getclean()
	{
		return clean;
	}
	
	public float getrec()
	{
		return rec;
	}
}



class Library 
{
	private float avail;
	private float digfac;
	private float syeff;
	
	public Library(float a, float b, float c)
	{
		avail=a;
		digfac=b;
		syeff=c;
	}
	
	public float getavail()
	{
		return avail; 
	}
	
	public float getdigfac()
	{
		return digfac; 
	}
	
	public float getsyeff()
	{
		return syeff; 
	}
	
	
}


class Academics
{
	private float ki;
	private float dc;
	private float cse;
	
	public Academics(float a, float b, float c)
	{
		ki=a;
		dc=b;
		cse=c;
	}
	
	public float getki()
	{
		return ki;
	}
	
	public float getdc()
	{
		return dc;
	}
	
	public float getcse()
	{
		return cse;
	}
}


class College
{
	private String name;
	private Mess M;
	private Hostel H;
	private Library L;
	private Academics A;
	private long fees;
	private String NAACCert;
	
	private int MessRank;
	private int HostelRank;
	private int LibraryRank;
	private int AcademicsRank;
	private int Rank;
	
	
	public College() throws IOException
	{
		name=Reader.next();
		String in1=Reader.reader.readLine();
		String word1[]=in1.split(" ");
		M=new Mess(Float.parseFloat(word1[1]),Float.parseFloat(word1[2]),Float.parseFloat(word1[3]),Float.parseFloat(word1[4]));
		String in2=Reader.reader.readLine();
		String word2[]=in2.split(" ");
		H=new Hostel(Float.parseFloat(word2[1]),Float.parseFloat(word2[2]),Float.parseFloat(word2[3]),Float.parseFloat(word2[4]));
		String in3=Reader.reader.readLine();
		String word3[]=in3.split(" ");
		L=new Library(Float.parseFloat(word3[1]),Float.parseFloat(word3[2]),Float.parseFloat(word3[3]));
		String in4=Reader.reader.readLine();
		String word4[]=in4.split(" ");
		A=new Academics(Float.parseFloat(word4[1]),Float.parseFloat(word4[2]),Float.parseFloat(word4[3]));
		Reader.next();
		fees=Reader.nextLong();
		Reader.next();
		Reader.next();
		NAACCert=Reader.next();
	}
	
	public String getname()
	{
		return name;
	}
	
	public long getfees()
	{
		return fees;
	}
	
	public String getgrade()
	{
		return NAACCert;
	}
	
	public Mess getM()
	{
		return M;
	}
	
	public Hostel getH()
	{
		return H;
	}
	
	public Library getL()
	{
		return L;
	}
	
	public Academics getA()
	{
		return A;
	}
	
	public void setMRank(int m)
	{
		MessRank=m;
	}
	
	public void setHRank(int h)
	{
		HostelRank=h;
	}
	
	public void setLRank(int l)
	{
		LibraryRank=l;
	}
	
	public void setARank(int a)
	{
		AcademicsRank=a;
	}
	
	public void setRank(int r)
	{
		Rank=r;
	}
	
	public int getMRank()
	{
		return MessRank;
	}
	
	public int getHRank()
	{
		return HostelRank;
	}
	
	public int getLRank()
	{
		return LibraryRank;
	}
	
	public int getARank()
	{
		return AcademicsRank;
	}
	
}




public class CllgRank 
{

	public void mergesort1(College[] arr, int low, int high)
	{
		
		if (low<high) 
		{
			int middle = (low + high) / 2;
			mergesort1(arr, low, middle);
			mergesort1(arr, middle + 1, high);
			merge1(arr, low, middle, high);
		}
	}
	
	public void merge1(College[] arr, int lef, int mid, int rig)
	{
				
		College[] aux=new College[rig+1];
		
		for(int i=0; i<rig+1; i++)
		{
			aux[i]=arr[i];
		}

		for (int i = lef; i <= rig; i++) 
		{
			aux[i] = arr[i];
		}

		int i = lef;
		int j = mid + 1;
		int k = lef;

		while (i <= mid && j <= rig) 
		{
			if(aux[i].getM().getav()==aux[j].getM().getav())
			{
				if(aux[i].getM().getnut()==aux[j].getM().getnut())
				{
					
					if(aux[i].getM().gethy()==aux[j].getM().gethy())
					{
						if(aux[i].getM().getdel()>aux[j].getM().getdel())
						{
							arr[k]=aux[i];
							i++;
						}
						
						else
						{
							arr[k]=aux[j];
							j++;
						}
					}
					
					else if(aux[i].getM().gethy()<aux[j].getM().gethy())
					{
						arr[k]=aux[i];
						i++;
					}
					
					else
					{
						arr[k]=aux[j];
						j++;
					}
					
					
				}
				
				else if(aux[i].getM().getnut()<aux[j].getM().getnut())
				{
					arr[k]=aux[i];
					i++;
				}
				
				else
				{
					arr[k]=aux[j];
					j++;
				}
			}
			
			else if(aux[i].getM().getav()<aux[j].getM().getav())
			{
				arr[k]=aux[i];
				i++;
			}
			
			else
			{
				arr[k]=aux[j];
				j++;
			}
			
			k++;
		}
		
		while (i <= mid) 
		{
			arr[k] = aux[i];
			k++;
			i++;
		}
			
		while (j <= rig) 
		{
			arr[k] = aux[j];
			k++;
			j++;
		}
	
	}
	
	
	
	
	
	
	
	public void mergesort2(College[] arr, int low, int high)
	{
		if (low<high) 
		{
			int middle = (low + high) / 2;
			mergesort2(arr, low, middle);
			mergesort2(arr, middle + 1, high);
			merge2(arr, low, middle, high);
		}
	}
	
	public void merge2(College[] arr, int lef, int mid, int rig)
	{
				
		College[] aux=new College[rig+1];
		
		for(int i=0; i<rig+1; i++)
		{
			aux[i]=arr[i];
		}
		

		for (int i = lef; i <= rig; i++) 
		{
			aux[i] = arr[i];
		}

		int i = lef;
		int j = mid + 1;
		int k = lef;

		while (i <= mid && j <= rig) 
		{
			
			if(aux[i].getH().getrmcond()==aux[j].getH().getrmcond())
			{
				
				
				if(aux[i].getH().getstudfac()==aux[j].getH().getstudfac())
				{
					
					if(aux[i].getH().getclean()==aux[j].getH().getclean())
					{
						if(aux[i].getH().getrec()<aux[j].getH().getrec())
						{
							arr[k]=aux[i];
							i++;
						}
						
						else
						{
							arr[k]=aux[j];
							j++;
						}
					}
					
					else if(aux[i].getH().getclean()<aux[j].getH().getclean())
					{
						arr[k]=aux[i];
						i++;
					}
					
					else
					{
						arr[k]=aux[j];
						j++;
					}
					
					
				}
				
				else if(aux[i].getH().getstudfac()<aux[j].getH().getstudfac())
				{
					arr[k]=aux[i];
					i++;
				}
				
				else
				{
					arr[k]=aux[j];
					j++;
				}
			}
			
			else if(aux[i].getH().getrmcond()<aux[j].getH().getrmcond())
			{
				arr[k]=aux[i];
				i++;
			} 
			
			else
			{
				arr[k]=aux[j];
				j++;
			}
			
			k++;
		}
		
		while (i <= mid) 
		{
			arr[k] = aux[i];
			k++;
			i++;
		}
			
		while (j <= rig) 
		{
			arr[k] = aux[j];
			k++;
			j++;
		}
	
	}
	
	
	
	public void mergesort3(College[] arr, int low, int high)
	{
		
		if (low<high) 
		{
			int middle = (low + high) / 2;
			mergesort3(arr, low, middle);
			mergesort3(arr, middle + 1, high);
			merge3(arr, low, middle, high);
		}
	}
	
	public void merge3(College[] arr, int lef, int mid, int rig)
	{
				
		College[] aux=new College[rig+1];
		
		for(int i=0; i<rig+1; i++)
		{
			aux[i]=arr[i];
		}
		

		for (int i = lef; i <= rig; i++) 
		{
			aux[i] = arr[i];
		}

		int i = lef;
		int j = mid + 1;
		int k = lef;

		while (i <= mid && j <= rig) 
		{
			
			if((aux[i].getL().getavail()+aux[i].getL().getdigfac()+aux[i].getL().getsyeff())/3<(aux[j].getL().getavail()+aux[j].getL().getdigfac()+aux[i].getL().getsyeff())/3)
			{
				arr[k]=aux[i];
				i++;
			} 
			
			else
			{
				arr[k]=aux[j];
				j++;
			}
			
			k++;
		}
		
		while (i <= mid) 
		{
			arr[k] = aux[i];
			k++;
			i++;
		}
			
		while (j <= rig) 
		{
			arr[k] = aux[j];
			k++;
			j++;
		}
	
	}
	
	
	
	public void mergesort4(College[] arr, int low, int high)
	{
		
		if (low<high) 
		{
			int middle = (low + high) / 2;
			mergesort4(arr, low, middle);
			mergesort4(arr, middle + 1, high);
			merge4(arr, low, middle, high);
		}
	}
	
	public void merge4(College[] arr, int lef, int mid, int rig)
	{
				
		College[] aux=new College[rig+1];
		
		for(int i=0; i<rig+1; i++)
		{
			aux[i]=arr[i];
		}
		

		for (int i = lef; i <= rig; i++) 
		{
			aux[i] = arr[i];
		}

		int i = lef;
		int j = mid + 1;
		int k = lef;

		while (i <= mid && j <= rig) 
		{
			if((aux[i].getA().getki()+aux[i].getA().getdc()+2*aux[i].getA().getcse())<(aux[j].getA().getki()+aux[j].getA().getdc()+2*aux[j].getA().getcse()))
			{
				arr[k]=aux[i];
				i++;
			} 
			
			else
			{
				arr[k]=aux[j];
				j++;
			}
			
			k++;
		}
		
		while (i <= mid) 
		{
			arr[k] = aux[i];
			k++;
			i++;
		}
			
		while (j <= rig) 
		{
			arr[k] = aux[j];
			k++;
			j++;
		}
	
	}
	
	
	
	
	public void mergesort5(College[] arr, int low, int high)
	{
		
		if (low<high) 
		{
			int middle = (low + high) / 2;
			mergesort5(arr, low, middle);
			mergesort5(arr, middle + 1, high);
			merge5(arr, low, middle, high);
		}
	}
	
	public void merge5(College[] arr, int lef, int mid, int rig)
	{
				
		College[] aux=new College[rig+1];
		
		for(int i=0; i<rig+1; i++)
		{
			aux[i]=arr[i];
		}
		

		for (int i = lef; i <= rig; i++) 
		{
			aux[i] = arr[i];
		}

		int i = lef;
		int j = mid + 1;
		int k = lef;

		while (i <= mid && j <= rig) 
		{
			
			if(((0.25*aux[i].getMRank())+(0.20*aux[i].getHRank())+(0.25*aux[i].getLRank())+(0.30*aux[i].getARank()))==((0.25*aux[j].getMRank())+(0.20*aux[j].getHRank())+(0.25*aux[j].getLRank())+(0.30*aux[j].getARank())))
			{
				if(aux[i].getfees()==aux[j].getfees())
				{
					if(aux[i].getgrade().compareTo(aux[j].getgrade())>0)
					{
						arr[k]=aux[i];
						i++;
					}
					
					else
					{
						arr[k]=aux[j];
						j++;
					}
				}
				
				else if(aux[i].getfees()>aux[j].getfees())
				{
					arr[k]=aux[i];
					i++;
				}
				
				else
				{
					arr[k]=aux[j];
					j++;
				}
			}
			
			else if(((25*aux[i].getMRank())+(20*aux[i].getHRank())+(25*aux[i].getLRank())+(30*aux[i].getARank()))<((25*aux[j].getMRank())+(20*aux[j].getHRank())+(25*aux[j].getLRank())+(30*aux[j].getARank())))
			{
				arr[k]=aux[i];
				i++;
			} 
			
			else
			{
				arr[k]=aux[j];
				j++;
			}
			
			k++;
		}
		
		while (i <= mid) 
		{
			arr[k] = aux[i];
			k++;
			i++;
		}
			
		while (j <= rig) 
		{
			arr[k] = aux[j];
			k++;
			j++;
		}
	
	}
	
	
	public static void main(String[] args) throws IOException
	{
		Reader.init(System.in);
		int m=Reader.nextInt();
		
		
		College[] arr=new College[m];
		for(int i=0; i<m; i++)
		{
			arr[i]=new College();
		}
		
		
		CllgRank ob=new CllgRank();
		
		ob.mergesort1(arr, 0, m-1);
		
		for(int j=0; j<m; j++)
		{
			arr[j].setMRank(j+1);
		}
		
		ob.mergesort2(arr, 0, m-1);
		
		for(int k=0; k<m; k++)
		{
			arr[k].setHRank(k+1);
		}
		
		ob.mergesort3(arr, 0, m-1);
		
		for(int l=0; l<m; l++)
		{
			arr[l].setLRank(l+1);
		}
		
		ob.mergesort4(arr, 0, m-1);
		
		for(int n=0; n<m; n++)
		{
			arr[n].setARank(n+1);
		}
		
		ob.mergesort5(arr, 0, m-1);
		
		
		for(int z=m-1; z>=0; z--)
		{
			System.out.println(arr[z].getname());
		}

	}

}
