package com.proalpha.codeartifact

import software.amazon.awssdk.services.codeartifact.CodeartifactClient
import software.amazon.awssdk.services.codeartifact.model.GetRepositoryEndpointRequest
import software.amazon.awssdk.services.codeartifact.model.GetAuthorizationTokenRequest
import software.amazon.awssdk.regions.Region

class CodeartifactApi {

    private final String domain
    private final String domainOwner
    private final String repository
    private final CodeartifactClient client

    CodeartifactApi(String region, String domain, String domainOwner, String repository) {
        this.domain = domain
        this.domainOwner = domainOwner
        this.repository = repository
        this.client = CodeartifactClient.builder()
            .region(Region.of(region))
            .build()
    }

    String repositoryUrl() {
        return client.getRepositoryEndpoint(
            GetRepositoryEndpointRequest.builder()
                .domain(this.domain)
                .domainOwner(this.domainOwner)
                .format('maven')
                .repository(this.repository)
                .build()
        ).repositoryEndpoint()
    }

    String authorizationToken() {
        return client.getAuthorizationToken(
            GetAuthorizationTokenRequest.builder()
                .domain(this.domain)
                .domainOwner(this.domainOwner)
                .build()
        ).authorizationToken()
    }

}
