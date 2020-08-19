package com.tech.commonHelper.commonApi;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.tech.annotations.Testable;
import com.tech.config.TestConfig;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testng.IAlterSuiteListener;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import java.util.ArrayList;
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
        System.out.println("TestConfig::::: "+testConfig);
        String group = "SMOKE"; //Take from mvn parameters
        //TODO: Also take the test names as a paremeters and execute only those.
        testNgXMLSetUp(suites, group);
    }

    private void testNgXMLSetUp(List<XmlSuite> suites, String group){
        XmlSuite xmlSuite = new XmlSuite();
        xmlSuite.setName("Regression");
        xmlSuite.addIncludedGroup(group);
        xmlSuite.setThreadCount(getParallelThreadCount());
        xmlSuite.setParallel(XmlSuite.ParallelMode.CLASSES);

        Multimap<String, String> testableClasses = findTestableClasses();

        testableClasses.keySet().stream()
                .forEach(
                        testName -> {
                            XmlTest xmlTest = new XmlTest(xmlSuite);
                            xmlTest.setName(testName);
                            List<XmlClass> xmlClasses = getXmlClasses(testableClasses, testName);
                            xmlTest.setXmlClasses(xmlClasses);

                        }
                );

        suites.add(xmlSuite);
    }

    private List<XmlClass> getXmlClasses(Multimap<String, String> testableClasses, String testName) {
        List<XmlClass> xmlClasses = new ArrayList<>();
        testableClasses.get(testName).stream()
                .forEach(
                        testClass -> {
                            xmlClasses.add(new XmlClass(testClass));
                        }
                );
        return xmlClasses;
    }

    /**
     * Used Java Reflection to get the all testable annotated classes info.
     * @return
     */
    private Multimap<String, String> findTestableClasses(){
        Multimap<String, String> testNameToTestClass = ArrayListMultimap.create();
        Reflections reflections = new Reflections("com.tech");
        for (Class<?> cl : reflections.getTypesAnnotatedWith(Testable.class)) {
            Testable testable = cl.getAnnotation(Testable.class);
            testNameToTestClass.put(testable.testName(), cl.getName());
        }
        return testNameToTestClass;
    }

    /**
     * Its based on current system's cores.
     * thread count = no. of cores * 1.5
     * Also it's depend on memory and some research on this.
     * @return
     */
    private static int getParallelThreadCount(){
        int cores = Runtime.getRuntime().availableProcessors();
        if (cores == 0){
            log.error("No free cores are available.");
            return 1;
        }
        int threads = (int) Math.floor(cores * 1.5);

        return threads;
    }
}
