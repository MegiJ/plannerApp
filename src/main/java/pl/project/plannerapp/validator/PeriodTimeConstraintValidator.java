package pl.project.plannerapp.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import pl.project.plannerapp.model.Period;
import pl.project.plannerapp.model.PeriodTime;

public class PeriodTimeConstraintValidator implements ConstraintValidator<PeriodTimeConstraint, PeriodTime> {
    @Override
    public void initialize(PeriodTimeConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PeriodTime periodTime, ConstraintValidatorContext context) {
        try {
            return periodTime.getBegin() == null || periodTime.getEnd() == null || periodTime.getBegin().isBefore(periodTime.getEnd());
        } catch (Exception e) {
            return false;
        }
    }
}
