package spittr.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import spittr.exeception.DuplicateSpittleException;

/**
 * <p>Title: AppWideExceptionHandler</p>
 *
 * @description: 控制器通知类 能处理所有控制器
 * @author: xiongzy
 * @date: 2018-10-24
 **/

@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(DuplicateSpittleException.class)
    public String handleDuplicateSpittle() {
        return "error/duplicate";
    }
}