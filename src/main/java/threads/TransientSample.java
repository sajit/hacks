package threads;


import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class TransientSample {
	
	
	private transient int age;
	private String name;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString(){
		return age+":"+name;
	}
	
	public static void main(String[] args) throws IOException{
		//1. read from a file
		String fileUrl = "/home/sajit/a.txt";
	
		List<String> lines=Files.readAllLines(Paths.get(fileUrl), Charset.forName("UTF-8"));
		String[] tokens = lines.get(0).split(",");
		Integer age = Integer.valueOf(tokens[0]);
		String name = tokens[1];
		TransientSample sample = new TransientSample();
		sample.setAge(age);
		sample.setName(name);
		System.out.println(sample);
		
		Files.write(Paths.get("/home/sajit/b.txt"), sample.toString().getBytes());

	}

}
