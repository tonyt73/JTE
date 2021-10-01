# JTE
A Jenkin Templating Engine implementation

## Overview:
  This is the core JTE implement for build jobs in Jenkins.
  
  I use Jenkins Organisation Folders to define a build type; of which I use 3:
   * Pull Request Validation
     * Validates the Pull Requests for merge to main/develop branch
     * Runs unit tests
     * No artifacts are kept
   * Continuous Integration
     * Builds a debug version
     * Full CI testing
       * Includes BDD testing
     * Artifacts are stored in Artifactory
   * Release
     * Creates a release branch
     * Builds a release version (no debug)
     * Artifacts are stored in Artifactory
     * Deploys to smoke test environment

  Each are setup in almost the same manor, with the exception of the Configuration Base Directory setting
   * Projects > Repository Sources > BitBucket Team/Project
   * Project Recognizers
     * Jenkins Templating Engine (only, remove any others)
       * check: Exclude repository branches without a pipeline configuration file
       * This simply means that we aren't interested in any repos that aren't really buildable with JTE
         * Yes; you can use a default Goverance Tier configuration, but lets not go there
     * Jenkins Templating Engine (settings)
       * From SCM
         * Source Location
           * Git
             * my git repo
         * Configuration Base Directory
           * depends on build type:
             * builds/pull-request-validation
             * builds/continuous-integration
             * builds/release
## Using within a project
  Within a project repository (in BitBucket terms) simply include a `pipeline_config.groovy` file
  
  For example:
  * A Maven Build
```
  libraries {
    maven
  }
```
  * A Gradle Build
```
  libraries {
    gradle
  }
```
 * Both inherit the base configuration libraries defined in `pipleine-configuration/pipeline_config.groovy`:
   * sonarqube
   * artifactory
   * git
   

## Links:
 * Github project: https://github.com/steven-terrana/templating-engine-plugin
 * Gitter community: https://gitter.im/jenkinsci/templating-engine-plugin


