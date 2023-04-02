# Reactive OpenAI API client library.

This is the Reactive OpenAI client library.

It was written using WebFlux and Spring Boot. The library also contains pre-configured Spring Boot starter for easier
usage.

# Table of Contents

- ### [Supported APIs](#supported)
- ### [Installation](#installations)
- ### [Usage](#usages)
- ### [Contributing](#contributings)
- ### [License](#licence)

## <a id="supported"></a>Supported APIs

- [Audio service](#audio-service)
- [Chat service](#chat-service)
- [Completions service](#completions-service)
- [Edits service](#edits-service)
- [Embeddings service](#embeddings-service)
- [Files service](#files-service)
- [Fine-tunes service](#fine-tunes-service)
- [Images service](#images-service)
- [Models service](#models-service)
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

## <a id="usages"></a>Usage

Here you can find some usage examples.
Also, kindly use the official documentation in order to get more information about parameters.

---
#### <a id="models-service"></a>Models service

[OpenAI Models Docs](https://platform.openai.com/docs/api-reference/models)

Some explanations with code

```java
Some java code
```
---

#### <a id="completions-service"></a>Completions service

[OpenAI Completions Docs](https://platform.openai.com/docs/api-reference/completions)

Some explanations with code

```java
Some java code
```
---

#### <a id="chat-service"></a>Chat service

[OpenAI Chat Docs](https://platform.openai.com/docs/api-reference/chat)

Some explanations with code

```java
Some java code
```
---

#### <a id="edits-service"></a>Edits service

[OpenAI Edits Docs](https://platform.openai.com/docs/api-reference/edits)

Some explanations with code

```java
Some java code
```
---

#### <a id="images-service"></a>Images service

[OpenAI Images Docs](https://platform.openai.com/docs/api-reference/images)

Some explanations with code

```java
Some java code
```
---

#### <a id="embeddings-service"></a>Embeddings service

[OpenAI Embeddings Docs](https://platform.openai.com/docs/api-reference/embeddings)

Some explanations with code

```java
Some java code
```
---

#### <a id="audio-service"></a> Audio service

[OpenAI Audio Docs](https://platform.openai.com/docs/api-reference/audio)

Some explanations with code

```java
Some java code
```
---

#### <a id="files-service"></a>Files service

[OpenAI Files Docs](https://platform.openai.com/docs/api-reference/files)

Some explanations with code

```java
Some java code
```
---

#### <a id="fine-tunes-service"></a>Fine-tunes service

[OpenAI Fine-tunes Docs](https://platform.openai.com/docs/api-reference/fine-tunes)

Some explanations with code

```java
Some java code
```
---

#### <a id="moderations-service"></a>Moderations service

[OpenAI Moderations Docs](https://platform.openai.com/docs/api-reference/moderations)

Some explanations with code

```java
Some java code
```

## <a id="contributings"></a>How can I help?

This is the open-source library, any help will be much appreciated. If you can see that there is a way to improve the code or functionality,
kindly fill out the issue or make a pull request with your changes.

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