package com.boot.board_250509.validator;

import com.boot.board_250509.model.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Slf4j
//@Autowired 와 연결
@Component
public class BoardValidator implements Validator {

    /**
     * This Validator validates only Person instances
     */
    public boolean supports(Class clazz) {
        return Board.class.equals(clazz);
    }

    public void validate(Object obj, Errors e) {
        log.info("@# validate()");

        Board b = (Board) obj;
        log.info("@# b=>"+b);

        if (b.getContent().equals("")){
            e.rejectValue("content", "key","내용을 입력하세요.");
        }
    }
}