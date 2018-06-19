import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.xml.bind.DatatypeConverter;

public class MD2Hasher {
	private MessageDigest messageDigest;
	
	public MD2Hasher() throws NoSuchAlgorithmException {
		messageDigest = MessageDigest.getInstance("MD2");
	}

	public String hashTextLine(String line) throws NoSuchAlgorithmException {
		messageDigest.reset();
		messageDigest.update(line.getBytes());
		return DatatypeConverter.printHexBinary(messageDigest.digest()).toUpperCase();
	}
}
