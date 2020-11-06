package com.transample.demo.controller;

import com.transample.demo.common.ResponseResult;
import com.transample.demo.config.MinioConfig;
import com.transample.demo.constants.ImgConstants;
import com.transample.demo.service.ITaoInterfaceService;
import com.transample.demo.utils.DateUtils;
import com.transample.demo.utils.ImageUtils;
import com.transample.demo.utils.MinioUtil;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/image")
@Api(tags = "图片相关API")
public class ImageController {

    @Resource
    private MinioUtil minioUtil;
    @Resource
    private ITaoInterfaceService taoInterfaceService;

    @Value("img")
    private String bucketName;

    @PostMapping("/addImg")
    public ResponseEntity add(HttpServletRequest request, @RequestParam("file") MultipartFile uploadFile) {
        String type = ImageUtils.checkFileType(uploadFile);
        if (StringUtils.isNotBlank(type)) {
            Long time = System.nanoTime();
            String  name = DateUtils.getNowDate() + "/" + time.toString() + "." + type.toLowerCase();
            if(!minioUtil.bucketExists(bucketName))
            {
                minioUtil.makeBucket(bucketName);
            }

            minioUtil.putObject(bucketName, uploadFile, name);
            ModelMap modelMap = new ModelMap();
            modelMap.put("imgUrl", name);
            return ResponseEntity.ok(ResponseResult.ok(modelMap));
        }
        return ResponseEntity.ok(ResponseResult.fail("上传图片失败"));


    }
//    @GetMapping("/test")
//    public String test()
//    {
//        return taoInterfaceService.getInterfaceId("taoAddress","getProvinceList");
//    }
}
