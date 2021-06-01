import java.util.*;

public class Mycd {
	public static String changeDir(String src, String dest){
		//breakdown dest by '/'
		String[] destStrings = dest.split("/");
		
		//stack will store the source and/or destination strings
		Stack<String> destStack = new Stack<String>();


		//if the destination doesn't start with a / then we must use the source directory's location
		if(dest.charAt(0) != '/'){
			//breakdown src by '/'
			String[] srcStrings = src.split("/");

			//loop through each part of the src adding it to the stack and a /
			for(int i=0; i < srcStrings.length; i++){
				if(!srcStrings[i].equals(""))
					destStack.push("/" + srcStrings[i]);
			}
		
		}
		//loop through each part of dest
		for(int j=0; j < destStrings.length; j++){
			//if string isn't "..', ".", "/" or "" we can add it to the stack
			if(!destStrings[j].equals("..") && !destStrings[j].equals(".") && !destStrings[j].equals("/") && !destStrings[j].equals(""))
				destStack.push("/" + destStrings[j]);
			//pop the last string from the stack if it's ".."
			else if(destStrings[j].equals(".."))
				if(!destStack.isEmpty())
					destStack.pop();
		}

		//if everything is popped, add a slash as we have come to the root
		if(destStack.isEmpty())
			destStack.push("/");

		//stringbuilder to store the final location
		StringBuilder result = new StringBuilder();

		for(String str: destStack){
			result.append(str);
		}


		//convert SB to string
		String finalDest = result.toString();

		//if path contains illegal characters, print error
		for(char c: finalDest.toCharArray()){
			if(!Character.isLetterOrDigit(c) && c != '/')
					return dest + ": No such file or directory";
		} 
		
		//otherwise print the path
		return finalDest;
		
	}


	public static void main(String[] args){

		System.out.println(changeDir(args[0],args[1]));

	}

}
