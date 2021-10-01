# JTE
A Jenkin Templating Engine implementation

My implementation:
Overview:
  This is the core JTE implement for build jobs in Jenkins
  I use Jenkins Organisation Folders to define a build type
   eg: I have 3 types at present
     * Pull Request Validation
     * Continuous Integration
     * Release
  Each are setup in almost the same manor
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

Links:
 * Github project: https://github.com/steven-terrana/templating-engine-plugin
 * Gitter community: https://gitter.im/jenkinsci/templating-engine-plugin


