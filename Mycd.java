import java.io.File;
import java.util.*;

public class Mycd {
	public static String changeDir(String src, String dest){
		StringBuilder result = new StringBuilder();
		Stack<String> destStack = new Stack<String>();

		String[] srcStrings = src.split("/");
		String[] destStrings = dest.split("/");

		//if the destination starts with a / then we don't need to use the source directory
		if(dest.charAt(0) == '/'){
			File directory = new File(dest);
			return directory.exists() ? dest : dest + ": No such file or directory";
		}
		
		if(src.equals("/")){
			destStack.push("/");
		}

		for(int i=0; i < srcStrings.length; i++){
			destStack.push(srcStrings[i] + "/");
		}
		for(int j=0; j < destStrings.length; j++){
			if(!destStrings[j].equals("..") && !destStrings[j].equals("."))
				destStack.push(destStrings[j]);
			//go up a level if it's '..'
			else if(destStrings[j].equals("..") && destStack.size() > 1)
				destStack.pop();
		}


		for(String str: destStack){
			result.append(str);
		}

		String finalDest = result.toString();

		File directory = new File(finalDest);

		return directory.exists() ? finalDest : finalDest + ": No such file or directory";
		
	}


	public static void main(String[] args){

		System.out.println(changeDir(args[0],args[1]));
		
	}

}
