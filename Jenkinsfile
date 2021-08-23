pipeline { 
    agent { 
        label "linux" 
    }
    
    tools { 
        maven 'maven-3'
        jdk 'java-8'
    }
    
    environment {
        GIT_BRANCH_REF = "${GIT_BRANCH}"
        GIT_LOCAL_BRANCH = "${GIT_BRANCH}"
    }
    
    stages { 
        
        stage ('clone') {
            
            steps {
        
                script {
                    GIT_LOCAL_BRANCH = GIT_BRANCH_REF.replace("refs/heads/", "")
                    GIT_LOCAL_BRANCH = GIT_LOCAL_BRANCH.replace("origin/", "")
                }
        
                echo 'Building Branch: ' + GIT_LOCAL_BRANCH
        
                withEnv(
                    [
                        "TARGET_BRANCH = ${GIT_LOCAL_BRANCH}"
                    ]
                ){
                    git poll: false,
                        branch: "${env.TARGET_BRANCH}",
                        credentialsId: 'GIT_SSH',
                        url: 'ssh://git@192.168.1.100:3322/CompSci/ds-singly-linked-list.git'
                 }
                 
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