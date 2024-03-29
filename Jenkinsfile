pipeline {
    agent any

    environment {
        APP_ARCHIVE_NAME = 'app'
        APP_MODULE_NAME = 'android-template'
        CHANGELOG_CMD = 'git log --date=format:"%Y-%m-%d" --pretty="format: * %s% b (%an, %cd)" | head -n 10 > commit-changelog.txt'
    }
    stages {
        stage("PR") {
            stages {
                stage("Build") {
                    steps {
                        sh 'chmod +x gradlew'
                        sh './gradlew -x clean assembleDebug'
                    }
                }
                stage("Test") {
                    steps {
                        sh './gradlew -x clean testDebugUnitTest'
                    }
                }
                stage("AndroidTest") {
                    steps {
                        sh './gradlew assembleDebugAndroidTest'
                    }
                }
                stage("build & SonarQube analysis") {
                    steps {
                        withSonarQubeEnv('sonarqube') {
                            sh 'chmod +x gradlew'
                                sh './gradlew sonar '
                        }
                    }
                }
                 stage("Quality Gate") {
                     steps {
                        script{
                            timeout(time: 2, unit: 'MINUTES') {
                                def qualitygate = waitForQualityGate()
                                if (qualitygate.status != "OK") {
                                    error "Pipeline aborted due to quality gate coverage failure: ${qualitygate.status}"
                                }
                            }
    
                        }
                     }
                 }
                stage("Build release ") {
            steps{
                sh './gradlew assembleRelease'
            }
        }
      
        stage("Compile") {
            steps{
                            archiveArtifacts artifacts: '**/*.apk', fingerprint: true, onlyIfSuccessful: true            
            }
        }

            }
        }
  }
    post {
        failure {
            mail(to: 'bachosodja@gmail.com',
                    subject: "Job '${env.JOB_NAME}' (${env.BUILD_NUMBER}) has failed",
                    body: "Please go to ${env.BUILD_URL}.")

            // Notify build breaker
            step([$class: 'Mailer', notifyEveryUnstableBuild: true, recipients: emailextrecipients([[$class: 'CulpritsRecipientProvider'], [$class: 'RequesterRecipientProvider']])])
        }
    }
}
