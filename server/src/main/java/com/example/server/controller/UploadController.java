package com.example.server.controller;


import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;


@RestController
public class UploadController {

    @RequestMapping("/upload")
    public boolean upload(@RequestParam("file") MultipartFile file, HttpServletRequest request)
            throws IllegalStateException, IOException {

        System.out.println("UploadController.upload()");

        // 判断上传的文件是否为空
        boolean isEmpty = file.isEmpty();
        System.out.println("\tisEmpty=" + isEmpty);
        if (isEmpty) {
            throw new RuntimeException("上传失败！上传的文件为空！");
        }

        // 检查文件大小
        long fileSize = file.getSize();
        System.out.println("\tsize=" + fileSize);
        if (fileSize > 1 * 1024 * 1024) {
            throw new RuntimeException("上传失败！上传的文件大小超出了限制！");
        }

        // 检查文件MIME类型
        String contentType = file.getContentType();
        System.out.println("\tcontentType=" + contentType);


        // 准备文件夹,获取项目中upload文件夹的路径
//        String parentDir = request.getServletContext().getRealPath("upload");
        File directory = new File("");//设定为当前文件夹
        String parentDir=directory.getAbsolutePath()+"\\src\\main\\resources\\uploadFile";

        System.out.println("\tpath=" + parentDir);
        File parent = new File(parentDir);
        if (!parent.exists()) {
            parent.mkdirs();
        }

        // 获取原始文件名
        String originalFilename = file.getOriginalFilename();
        System.out.println("\toriginalFilename=" + originalFilename);

        // 确定最终保存时使用的文件
        String filename = UUID.randomUUID().toString();
        String suffix = "";
        int beginIndex = originalFilename.lastIndexOf(".");
        if (beginIndex != -1) {
            suffix = originalFilename.substring(beginIndex);
        }

        // 执行保存文件
        File dest = new File(parent, filename + suffix);
        file.transferTo(dest);

        return true;
    }

}
