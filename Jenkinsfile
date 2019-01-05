pipeline {
    agent {
        node {
            label 'DV'
        }
    }
    stages {
        stage('Build Jar') {
            steps {
                sh 'sh mvn package -DskipTest'
            }
        }
        stage('Build Image') {
            steps {
                script {
                 '/snap/bin/docker build -t testy/mvn .'
                }
            }
        }

    }
}