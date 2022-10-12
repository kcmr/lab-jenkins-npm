pipeline {
  agent any

  tools {
    nodejs 'lts'
  }

  stages {
    stage('Install') {
      steps {
        sh 'npm ci'
      }
    }

    stage('Test') {
      steps {
        sh 'npm t'
      }
    }
  }
}
