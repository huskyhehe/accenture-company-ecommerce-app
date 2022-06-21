pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                bat './gradlew assemble'
            }
        }
        stage('Test') {
            steps {
                bat './gradlew test'
            }
        }
    }
}
