void call() {
    stage("Gradle: Build") {
        println "Building from the Gradle library with 'options:${config.options}' and 'clean:${config.clean}'"
        node {
            //sh 'gradle ${config.options} ${config.clean} install'
        }
    }
}
