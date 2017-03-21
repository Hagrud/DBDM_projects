package closure;

import java.util.SortedSet;

import closure.data.AttributeSet;
import closure.data.FD;
import closure.data.IO;

public class Closure {

	public static void main(String[] args) {
		
		if(args.length < 1 || args[0].equals("-h")){
			showHelp();
			return;
		}
		
		if(args[0].equals("-naive")){
			if(args.length < 3){
				showHelp();
				return;
			}
			
			SortedSet<FD> sigma = IO.read(args[1]);
			AttributeSet atts = IO.readAttibString(args[2]);
			//Algorithms.naiveClosure(sigma, atts);
		}
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
