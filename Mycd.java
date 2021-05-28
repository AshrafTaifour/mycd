import java.io.File;
public class Mycd {
	public static String changeDir(String src, String dest){
		StringBuilder result = new StringBuilder();



		return result.toString();
		
	}


	public static void main(String[]args){
		
		String test = "/abc/def/ghi";
		
		String dest = "/";

		File resultDirectory = new File(dest);

		File testDir = new File(test);

		System.out.println(resultDirectory.exists());
		System.out.println(testDir.exists());
	}

}
