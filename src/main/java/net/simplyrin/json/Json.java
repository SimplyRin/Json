package net.simplyrin.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import club.sk1er.utils.JsonHolder;

public class Json {

	public static void saveJson(JsonHolder json, String path) {
		saveJson(json, new File(path));
	}

	public static void saveJson(JsonHolder json, File file) {
		FileWriter filewriter;
		try {
			filewriter = new FileWriter(file);
			filewriter.write(json.toString());
			filewriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static JsonHolder getJson(String path) {
		return getJson(new File(path));
	}

	public static JsonHolder getJson(File file) {
		try {
			return new JsonHolder(Files.lines(Paths.get(file.getPath()), Charset.defaultCharset()).collect(Collectors.joining(System.getProperty("line.separator"))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static JsonHolder loadJson(String path) {
		return getJson(new File(path));
	}

	public static JsonHolder loadJson(File file) {
		return getJson(file);
	}

}
