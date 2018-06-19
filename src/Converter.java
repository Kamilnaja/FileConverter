import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Path;
import java.security.NoSuchAlgorithmException;

public class Converter implements FileConverter {

	@Override
	public void convertFile(Path input, Path output) {
		try {
			long start = System.currentTimeMillis();
			readFile(input, output);
			System.out.println(System.currentTimeMillis() - start);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public void convertFile(File input, File output) {
		convertFile(input.toPath(), output.toPath());
	}
	
	public void readFile(Path input, Path output) throws IOException, NoSuchAlgorithmException {
		BufferedReader reader = new BufferedReader(new FileReader(input.toString()));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output.toFile())));
		convertToMd5(reader, writer);
		reader.close();
		writer.close();

//		BufferedReader reader2 = new BufferedReader(new FileReader(input.toString()));
//		BufferedWriter writer2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output.toFile())));
//		convertToMd2(reader, writer);
//		reader2.close();
//		writer2.close();
//		
	}

	private void convertToMd5(BufferedReader reader, BufferedWriter writer)
			throws NoSuchAlgorithmException, IOException {
		String line;
		MD5Hasher md5Hasher = new MD5Hasher();
		
		while ((line = reader.readLine()) != null) {
			writer.write(line + ";" + md5Hasher.hashTextLine(line));
			writer.newLine();
		}
	}
	
	private void convertToMd2(BufferedReader reader, BufferedWriter writer)
			throws NoSuchAlgorithmException, IOException {
		String line;
		MD2Hasher md2Hasher = new MD2Hasher();
		
		while ((line = reader.readLine()) != null) {
			writer.write(line + ";" + md2Hasher.hashTextLine(line));
			writer.newLine();
		}
	}
}
