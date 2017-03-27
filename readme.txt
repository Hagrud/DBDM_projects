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
	
	- 2 :	TODO ---------------------------------------
	
#Exercice 3
	- 1 :	We used java pre-defined HashMap for count and list.
	
	- 2 :	?
	
	- 3 :	Algorithm 2 is implemented in "src/closure/algorithms/ImprovedAlgorithm.java" in the function run.
	
	- 4 :	TODO ---------------------------------------
	
#Exercice 4
	- 1 : 	This file.
	
	- 2 : 	We choose the first elem of the set (sorted by lexical order). As java sortedSet have a direct access to its first element.
	
	- 3 :	TODO ----------------------------------------
	
#Exercice 5
	- 1 :	Generate algorithm implemented in "src/closure/algorithms/GenerateAlgorithm".
			TODO ----------------- (shuffle the output).
	
	- 2 :	Script implemented at the root folder.
			TODO ----------------- make csv.
	
	- 3 :	TODO ----------------- need cvs.
	
#Exercice 6
	- 1 :	TODO -----------------
	
	- 2 :	TODO
	
	- 3 :	TODO
	
#Exercice 7
	- 1 :	Function implemented in "src/closure/algorithms/Tools.java" as SigmaProve.
	
	- 2 :	
	
	- 3 :
	
	- 4 :
	
	- 5 :

	