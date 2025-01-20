pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/Ganeshbankuru/git-test'
            }
        }
        stage('Build') {
            steps {
                sh 'javac palindrome.java'
            }
        }
        stage('Run') {
            steps {
                sh 'java palindrome'
            }
        }
    }
}
