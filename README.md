![Maven Central](https://img.shields.io/maven-central/v/io.github.reactiveclown/openai-webflux-client-spring-boot-starter?color=green)
![Stars](https://img.shields.io/github/stars/reactiveclown/openai-webflux-java?style=social)
# Reactive OpenAI API client library.

This is the Reactive OpenAI client library.

It was written using WebFlux and Spring Boot. The library also contains pre-configured Spring Boot starter for easier
usage.

The library is unofficial and community-maintained. Feel free to join the development.

# Table of Contents

- ### [Supported APIs](#supported)
- ### [Installation](#installations)
- ### [Usage](#usages)
- ### [Contributing](#contributings)
- ### [License](#licence)

## <a id="supported"></a>Supported APIs

- [Models service](#models-service)
- [Completions service](#completions-service)
- [Chat service](#chat-service)
- [Edits service](#edits-service)
- [Images service](#images-service)
- [Embeddings service](#embeddings-service)
- [Audio service](#audio-service)
- [Files service](#files-service)
- [Fine-tunes service](#fine-tunes-service)
- [Moderations service](#moderations-service)

## <a id="installations"></a>Installation

Dependency import via **Maven**:

```xml

<dependency>
    <groupId>io.github.reactiveclown</groupId>
    <artifactId>openai-webflux-client-spring-boot-starter</artifactId>
    <version>0.9.1</version>
</dependency>
```

Dependency import via **Gradle**:

```implementation 'io.github.reactiveclown:openai-webflux-client-spring-boot-starter:0.9.1'```


After adding the dependency remember to add yor OpenAI api key to the application.properties.
```properties
com.github.reactiveclown.openai.apiKey=OPENAI_API_KEY
```

You can also add the Organization id and change baseUrl by providing next configuration variables.
But this step is not mandatory one.
```properties
com.github.reactiveclown.openai.organizationId=OPENAI_ORGANIZATION_ID
com.github.reactiveclown.openai.baseUrl=OPENAI_CUSTOM_BASE_URL
```

## <a id="usages"></a>Usage

Here you can find some usage examples.
Also, kindly use the official documentation in order to get more information about parameters.

---
#### <a id="models-service"></a>Models service

[OpenAI Models Docs](https://platform.openai.com/docs/api-reference/models)

Models service is used to retrieve the list of models or information about specific model.

```java
@Service
public class ExampleService {

    private final ModelsService service;

    public ExampleService(ModelsService service) {
        this.service = service;
    }

    public Mono<ListModelsResponse> listModels() {
        return service.listModels();
    }

    public Mono<RetrieveModelResponse> retrieveModel(String modelName) {
        return service.retrieveModel(modelName);
    }
}
```
---

#### <a id="completions-service"></a>Completions service

[OpenAI Completions Docs](https://platform.openai.com/docs/api-reference/completions)

Completions service is used to complete the text. Fell free to play around with builder parameters.

```java
@Service
public class ExampleService {

    private final CompletionsService service;

    public ExampleService(CompletionsService service) {
        this.service = service;
    }

    public Mono<CreateCompletionResponse> createCompletion() {
        return service.createCompletion(
                CreateCompletionRequest
                        .builder("babbage")
                        .n(2)
                        .bestOf(1)
                        .build());
    }
}
```
---

#### <a id="chat-service"></a>Chat service

[OpenAI Chat Docs](https://platform.openai.com/docs/api-reference/chat)

Chat service is used to chat with the chat models. Fell free to play around with builder parameters.

```java
@Service
public class ExampleService {

    private final ChatService service;

    public ExampleService(ChatService service) {
        this.service = service;
    }

    public Mono<CreateChatCompletionResponse> createChatCompletion() {
        return service.createChatCompletion(
                CreateChatCompletionRequest
                        .builder("gpt-3.5-turbo", List.of(new MessageData("user","do something")))
                        .n(3)
                        .build());
    }
}
```
---

#### <a id="edits-service"></a>Edits service

[OpenAI Edits Docs](https://platform.openai.com/docs/api-reference/edits)

Edits service is used to make an edits to the provided input. Fell free to play around with builder parameters.

```java
@Service
public class ExampleService {

    private final EditsService service;

    public ExampleService(EditsService service) {
        this.service = service;
    }

    public Mono<CreateEditResponse> createEdit() {
        return service.createEdit(
                CreateEditRequest
                        .builder("babbage", "Add one digit after every word")
                        .input("One Two Three")
                        .build());
    }
}
```
---

#### <a id="images-service"></a>Images service

[OpenAI Images Docs](https://platform.openai.com/docs/api-reference/images)

Image service is used to generate a different images and their transformations.
> ⚠️ As for now, methods that are requiring images are blocking. In the nearest future it is planned to add async FilePart implementation.

```java
@Service
public class ExampleService {

    private final ImagesService service;

    public ExampleService(ImagesService service) {
        this.service = service;
    }

    //Non-blocking
    public Mono<CreateImageResponse> createImage() {
        return service.createImage(
                CreateImageRequest
                        .builder("Generate a digital art of Ukraine")
                        .build());
    }

    //Blocking
    public Mono<CreateImageVariationResponse> createImageVariation() {
        return service.createImageVariation(
                CreateImageVariationRequest
                        .builder("src/main/resources/exampleImage.png")
                        .size("512x512")
                        .build());
    }

    //Blocking
    public Mono<CreateImageEditResponse> createImageEdit() {
        return service.createImageEdit(
                CreateImageEditRequest
                        .builder("src/main/resources/exampleImage.png", "Generate a green fields")
                        .mask("src/main/resources/exampleMask.png")
                        .build());
    }
}
```
---

#### <a id="embeddings-service"></a>Embeddings service

[OpenAI Embeddings Docs](https://platform.openai.com/docs/api-reference/embeddings)

Embedding service is used to create embeddings. Fell free to play around with builder parameters.

```java
@Service
public class ExampleService {

    private final EmbeddingsService service;

    public ExampleService(EmbeddingsService service) {
        this.service = service;
    }

    public Mono<CreateEmbeddingsResponse> createEmbeddings(){
        return service.createEmbeddings(
                CreateEmbeddingsRequest
                        .builder("babbage", "example input")
                        .build());
    }
}
```
---

#### <a id="audio-service"></a> Audio service

[OpenAI Audio Docs](https://platform.openai.com/docs/api-reference/audio)

Audio service is used to turn audio into text, also to make a translations into English. Fell free to play around with builder parameters.
> ⚠️ As for now, methods that are requiring audio files are blocking. In the nearest future it is planned to add async FilePart implementation.

```java
@Service
public class ExampleService {

    private final AudioService service;

    public ExampleService(AudioService service) {
        this.service = service;
    }

    //Blocking
    public Mono<CreateTranscriptionResponse> createTranscription() {
        return service.createTranscription(
                CreateTranscriptionRequest
                        .builder("src/main/resources/exampleAudio.mp3", "whisper-1")
                        .build());
    }

    //Blocking
    public Mono<CreateTranslationResponse> createTranslation(){
        return service.createTranslation(CreateTranslationRequest
                .builder("src/main/resources/exampleAudio.mp3", "whisper-1")
                .build());
    }
}
```
---

#### <a id="files-service"></a>Files service

[OpenAI Files Docs](https://platform.openai.com/docs/api-reference/files)

File service is used to upload and work with files. Fell free to play around with builder parameters.
> ⚠️ As for now, methods that are requiring files are blocking. In the nearest future it is planned to add async FilePart implementation.

```java
@Service
public class ExampleService {

    private final FilesService service;

    public ExampleService(FilesService service) {
        this.service = service;
    }

    public Mono<ListFilesResponse> listFilesResponse() {
        return service.listFiles();
    }
    
    //Blocking
    public Mono<UploadFileResponse> uploadFile() {
        return service.uploadFile(
                UploadFileRequest
                        .builder("src/main/resources/exampleFile.jsonl", "finetune")
                        .build());
    }

    public Mono<DeleteFileResponse> deleteFile() {
        return service.deleteFile("fileId");
    }

    public Mono<RetrieveFileResponse> retrieveFile() {
        return service.retrieveFile("fileId");
    }

    public Mono<String> retrieveFileContent() {
        return service.retrieveFileContent("fileId");
    }
}
```
---

#### <a id="fine-tunes-service"></a>Fine-tunes service

[OpenAI Fine-tunes Docs](https://platform.openai.com/docs/api-reference/fine-tunes)

Fine-tunes service is used to work with fine-tune files and models. Fell free to play around with builder parameters.

```java
@Service
public class ExampleService {

    private final FineTunesService service;

    public ExampleService(FineTunesService service) {
        this.service = service;
    }

    public Mono<CreateFineTuneResponse> createFineTune(){
        return service.createFineTune(
                CreateFineTuneRequest
                        .builder("trainingFileId")
                        .build());
    }

    public Mono<ListFineTunesResponse> listFineTunes(){
        return service.listFineTunes();
    }

    public Mono<RetrieveFineTuneResponse> retrieveFineTune(){
        return service.retrieveFineTunes("fineTuneId");
    }

    public Mono<CancelFineTuneResponse> cancelFineTune(){
        return service.cancelFineTune("fineTuneId");
    }

    public Mono<ListFineTuneEventsResponse> listFineTuneEvents(){
        return service.listFineTuneEvents("fineTuneId");
    }

    public Mono<DeleteFineTuneModelResponse> deleteFineTuneModel(){
        return service.deleteFineTuneModel("modelId");
    }
}
```
---

#### <a id="moderations-service"></a>Moderations service

[OpenAI Moderations Docs](https://platform.openai.com/docs/api-reference/moderations)

Moderations service is used to check for moderation violations. Fell free to play around with builder parameters.

```java
@Service
public class ExampleService {

    private final ModerationsService service;

    public ExampleService(ModerationsService service) {
        this.service = service;
    }

    public Mono<CreateModerationResponse> createModeration() {
        return service.createModeration(
                CreateModerationRequest.builder("violating input").build());
    }
}
```

## <a id="contributings"></a>How can I help?

This is the open-source library, any help will be much appreciated. If you can see that there is a way to improve the code or functionality,
kindly fill out the issue or make a pull request with your changes. Also feel free to look at opened issues and submit a pull request if you have your solution.

## <a id="licence"></a>License

```text
MIT License

Copyright (c) 2023 Maksym Volkov

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```