package com.proalpha.codeartifact

import org.gradle.api.Project
import org.gradle.api.Plugin
import org.gradle.api.artifacts.dsl.RepositoryHandler

class CodeartifactPlugin implements Plugin<Project> {

    void apply(Project project) {
        setupCodeartifactRepository(project.repositories)
        if (project.plugins.hasPlugin('maven-publish')) {
            setupCodeartifactRepository(project.publishing.repositories)
        }
    }

    void setupCodeartifactRepository(RepositoryHandler repositories) {
        repositories.metaClass.codeartifact = { Closure closure ->
            CodeartifactRepository repository = new CodeartifactRepository()
            closure.delegate = repository
            closure.resolveStrategy = Closure.DELEGATE_FIRST
            closure()
            repository.add(repositories)
        }
    }

}
