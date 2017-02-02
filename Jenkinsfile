#!/usr/bin/env groovy

node('jenkins-slave') {
    wrap([$class: 'AnsiColorBuildWrapper', 'colorMapName': 'xterm']) {
        timestamps {
            try {
                stage('Checkout') {
                    echo 'Checking out src code...'
                    checkout scm
                }

                stage('Compile') {
                    echo 'Compiling src code...'
                    sh './gradlew build -x test'
                }

                stage('Unit Test') {
                    timeout(time: 5, unit: 'MINUTES') {
                        echo 'Running unit test...'
                        sh './gradlew test'
                    }
                }

                stage('Report Unit Test') {
                    echo 'Reporting unit test...'
                    step([
                        $class: 'JUnitResultArchiver',
                        allowEmptyResults: true,
                        testResults: 'build/test-results/test/*.xml'
                    ])
                }
            } catch (error) {
                currentBuild.result = "FAILURE"
                echo "Project build error: ${error}"
                throw error
            } finally {
                stage('Clean Workspace') {
                    timeout(time: 2, unit: 'MINUTES') {
                        echo 'Cleaning workspace'
                        sh './gradlew clean'
                    }
                }
            }
        }
    }
}