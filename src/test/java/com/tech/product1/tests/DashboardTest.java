package com.tech.product1.tests;

import com.tech.annotations.Platforms;
import com.tech.enums.Platform;
import com.tech.product1.common.Product1BaseAutomation;
import org.testng.annotations.Test;

public class DashboardTest extends Product1BaseAutomation {

    @Platforms({Platform.WEB, Platform.APP})
    @Test(description = "verify dashboard page contain logo.")
    public void test1() {



    }

    @Platforms({Platform.WEB})
    @Test(description = "verify dashboard page contain logo.")
    public void test2() {

    }
}
