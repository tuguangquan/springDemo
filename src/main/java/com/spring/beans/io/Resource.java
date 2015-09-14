package com.spring.beans.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * User: kingkong.wang
 * Date: 15-7-23
 */
public interface Resource {

    InputStream getInputStream() throws IOException;
}
