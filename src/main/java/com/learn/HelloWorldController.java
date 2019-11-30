package com.learn;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

//@Controller
//public class HelloWorldController {
//       private static final String  UPLOADED_FOLDER="C:\\Users\\think\\Downloads\\";
////     @RequestMapping(value = "/")
////     public  String sayHello(ModelMap map)
////     {
//////         map.addAttribute("message","http://www.xwing.com");
//////         map.addAttribute("userName","xx");
//////         map.addAttribute("date", new Date());
////         return "upload";
////
////     }
//      @GetMapping("/")
//      public String index(){
//          return "upload";
//      }
//
//      @PostMapping("/upload")
//      public String singleFileUpload(@RequestParam("file") MultipartFile file,
//                                     RedirectAttributes redirectAttributes) {
//          if (file.isEmpty()) {
//              redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//              return "redirect:/uploadStatus";
//          }
//          try {
//              // Get the file and save it somewhere
//              byte[] bytes = file.getBytes();
//              // UPLOADED_FOLDER 文件本地存储地址
//              Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//              Files.write(path, bytes);
//
//              redirectAttributes.addFlashAttribute("message",
//                      "You successfully uploaded '" + file.getOriginalFilename() + "'");
//
//          } catch (IOException e) {
//              e.printStackTrace();
//          }
//          return "redirect:/uploadStatus";
//      }
//
//      @GetMapping("/uploadStatus")
//      public  String uploadStatus(){
//          return "uploadStatus";
//      }
//
//     @RequestMapping("/fragment")
//    public  String  fragment() {
//          return "fragment";
//     }
//}
