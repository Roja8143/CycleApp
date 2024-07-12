package com.edubridge.CycleApp;

    import java.util.List;
	import java.util.Scanner;

	import com.edubridge.CycleApp.Dao.CycleDaoImpl;
	import com.edubridge.CycleApp.model.Cycle;
	import com.edubridge.CycleApp.Dao.CycleDao;

	public class App {
		public static void main( String[] args )
	    {
	    	CycleDao dao=new CycleDaoImpl();
	        Scanner in = new Scanner(System.in);
	        while(true) {
	        	System.out.println("MY CYCLE APP");
	        	System.out.println("1. ADD  ALL CYCLE");
	        	System.out.println("2. VIEW CYCLE");
	        	System.out.println("3. SEARCH CYCLE");
	        	System.out.println("4.UPDATE CYCLE");
	        	System.out.println("5. DELETE ALL CYCLE");
	        	System.out.println("PLEASE CHOOSE OPTION:");
	        	int option = in.nextInt();
	        	
	        	
	        	switch (option) {
	        case 1:
	        		System.out.println("please enter cycle categories:");
	    			String categories=in.next();
	    			System.out.println("please enter cycle name:");
	    			String name=in.next();
	    			System.out.println("please enter cycle price:");
	    			int price=in.nextInt();
	    			System.out.println("please enter cycle colour");
	    			String colour=in.next();
	    			
	    			Cycle newCycle=new Cycle();
	    			newCycle.setCategories(categories);
	    			newCycle.setName(name);
	    			newCycle.setPrice(price);
	    			newCycle.setColour(colour);
	    			
	    			int status=dao.addCycle(newCycle);
	    			if(status>=1) {
	    				System.out.println("New cycle saved!!!");
	    			}else {
	    				System.out.println("Something went wrong!!!");
	    			}
	    			break;
	        	case 2:
	        		
	        		
	        		List<Cycle> cycles=dao.getAllCycles();
	    			if(cycles.size() != 0) {
	    				for(Cycle c : cycles) {
	    					System.out.println(c.getCategories()+"\t"+c.getName()+"\t"+c.getPrice()+"\t"+c.getColour());
	    				}
	    			}else {
	    				System.out.println("no cycle found");
	    				}
	    			
	    			break;
	             case 0:
	               	System.out.println("Bye!!");
	        		break;
	        	 default:
	        		System.out.println("invalid Option!!!");
	        		break;
	        		
	        	}
	        	
	        	}
	        	
	        }
	    }



