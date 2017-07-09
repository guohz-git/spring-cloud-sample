package com.hysky.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Upload File Controller
 */
@Controller
public class FileUploadController  {

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(@RequestParam(value = "file"
            ,required = true) MultipartFile file) throws IOException{
//        byte[] bytes = file.getBytes();
//        File fileToSave = new File(file.getOriginalFilename());
//        FileCopyUtils.copy(bytes,fileToSave);

        String filename = file.getOriginalFilename();

        String path = "E:\\";


        // 实例化一个文件字节输出流，通过路径加上文件名
        FileOutputStream fs = new FileOutputStream(path + "/" + filename);
        FileCopyUtils.copy(file.getInputStream(),fs);

//        InputStream stream = file.getInputStream();
//
//        // 实例化字节数组，用于读写文件
//        byte[] buffer = new byte[1024 * 1024];
//
//        //已读自己变量
//        int byteRead = 0;
//        // 进行文件读写操作
//        while ((byteRead = stream.read(buffer)) != -1) {
//            fs.write(buffer, 0, byteRead);
//            //刷新文件流
//            fs.flush();
//        }
//        // 流对象关闭操作
//        fs.close();
//        stream.close();
        return path + "/" + filename;
    }



    @RequestMapping(value = "/msg")
    @ResponseBody
    public String handleFileUpload() throws IOException{
       return "msg";
    }
}
