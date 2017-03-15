package com.nokia.training.d01.s05;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.util.Date;

@Target(value = {ElementType.TYPE})
public @interface TrainingSession {
    TrainingDay day();
    String topic();			            // makes the ‘topic’ element mandatory
    String[] subTopics() default {};	// note the use of an array of elements
}
