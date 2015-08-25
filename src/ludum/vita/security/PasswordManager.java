package ludum.vita.security;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Random;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;


/**
 * Password Manager that handles 
 * @author Gregory L. Daniels
 *
 */
public class PasswordManager {

	private static PasswordManager passwordConfig;
	
	@Deprecated 
	protected ArrayList<Character> passwordEncyptionBuilder;
	
	@Deprecated
	protected Random randomizer = new Random();
	
	/**
	 * Algorithm used by Java's cipher.
	 */
	protected static final String ALGORITHM = "AES";
	
	/**
	 * String representing the key for which all passwords will be 
	 * encrypted before being stored into database.
	 * WARNING! DO NOT CHANGE IF THERE HAS BEEN PLAYERS WHOSE PASSWORD
	 * HAVE BEEN ENCRYPTED WITH THE KEY. THIS WILL LEAVE THEIR KEYS
	 * USELESS AND UNRETRIEVABLE.
	 */
	protected static final String PRIVATE_KEY = "S2c0O1rF5EVLiE2g";
	
	/**
	 * Main cipher that will handle running the appropriate algorithm
	 * for encrypting and decrypting password's in the system.s
	 */
	private static Cipher cipher;

	/**
	 * Ensures that there is only one instance running for the manager.
	 * @return PasswordManager for handling password security.
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchProviderException
	 */
	public static PasswordManager getPasswordConfiguration() throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {
		if(passwordConfig == null){
			passwordConfig = new PasswordManager();
		}
		return passwordConfig;
	}

	/**
	 * Constructor for this password manager, can not be called outside of this class.
	 * Handles initializing the cipher.
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws NoSuchProviderException
	 */
	protected PasswordManager() throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException{
		cipher = Cipher.getInstance(ALGORITHM);
	}

	/**
	 * Old simple character manipulation cipher mechanism for player passwords
	 * registered in the Life Score System.
	 * @deprecated 1.0
	 * @param password String representing the password to be 
	 * manipulated.
	 * @return String that represents an encrypted version of a password.
	 */
	public String securePassword(String password) {
		int r = randomizer.nextInt(8)+1;
		passwordEncyptionBuilder = new ArrayList<Character>();
		for(char c: password.toCharArray())
			passwordEncyptionBuilder.add(c);
		String encrypted = "";
		for(char c: passwordEncyptionBuilder){
			encrypted += (char)(c+r);
		}
		return encrypted + r;
	}

	/**
	 * Reverse character manipulation cipher mechanism for player passwords
	 * registered in the Life Score System.
	 * @deprecated 1.0
	 * @param encryptedPassword String that has been encrypted via the 
	 * securePassword method.
	 * @return String that represents plain text version of player's password.
	 */
	public String restorePassword(String encryptedPassword) {
		int r = Integer.valueOf(encryptedPassword.charAt(encryptedPassword.length()-1)-'0');
		passwordEncyptionBuilder = new ArrayList<Character>();
		for(char c: encryptedPassword.toCharArray())
			passwordEncyptionBuilder.add(c);
		String decrypted = "";
		for(char c: passwordEncyptionBuilder){
			decrypted += (char)(c-r);
		}
		return decrypted.replace(decrypted.charAt(decrypted.length()-1), ' ').trim();
	}

	/**
	 * Simple method that calls on the main cipher method for encryption.
	 * @param password Player's password to be encrypted into the system.
 	 * @return An encrypted String representing the player's password.
	 * @throws BadPaddingException 
	 * @throws IllegalBlockSizeException 
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws InvalidKeyException 
	 * @throws Exception 
	 */
	public String encryptPassword(String password) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		return doCipher(Cipher.ENCRYPT_MODE, passwordFix(Cipher.ENCRYPT_MODE,password));
	}

	/**
	 * Simple method that calls on the main cipher method for decryption. 
	 * Must pass in a password that has been encrypted via the encryptPassword method.
	 * @param password Encrypted version of the player's password.
	 * @return
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	public String decryptPassword(String password) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		return passwordFix(Cipher.DECRYPT_MODE, doCipher(Cipher.DECRYPT_MODE, password));
	}

	/**
	 * Main cipher method that handles the encryption and decryption for player
	 * passwords. This method should never be called outside of this class.
	 * @param cMode Mode for the cipher to run. Should only be ENCRYPT or DECRYPT
	 * @param password the appriopiate version of the password that will be encoded
	 * or decoded.
	 * @return String representing either the encoded or decoded password.
	 * @throws InvalidKeyException
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws IllegalBlockSizeException
	 * @throws BadPaddingException
	 */
	protected String doCipher(int cMode, String password) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		Key secretKey = new SecretKeySpec(PRIVATE_KEY.getBytes(), ALGORITHM);
		cipher.init(cMode, secretKey);
		return new String(cipher.doFinal(password.getBytes()));
	}

	/**
	 * Helper code for correcting the password for the cryptography.
	 * @param mode Mode for which the password is being manipulated.
	 * @param password The password to be fixed.
	 * @return Appropriate password ready for either storing or checking.
	 */
	protected String passwordFix(int mode, String password){
		String padded = password;
		if(mode == Cipher.ENCRYPT_MODE){
			while(padded.length()%4 != 0){
				padded += "\0";
			}
		} else {
			padded = padded.replace("\0", "");
		}
		return padded;
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		PasswordManager p = PasswordManager.getPasswordConfiguration();
		System.out.println(p.decryptPassword("Pm'Ÿ‹Û˜J#“}Ø"));
	}

}
