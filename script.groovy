def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-user', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t [nexus-ip]:[docker-port]/java-maven-app:1.0 .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin [nexus-ip]:[docker-port]"
        sh 'docker push [nexus-ip]:[docker-port]/java-maven-app:1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
