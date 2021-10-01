void call(app_env){
    stage("Artifactory: Deploy To ${app_env.short_name}"){
        println "deploying the artifact to Artifactory"
        // looping
        // app_env.repos.each { repo -> 
        //    println "Repo is ${repo}"
        //}
    }
}