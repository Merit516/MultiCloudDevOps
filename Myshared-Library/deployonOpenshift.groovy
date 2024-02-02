#!/usr/bin/env groovy

 
def call(String OpenShiftCredentialsID, String openshiftClusterurl, String openshiftProject, String imageName) {
    
   
    sh "export BUILD_NUMBER=$(cat ../build.txt)"
    sh "mv  multi-branch/deploy.yaml  multi-branch/deploy.yaml.tmp"
    sh "cat Deployment/deploy.yaml.tmp | envsubst > Deployment/deploy.yaml"
    sh "rm -f multi-branch/deploy.yaml.tmp"
   

    
    withCredentials([string(credentialsId: "${OpenShiftCredentialsID}", variable: 'OpenShift_CREDENTIALS')]) {
            sh "oc login --server=${openshiftClusterurl} --token=${OpenShift_CREDENTIALS} --insecure-skip-tls-verify"
            sh "oc project merit"
            sh "oc apply -f ."
    }

    
   
    
}
