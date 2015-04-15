import java.util.*
    
    public class ClarkeWrightHeuristic{
	
	public double computeSolution(VRPinstance instance, java.util.List<Tour>solution){
	    int length = solution.getMatrix().length;
	    
	    PriorityQueue heap;
	    initsolution(instance, solution, length, heap);
	    
	    Tour t;
	    t.apprendCustomer(0);
	    int gain = 0;
	    
	    while (!heap.isEmpty()){
		    //on récupère le meilleur gain possible
	    	double tmp[3] = heap.poll();
	    	
	    	//on regarde si la solution est valide
	    	//si elle est valide on continue
	    	//sinon on enlève l'arc et on continue
	    	if (isValid(t,tmp[0],tmp[1])){
	    		t.appendCustomer(tmp[0]);
	    		t.appendCustomer(tmp[1]);
		    	gain+=tmp[2];
	    	}	    
	    }
	    
	    return getDistance(instance,solution);
	}
	
	boolean isValid(Tour t, int i, int j){
		if (!t.getCustomers().contains(i) && !t.getCustomers().contains(j))
			return true;
		
		
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

	
