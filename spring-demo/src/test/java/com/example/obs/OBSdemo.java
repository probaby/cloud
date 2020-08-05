//package com.example.obs;
//
//import com.obs.services.ObsClient;
//import com.obs.services.ObsConfiguration;
//import com.obs.services.model.AccessControlList;
//import com.obs.services.model.GroupGrantee;
//import com.obs.services.model.ObsBucket;
//import com.obs.services.model.Permission;
//
//import java.io.ByteArrayInputStream;
//
///**
// * @author huangbiaof
// * @data 创建时间：2019/12/13 16:18
// */
//
//public class OBSdemo {
//
//    private boolean existsBucket(String bucket, ObsClient obsClient) {
//
//        boolean exists = obsClient.headBucket(bucket);
//        if(exists) {
//            AccessControlList acl = obsClient.getBucketAcl(bucket);
//            acl.grantPermission(GroupGrantee.ALL_USERS, Permission.PERMISSION_READ);
//            System.out.println(acl.toString());
//            obsClient.setBucketAcl(bucket, acl);
//        }
//
//        if(!exists) {
//            ObsBucket obsBucket = new ObsBucket();
//            obsBucket.setBucketName(bucket);
//            AccessControlList acl = new AccessControlList();
//            acl.grantPermission(GroupGrantee.ALL_USERS, Permission.PERMISSION_READ);
//            obsBucket.setAcl(acl);
//            exists = obsClient.createBucket(obsBucket) != null;
//        }
//
//        return exists;
//
//    }
//
//
//    public void test(){
//        // Provide your Access Key
////        String ak = "90L8PNIEWU7PKPB8YJZ2";
////        // Provide your Secret Key
////        String sk = "7A5BHJMWpIdM5cPajJRzaUwNKksrvPrWUIXKqJGX";
//        String endPoint = "obs.cn-north-1.myhuaweicloud.com";
////        String endPoint = "obs.cn-north-1.myhwclouds.com";
//
//          String ak = "90L8PNIEWU7PKPB8YJZ2";
//
//         String sk = "7A5BHJMWpIdM5cPajJRzaUwNKksrvPrWUIXKqJGX";
//        ObsConfiguration config= new ObsConfiguration();
//        config.setHttpsOnly(true);
//        config.setValidateCertificate(true);
//        ObsClient obsClient = new ObsClient(ak, sk, endPoint);
//        //obsClient.createBucket("ssckanban");
//        existsBucket("nccloudobstest",obsClient);
//        obsClient.putObject("nccloudobstest", "test", new ByteArrayInputStream("hello".getBytes()));
//
//    }
//
//    public static void main(String[] args) {
//        new OBSdemo().test();
//    }
//}
