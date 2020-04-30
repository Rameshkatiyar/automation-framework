package com.tech.commonHelper.commonApi;

import com.tech.config.TestConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlSuite;

import java.util.List;

@Slf4j
@Service
public class AlterTestNgXmlListener implements IAlterSuiteListener {

    @Autowired
    private TestConfig testConfig;

    /**
     * Using this IAlterSuiteListener listener, you can tweak :
     *
     * Thread count
     * Parallel execution mode switch (enable/disable parallel execution)
     * Add more <test> tags into your suite xml.
     * and many more such use cases.
     *
     * Note: This listener will NOT be invoked if it is wired in via the @Listeners
     * @param suites
     */
    @Override
    public void alter(List<XmlSuite> suites) {
        System.out.println("TestConfig: "+testConfig);
//        XmlSuite suite = suites.get(0);
//        XmlTest xmlTest = new XmlTest(suite);
//        xmlTest.setName("CommandLine_Test");
//        String packages = System.getProperty("package", suite.getParameter("package"));
//        XmlPackage xmlPackage = new XmlPackage(packages);
//        xmlTest.setXmlPackages(Collections.singletonList(xmlPackage));
//        for(XmlSuite suite:suites) {
//            suite.addIncludedGroup("bdd_runner");
//            System.out.println("*****Suit"+ suite.getFileName() + "  Name: "+suite.getName());
//        }
    }
}
