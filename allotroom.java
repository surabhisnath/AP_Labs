//SURABHI S NATH
//2016271
//AP LAB1


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class R	//Reader class
{
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) 
    {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException 
    {
        while ( ! tokenizer.hasMoreTokens() ) 
        {
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException 
    {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException 
    {
        return Double.parseDouble( next() );
    }

}


class Student		//Class student which has all data of the student and also a boolean indicator indicating weather hostel is alloted to the student
{
	private String name;
	private String rollno;
	private String prog;
	private int dist;
	private boolean alloted;
	
	public Student(String n, String rn, String p, int d)
	{
		name=n;
		rollno=rn;
		prog=p;
		dist=d;
		alloted=false;			//when object is created, boolean alloted is set false
	}
	
	
	public String toString()
	{
		return name+" "+rollno+" "+prog+" "+dist;
	}
	
	
	public int getdist()
	{
		return dist;
	}
	
	public void setalloted(boolean v)
	{
		alloted=v;
	}
	
	public boolean getalloted()
	{
		return alloted;
	}
}



public class allotroom 
{
	
	public void bubblesort(Student arr[], int size)		//sorting method to sort Phd, PG, UG students in decreasing order of distance
	{
		for(int i=0; i<size; i++)
		{
			for(int j=0; j<size-i-1; j++)
			{
				if(arr[j+1].getdist()>arr[j].getdist())
				{
					Student temp=arr[j+1];
					arr[j+1]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException
	{
		R.init(System.in);
		
		int num_stud;
		int num_rooms;
		
		num_stud=R.nextInt();
		num_rooms=R.nextInt();
		
		Student arr[]=new Student[num_stud];		//Stores all students
		int c=0;
		
		
		Student phd[]=new Student[num_stud];		//Stores PhD students
		Student PG[]=new Student[num_stud];			//Stores PG students
		Student UG[]=new Student[num_stud];			//Stores UG students
		int d=0, e=0, f=0;
		
		
		for(int i=0; i<num_stud; i++)
		{
			String a=R.reader.readLine();
			String word[]=a.split(" ");
			
			Student st=new Student(word[0], word[1], word[2], Integer.parseInt(word[3]));
			arr[c++]=st;
			
			switch(word[2])						//Put into arrays based on programme (PhD or PG or UG)
			{
				case "PhD": phd[d++]=st;
				break;
				case "PG": PG[e++]=st;
				break;
				case "UG": UG[f++]=st;
				break;
			}
		}
		
		allotroom ob=new allotroom();
		ob.bubblesort(phd, d);
		ob.bubblesort(PG, e);
		ob.bubblesort(UG, f);
		
		
		int phdcount, PGcount;
		
		PGcount=num_rooms/2;
		phdcount=num_rooms-PGcount;
		int UGcount=0;
		
		//Allot rooms and set their boolean alloted as true
		
		if(d>=phdcount)
		{
			for(int z=0; z<phdcount; z++)
			{
				phd[z].setalloted(true);
			}
		}
		
		else
		{
			for(int z=0; z<d; z++)
			{
				phd[z].setalloted(true);
			}
			
			UGcount+=phdcount-d;
		}
		
		
		if(e>=PGcount)
		{
			for(int q=0; q<PGcount; q++)
			{
				PG[q].setalloted(true);
			}
		}
		
		else
		{
			for(int q=0; q<e; q++)
			{
				PG[q].setalloted(true);
			}
			
			UGcount+=PGcount-e;
		}
		
		
		if(f>=UGcount)
		{
			for(int r=0; r<UGcount; r++)
			{
				UG[r].setalloted(true);
			}
		}
		
		else
		{
			for(int r=0; r<f; r++)
			{
				UG[r].setalloted(true);
			}
		}
		
		
		for(int g=0; g<num_stud; g++)			//Iterate over all students in the order as in input and display data of students for whom hostel is alloted
		{
			if(arr[g].getalloted()==true)
				System.out.println(arr[g].toString());
		}

	}

}
