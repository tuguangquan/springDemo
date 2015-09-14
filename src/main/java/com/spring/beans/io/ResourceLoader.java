package com.spring.beans.io;

import java.net.URL;

/**
 * User: kingkong.wang
 * Date: 15-7-23
 */
public class ResourceLoader {

    public Resource getResource(String location){
        URL resource = this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
