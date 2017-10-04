package com.taotao.controller;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author:VbisoWen
 * @Description:
 * @Date:Create in 18:36 2017/10/4
 * @Modified By:
 */
public class FTPTest {

    @Test
    public void testFTPClient() throws IOException {
        FTPClient ftpClient = new FTPClient();

        ftpClient.connect("192.168.159.130", 21);
        ftpClient.login("ftpuser", "123456");
        FileInputStream file = new FileInputStream(new File("E:\\pictures\\561c77211a44291ccc36af919830a069.jpg"));
        ftpClient.changeWorkingDirectory("/home/ftpuser/www/images");
        ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);
        ftpClient.storeFile("hello1.jpg", file);
        ftpClient.logout();
    }
}
