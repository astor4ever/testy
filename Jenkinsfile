pipeline {
    agent {
        node {
            label 'DV'
        }
    }
    stages {
        stage('Build Jar') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Build Image') {
            steps {
                script {
                 sh '/snap/bin/docker build -t astor4ever/mvndocker .'
                }
            }
        }

    }
}