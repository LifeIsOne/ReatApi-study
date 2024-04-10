package shop.mtcoding.blog._core.errors;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import shop.mtcoding.blog._core.errors.exception.*;
import shop.mtcoding.blog._core.utils.ApiUtil;

// RuntimeException이 터지면 해당 파일로 오류가 모인다
@RestControllerAdvice // 데이터 응답
public class MyExceptionHandler {

    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping) || @annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void hello(JoinPoint jp){
        Object[] args = jp.getArgs(); // 파라메터(매개변수)
        System.out.println("크기 : "+args.length);

        for(Object arg : args){

            if(arg instanceof Errors){
                Errors errors = (Errors) arg;

                if(errors.hasErrors()){
                    for (FieldError error : errors.getFieldErrors()){
                        System.out.println(error.getField());
                        System.out.println(error.getDefaultMessage());

                        throw new Exception400(error.getDefaultMessage()+" : "+error.getField());
                    }
                }
            }

        }

        System.out.println("MyValidationHandler : 🧡💛💚💜🤎🖤💖💗💓💞💕❣💔🤍💘💝");
    }
}
