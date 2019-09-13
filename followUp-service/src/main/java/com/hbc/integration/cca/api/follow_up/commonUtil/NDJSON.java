//Skip to content
//Search or jump to…
//
//Pull requests
//Issues
//Marketplace
//Explore
// 
//@SanaParvez 
//Learn Git and GitHub without any code!
//Using the Hello World guide, you’ll start a branch, write comments, and open a pull request.
//
//
//1
//01jignaasu/ndjson-java
// Code Issues 1 Pull requests 0 Projects 0 Wiki Security Insights
//ndjson-java/src/main/java/org/jmeshtru/ndjson/NDJSON.java
//@jignaasu jignaasu Initial support for JSONObject
//191c7ab on Nov 30, 2017
//54 lines (45 sloc)  1.63 KB
//  
//package com.hbc.integration.cca.api.follow_up.commonUtil;
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//import java.util.Objects;
//import java.util.stream.Collectors;
//
//import org.json.JSONObject;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class NDJSON {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(NDJSON.class);
//
//	public List<JSONObject> parse(InputStream inputStream) {
//		Objects.requireNonNull(inputStream, "InputStream cannot be null");
//		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
//		return bufferedReader
//				.lines()
//				.filter(str -> !str.isEmpty())
//				.map(JSONObject::new)
//				.collect(Collectors.toList());
//	}
//
//	public void generate(List<JSONObject> ndJsonList, OutputStream outputStream) throws IOException {
//		Objects.requireNonNull(ndJsonList);
//		Objects.requireNonNull(outputStream);
//
//		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
//		ndJsonList.stream()
//				.map(JSONObject::toString)
//				.map(str -> str.replace("\n", "").replace("\r", "").trim())
//				.forEachOrdered(jsonString -> writeWithNewLine(bufferedWriter, jsonString));
//		bufferedWriter.flush();
//	}
//
//	private void writeWithNewLine(BufferedWriter writer, String jsonString) {
//		try {
//			writer.write(jsonString);
//			writer.newLine();
//		} catch (IOException e) {
//			LOGGER.error("Error while writing the object to stream", e);
//		}
//	}
//}