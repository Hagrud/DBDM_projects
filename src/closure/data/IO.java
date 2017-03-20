package closure.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class IO {

	public static SortedSet<FD> read(String file){
		SortedSet<FD> out = new TreeSet<FD>();
	
		Scanner scan;
		try {
			scan = new Scanner(new File("CCF2015P.txt"));
			
			while(scan.hasNextLine()){
				String line = scan.nextLine();
				if(line.length() == 0 || line.charAt(0) == '#' || line.charAt(0) == ' '){
					continue;
				}
				
				String[] fString = line.split("->");
				
				AttributeSet left = readAttibString(fString[0]);
				AttributeSet right = readAttibString(fString[1]);
				
				out.add(new FD(left, right));	
			}
			
			scan.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return out;
	}
	
	public static AttributeSet readAttibString(String atts){
		AttributeSet set = new AttributeSet();
		String[] part = atts.split(" ");
		for(String attribute : part){
			set.addAttribute(attribute);
		}
		return set;
	}
}
