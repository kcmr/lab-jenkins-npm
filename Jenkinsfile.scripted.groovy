node {
  timestamps {
    stage('Checkout SCM') {
      checkout([
        $class: 'GitSCM',
        branches: [[name: '**']],
        extensions: [],
        userRemoteConfigs:
        [[url: 'https://github.com/kcmr/lab-jenkins-npm.git']]
      ])
    }

    withDockerContainer('node:18-slim') {
      stage('Install') {
        sh 'npm ci'
      }

      stage('Test') {
        sh 'npm t'
      }
    }
  }

  cleanWs cleanWhenFailure: false, notFailBuild: true
}
