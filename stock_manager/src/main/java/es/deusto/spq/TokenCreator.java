package es.deusto.spq;

import java.security.SecureRandom;
import java.util.Base64;

public class TokenCreator {

    /*
    This code will generate random string in base64 encoding with 32 chars. 
    In Base64 encoding every char encodes 6 bits of the data. 
    So for 24 bytes from the above example you get the 32 chars. 
    You can change the length of the output string by changing the number of random bytes. 
    This solution is more secure than UUID (that uses only 16 random bytes) and generates string that safely could be used in HTTP urls.
    */

    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }

}