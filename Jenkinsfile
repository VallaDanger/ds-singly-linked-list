pipeline { 
    agent { 
        label "linux" 
    }
    tools { 
        maven 'maven-3'
        jdk 'java-8'
    }
    stages { 
        
        stage ('clone') {
            
            steps {
        
                git branch: $GIT_BRANCH
                    credentialsId: 'GIT_SSH'
                    url: 'ssh://git@192.168.1.100:3322/CompSci/ds-singly-linked-list.git'
            }
                
        }
        
        stage ('verify') {
            
            steps {
            
                withMaven (
                    maven: 'maven-3',
                    options: [
                        artifactsPublisher(disabled: true), 
                        findbugsPublisher(disabled: true), 
                        openTasksPublisher(disabled: true),
                        jacocoPublisher(disabled: true),
                        dependenciesFingerprintPublisher(disabled: true),
                        junitPublisher(disabled: true),
                        spotbugsPublisher(disabled: true)
                    ]
                ){
                  sh "mvn -e -ntp clean verify"
                }
                
            }
            
        }
    }
}