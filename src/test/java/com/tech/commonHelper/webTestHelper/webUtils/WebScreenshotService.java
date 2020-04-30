package com.tech.commonHelper.webTestHelper.webUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebScreenshotService {
//    public WebDriver captureScreenShots(WebDriver driver, String directory, String imageName){
//        String screenshotPath = webPathConfig.getWebScreenshotsPath().concat(directory + "/");
//        String imageNameWithExtension = getProperImageName(imageName);
//
//        try {
//
//            //  Shutterbug.shootPage(driver, ScrollStrategy.BOTH_DIRECTIONS).withName(imageName).save(screenshotPath);
//            //  webPageFullPageScreenshotService.makeFullScreenshot(driver, directory.concat(imageName+".png"));
//            Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(100)).takeScreenshot(driver);
//            ImageIO.write(screenshot.getImage(),"PNG",new File(screenshotPath+imageNameWithExtension));
//
//            log.info("Screenshot created and copy at locatoin {}", screenshotPath.concat(imageNameWithExtension));
//            return driver;
//        } catch (Exception e) {
//            log.info("Exception : {}", e.getMessage());
//            return driver;
//        }
//    }
//
//    public String getProperImageName(String img){
//        if (Strings.isNullOrEmpty(img)){
//            return "blank.png";
//        }
//        if (!img.contains(".png")){
//            return img.concat(".png");
//        }
//        return img;
//    }

}
