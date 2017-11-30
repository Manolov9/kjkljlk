package com.example.tests;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class luchotest {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://dev.embodee.com/gbuilder/index.html?garment=881257&rules=temp");
		selenium.start();
	}

	@Test
	public void testLuchotest() throws Exception {
		selenium.open("/gbuilder/index.html?garment=881257&rules=temp");
		assertEquals("Text", selenium.getText("id=Text"));
		selenium.click("id=Text");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("id=Text")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		assertEquals("Front Name", selenium.getText("//div[@id='heading_sel_4']/div/div/span"));
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//div[@id='heading_front_upper_name']/div/div/span")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		assertEquals("Straight Name", selenium.getText("//div[@id='heading_front_upper_name']/div/div/span"));
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//div[@id='heading_front_upper_name']/div/div/span")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		selenium.click("//div[@id='heading_front_upper_name']/div/div/span");
		for (int second = 0;; second++) {
			if (second >= 60) fail("timeout");
			try { if (selenium.isElementPresent("//ul[@id='subtabs_front_upper_name']/li/div")) break; } catch (Exception e) {}
			Thread.sleep(1000);
		}

		assertEquals("Name", selenium.getText("//ul[@id='subtabs_front_upper_name']/li/div"));
		selenium.type("id=front_upper_name-name-line1", "Lucho");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
