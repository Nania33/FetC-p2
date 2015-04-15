import java.util.*
    
    public class ClarkeWrightHeuristic{
	
	public double computeSolution(VRPinstance instance, java.util.List<Tour>solution){
	    int length = solution.getMatrix().length;
	    
	    PriorityQueue heap;
	    initsolution(instance, solution, length, heap);
	    
	    Tour t;
	    
	    
	    while (!heap.isEmpty()){
		    //on récupère le meilleur gain possible
	    	double tmp[3] = heap.poll();
	    	
	    	//on ajoute l'arc concerné au tour
	    	
	    	//on regarde si la solution est valide
	    	
	    	//si elle est valide on continue
	    	
	    	//sinon on enlève l'arc et on continue
	    
	    
	    
	    }
	    
	    return getDistance(instance,solution);
	}
	
	public int getCapacity(VRPinstance instance, Tour a, Tour b){
		int capacity;
		CustomList<Integer> customers = a.getCustomers();
		Iterator itr = customers.iterator();
		ArrayList<Integer> visited = new ArrayList<Integer>();
		
		while (itr.hasNext()){
			if (!visited.contains(itr)){
				capacity += instance.getDemand(itr);
				visited.add(itr);
			}
			itr.next();
		}
		
		customers = b.getCustomers();
		itr = customers.iterator();
		while (itr.hasNext()){
			if (!visited.contains(itr)){
				capacity += instance.getDemand(itr);
				visited.add(itr);
			}
			itr.next();
		}
		
		return capacity;
	}
	  
	public double getGain(VRPinstance instance, Tour a, Tour b){
		double disOA, disOB, disAB;
		double[][] matrix = instance.getMatrix();
		Customer c1,c2;
		c1 = a.getFirstCustomer();
		c2 = a.getLastCustomer();
		disOA = matrix[c1][c2];
		
		c1 = b.getFirstCustomer();
		c2 = b.getLastCustomer();
		disOB = matrix[c1][c2];
		
		c1 = a.getFirstCustomer();
		c2 = b.getLastCustomer();
		disAB = matrix[c1][c2];
		
		return disOA + disOB - disAB;
	}
	
	public void initSolution(VRPinstance instance , java.util.List<Tour>solution, int length, PriorityQueue heap){
	    double gain;
		for (i = 1; i < solution.getMatrix().length ; i++){
	    	for (j=i+1;j<solution.getMatrix().length;j++){
	    		gain = solution.getMatrix[0][i] + solution.getMatrix()[0][j] - solution.getMatrix[i][j];
	    		double add1[3];
	    		add1[0]=i;
	    		add1[1]=j;
	    		add1[2]=gain;
	    		double add2[3];
	    		add2[0]=j;
	    		add2[1]=i;
	    		add2[2]=gain;
	    		head.add(add1);
	    		heap.add(add2);
	    	}
	    }
	}
}

	
