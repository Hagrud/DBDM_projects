DBDM project from Ni Luh Dewi Sintiari and Polet Pierre-Etienne

#Exercice 1
	- 1 : 	- Attributes are strings.
			- Attributes Set : As we need to make union between attributes sets and compare them with the lexical order, we choose to use SortedSet structures with some comparative function added.
			- Set of Attributes Set : for the same raison we use SortedSet of Attributes Set.
			
			- FD : We define a new type with a 2 attributes set variables left and right.
			- set of FD : We also use sortedSets.
			
			All the sortedSets are in fact Binary Search trees.
			
			Datatypes are defined in : 	- "src/closure/data/AttributeSet.java"
										- "src/closure/data/FD.java"
										
	- 2 :	- For input we made a function that convert a file into a set of FD.
			
			In : - "src/closure/data/IO.java"
			
			- For output each new datatype have a function toString() that give the correct form of the data for output.
			
	- 3 :	Main programme is defined in "src/closure/Closure.java"
	
#Exercice 2
	- 1 :	Algorithm 1 is implemented in : "src/closure/algorithms/NaiveClosure.java" in the function run.
	
	- 2 :	Test files are located in testing_sets folders.
	
#Exercice 3
	- 1 :	We used java pre-defined HashMap for count and list.
	
	- 2 :	In this case I found it more usefull to keep it in the same function due to the datatype we use.
	
	- 3 :	Algorithm 2 is implemented in "src/closure/algorithms/ImprovedAlgorithm.java" in the function run.
	
	- 4 :	Test files are located in testing_sets folders.
	
#Exercice 4
	- 1 : 	This file.
	
	- 2 : 	We choose the first elem of the set (sorted by lexical order). As java sortedSet have a direct access to its first element.
	
	- 3 :	We didn't found any corner case.
	
#Exercice 5
	- 1 :	Generate algorithm implemented in "src/closure/algorithms/GenerateAlgorithm".
	
	- 2 :	Script implemented at the root folder.
            As we use java, the virtual machine take a lot of time to initialize and may add a big "constant" time on each measure.
            So we also provide an internal test that only measure time past in the functions. As we use system time to compute the
            algorithm delay it can be impacted by the task scheduler of the computer we use.
	
	- 3 :	Plot from bash script is in "Plot_bash_script.png".
	        Plot from code is in "Plot_code.png".
	
#Exercice 6
	- 1 :	This set can be usefull to test our algorithm because we know each FD of the set is needed to have the correct answer.
	        => we do not provide redundant information.
	
	- 2 :   We use two experimental setup:
	            - The first one use script made in question 5.2, we measure the time to read execute the algorithm and write the outputs.
	            - The second one is in code algorithm, it only measure the running time of the algorithm (not the input output). So it work on already sorted
	            fd sets.
	            
	        In both cases data are analysed with exel/libreoffice to plot the curve and compute the regression.
	
	- 3 :	- For the first setup we had issues due to the java virtual machine, as we measure time from the batch that take in account the java launch and initialization that are not related to our algorithm. So the regression are higly disturbed by thoses delay and we don't get good results.
	        - On the second the only perturbation is due to the sheduler of the computer, we also take much more data. We clearly see that the naive algorithm is non linear and that the improved one quickly get better performances.
	
#Exercice 7
	- 1 :	Function implemented in "src/closure/algorithms/Tools.java" as SigmaProve.
	
	- 2 :	Minimization implemented in : "src/closure/algorithms/MinimizeAlgorithm.java".
	        Reduction implemented in : "src/closure/algorithms/ReduceAlgorithm.java".
	        Normalization implemented in : "src/closure/Closure.java" and "src/closure/algorithms/Tools.java" as Normalize.
	
	- 3 :   Implemented in  "src/closure/algorithms/Tools.java" as Schema.
	
	- 4 :   Implemented in "src/closure/algorithms/Tools.java" as getSuperKey and BCNF.
	
	- 5 :   Implemented in "src/closure/algorithms/DecomposeAlgorithm.java"
	            using getNonTrivialKey from "src/closure/algorithms/Tools.java".

	
