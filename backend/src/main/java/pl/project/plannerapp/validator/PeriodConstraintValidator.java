package pl.project.plannerapp.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.project.plannerapp.model.Period;

public class PeriodConstraintValidator implements ConstraintValidator<PeriodConstraint, Period> {
    @Override
    public void initialize(PeriodConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Period period, ConstraintValidatorContext context) {
        try {
            return period.getBegin() == null || period.getEnd() == null || period.getBegin().isBefore(period.getEnd());
        } catch (Exception e) {
            return false;
        }
    }
}
