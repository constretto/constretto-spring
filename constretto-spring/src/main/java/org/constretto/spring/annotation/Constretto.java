package org.constretto.spring.annotation;

import org.constretto.spring.internal.ConstrettoImportRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to setup Constretto Spring BeanPostProcessors in Java-based Spring context.
 * <br>
 * If you provide this annotation without any arguments it will search for a public static non-arg method in your
 * configuration class that returns a {@link org.constretto.ConstrettoConfiguration} instance
 * (hint: use {@link org.constretto.ConstrettoBuilder} to create one).
 *
 * @author zapodot at gmail dot com
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(ConstrettoImportRegistrar.class)
@Documented
public @interface Constretto {

    /**
     * Should the Constretto based property placeholder BeanPostProcessor be enabled? Default is true
     *
     * @return a boolean indicating whether the Constretto property placeholder annotation should added to the Spring context
     */
    boolean enablePropertyPlaceholder() default true;

    /**
     * Should the Constretto annotation (for injecting configuration for {@link org.constretto.annotation.Configuration}
     * and {@link org.constretto.annotation.Configure} annotated fields and methods.
     *
     * @return a boolean indicating whether annotation support should be enabled
     */
    boolean enableAnnotationSupport() default true;


}
