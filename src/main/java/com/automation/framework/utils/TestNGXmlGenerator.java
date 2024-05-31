package com.automation.framework.utils;

import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

public class TestNGXmlGenerator {
    public static void main(String[] args) throws IOException {
        String browser = System.getProperty("browser", "chrome");
        String testRunner = System.getProperty("testRunner", "com.example.runners.DynamicTestRunner");

        // Create a new XML suite
        XmlSuite suite = new XmlSuite();
        suite.setName("DynamicSuite");

        // Create a new XML test and add it to the suite
        XmlTest test = new XmlTest(suite);
        test.setName("DynamicTest");

        // Add the test runner class to the XML test
        XmlClass testClass = new XmlClass(testRunner);
        test.setXmlClasses(Collections.singletonList(testClass));

        // Add browser parameter to the test
        test.addParameter("browser", browser);

        // Write the XML file to a location
        FileWriter writer = new FileWriter("dynamic-testng.xml");
        writer.write(suite.toXml());
        writer.flush();
        writer.close();
    }
}
