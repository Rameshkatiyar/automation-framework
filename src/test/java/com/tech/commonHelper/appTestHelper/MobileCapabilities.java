package com.tech.commonHelper.appTestHelper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MobileCapabilities {
    //BrowserStack Variables
    String platform;
    String device;
    String osVersion;
    String appUrl;

    String project;
    String testName;

    //Local App Test Variables
    String appPackage;
    String appActivity;
    String udid;
}
