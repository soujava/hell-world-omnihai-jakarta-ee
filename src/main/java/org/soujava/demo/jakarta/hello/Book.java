package org.soujava.demo.jakarta.hello;

import java.util.List;

public record Book(
        String title,
        String author,
        String description,
        List<String> keywords
) {
}