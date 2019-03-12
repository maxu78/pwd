package com.fiberhome.pwd.exception;

import com.fiberhome.pwd.pojo.ResponseInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.PrintWriter;
import java.io.StringWriter;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object processException(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        ResponseInfo error = new ResponseInfo();
        if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
            error.setStatus("404");
        } else {
            error.setStatus("500");
        }
        error.setData(stackTraceToString(e));
        return error;
    }

    private static String stackTraceToString(Throwable e) {
        try {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            return sw.toString();
        } catch (Exception var1) {
            return  "bad StackToString";
        }
    }
}
