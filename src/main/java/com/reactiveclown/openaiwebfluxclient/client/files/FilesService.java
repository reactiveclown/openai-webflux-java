package com.reactiveclown.openaiwebfluxclient.client.files;

import reactor.core.publisher.Mono;

public interface FilesService {
    Mono<ListFilesResponse> listFiles();

    Mono<UploadFileResponse> uploadFile(UploadFileRequest request);

    Mono<DeleteFileResponse> deleteFile(String fileId);

    Mono<RetrieveFileResponse> retrieveFile(String fileId);

    Mono<String> retrieveFileContent(String fileId);
}
