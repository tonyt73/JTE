//void call(){
//    stage("Maven: Unit Test"){
//            steps {
//                unit_test {
//                    stage = "Unit Test"
//                    image = "maven"
//                    command = "mvn clean verify"
//                    stash {
//                        name = "test-results"
//                        includes = "./target"
//                        excludes = "./src"
//                        useDefaultExcludes = false
//                        allowEmpty = true
//                    }
//                }
//                //println 'unit testing from the maven library'
//                //sh 'mvn test'
//            }
//        }
//    }
//}

void call(){
    stage("Maven: Unit Test") {
        println "Unit Testing from the maven library"
        node {
            // this now works if mvn is installed
            //sh "mvn ${config.options} ${config.clean} verify"
        }
    }
}