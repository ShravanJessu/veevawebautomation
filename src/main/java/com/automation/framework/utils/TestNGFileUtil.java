package com.automation.framework.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;

public class TestNGFileUtil {

	public static void main(String[] args) {

		System.out.println("Generating TestNG XML file with the following details:");
		if (args.length < 2) {
			System.out.println("Usage: TestNGFileGenerator <browser1,browser2,...> <runnerClass>");
			return;
		}
		String[] browsers = args[0].split(",");
		String runnerClass = args[1];
		System.out.println("Browsers: " + String.join(", ", browsers));
		System.out.println("Runner Class: " + runnerClass);
		generateTestNGFile(browsers, runnerClass);
	}

	public static void generateTestNGFile(String[] browsers, String runnerClass) {
		StringBuilder xmlContent = new StringBuilder();
		xmlContent.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
//		xmlContent.append("<!DOCTYPE suite SYSTEM \"http://testng.org/testng-1.0.dtd\">\n");
		xmlContent.append("<suite name=\"Cucumber Tests\">\n");

		for (String browser : browsers) {
			xmlContent.append("<test name=\"Local " + browser.toUpperCase() + " TEST\">\n");
			xmlContent.append("\t<parameter name=\"browser\" value=\"" + browser + "\"/>\n");
			xmlContent.append("\t<classes>\n");
			xmlContent.append("\t\t<class name=\"" + runnerClass + "\"/>\n");
			xmlContent.append("\t</classes>\n");
			xmlContent.append("</test>\n");
		}

		xmlContent.append("</suite>");

		System.out.println("Generated TestNG Content: \n"+xmlContent.toString());

		try (FileWriter writer = new FileWriter("testng.xml")) {
			writer.write(xmlContent.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
