pipeline {
  // agent any

  // tools {
  //   nodejs 'lts'
  // }

  agent {
    docker {
      image 'node:18-slim'
    }
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
