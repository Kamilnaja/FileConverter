import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public abstract class Hasher {
	
	private MessageDigest messageDigest;
	
	public String hashTextLine(String line) throws NoSuchAlgorithmException {
		messageDigest.reset();
		messageDigest.update(line.getBytes());
		return DatatypeConverter.printHexBinary(messageDigest.digest()).toUpperCase();
	}
}
