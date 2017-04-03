package closure;

import java.util.SortedSet;

import closure.algorithms.Algorithm;
import closure.algorithms.DecomposeAlgorithm;
import closure.algorithms.GenerateAlgorithm;
import closure.algorithms.ImprovedAlgorithm;
import closure.algorithms.NaiveClosure;
import closure.algorithms.Tools;
import closure.data.AttributeSet;
import closure.data.FD;
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
			String val = "";
			for(FD fd : Tools.normalize(IO.read(args[1]))){
				val = val + fd.toString() +"\n";
			}
			System.out.println(val);
		}
		
		else if(args[0].equals("-decompose")){
			SortedSet<FD> fds = IO.read(args[1]);
			DecomposeAlgorithm decompose = new DecomposeAlgorithm(fds, Tools.Schema(fds));
			
			decompose.run();
			System.out.println(decompose.getSets());
		}
		
		else if(args[0].equals("-speedTest")){
			
			System.out.println("#, \t nlin, \t lin" );

			for(int i = 100; i <= 4000; i = i + 100){
				for(int j = 0; j < 30; j++){
					
					GenerateAlgorithm generate = new GenerateAlgorithm(i);
					generate.run();
					
					SortedSet<FD> fds = generate.getFDs();
					
					AttributeSet atts = new AttributeSet();
					atts.addAttribute("0");
				
					Algorithm algo = new NaiveClosure(fds, atts);
				
					long startTime = System.nanoTime();
						algo.run();
					long endTime = System.nanoTime();
					long nlduration = (endTime - startTime)/1000;
				
					generate = new GenerateAlgorithm(i);
					generate.run();
					fds = generate.getFDs();
				
					atts = new AttributeSet();
					atts.addAttribute("0");
				
					algo = new ImprovedAlgorithm(fds, atts);
				
					startTime = System.nanoTime();
						algo.run();
					endTime = System.nanoTime();
					long lduration = (endTime - startTime)/1000; 
				
					System.out.println(i + ",\t" + nlduration + ",\t" + lduration);
				}
			}
		}
		
		else{
			showHelp();
		}
		

	}
	
	private static void showHelp(){
		System.out.println("--help : this is the help section");
		System.out.println("	commands list :");
		System.out.println("		-naive files arguments");
		System.out.println("		-improved files arguments");
		System.out.println("		-generate integer");
		System.out.println("		-normalize file");
		System.out.println("		-decompose file");
	}

}
