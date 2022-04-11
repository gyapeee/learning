package com.gyapeee.learn.testautomation.simplelearn;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * <p> These are not part of the Simple Learn questions. Added by myself</p>
 *
 * <h2>Table of content</h2>
 * <ul>
 * <li>32. How to add an extension to the browser?</li>
 * <li>33. What is Bot Pattern?</li>
 * <li>34. What is Page Factory in Selenium?</li>
 * </ul>
 */
@TestMethodOrder(MethodOrderer.MethodName.class)
public class SeleniumNonSimpleLearnTests {

    @Test
    void TC_32_How_to_add_an_extension_to_the_browser() {
        //https://www.browserstack.com/guide/test-chrome-extensions-in-selenium
    }

    @Test
    void TC_33_What_is_Bot_Pattern() {
        //https://www.selenium.dev/documentation/test_practices/design_strategies/

    }

    @Test
    void TC_34_What_is_Page_Factory_in_Selenium() {
        // https://www.lambdatest.com/blog/page-factory-in-selenium/

    }

    @Test
    void TC_35_How_to_be_sure_that_test_finds_the_exact_Element() {
        // Add test or QA ID for each element on the frontend to get the element faster
    }
}
