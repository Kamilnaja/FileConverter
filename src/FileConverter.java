import java.io.File;
import java.nio.file.Path;

public interface FileConverter {
	public void convertFile(Path input, Path output);
	public void convertFile(File input, File output);
}
