package jsr.bean.validation.example;

import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SingerValidationService {
  @Autowired
  private Validator validator;

  public Set<ConstraintViolation<Singer>> validateSinger(Singer singer) {
    return validator.validate(singer);
  }
}
