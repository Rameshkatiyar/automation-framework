package com.tech.common;


import com.tech.Application;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

@ContextConfiguration(classes = Application.class)
public class AutomateTest extends AbstractTestNGSpringContextTests {
    public final String SMOKE = "SMOKE";
    public final String ACCEPTANCE = "ACCEPTANCE";
    public final String REGRESSION = "REGRESSION";

    public String eligiblePlatforms;
}
