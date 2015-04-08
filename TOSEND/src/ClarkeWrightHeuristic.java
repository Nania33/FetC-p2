import java.util.*
    
    public class ClarkeWrightHeuristic{
	
	public double computeSolution(VRPinstance instance, java.util.List<Tour>solution){
	    int length = solution.getMatrix().length;
	    initsolution(instance, solution, length);
	    
	    int capacity = getCapacity();
	    int tmp_capacity;
	    double max_gain = 0;
	    double tmp_gain;
	    int i,j,tmp1, tmp2;
	    Tour a,b;
	    CustomerList first,second;
	    
	    //on essaie les combinaisons à partir de chaque instance
	    while (true){
	    	for (i=0;i<solution.size();i++){
	    		for (j=i+1;j<solution.size();j++){
	    			tmp_capacity = getCapacity(instance,solution.get(i),solution.get(j));
	    			if (tmp_capacity < capacity){
	    				tmp_gain = getGain(instance,solution.get(i),solution.get(j));
	    				if (tmp_gain > max_gain){
	    					max_gain = tmp_gain;
	    					tmp1 = i;
	    					tmp2 = j;
	    				}
	    			}
	    		}
	    	}
	    	
	    	if (max_gain == 0)
	    		break;
	    		
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
	
	public void initSolution(VRPinstance instance , java.util.List<Tour>solution, int length){
	    for (i = 1; i < solution.getMatrix().length ; i++){
		Tour ttmp = Tour(instance , i);
		solution.append(ttmp);
	    }	    	    
	}
}

	
