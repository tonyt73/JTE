// these are your base libraries that the project repos can't override (unless you allow it)
// they are included in all jobs
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

// method names that should be implemented
template_methods {
    scm_checkout
    unit_test
    build
    deploy_artifact
    ci_test_artifact
}

// Stages are functions that can be called from a Jenkinsfile
// I use them in the builds/{build type} definitions
// They are your template for a particular sequences
stages {
    // the definition of our PR validation builds
    pull_request_validation {
        unit_test
        static_code_analysis
    }
    // the definition of a CI build/test
    continuous_integration {
        scm_checkout
        build
//        deploy_artifact
//        ci_test_artifact
    }
    // the definiton of a new release build
    create_release {
        scm_checkout
        build
//        deploy_artifact
    }
}

// DO NOT Add environments here
// Add environments per project?