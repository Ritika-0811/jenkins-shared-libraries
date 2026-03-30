def call(String project, String imageTag, String dockerHubUser) {

    withCredentials([usernamePassword(
        credentialsId: "dockerhubCred",
        usernameVariable: "USER",
        passwordVariable: "PASS"
    )]) {

        sh """
            echo \$PASS | docker login -u \$USER --password-stdin
            docker push ${dockerHubUser}/${project}:${imageTag}
        """
    }
}
