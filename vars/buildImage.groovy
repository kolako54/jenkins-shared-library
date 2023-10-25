#!/usr/bin/env groovy
def call() {
    echo "building the docker image..."
    withCredentials([
            usernamePassword(credentialsId: 'docker-hub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')
    ]) {
        sh 'docker build -t kolako54/my-maven-repo:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push kolako54/my-maven-repo:jma-2.0"
    }
}