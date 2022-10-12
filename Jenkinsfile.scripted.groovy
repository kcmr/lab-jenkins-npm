/* groovylint-disable ImplicitClosureParameter */
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
        sh 'npm ci --loglevel verbose'
      }

      stage('Test') {
        sh 'npm t'
      }
    }

    stage('Run groovy script') {
      List<String> shoppingList = [
        'manzanas',
        'naranjas',
        'kiwis',
        'patatas'
      ]

      shoppingList.each {
        println "Buy: ${it}"
      }
    }

    stage('Clean Workspace') {
      cleanWs cleanWhenFailure: false, notFailBuild: true
    }
  }
}
