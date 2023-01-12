job('Aplicacion Node.js Docker DSL Docker') {
    description('Aplicación Node JS Docker DSL para el curso de Jenkins')
    scm {
        git('https://github.com/Duvis07/nodejsapp.git', 'master') { node ->
            node / gitConfigName('Duvis07')
            node / gitConfigEmail('duvan.botero@est.iudigital.edu.co')
        }
    }
    triggers {
        scm('H/7 * * * *')
    }
    wrappers {
        nodejs('nodejs')
    }
    steps {
        dockerBuildAndPublish {
            repositoryName('duvis07/nodejsapp')
            registryCredentials('docker-hub')
            forcePull(false)
            createFingerprints(false)
            skipDecorate()
        }
    }
}
