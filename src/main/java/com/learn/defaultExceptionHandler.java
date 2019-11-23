package com.learn;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class defaultExceptionHandler {

    @ExceptionHandler(MultipartException.class)
    public  String  exceptionHandler(MultipartException e, RedirectAttributes redirectAttributes) {
        System.out.println("in exceptionHandler");
        redirectAttributes.addAttribute("message",e.getCause().getMessage());
        System.out.println("in exceptionHandler2222");

        return "redirect:/uploadStatus";
    }
}
