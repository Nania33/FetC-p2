import java.util.*
    
    public class ClarkeWrightHeuristic{
	
	public double computeSolution(VRPinstance instance, java.util.List<Tour>solution){
	    int length = solution.getMatrix().length;
	    initsolution(instance, solution, length);
	    
	    
	    
	}
	
	public void initSolution(VRPinstance instance , java.util.List<Tour>solution, int length){
	    for (i = 1; i < solution.getMatrix().length ; i++){
		Tour ttmp = Tour(instance , i);
		solution.append(ttmp);
	    }	    	    
	}
	
    }

}

	
