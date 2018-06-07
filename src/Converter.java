import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Converter implements FileConverter {

	@Override
	public void convertFile(Path input, Path output) {
		try {
			readFile(input);
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
		System.out.println("MD5 " + new BigInteger(1, m.digest()).toString(16));
		String hashedData = new BigInteger(1, m.digest()).toString(16);
		return hashedData;
	}

	public void saveHashedFile(String hashedText) {
		System.out.println(hashedText);
	}

	public String readFile(Path input) throws IOException, NoSuchAlgorithmException {
		BufferedReader reader = new BufferedReader(new FileReader(input.toString()));
		String line;
		String readedText = "";
		while ((line = reader.readLine()) != null) {
			if (line.length() > 0) {
				readedText += (line);
//				zapisz zahashowane dane
				saveHashedFile(hashTextLine(line));
//				System.out.println(line);
			}
		}
		reader.close();
		return readedText;
	}
}
