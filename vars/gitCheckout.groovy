def call(Map stageParams) {

checkout([
    $class: 'GitSCM', 
    branches: [[name: 'stageParams.branch']],
    doGenerateSubmoduleConfigurations: false,
    userRemoteConfigs: [[url: 'https://github.com/MattHughesEE/KhanBank.git']]
    ])
    }
