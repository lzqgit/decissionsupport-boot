package com.phy.decisionsupport.uac;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * Created by Administrator on 2018/8/27.
 */

@ControllerAdvice("com.phy.decisionsupport")
public class WebExceptionHandler {

    /**
     * 日志log
     */
    private static Logger log = LoggerFactory.getLogger(WebExceptionHandler.class);
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity operateExp(Exception  ex, HttpServletRequest request, HttpServletResponse response) {
        String message = ex.getMessage();
        log.debug(Objects.requireNonNull(message, ex.getClass().getSimpleName()));
//        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new JsonResult(1,message));
    }

}