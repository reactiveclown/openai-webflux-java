package com.reactiveclown.openaiwebfluxclient.client.files;

import reactor.core.publisher.Mono;

public interface FilesService {
    /**
     * Returns a list of files that belong to the user's organization.
     *
     * @return A Mono of {@link ListFilesResponse}
     */
    Mono<ListFilesResponse> listFiles();

    /**
     * Upload a file that contains document(s) to be used across various endpoints/features.
     * Currently, the size of all the files uploaded by one organization can be up to 1 GB.
     *
     * @param request {@link UploadFileRequest}
     * @return A Mono of {@link UploadFileResponse}
     */
    Mono<UploadFileResponse> uploadFile(UploadFileRequest request);

    /**
     * Delete a file.
     *
     * @param fileId The ID of the file to use for this request
     * @return A Mono of {@link DeleteFileResponse}
     */
    Mono<DeleteFileResponse> deleteFile(String fileId);

    /**
     * Returns information about a specific file.
     *
     * @param fileId The ID of the file to use for this request
     * @return A Mono of {@link RetrieveFileResponse}
     */
    Mono<RetrieveFileResponse> retrieveFile(String fileId);

    /**
     * Returns the contents of the specified file
     *
     * @param fileId The ID of the file to use for this request
     * @return A Mono of {@link String}
     */
    Mono<String> retrieveFileContent(String fileId);
}
