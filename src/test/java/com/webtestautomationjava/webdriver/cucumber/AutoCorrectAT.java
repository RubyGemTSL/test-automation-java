package com.webtestautomationjava.webdriver.cucumber;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "src/test/resources/features/", tags = {"@bbc"}, format = {"html:target/cucumber-report/bbc"})
public class AutoCorrectAT {
}
