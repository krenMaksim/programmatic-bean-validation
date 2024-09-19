package com.example.bean.validation.conf;

import com.example.bean.validation.constraint.UserIdDef;
import com.example.bean.validation.entity.User;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.hibernate.validator.cfg.ConstraintMapping;
import org.hibernate.validator.cfg.context.TypeConstraintMappingContext;
import org.hibernate.validator.cfg.defs.NotNullDef;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.SpringConstraintValidatorFactory;

@Configuration
class ValidationConf {

  @Bean
  Validator validator(AutowireCapableBeanFactory autowireCapableBeanFactory) {
    HibernateValidatorConfiguration conf = Validation.byProvider(HibernateValidator.class).configure();
    ConstraintMapping constraintMapping = conf.createConstraintMapping();

    TypeConstraintMappingContext<User> context = constraintMapping.type(User.class);
    context.field("id").constraint(new UserIdDef());
    context.field("name").constraint(new NotNullDef());

    return conf.allowOverridingMethodAlterParameterConstraint(true)
        .addMapping(constraintMapping)
        .constraintValidatorFactory(new SpringConstraintValidatorFactory(autowireCapableBeanFactory))
        .buildValidatorFactory()
        .getValidator();
  }
}
