node {
  timestamps {
    withDockerContainer('node:18-slim') {
      stage('Install') {
        sh 'npm i'
      }

      stage('Test') {
        sh 'npm t'
      }
    }
  }

  cleanWs cleanWhenFailure: false, notFailBuild: true
}
