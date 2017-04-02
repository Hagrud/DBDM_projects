package closure;

import closure.algorithms.Algorithm;
import closure.algorithms.GenerateAlgorithm;
import closure.algorithms.ImprovedAlgorithm;
import closure.algorithms.NaiveClosure;
import closure.algorithms.ReduceAlgorithm;
import closure.algorithms.MinimizeAlgorithm;
import closure.data.IO;

public class Closure {

	public static void main(String[] args) {
		
		if(args.length < 1 || args[0].equals("-h")){
			showHelp();
			return;
		}
		
		//Exercise 1 : Naive algorithm
		if(args[0].equals("-naive")){
			if(args.length < 3){
				showHelp();
				return;
			}
			
			Algorithm naive = new NaiveClosure(IO.read(args[1]), IO.readAttibString(args[2]));
			naive.run();
			
			System.out.println(naive);
			
		}
		
		//Exercise 2 : Improved algorithm
		else if(args[0].equals("-improved")){
			if(args.length < 3){
				showHelp();
				return;
			}
			
			Algorithm improved = new ImprovedAlgorithm(IO.read(args[1]), IO.readAttibString(args[2]));
			improved.run();
			
			System.out.println(improved);
		}
		
		//Exercise 5 : generate algorithm
		else if(args[0].equals("-generate")){
			if(args.length < 2){
				showHelp();
				return;
			}
			
			Algorithm generate = new GenerateAlgorithm(Integer.valueOf(args[1]));
			generate.run();
			
			System.out.println(generate);
		}
		
		
		//Exercise 7 : normalize algorithm
		else if(args[0].equals("-normalize")){
			MinimizeAlgorithm minimize = new MinimizeAlgorithm(IO.read(args[1]));
			minimize.run();
			
			ReduceAlgorithm reduce = new ReduceAlgorithm(minimize.getFdSet());
			reduce.run();
			
			System.out.println(reduce.getFdSet());
		}
		
		else if(args[0].equals("-decompose")){
			
		}
		
		else{
			showHelp();
		}
	}
	
	private static void showHelp(){
		System.out.println("--help");
	}

}
