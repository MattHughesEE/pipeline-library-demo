def call(Map stageParams) {

checkout([
    $class: 'GitSCM', 
    branches: [[name: '*/master']],
    doGenerateSubmoduleConfigurations: false, 
    extensions: [], 
    submoduleCfg: [], 
    userRemoteConfigs: [[url: 'https://github.com/MattHughesEE/KhanBank.git']]
    ])
    }
