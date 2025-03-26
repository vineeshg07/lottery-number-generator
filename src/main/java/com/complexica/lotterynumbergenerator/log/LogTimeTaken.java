package com.complexica.lotterynumbergenerator.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.logging.Level;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LogTimeTaken {
    Level level() default LogTimeTaken.Level.INFO;

    public static enum Level {
        DEBUG,
        INFO;

        private Level() {
        }
    }
}
