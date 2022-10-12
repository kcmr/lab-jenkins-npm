pipeline {
  agent none

  stages {
    stage('Install') {
      steps {
        nodejs('lts') {
          sh 'npm ci'
        }
      }
    }

    stage('Test') {
      steps {
        nodejs('lts') {
          sh 'npm t'
        }
      }
    }
  }
}
