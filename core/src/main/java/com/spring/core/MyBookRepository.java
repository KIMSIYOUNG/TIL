package com.spring.core;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class MyBookRepository implements BookRepository {
}
