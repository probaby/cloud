package com.example.property;



import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author huangbiaof
 * @data 创建时间：2019/5/6 16:06
 */

public class PropertyDemo {


//    public static void main(String[] args) throws InterruptedException {
//        PropertyDemo pro = new PropertyDemo();
//        Configuration con = null;
//        ArrayList
//
//            try {
//                con = pro.getProperty();
//
//            } catch (Exception e) {
//                e.printStackTrace();
//            }winp
//            System.out.println(con.getString("ufs.config.base.dsname"));
//
//    }
//
//    public Configuration getProperty() throws Exception {
//        Parameters params = new Parameters();
//
//        // init file location strategy
//        List<FileLocationStrategy> subs = Arrays.asList(
//                new ProvidedURLLocationStrategy(),
//                new FileSystemLocationStrategy(),
//                new ClasspathLocationStrategy());// 此条被应用
//        FileLocationStrategy strategy = new CombinedLocationStrategy(subs);
//
//
//        File propertiesFile = new File(System.getProperty("user.dir") + "/src\\test\\resources/ufs.properties");
//        Configuration con = null;
//        if (propertiesFile.exists()) {
////            PropertiesBuilderParameters propertiesBuilderParameters = params.properties().setFile(propertiesFile)
////                    .setEncoding("UTF-8").setListDelimiterHandler(new DefaultListDelimiterHandler(','))
////                    .setThrowExceptionOnMissing(true).setLocationStrategy(strategy);
//
//
//            ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration> builder = new ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration>(
//                    PropertiesConfiguration.class).configure(params.properties().setFile(propertiesFile)
//                    .setEncoding("UTF-8"));
//            PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(), null, 1,
//                    TimeUnit.SECONDS);
//            trigger.start();
//
//            builder.addEventListener(ConfigurationBuilderEvent.RESET, (event) -> {
//                System.out.println("Event:" + event);
//            });
//
//            con = builder.getConfiguration();
//            while (true) {
//                Thread.sleep(1000);
//                System.out.println(builder.getConfiguration().getString("bbb"));
//            }
//            //return con;
//
//        }
//        return con;
//
//        //return con;
//    }
//
//
//    public Configuration getProperty2() {
//
//        Parameters params = new Parameters();
//        // Read data from this file
//        File propertiesFile = new File(System.getProperty("user.dir") + "/src\\test\\resources/config.properties");
//
//        // Use PropertiesConfiguration to read file
//        ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration> builder = new ReloadingFileBasedConfigurationBuilder<PropertiesConfiguration>(
//                PropertiesConfiguration.class).configure(params.fileBased().setFile(propertiesFile));
//
//        // check the file per second
////        PeriodicReloadingTrigger trigger = new PeriodicReloadingTrigger(builder.getReloadingController(), null, 1,
////                TimeUnit.SECONDS);
////
////        // start trigger
////        trigger.start();
//
//        try {
//            return builder.getConfiguration();
//        } catch (ConfigurationException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    public Configuration getProperty3() throws ConfigurationException {
//        Configurations configs = new Configurations();
//        Configuration con = configs.properties(new File(System.getProperty("user.dir") + "/src\\test\\resources/config.properties"));
//        return con;
//        // Configuration config = configs.properties(new File("config.properties"));
//    }

}
