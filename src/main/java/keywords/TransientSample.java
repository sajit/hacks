package keywords;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class TransientSample implements Serializable {

	private static final long serialversionUID =
			129348938L;
	//this field is not persisted during serialization
	//also the field is not persisted only by normal serialization. if we specify to serialize
	//using the toString method it ends up in the file
	private transient int age;
	private String name;
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

	public static void main(String[] args) throws IOException {


		final URL resource = TransientSample.class.getClassLoader().getResource("a.txt");
		List<String> lines=Files.readAllLines(Paths.get(resource.getPath()), Charset.forName("UTF-8"));
		String[] tokens = lines.get(0).split(",");
		Integer age = Integer.valueOf(tokens[0]);
		String name = tokens[1];
		TransientSample sample = new TransientSample();
		sample.setAge(age);
		sample.setName(name);
		System.out.println(sample);

		Path path = Paths.get(resource.getPath()+".bkup");
		Path targetFile = Paths.get(path.toAbsolutePath() + "b.txt");

		// serialization
		FileOutputStream fos = new FileOutputStream(targetFile.toFile());
		try(ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(sample);

		}
		fos.close();



		//Files.write(targetFile, sample.toString().getBytes());

	}

}
