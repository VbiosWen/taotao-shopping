package com.taotao.service.impl;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.util.FtpUtil;
import com.taotao.common.util.IDUtils;
import com.taotao.service.PictureService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Author:VbisoWen
 * @Description: 图片上传业务实现
 * @Date:Create in 20:23 2017/10/4
 * @Modified By:
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Value("${host}")
    private String host;
    @Value("${port}")
    private int port;
    @Value("${ftpusername}")
    private String username;
    @Value("${password}")
    private String password;
    @Value("${basepath}")
    private String basepath;
    @Value("${imageBaseUrl}")
    private String imageBaseUrl;

    @Override
    public Map upload(MultipartFile uploadFile) {
        HashMap<Object, Object> map = new HashMap<>();

        /**
         * 判断图片是否为空 为空直接返回错误信息
         */
        if (uploadFile == null || uploadFile.isEmpty()) {
            map.put("error", 1);
        }
        //获取图片名称
        String originalFilename = uploadFile.getOriginalFilename();
        //获取图片的后缀标识
        String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
        //生成新的图片名称
        String imageName = IDUtils.genImageName() + ext;

        //生成图片的存放路径 以日期格式(/yyyy/mm/dd)为基础
        DateTime dateTime = new DateTime();
        String filePath = dateTime.toString("/yyyy/MM/dd");

        try {
            //上传文件到nginx服务器
            FtpUtil.uploadFile(host, port, username, password, basepath, filePath, imageName, uploadFile.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            //上传失败 返回失败信息
            map.put("error", 1);
        }
        map.put("error", 0);
        map.put("url", imageBaseUrl + filePath + "/" + imageName);
        return map;
    }
}
