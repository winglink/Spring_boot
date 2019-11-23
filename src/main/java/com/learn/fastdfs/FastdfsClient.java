package com.learn.fastdfs;

import org.csource.fastdfs.*
public class FastdfsClient {

    static  {
        try{
            ClientGlobal.initByProperties("fastfs-client.properties");
        }catch (Exception e){

        }
    }
}
