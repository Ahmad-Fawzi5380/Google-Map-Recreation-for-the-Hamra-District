import java.util.*;


class Connecting_Points {

    public String name;
    public String Kind;
    public double X;
    public double Y;
    public int ID;

    public Connecting_Points(String name, String Kind, double X, double Y,int ID) {
        this.name = name;
        this.Kind = Kind;
        this.X = X;
        this.Y = Y;
        this.ID=ID;
    }

    @Override
    public String toString() {
        return this.name + ", (" + this.X + "," + this.Y + "), " + this.Kind;
    }
}

   

public class Main {
	
	public static List<List<Integer>> E= new ArrayList<>(33);
	
	public static void Buildthemap(Connecting_Points V[]) {
		V[0] = new Connecting_Points("Barbar-Hamra", "Restaurant", 5.9, 5.8,0);
        V[1] = new Connecting_Points("Emile Edde Intersection 1", "Intersection", 0.6, 6.3,1);
        V[2] = new Connecting_Points("Emile Edde Intersection 2", "Intersection", 3.5, 6.4,2);
        V[3] = new Connecting_Points("Emile Edde Intersection 3", "Intersection", 6.1, 6.4,3);
        V[4] = new Connecting_Points("Emile Edde Intersection 4", "Intersection", 10.4, 6.0,4);
        V[5] = new Connecting_Points("Baalbak Intersection 1", "Intersection", 0.8, 5.3,5);
        V[6] = new Connecting_Points("Baalbak Intersection 2", "Intersection", 3.7, 5.6,6);
        V[7] = new Connecting_Points("Hamra Intersection 1", "Intersection", 0.9, 3.7,7);
        V[8] = new Connecting_Points("Hamra Intersection 2", "Intersection", 3.9, 4.3,8);
        V[9] = new Connecting_Points("Hamra Intersection 3", "Intersection", 6.3, 4.6,9);
        V[10] = new Connecting_Points("Hamra Intersection 4", "Intersection", 10.0, 4.9,10);
        V[11] = new Connecting_Points("Hamra Intersection 5", "Intersection", 10.3, 4.9,11);
        V[12] = new Connecting_Points("Player One", "Arcade", 2.0, 3.8,12);
        V[13] = new Connecting_Points("Sushi Bell intersection", "Intersection", 1.0, 3.0,13);
        V[14] = new Connecting_Points("Sushi Bell", "Restaurant", 1.6, 3.0,14);
        V[15] = new Connecting_Points("Hamra Street intersection", "Intersection", 3.9, 3.4,15);
        V[16] = new Connecting_Points("Makdisi intersection", "Intersection", 6.5, 3.8,16);
        V[17] = new Connecting_Points("Sidani intersection 1", "Intersection", 1.2, 1.7,17);
        V[18] = new Connecting_Points("Sidani intersection 2", "Intersection", 4.2, 1.7,18);
        V[19] = new Connecting_Points("Lima Gelato", "Restaurant", 4.2, 2.2,19);
        V[20] = new Connecting_Points("Souraty intersection 1", "Intersection", 6.8, 2.6,20);
        V[21] = new Connecting_Points("Souraty intersection 2", "Intersection", 8.1, 3.0,21);
        V[22] = new Connecting_Points("Souraty intersection 3", "Intersection", 9.4, 3.4,22);
        V[23] = new Connecting_Points("Souraty intersection 4", "Intersection", 10.5, 3.7,23);
        V[24] = new Connecting_Points("Bliss intersection 1", "Intersection", 1.3, 0.6,24);
        V[25] = new Connecting_Points("Bliss intersection 2", "Intersection", 4.4, 0.0,25);
        V[26] = new Connecting_Points("Bliss intersection 3", "Intersection", 6.7, 0.2,26);
        V[27] = new Connecting_Points("Dr. Mohammad Jomaa Clinic", "Clinic", 7.1, 0.6,27);
        V[28] = new Connecting_Points("Makhoul Intersection", "Intersection", 7.1, 1.0,28);
        V[29] = new Connecting_Points("Clemencea Intersection", "Intersection", 10.2, 1.0,29);
        V[30] = new Connecting_Points("AUBMC", "Hospital", 8.5, 1.7,30);
        V[31] = new Connecting_Points("Right AUBMC intersection", "Intersection", 9.9, 2.0,31);
        V[32] = new Connecting_Points("Eyedeas Smart Optics", "Optics shop", 4.3, 1.1,32);
        
        Connect(0,9);
        Connect(1,2);
        Connect(1,5);
        Connect(2,3);
        Connect(2,6);
        Connect(3,0);
        Connect(3,4);
        Connect(4,11);
        Connect(5,6);
        Connect(5,7);
        Connect(6,0);
        Connect(6,8);
        Connect(7,12);
        Connect(7,13);
        Connect(8,12);
        Connect(8,9);
        Connect(9,16);
        Connect(9,10);
        Connect(10,11);
        Connect(11,23);
        Connect(13,14);
        Connect(13,17);
        Connect(14,15);
        Connect(15,16);
        Connect(15,19);
        Connect(16,20);
        Connect(17,18);
        Connect(17,24);
        Connect(18,32);
        Connect(18,20);
        Connect(19,18);
        Connect(20,28);
        Connect(20,21);
        Connect(21,30);
        Connect(21,22);
        Connect(22,23);
        Connect(22,31);
        Connect(24,25);
        Connect(25,26);
        Connect(26,29);
        Connect(27,26);
        Connect(28,27);
        Connect(28,30);
        Connect(30,31);
        Connect(31,29);
        Connect(32,25);  
	}

	static class Node implements Comparable<Node>{
		int city;
		double dist;
		
		public Node(int a, double b) {
			city=a;
			dist=b;
		}

		@Override
		public int compareTo(Node other) {
			// TODO Auto-generated method stub
			return Double.compare(dist, other.dist);
		}

    
    

	}
	
	public static double Distance(Connecting_Points A, Connecting_Points B) {
        double X = Math.pow(B.X - A.X, 2);
        double Y = Math.pow(B.Y - A.Y, 2);
        return Math.sqrt(X + Y);
    }
    
    public static void Path(int start,int end,Connecting_Points V[]) {
     
        PriorityQueue<Node> Q=new PriorityQueue<>();
		
		double dist[]=new double[33];
		int prev[]=new int[33];
		
		
		Arrays.fill(prev, -1);
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[start]=0;
		prev[start]=0;
		
		Q.add(new Node(start,0));
		
       while(!(Q.isEmpty())) {
			
			Node temp=Q.poll();
			
			int u=temp.city;
			
			if(temp.dist>dist[u]) continue;
			
			for(Integer j : E.get(u)) {
				double cost=Distance(V[j],V[u]);
				
				int v=j;
				
				if(dist[u]+cost<dist[v]) {
					
					dist[v]=dist[u]+cost;
					
					prev[v]=u;
					
					Q.add(new Node(v,dist[v]));
				}
			}
				
		}
       
       //for(int i : prev) {
     //   System.out.print(i+" ");
     //  }
       
       PrintPath(start,end,dist,prev,V);

     
    }
    
    public static String GetDirection(Connecting_Points A, Connecting_Points B) {
        double angle = Math.toDegrees(Math.atan2(B.Y - A.Y, B.X - A.X));

        if (angle < 0) angle += 360;

        if (angle >= 45 && angle < 135) return "South";
        if (angle >= 135 && angle < 225) return "West";
        if (angle >= 225 && angle < 315) return "North";
        return "East";
    }
	
    public static void PrintPath(int start, int end, double dist[], int prev[], Connecting_Points V[]) {
        ArrayList<Integer> Arr2 = new ArrayList<>();

        for (int i = end; i != start; i = prev[i]) {
            Arr2.add(i);

            if (prev[i] == -1) {
                System.out.println("No path found.");
                return;
            }
        }
        Arr2.add(start);

        Collections.reverse(Arr2);

        System.out.println("Start at " + V[start].name);

        for (int i = 1; i < Arr2.size(); i++) {
            int prevNode = Arr2.get(i - 1);
            int currNode = Arr2.get(i);

            double distance = Distance(V[prevNode], V[currNode]);
            String direction = GetDirection(V[prevNode], V[currNode]);

            System.out.println("Go " + String.format("%.2f", distance) + " meters " +
                               direction + " to " + V[currNode].name);
        }
    }
	
    public static void Connect(int a, int b) {
     E.get(a).add(b);
     E.get(b).add(a);
    }
	
	public static int FindLocation(String location, Connecting_Points V[]) {
		for(Connecting_Points i : V) {
			if(i.name.equals(location)) {
				
				System.out.println("Location found!");
				return i.ID;
			}
		}
		
		System.out.println("Not found, please type the name correctly");
		
		return -1;
	}
	
	public static void main(String[] args) {
	 
		    Scanner scan= new Scanner(System.in);

		    Connecting_Points V[] = new Connecting_Points[33];

		    
		    for (int i = 0; i < 33; i++) {
		     E.add(new ArrayList<>());
		    }
		    
		    Buildthemap(V);
		    
		    System.out.println();
		    
		    System.out.println("Hello!");
		    System.out.println("What do you want to do?");
		    System.out.println("1-Print all the Connecting Points");
		    System.out.println("2-Print all the Edges");
		    System.out.println("3-Find a path to a location");
		    System.out.println("Type the number of what you want to do:");
		    int choice= scan.nextInt();
		    
		    if(choice==1) {
		     for (Connecting_Points i : V) {
		         System.out.println(i);
		     }
		    }
		    else if(choice==2) {
		     for (int i = 0; i < 33; i++) {
		         for (int j = 0; j < E.get(i).size(); j++) {
		             int neighborIndex = E.get(i).get(j);
		             System.out.printf("(%s, %s, %.2f)%n",
		                     V[i].name, V[neighborIndex].name, Distance(V[i], V[neighborIndex]));
		         }
		     }
		    }
		    
		    else if(choice==3) {
		     System.out.println("Type the name of your location (Please type it correctly).");
		     scan.nextLine();
		     String location = scan.nextLine();
		     int L=FindLocation(location,V);
		     if(L!=-1) {
				System.out.println("Type the name of your destination (Please type it correctly).");
				String destination= scan.nextLine();
				int D=FindLocation(destination,V);
				if(D!=-1) {
					Path(L,D,V);
				}
		     }
			
		    }
    
    }
}