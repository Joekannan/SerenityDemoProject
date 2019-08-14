package com.TWG.Mobile.testRunners;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public final class AppiumServerController {

    private final static AppiumDriverLocalService service;

    static  {
        service = AppiumDriverLocalService.buildDefaultService();
    }
    public static void startAppiumServer(){
        try{
//        	Map<String, String> env = new HashMap<>(System.getenv());
//    		env.put("PATH", "/usr/local/bin:" + env.get("PATH"));
//                        AppiumServiceBuilder builder = new AppiumServiceBuilder()
//    				.withIPAddress("0.0.0.0")
//    				.usingPort(4723)
//    				.withEnvironment(env)
//    				.usingDriverExecutable(new File("/usr/local/bin/node"))
//    				.withAppiumJS(new File("/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js"));
//    		
//    		service = AppiumDriverLocalService.buildService(builder);
//                        service.start();
            service.start();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void stopAppiumServer() {
        try{
            if (service.isRunning()) {
                service.stop();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
