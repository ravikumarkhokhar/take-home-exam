# take-home-exam Setup Instruction

## Basically you need to install the following tools and setup path:
- Eclipse IDE
- Java
- Maven
- TestNG Plugin in Eclipse

# JAVA Setup

1) Download **java 11.0.18** from https://www.oracle.com/java/technologies/downloads/#java11
2) Install java and JDK
3) Setup Environment Variable
   a) If you are using windows then search environment variable in windows search bar
   b) Click on Edit Environment Variable
   c) You will see Advanced Tab. Now, Click on Environment Variable
   d) You will see User Variables and System Variables
   e) Click on New in User variable
   f) Type **'Path'** in Variable Name and **'C:\Program Files\Java\jdk-11.0.11\bin'** in variable value
      You have to find jdk installation path in C:\Program Files\. Copy that bin directory path and paste it on Path varible value.
     
 
# Maven setup
 
 1) Download Maven from https://maven.apache.org/download.cgi
 2) Unzip maven folder and put it in C:\Program Files\
 2) Now we need to update the Path Variable with Maven’s installation ‘bin’ directory to run Maven from the command line. Follow the following steps:
 3) Setup Environment Variable
   a) Search environment variable in windows search bar
   b) Click on Edit Environment Variable
   c) You will see Advanced Tab. Now, Click on Environment Variable
   d) You will see User Variables and System Variables
   e) We already set java path previously now we have to set maven path
   f) Select Path and click on Edit button
   f) Type **'Path'** in Variable Name and **'C:\Program Files\apache-maven-3.8.7\apache-maven\src\bin**' in variable value
      You have to find maven installation path in C:\Program Files\. Copy that bin directory path and paste it on Path varible value.
      
# Eclipse setup
 
 1) Go to https://www.eclipse.org/downloads/packages/release/2022-06/r
 2) Download Eclipse IDE for Enterprise Java and Web Developers
 3) Unzip folder
 2) Open eclipse application
 3) Create workspace or accept default location of workspace

# TestNG plugin installation in Eclipse
 
 1) Open Eclipse IDE
 2) For TestNG plugin, Go to **Help -> Eclipse Marketplace -> Search TestNG -> Install TestNG**
 3) Now you will see Restart Eclipse. Click Restart.
  

 ## Now open take-home-exam project to Eclipse
 1) Open Eclipse IDE 
 2) Click ok existing/default workspace
 3) Go to** File -> Maven -> Existing Maven Projects -> Select take-home-exam project folder**
 4) Now It will take few minutes to download all jar/dependency
 5) Woohoo!! Finally, project is ready for execution.
 
 # Steps to execute all test cases using suit file TestCaseExecution.xml
 1) Go to **src/test/resource** and RIGHT CLICK on **TestCaseExecution.xml**
 2) Find **Run as** option then Click on **TestNG Suite**
 3) Now it will execute all the test cases which is written in TestCaseExecution.xml
 4) You will see results in **console** as well as **reports/index.html** and **test-output/emailable-report.html** file.
 
 # Steps to run individual test cases from Test classes such as LoginTest, CreateAccountTest, and ForgotPasswordTest
 1) Go to src/test/java and open any test class that you want to run
 2) You will see all diffent test cases methods and it has **Run | Debug** text above the method. Click on Run and it will execute.
 3) You will see results in **console** as well as **reports/index.html** and **test-output/emailable-report.html** file.
