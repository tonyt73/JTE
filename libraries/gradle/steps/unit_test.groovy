void call() {
    stage("Gradle: Unit Test") {
        println "Unit Testing from the Gradle library with 'options:${config.options}' and 'clean:${config.clean}'"
        node {
            //sh 'gradle ${config.options} ${config.clean} verify'
        }
    }
}
