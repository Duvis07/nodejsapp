job('Aplicacion Node.js DSL') {
    description('Aplicación Node JS DSL para el curso de Jenkins')
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
        shell("npm install")
    }
}
