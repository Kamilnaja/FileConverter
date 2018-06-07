import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Converter implements FileConverter {

	private Path output;
	private Path input;

	@Override
	public void convertFile(Path input, Path output) {
		this.input = input;
		this.output = output;
		try {
			readFile();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void convertFile(File input, File output) {
		// TODO Auto-generated method stub

	}

	public String hashTextLine(String line) throws NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(line.getBytes(), 0, line.length());
		String hashedData = new BigInteger(1, m.digest()).toString(16);
		return hashedData;
	}

	public void saveHashedText(String hashedText) throws FileNotFoundException {
		System.out.println("text to save = " + hashedText);
		PrintWriter out = new PrintWriter(output.toString());
		out.println(hashedText);
		out.close();
	}

	public String readFile() throws IOException, NoSuchAlgorithmException {
		BufferedReader reader = new BufferedReader(new FileReader(input.toString()));
		String line;
		String readedText = "";
		String textToSave = "";
		while ((line = reader.readLine()) != null) {
			if (line.length() > 0) {
				textToSave += (line + "; " + hashTextLine(line) + "\r");
			}
		}
		saveHashedText(textToSave);
		reader.close();
		return readedText;
	}
}
