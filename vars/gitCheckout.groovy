def call(Map stageParams) {

checkout([
    $class: 'GitSCM', 
    branches: [[name: 'stageParams.branch']],
    doGenerateSubmoduleConfigurations: false, 
    extensions: [], 
    submoduleCfg: [], 
    userRemoteConfigs: [[url: 'https://github.com/MattHughesEE/KhanBank.git']]
    ])
    }
