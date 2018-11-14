package com.practice;

@interface Author {
    String value();
    String name() default "John Doe";
    String date() default "1997-12-01";
}
