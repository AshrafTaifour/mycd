import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class MycdTest {
	//NOTE: PLEASE CHANGE USERNAME VARIABLE TO MATCH YOUR USERNAME ON YOUR MACHINE
	String username = "ashraft";

   @BeforeEach                                         
    public void setUp() throws Exception {
        Mycd CD = new Mycd();
    }

   @Test
   void myFirstTest(){
   	String src = "/";
	String dst = "home";
	String expResult = "/home";
	assertEquals(expResult, Mycd.changeDir(src, dst));
   }
   
   
   @Test
   void mySecondTest(){
   	String src = "/home/"+username;
	String dst = "Desktop";
	String expResult = "/home/"+username+"/Desktop";
	assertEquals(expResult, Mycd.changeDir(src, dst));
   }
   
   @Test
   void myThirdTest(){
   	String src = "/home/"+username;
	String dst = "..";
	String expResult = "/home";
	assertEquals(expResult, Mycd.changeDir(src, dst));
   }


   @Test
   void myFourthTest(){
   	String src = "/home/"+username;
	String dst = "/home";
	String expResult = "/home";
	assertEquals(expResult, Mycd.changeDir(src, dst));
   }
   
   @Test
   void myFifthTest(){
   	String src = "/home/"+username+"/Desktop";
	String dst = "/home/"+username+"/Downloads";
	String expResult = "/home/"+username+"/Downloads";
	assertEquals(expResult, Mycd.changeDir(src, dst));
   }
   
   @Test
   void mySixthTest(){
   	String src = "/home/"+username;
	String dst = "../..";
	String expResult = "/";
	assertEquals(expResult, Mycd.changeDir(src, dst));
   }

   @Test
   void mySeventhTest(){
   	String src = "/home/"+username;
	String dst = "../../..";
	String expResult = "/";
	assertEquals(expResult, Mycd.changeDir(src, dst));
   }

   @Test
   void myEighthTest(){
   	String src = "/home/"+username;
	String dst = ".";
	String expResult = "/home/"+username;
	assertEquals(expResult, Mycd.changeDir(src, dst));
   }

   @Test
   void myNinthTest(){
   	String src = "/home/"+username;
	String dst = "..Desktop";
	String expResult = "..Desktop: No such file or directory";
	assertEquals(expResult, Mycd.changeDir(src, dst));
   }

   @Test
   void myTenthTest(){
   	String src = "/home/"+username;
	String dst = "//////";
	String expResult = "/";
	assertEquals(expResult, Mycd.changeDir(src, dst));
   }

   @Test
   void myEleventhTest(){
   	String src = "/home/"+username;
	String dst = "......";
	String expResult = "......: No such file or directory";
	assertEquals(expResult, Mycd.changeDir(src, dst));
   }

   @Test
   void myTwelfthTest(){
   	String src = "/home/"+username+"/Desktop";
	String dst = "../blah///../Documents/.";
	String expResult = "/home/"+username+"/Documents";
	assertEquals(expResult, Mycd.changeDir(src, dst));
   }




}
