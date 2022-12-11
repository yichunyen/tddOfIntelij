pipeline {
    agent any

    options {
        timestamps()
    }

    stages{
        stage('Start') {
            steps {
                echo 'START'
                // git configuration set on Jenkins job
                // git branch: 'main', changelog: false, poll: false, url: 'https://github.com/yichunyen/tddOfIntelij.git'
            }
        }

        stage('Unit Test') {
            steps {
				echo 'UNIT TEST'
                sh './gradlew test'
            }
        }
    }
}