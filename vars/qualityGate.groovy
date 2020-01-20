  
def call(Map stageParams) {
  pipeline {
    agent {
      label 'master' // label [ label: 'stageParams.label']
    }
    stages {
      stage ('qualityGate') {
        steps {
          timeout(time: 2, unit: 'MINUTES') {
          // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
					// true = set pipeline to UNSTABLE, false = don't
            waitforQualityGate abortPipeline: true
           }
          }
         }
         
