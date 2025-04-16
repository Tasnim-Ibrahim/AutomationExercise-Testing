# Jenkins Pipeline Documentation

A brief documentation of the Jenkins CI/CD pipeline for the Automation Exercise project.

## Pipeline Structure

This project uses a Jenkins pipeline with the following stages:

1. **Checkout**: Retrieves code from source github repo
2. **Build**: Compiles the Java project using Maven
3. **Test**: Runs automated tests and generates reports

## Environment

- **JDK**: Version 21
- **Build Tool**: Maven

## Pipeline Configuration

```groovy
pipeline {
    agent any

    tools {
        jdk 'JDK21'
        maven 'Maven'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
            post {
                always {
                    // Archive TestNG reports
                    step([$class: 'Publisher', reportFilenamePattern: '**/testng-results.xml'])
                    
                    // Publish HTML reports
                    publishHTML([
                        allowMissing: false,
                        alwaysLinkToLastBuild: true,
                        keepAll: true,
                        reportDir: 'target/surefire-reports',
                        reportFiles: 'index.html',
                        reportName: 'TestNG HTML Report'
                    ])
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
```

## Test Reports

After running the pipeline:
- TestNG XML reports are archived
- HTML test reports are available under "TestNG HTML Report" on the build page

## Running the Pipeline

To run the pipeline manually, navigate to the project in Jenkins and click "Build Now".

## Scheduled Execution
The pipeline is configured to run daily.
