node {

// This is to demo github action	
 def sonarUrl = 'sonar.host.url=http://localhost:9000/projects' 
  stage('SCM Checkout-Compile')
     {
    sh "mvn -https://github.com/Sonali-K/ECGC-CI-CD-Angular-Spring-Boot-1/blob/master/spring_boot_demo/pom.xml compile"
      echo "Running Stage First"
         input 'Are you sure?'
          }
   
   stage('Build Docker Image'){
  git credentialsId: 'eb857953-4899-4983-928e-450aa25606d5', url: 'http://10.212.0.206:81/Sonali/ECGC-CI-CD-Angular-Spring-Boot-1'
     sh 'docker build -t sdkanse/spring-boot-demo.war:1.0SNAPSHOT .'
   }
      stage('Push Docker Image'){
    withCredentials([string(credentialsId: 'DockerHubID', variable: 'DockerHub')]) {
    // some block
             sh "docker login -u sdkanse -p ${DockerHub}"
}
     sh 'docker push sdkanse/spring-boot-demo.war:1.0SNAPSHOT'
   }           
}


