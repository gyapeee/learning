package com.gyapeee.learn.testautomation;

import org.junit.platform.suite.api.IncludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SuiteDisplayName;

@Suite
@SuiteDisplayName("Selenium Simple Learn tutorial examples")
@SelectPackages("com.gyapeee.learn.testautomation.simplelearn")
@IncludeClassNamePatterns("^.*Tests")
public class SimpleLearnExamplesTestSuit {
}
