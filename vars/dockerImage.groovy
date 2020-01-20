def call(String project, String hubUser) {
    def customImage = docker.build("${project}:${env.BUILD_ID}", "--pull --build-arg app_version=${BUILD_ID}-RELEASE --build-arg port=9020 .")
customImage.push()

customImage.push('latest')
    }
