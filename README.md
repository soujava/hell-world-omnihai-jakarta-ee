# Jakarta EE with OmniHai

This sample uses [OmniHai](https://omnihai.org/) with CDI to generate structured book recommendations through OpenAI.

Put your OpenAI API key in the ignored `src/main/liberty/config/server.env` file:

```shell
OPENAI_API_KEY=your-openai-api-key
```

Then start Open Liberty:

```shell
mvn clean package liberty:run
```

The model is configured in `src/main/resources/META-INF/microprofile-config.properties`.

Request recommendations at `http://localhost:9080/books`:

```shell
curl --request POST http://localhost:9080/books \
  --header 'Content-Type: application/json' \
  --data '{"title":"Effective Java","author":"Joshua Bloch"}'
```
