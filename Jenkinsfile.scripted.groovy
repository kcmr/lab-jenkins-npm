node {
  timestamps {
    stage('Checkout SCM') {
      git branch: 'main', url: 'https://github.com/kcmr/lab-jenkins-npm.git'
    }

    withDockerContainer('node:18-slim') {
      stage('Install') {
        sh 'npm i'
      }

      stage('Test') {
        sh 'npm t'
      }
    }
  }
}
