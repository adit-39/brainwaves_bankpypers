package com.example.encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	public void encrypt(View view) {
		EditText e = (EditText) findViewById(R.id.editText1);
		String password = e.getText().toString();
		TextView v = (TextView) findViewById(R.id.textView1);
		try {
			String hash = this.get_SHA_512_SecurePassword(password, getSalt());
			v.setText(hash);
			android.util.Log.d("hash", hash);
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}
	}

	private String get_SHA_512_SecurePassword(String passwordToHash, String salt) {
		MessageDigest md;
		String generatedPassword = null;
		try {
			md = MessageDigest.getInstance("SHA-1");
			md.update(salt.getBytes());
			byte[] bytes = md.digest(passwordToHash.getBytes());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
						.substring(1));
			}
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	// Add salt
	private String getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		android.util.Log.d("salt", salt.toString());
		return salt.toString();
	}
}
