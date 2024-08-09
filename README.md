# Gradle Codeartifact Plugin

This plugin extends the gradle repository handler class with a closure to add a codeartifact repository.
This codeartifact repository then uses the aws cli to get the repository endpoint and the authorization token and generates a maven repository out of it.
Therefore it's a wrapper around the maven repository closure.
It extends the default RepositoryHandler directly on the project and the RepositoryHandler of the `maven-publish` plugin if this is loaded.

## Usage

You can add the plugin like this and add as many codeartifact repositories, as you want:

```groovy
plugins {
    id 'com.proalpha.codeartifact' version '1.0.2'
}

repositories {
    codeartifact {
        region '<region>'
        domain '<domain>'
        domainOwner '<domainOwner>'
        repository '<repository>'
    }
}
```

Or you add repositories to the publishing plugin:

```groovy
plugins {
    id 'maven-publish'
    id 'com.proalpha.codeartifact' version '1.0.2' // Note: Has to be added after maven-publish
}

publishing {
    repositories {
        codeartifact {
            region '<region>'
            domain '<domain>'
            domainOwner '<domainOwner>'
            repository '<repository>'
        }
    }
}
```

## License

[![Apache License 2.0](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](LICENSE)
