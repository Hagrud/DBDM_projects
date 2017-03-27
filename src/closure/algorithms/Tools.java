package closure.algorithms;

import closure.data.FD;

public class Tools {
	
	 public static boolean SigmaProve(FD fd, Algorithm algo){
		 algo.setAtts(fd.getLeft());
		 algo.run();
		 return algo.getSet().include(fd.getRight());
	 }

}
