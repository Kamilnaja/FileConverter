import java.nio.file.Path;
import java.nio.file.Paths;

public class FileConverterTest {

	public static void main(String[] args) {
		Path input = Paths.get("c:/tmp/words.txt");
		Path output = Paths.get("./output.txt");

		Converter fileConverter = new Converter();
		fileConverter.convertFile(input, output);
	}
}
