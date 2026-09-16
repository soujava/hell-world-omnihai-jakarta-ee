package org.soujava.demo.jakarta.hello;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import org.omnifaces.ai.AIService;
import org.omnifaces.ai.cdi.AI;

@ApplicationScoped
public class NextReadBookService {

    @Inject
    @AI(
        apiKey = "${config:openai.api-key}",
        model = "${config:openai.model}",
        prompt = """
            Recommend up to 3 books that should naturally follow the provided book in a learning journey.

            Recommendations should prioritize:
            - conceptual progression
            - complementary knowledge
            - technical depth
            - thematic similarity

            For each recommendation provide:
            - title
            - author
            - concise description
            - relevant keywords
            - a short recommendation reason

            Keep recommendations concise, technically relevant, and focused on software engineering
            and architecture learning.
            """
    )
    private AIService aiService;

    public NextReadBooks recommend(BookRequest request) {
        var prompt = """
            Recommend the next books for this learning journey:
            Title: %s
            Author: %s
            """.formatted(request.title(), request.author());

        return aiService.chat(prompt, NextReadBooks.class);
    }
}