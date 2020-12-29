package DuAn2.Common;

import org.apache.commons.codec.binary.Base64;

public class Common {
	public static String encode(String str) {
		Base64 base64 = new Base64();
		String encodedString = new String(base64.encode(str.getBytes()));
		return encodedString;
	}
	
	public static String decode(String str) {
		Base64 base64 = new Base64();
		String decodedString = new String(base64.decode(str.getBytes()));
		return decodedString;
	}
}
