package com.learn;

import com.learn.fastdfs.FastDFSFile;
import com.learn.fastdfs.FastdfsClient;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {

    private static org.slf4j.Logger logger = LoggerFactory.getLogger(FastdfsClient.class);

    @GetMapping("/upload")
    public  String get_upload(){
        return  "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:/uploadStatus";
        }
        try{
            String path=saveFile(file);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            redirectAttributes.addFlashAttribute("url",path);
        }catch (Exception e){
            logger.error("savefile error");
        }
        return "redirect:/uploadStatus";
    }
    private  String saveFile(MultipartFile file) throws  Exception{
        byte[] bytes={};
        String path=null;
        try {
            bytes = file.getBytes();
        }catch (Exception e) {
            logger.error("getBytes error");
        }
        String fileName=file.getOriginalFilename();
        String ext=fileName.substring(fileName.lastIndexOf(".")+1);
        String[] fileAbsolutePath={};
        FastDFSFile fastDFSFile=new FastDFSFile(fileName,bytes,ext);
        try{
            fileAbsolutePath= FastdfsClient.upload(fastDFSFile);
        }catch (Exception e){
            logger.error("upload file exception");
        }
        if(fileAbsolutePath == null)
            logger.error("upload file failed,please upload again");
        try{
            path=FastdfsClient.getTrackerUrl()+fileAbsolutePath[0]+"/"+fileAbsolutePath[1];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  path;
    }

    @GetMapping("/uploadStatus")
    public  String uploadStatus(){
        return "uploadStatus";
    }

    @RequestMapping("/fragment")
    public  String  fragment() {
        return "fragment";
    }
}
