package com.fasterxml.jackson.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * TODO: 这个注解只在反序列化时使用，指定该java属性可以接受的更多名称，也就是别名嘛
 * Annotation that can be used to define one or more alternative names for
 * a property, accepted during deserialization as alternative to the official
 * name. Alias information is also exposed during POJO introspection, but has
 * no effect during serialization where primary name is always used.
 *<p>
 * Examples:
 *<pre>
 *public class Info {
 *  &#64;JsonAlias({ "n", "Name" })
 *  public String name;
 *}
 *</pre>
 *
 * @since 2.9
 */
@Target({ElementType.ANNOTATION_TYPE, // for combo-annotations
    ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER// for properties (field, setter, ctor param)
})
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotation
public @interface JsonAlias
{
    /**
     * One or more secondary names to accept as aliases to the official name.
     *
     * @return Zero or more aliases to associate with property annotated
     */
    public String[] value() default { };
}
