package com.concept.curl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class HitUrlAndGetHtmlSourceCode {

	public static void main(String[] args) throws UnsupportedEncodingException, IOException {
		URL url = new URL("https://www.opentext.com/");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(
				url.openStream(), "UTF-8"))) {
			for (String line; (line = reader.readLine()) != null;) {
				System.out.println(line);
			}
		}
	}
}
