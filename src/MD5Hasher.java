import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class MD5Hasher {
	private MessageDigest messageDigest;

	public MD5Hasher() throws NoSuchAlgorithmException {
		messageDigest = MessageDigest.getInstance("MD5");
	}

	public String hashTextLine(String line) throws NoSuchAlgorithmException {
		messageDigest.reset();
		messageDigest.update(line.getBytes());
		return DatatypeConverter.printHexBinary(messageDigest.digest()).toUpperCase();
	}
}
