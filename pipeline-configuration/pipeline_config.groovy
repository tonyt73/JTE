@merge libraries {
    sonarqube
    artifactory
    git
}

jte {
    // allows a project to override JTE using a Jenkinsfile
    allow_scm_jenkinsfile = false
    // leave as false; true = naming collision madness
    permissive_initialization = false
    // changes the order in which libraries are discovered and loaded
    reverse_library_resolution = false
}

keywords {
    // master or main
    master  = /^[Mm]a(ster|in)$/
    // develop, development or developer
    develop = /^[Dd]evelop(ment|er|)$/
    // hotfix/
    hotfix  = /^[Hh]ot[Ff]ix$/
    // release/n..n or releases/n..n
    release = /^[Rr]elease(s|)\/(\d+.)*\d$/
}

template_methods {
    scm_checkout
    unit_test
    build
    deploy_artifact
    ci_test_artifact
}

stages {
    pull_request_validation {
        unit_test
        static_code_analysis
    }
    continuous_integration {
        scm_checkout
        build
//        deploy_artifact
//        ci_test_artifact
    }
    create_release {
        scm_checkout
        build
//        deploy_artifact
    }
}

// DO NOT Add environments here
// Add environments per project?