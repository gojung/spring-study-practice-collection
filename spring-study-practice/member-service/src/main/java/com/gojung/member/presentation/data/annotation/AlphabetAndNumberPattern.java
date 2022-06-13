package com.gojung.member.presentation.data.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.regex.Pattern;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AlphabetAndNumberPattern.AlphabetAndNumberPatternValidator.class)
public @interface AlphabetAndNumberPattern {

  String message() default "숫자와 영문자만 사용할수 있습니다.";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  class AlphabetAndNumberPatternValidator implements
      ConstraintValidator<AlphabetAndNumberPattern, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
      if (value == null) {
        return false;
      }

      Pattern pattern = Pattern.compile("^[a-zA-Z0-9.,]*$");
      return pattern.matcher(value).find();
    }
  }
}
