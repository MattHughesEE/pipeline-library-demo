def call(Map stageParams) {
  pipeline {
    agent {
      label 'master' // label [ label: 'stageParams.label']
    }
    stages {
      stage ('gitCheckout') {
      steps {
        checkout([
    $class: 'GitSCM', 
    branches: [[name: 'stageParams.branch']],
    doGenerateSubmoduleConfigurations: false,
    userRemoteConfigs: [[url: 'stageParams.scmUrl']]
    ])
      }
    }
      stage('build & SonarQube Analysis') {
        sh label 'setting new build number', script: 'mvn versions:set -DnewVersion=${BUILD_ID}-RELEASE'
        withSonarQubeEnv('SonarQube') {
          sh 'mvn clean package sonar:sonar'
        }
      }
      stash includes: 'target/*.jar', name: 'app'
      stash includes: 'Dockerfile', name: 'dockerfile'
      stash includes: 'encryption.sh', name: 'entrypoint'
    }
  }
}
    
            
  //sh [label: 'stageParams.label']
  

