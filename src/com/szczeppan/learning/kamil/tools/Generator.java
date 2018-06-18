package com.szczeppan.learning.kamil.tools;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class Generator {

	private static final int LINES = 5000000;
	private static final String OUTPUT_FILE = "C:/tmp/words.txt";

	public static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWER = UPPER.toLowerCase(Locale.ROOT);
	public static final String DIGITS = "0123456789";
	public static final String ALPHANUM = UPPER + LOWER + DIGITS;
	public static char[] CHARS = ALPHANUM.toCharArray();

	public Generator() {

	}

	private void generate(int lines, int length) {
		Path path = Paths.get(OUTPUT_FILE);
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			for (int i = 0; i < lines; i++) {
				writer.write(generateWord(length));
				writer.newLine();
			}
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String generateWord(int length) {
		StringBuilder builder = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			builder.append(CHARS[ThreadLocalRandom.current().nextInt(CHARS.length)]);
		}
		return builder.toString();
	}

	public static void main(String[] args) {
		new Generator().generate(LINES, 40);
	}
}
