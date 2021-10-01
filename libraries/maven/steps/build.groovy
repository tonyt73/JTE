void call(){
    stage("Maven: Build"){
        println "Building from the maven library with 'options:${config.options}' and 'clean:${config.clean}'"
        node {
            //sh 'mvn ${config.options} ${config.clean} install'
        }
    }
}
