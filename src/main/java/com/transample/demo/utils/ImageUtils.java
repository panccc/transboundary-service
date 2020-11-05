package com.transample.demo.utils;

import com.transample.demo.utils.file.FileType;
import com.transample.demo.utils.file.FileTypeJudge;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: huangjg
 * @Date: 2020/9/8 20:15
 * @Description:
 */
@Slf4j
public class ImageUtils {
    public static final String[] IMG_TYPES = {"BMP", "JPG", "JPEG", "GIF", "PNG", "MP4","FLV","AVI","WMV"};


    public static String checkFileType(MultipartFile file) {
        String result = null;
        try {
            InputStream inputStream = file.getInputStream();
            FileType fileType = FileTypeJudge.getType(inputStream);
            if (null == fileType) {
                return result;
            }
            for (String type : IMG_TYPES) {
                if (fileType.name().equals(type)) {
                    System.out.println(fileType.getValue());
                    result = fileType.name();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}