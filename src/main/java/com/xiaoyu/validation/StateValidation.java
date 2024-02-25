package com.xiaoyu.validation;

import com.xiaoyu.anno.State;
import jakarta.validation.Constraint;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: zhangyu
 * @Date: 2024/02/25/19:45
 * @Description:
 */
public class StateValidation implements ConstraintValidator<State,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
    //提供校验规则
        if(value==null){
            return  false;
        }
        if (value.equals("已发布")||value.equals("草稿")){
            return  true;
        }
        return  false;
    }
}
