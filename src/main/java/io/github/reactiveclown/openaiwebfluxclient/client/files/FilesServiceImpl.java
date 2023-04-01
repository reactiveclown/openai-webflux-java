package io.github.reactiveclown.openaiwebfluxclient.client.files;

import org.springframework.core.io.PathResource;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class FilesServiceImpl implements FilesService {

    private final WebClient client;

    public FilesServiceImpl(WebClient client) {
        this.client = client;
    }

    @Override
    public Mono<ListFilesResponse> listFiles() {
        String listFilesUrl = "/files";
        return client.get()
                .uri(listFilesUrl)
                .retrieve()
                .bodyToMono(ListFilesResponse.class);
    }

    @Override
    public Mono<UploadFileResponse> uploadFile(UploadFileRequest request) {
        String uploadFileUrl = "/files";
        var multipartBodyBuilder = new MultipartBodyBuilder();
        multipartBodyBuilder.part("file", new PathResource(request.file()));
        multipartBodyBuilder.part("purpose", request.purpose());
        return client.post()
                .uri(uploadFileUrl)
                .bodyValue(multipartBodyBuilder.build())
                .retrieve()
                .bodyToMono(UploadFileResponse.class);
    }

    @Override
    public Mono<DeleteFileResponse> deleteFile(String fileId) {
        String deleteFileUrl = String.format("/files/%s", fileId);
        return client.delete()
                .uri(deleteFileUrl)
                .retrieve()
                .bodyToMono(DeleteFileResponse.class);
    }

    @Override
    public Mono<RetrieveFileResponse> retrieveFile(String fileId) {
        String retrieveFileUrl = String.format("/files/%s",fileId);
        return client.get()
                .uri(retrieveFileUrl)
                .retrieve()
                .bodyToMono(RetrieveFileResponse.class);
    }

    @Override
    public Mono<String> retrieveFileContent(String fileId) {
        String retrieveFileContentUrl = String.format("/files/%s/content", fileId);
        return client.get()
                .uri(retrieveFileContentUrl)
                .retrieve()
                .bodyToMono(String.class);
    }
}
