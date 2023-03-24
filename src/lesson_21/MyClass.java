package lesson_21;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MyClass {
	@MyAnnotation("Field 1")
	String field1;
	@MyAnnotation("Field 2")
	int field2;
	char field3;
	
	public String getField1() {
		return field1;
	}
	public void setField1(String field1) {
		this.field1 = field1;
	}
	public int getField2() {
		return field2;
	}
	public void setField2(int field2) {
		this.field2 = field2;
	}
	public char getField3() {
		return field3;
	}
	public void setField3(char field3) {
		this.field3 = field3;
	}
	
	public MyClass(String field1, int field2, char field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}
	
	@Override
	public String toString() {
		return "MyClass [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
	
	void saveAnnotation(File file) throws IOException {
	    try (FileWriter writer = new FileWriter(file)) {
	        for (java.lang.reflect.Field field : this.getClass().getDeclaredFields()) {
	            if (field.isAnnotationPresent(MyAnnotation.class)) {
	                MyAnnotation annotation = field.getAnnotation(MyAnnotation.class);
	                writer.write(annotation.value() + ": " + field.getName() + " = ");
	                writer.write(field.get(this).toString());
	            }
	        }
	    } catch (IOException | IllegalAccessException e) {
	        throw new IOException("Failed to save annotation", e);
	    }
	}
	
}
