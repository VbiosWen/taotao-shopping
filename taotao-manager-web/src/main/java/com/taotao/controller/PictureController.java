package com.taotao.controller;

import com.taotao.common.pojo.PictureResult;
import com.taotao.common.util.JsonUtils;
import com.taotao.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author:VbisoWen
 * @Description:
 * @Date:Create in 20:44 2017/10/4
 * @Modified By:
 */
@Controller
@RequestMapping("/pic")
public class PictureController {


    @Autowired
    private PictureService pictureService;

    @RequestMapping("/upload")
    @ResponseBody
    public PictureResult upload(MultipartFile uploadFile) {
        PictureResult result = pictureService.upload(uploadFile);

        return result;
    }

}




