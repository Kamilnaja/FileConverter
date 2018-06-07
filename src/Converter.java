import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

public class Converter implements FileConverter {

	public String readFile(Path input) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(input.toString()));
		String line;
		String readedText = "";
		while((line = reader.readLine()) != null)
			readedText += line;
		reader.close();
		return readedText;
	}

	@Override
	public void convertFile(Path input, Path output) {
		try {
			System.out.println(readFile(input));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void convertFile(File input, File output) {
		// TODO Auto-generated method stub

	}
}
