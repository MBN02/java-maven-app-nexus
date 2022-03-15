def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'nexus-user', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
        sh 'docker build -t 40.83.250.80:8083/java-maven-app:1.0 .'
        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin 40.83.250.80:8083"
        sh 'docker push 40.83.250.80:8083/java-maven-app:1.0'
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
