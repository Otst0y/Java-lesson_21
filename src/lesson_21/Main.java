package lesson_21;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		File file = new File("lesson_21.txt");
		
		MyClass myClass = new MyClass("custom string", 100, 'A');
		
		try {
			myClass.saveAnnotation(file);
		} catch (IllegalArgumentException | IOException e) {
			e.printStackTrace();
		}

	}

}
