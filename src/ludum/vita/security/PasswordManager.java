package ludum.vita.security;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;


public class PasswordManager {
	
	private static PasswordManager passwordConfig;
	private ArrayList<Character> passwordEncyptionBuilder;
	private Random randomizer;
	
	public static PasswordManager getPasswordConfiguration() {
		if(passwordConfig == null){
			passwordConfig = new PasswordManager();
		}
		return passwordConfig;
	}
	
	protected PasswordManager(){
		randomizer = new Random();
	}
	
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
	
	public String sPassword(String password) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
		KeyGenerator kg = KeyGenerator.getInstance("Blowfish");
		kg.init(128);
		Key key = kg.generateKey();
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(1024);
		KeyPair kp = kpg.genKeyPair();
		Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
		cipher.init(Cipher.ENCRYPT_MODE, kp.getPublic());
		return new String(key.getEncoded());
	}
	
//	public String rPassword(String epassword){
//		
//	}
	
	
	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, ShortBufferException, BadPaddingException, InvalidKeyException{
		PasswordManager p = PasswordManager.getPasswordConfiguration();
		System.out.println(p.sPassword("#One1605"));
	}
}
