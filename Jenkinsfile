@Library('MyShared-Library')_
pipeline {
    agent any
    
    environment {
         		    			
        imageName   		    = 'merit237/spring-boot-app'     			
	openshiftCredentialsID	    = 'deployment'		    			 
	openshiftClusterURL	    = 'https://api.ocpuat.devopsconsulting.org:6443'   	
        openshifProject 	    = 'merit'			     			
	    
    }
    
    stages {
        
        stage('Repo checkout') {
            steps {
            	script {
                	checkoutRepo
                }
            }
        }

        stage('Unit est') {
            steps {
                script {
                	UnitTests
        	}
    	    }
	}
	
        stage('Sonarqube') {
            steps {
                script {
                    	SonarQube()
                }
            }
        }
       
        stage('Build and Push Docker Image') {
            steps {
                script {
                	
                 		buildandPushDockerImage("${dockerHubCredentialsID}", "${imageName}")
                        
                    	
                }
            }
        }

        stage('Deploy on OpenShift Cluster') {
            steps {
                script { 
                        
                	dir('Deployment') {
				deployOnOpenShift("${openshiftCredentialsID}", "${openshiftCluster}", "${openshifProject}", "${imageName}")
                    	}
                }
            }
        }
    }

    
    }
}
