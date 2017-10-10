package com.taotao.service;

import com.taotao.common.pojo.PictureResult;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author:VbisoWen
 * @Description:
 * @Date:Create in 20:21 2017/10/4
 * @Modified By:
 */
public interface PictureService {

    public PictureResult upload(MultipartFile uploadFile);
}
