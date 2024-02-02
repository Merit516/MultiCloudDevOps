#!usr/bin/env groovy
def call(String dockerHubCredentialsID, String imageName) {
	// Log in to DockerHub 
	withCredentials([usernamePassword(credentialsId: "DockerHubid", usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
		sh "docker login -u ${USERNAME} -p ${PASSWORD}"
        }
        
        // Build and push Docker image
        echo "Building and Pushing Docker image..."
        sh "docker build -t ${imageName}:${BUILD_NUMBER} ."
    
