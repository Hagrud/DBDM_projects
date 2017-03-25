package closure;

import closure.algorithms.Algorithm;
import closure.algorithms.NaiveClosure;
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
			
		}
		else if(args[0].equals("-generate")){
			
		}
		else if(args[0].equals("-normalize")){
			
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
