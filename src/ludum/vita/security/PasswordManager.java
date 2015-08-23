package ludum.vita.security;

import java.util.ArrayList;
import java.util.Random;


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
	
//	public static void main(String[] args){
//		PasswordManager p = PasswordManager.getPasswordConfiguration();
//		System.out.println(p.restorePassword(p.securePassword("#One1605")));
//	}
}
