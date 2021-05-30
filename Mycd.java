import java.io.File;
import java.util.*;

public class Mycd {
	public static String changeDir(String src, String dest){
		//breakdown dest by '/'
		String[] destStrings = dest.split("/");
		
		//stack will store the source and/or destination strings
		Stack<String> destStack = new Stack<String>();

		//start off any path with the initial slash
		destStack.push("/");

		//if the destination doesn't start with a / then we must use the source directory's location
		if(dest.charAt(0) != '/'){
			//breakdown src by '/'
			String[] srcStrings = src.split("/");

			//loop through each part of the src adding it to the stack and a /
			for(int i=0; i < srcStrings.length; i++){
				if(!srcStrings[i].equals(""))
					destStack.push(srcStrings[i] + "/");
			}
		
		}
		//loop through each part of dest
		for(int j=0; j < destStrings.length; j++){
			//if string isn't "..', ".", "/" or "" we can add it to the stack
			if(!destStrings[j].equals("..") && !destStrings[j].equals(".") && !destStrings[j].equals("/") && !destStrings[j].equals("")){
				//add a slash only if it's not the last string
				if(j != destStrings.length -1)
					destStack.push(destStrings[j] + "/");
				else destStack.push(destStrings[j]);
			}
			//pop the last string from the stack if it's ".."
			else if(destStrings[j].equals("..") && destStack.size() > 1)
				destStack.pop();
		}

		//stringbuilder to store the final location
		StringBuilder result = new StringBuilder();

		for(String str: destStack){
			result.append(str);
		}


		//convert SB to string
		String finalDest = result.toString();

		//check if directory exists by using Java's File API
		File directory = new File(finalDest);

		//if directory exists return the location, otherwise print destination + error message
		return directory.exists() ? finalDest : dest + ": No such file or directory";
		
	}


	public static void main(String[] args){

		System.out.println(changeDir(args[0],args[1]));

	}

}
