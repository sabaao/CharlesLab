# Requirement
1. Follow git flow.
2. It can finish release and hotfix.
3. When finish release and hotfix, it will merge to master and develop.
4. When finish, it will deploy to nexus.

# jgitflow-maven-plugin
Include plugin in pom.xml.
```xml
<build>
    <plugins>
        <plugin>
            <groupId>external.atlassian.jgitflow</groupId>
            <artifactId>jgitflow-maven-plugin</artifactId>
            <version>1.0-m5.1</version>
            <configuration>
               <flowInitContext>
                 <!-- <masterBranchName>master</masterBranchName> -->
                 <!-- <developBranchName>develop</developBranchName> -->
                 <versionTagPrefix>${project.artifactId}-</versionTagPrefix>
               </flowInitContext>
               <username>username</username>
               <password>password</password>
               <allowSnapshots>true</allowSnapshots>
               <pushReleases>true</pushReleases>
               <keepBranch>false</keepBranch>
               <noDeploy>false</noDeploy>
            </configuration>
        </plugin>
    </plugins>
</build>
```
|Tag   |Descrption   |
|---|---|
|masterBranchName   |Your master branch name.   |
|developBranchName   |Your develop branch name.   |
|versionTagPrefix   |Tag prefix name.   |
|username |Git username. |
|password | Git password. |
|allowSnapshots |true : allow snapshot in pom. false: not allow snapshot in pom. Default is false.|
|pushReleases | Push code to remote server, default is false. |
|keepBranch | It will kill branch after than push, default is false. | 
|noDeploy | true : run 「mvn deploy」 after than finish. false : run 「mvn install」 after than finish. |

# Command
* release-start : create a release branch, and update version of pom.
* release-finish : execute mvn deploy( or mvn install), and merge release branch into master and develop, and update version of pom.
* hotfix-start : create a hotfix branch, and update version of pom.
* hotfix-finish : execute mvn deploy( or mvn install), and merge hotfix branch into master and develop, and update version of pom.
* feature-start : create a feature branch.
* feature-finish : merge feature branch.
* build-number : assign a build number (-buildX, X is build number) , then you can update pom version of current branch.

# Example
* mvn jgitflow:release-start
* mvn jgitflow:release-finish
* mvn jgitflow:hotfix-start
* mvn jgitflow:hotfix-finish
* mvn jgitflow:feature-start
* mvn jgitflow:feature-finish                 

