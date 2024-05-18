package com.mozip.handler;

import com.mozip.dto.CMRespDto;
import com.mozip.handler.ex.CustomApiException;
import com.mozip.handler.ex.CustomException;
import com.mozip.handler.ex.CustomValidationApiException;
import com.mozip.handler.ex.CustomValidationException;
import com.mozip.util.Script;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public String exception(CustomException e) {
        return Script.back(e.getMessage());
    }

    @ExceptionHandler(CustomValidationException.class) //CustomValidationException 이 발생하는 모든 오류를 이 메서드가 가로챈다.
    public String validationException(CustomValidationException e) {
        // CMRespDto, Script 비교
        // 1. 클라이언트에게 응답할 때는 Script 좋음.
        // 2. Ajax 통신을 할 때에는 CMRespDto 가 좋다.
        // 3. Android 통신 - CMRespDto 가 좋다.
        if (e.getErrorMap() == null) {
            return Script.back(e.getMessage());
        } else {
            return Script.back(e.getErrorMap().toString());
        }
    }

    @ExceptionHandler(CustomApiException.class)
    public ResponseEntity<?> apiException(CustomApiException e) {
        return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), null), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomValidationApiException.class) //CustomValidationException 이 발생하는 모든 오류를 이 메서드가 가로챈다.
    public ResponseEntity<?> validationException(CustomValidationApiException e) {
        return new ResponseEntity<>(new CMRespDto<>(-1, e.getMessage(), e.getErrorMap()), HttpStatus.BAD_REQUEST);
    }
}
