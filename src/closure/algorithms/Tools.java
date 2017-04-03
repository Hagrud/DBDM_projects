package closure.algorithms;

import java.util.SortedSet;

import closure.data.AttributeSet;
import closure.data.FD;

public class Tools {
	
	 public static boolean SigmaProve(FD fd, Algorithm algo){
		 algo.setAtts(fd.getLeft());
		 algo.run();
		 return algo.getSet().include(fd.getRight());
	 }
	 
	 public static AttributeSet Schema(SortedSet<FD> sigma){
		 
		 AttributeSet set = new AttributeSet();
		 
		 for(FD fd : sigma){
			 set.addAttributes(fd.getLeft());
			 set.addAttributes(fd.getRight());
		 }
		 
		 return set;
	 }
	 
	 public static boolean isSupetKey(SortedSet<FD> sigma, AttributeSet X){
		 return Schema(sigma).include(X);
	 }
	 
	 public static boolean BCNF(SortedSet<FD> dep, AttributeSet R){
		 for(FD fd : dep){
			 if(fd.getLeft().include(fd.getRight()) || R.include(fd.getLeft()))
				 continue;
			 else
				 return false;
		 }
		 return true;
	 }
	 
	 public static SortedSet<FD> normalize(SortedSet<FD> sigma){
			MinimizeAlgorithm minimize = new MinimizeAlgorithm(sigma);
			minimize.run();
			
			ReduceAlgorithm reduce = new ReduceAlgorithm(minimize.getFdSet());
			reduce.run();

			return reduce.getFdSet();
	 }
	 
	 public static FD getNonTrivialKey(SortedSet<FD> fds, AttributeSet U){
		ImprovedAlgorithm algo = new ImprovedAlgorithm(fds, null);
		for(FD fd : fds){
			FD nfd = new FD(fd.getLeft(), U);
			if(!fd.getLeft().include(fd.getRight()) && !SigmaProve(nfd, algo))
				return fd;
		} 
		
		return null;
	 }

}
