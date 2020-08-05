package com.suzhe.fastdfs.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;


@Service
public class UploadServcice {

    @Value("${image.adress}")
    private String imageAdress;

    private static final List<String> allowTypes = Arrays.asList("image/png", "image/jpeg");

    private static final Logger logger = LoggerFactory.getLogger(UploadServcice.class);

    @Autowired
    private FastFileStorageClient storageClient;


    public void demo() {
//        storageClient.uploadSlaveFile();
        FastFileStorageClient storageClient;

    }

    public String upload(MultipartFile file){
        try{
            // 1、文件的校验
            // 1.1.校验文件类型
            String contentType = file.getContentType();
            if(!allowTypes.contains(contentType)){
                // 类型不匹配，直接返回null
                return null;
            }
            // 1.2.校验数据内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if(image == null){
                // 内容有问题
                return null;
            }

            // 2、保存到某个位置
//            file.transferTo(new File("D:\\heima29\\upload", file.getOriginalFilename()));

            // 2、上传到FastDFS
//           this.storageClient.uploadFile(
//                    file.getInputStream(), file.getSize(), getExtension(file.getOriginalFilename()), null);//非缩略图的上传方式

            StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(file.getInputStream(), file.getSize(),getExtension(file.getOriginalFilename()), null);
            // 3、生成图片地址
            String url =  imageAdress + storePath.getFullPath();

            return url;
        } catch (Exception e){
            logger.error("文件上传失败：文件名：{}", file.getOriginalFilename(), e);
            return null;
        }
    }

    public String getExtension(String fileName){
        return StringUtils.substringAfterLast(fileName,".");
    }
}
