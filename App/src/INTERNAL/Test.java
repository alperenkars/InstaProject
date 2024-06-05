package INTERNAL;

import javax.swing.JFrame;
/* Pledge of Honor *************************************************************************************
I hereby certify that I have completed this programming project on my own without any help from
anyone else. The effort in the project thus belongs completely to me. I did not search for a
solution, or I did not consult to any program written by others or did not copy any program from
other sources. I read and followed the guidelines provided in the project description.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Alperen Kars, 75641>
************************************************************************************************************/


public class Test {

public static void main(String[] args) {
		//This is the test class, a new Login object is created along with the several users
		Login c = new Login();
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setSize(350, 350);
		c.setVisible(true);
		User aak=new User("u1","123","ali","kısa","12","kisaali@hotmail.com","Premium");
		User aa=new User("u2","456","veli","uzun","76","uzunveli@gmail.com","Standard");
		
		
		
		
		
	}

}
