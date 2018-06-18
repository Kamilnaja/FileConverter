import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
			readFile(); // todo - add parameter
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void convertFile(File input, File output) {

	}

	public String hashTextLine(String line) throws NoSuchAlgorithmException {
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(line.getBytes(), 0, line.length());
		String hashedData = new BigInteger(1, m.digest()).toString(16);
		return line + " : " + hashedData + "\r";
	}

	public void readFile() throws IOException, NoSuchAlgorithmException {
		BufferedReader reader = new BufferedReader(new FileReader(input.toString()));
		FileOutputStream fos = new FileOutputStream("output.txt");
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));

		String line;
		while ((line = reader.readLine()) != null) {
			writer.write(hashTextLine(line));
		}
		writer.close();
		reader.close();
	}
}
