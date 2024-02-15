package com.proalpha.codeartifact

import org.gradle.api.artifacts.dsl.RepositoryHandler

class CodeartifactRepository {

    private String regionParam
    private String domainParam
    private String domainOwnerParam
    private String repositoryParam

    void region(String region) {
        this.regionParam = region
    }

    void domain(String domain) {
        this.domainParam = domain
    }

    void domainOwner(String domainOwner) {
        this.domainOwnerParam = domainOwner
    }

    void repository(String repository) {
        this.repositoryParam = repository
    }

    void add(RepositoryHandler repositories) {
        CodeartifactApi api = new CodeartifactApi(
            this.regionParam,
            this.domainParam,
            this.domainOwnerParam,
            this.repositoryParam,
        )
        repositories.maven {
            url api.repositoryUrl()
            credentials {
                username 'aws'
                password api.authorizationToken()
            }
        }
    }

}
