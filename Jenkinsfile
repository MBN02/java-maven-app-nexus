#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    tools {
        maven 'maven_3.8.4'
    }
    stages{
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("buildJar") {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
         stage("buildImage") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
