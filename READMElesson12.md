the task # 1
    <properties>
   
        <selenium-java.version>3.141.59</selenium-java.version>
        <testng.version>7.1.0</testng.version>
        <io.github.bonigarcia.version>4.4.1</io.github.bonigarcia.version>
        <maven-surefire-plugin.version>3.0.0-M5</maven-surefire-plugin.version>

    </properties>
   
   
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>${selenium-java.version}</version>
        </dependency>
   
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>${testng.version}</version>
            <scope>test</scope>
        </dependency>
   
        <dependency>
            <groupId>io.github.bonigarcia</groupId>
            <artifactId>webdrivermanager</artifactId>
            <version>${io.github.bonigarcia.version}</version>
        </dependency>

    <build>
        <pluginManagement>
            <plugins>
                <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-surefire-plugin</artifactId>
                    <version>${maven-surefire-plugin.version}</version>
                </plugin>
            </plugins>
        </pluginManagement>
    </build>

***********************************************************************************
the task # 2.1

mvn versions:use-latest-versions

[INFO] --- versions-maven-plugin:2.8.1:use-latest-versions (default-cli) @ SauseDemo ---

[INFO] Major version changes allowed

[INFO] artifact org.seleniumhq.selenium:selenium-java: checking for updates from central

[INFO] artifact org.testng:testng: checking for updates from central

[INFO] artifact io.github.bonigarcia:webdrivermanager: checking for updates from central

******************************************************************
the task # 3
mvn -Dtest=LoginTest test
T E S T S

 STARTING TEST inputOfCorrectDataTest ========================================

 FINISHED TEST  Duration: 3s ========================================


 STARTING TEST inputOfEmptyFieldsTest ========================================

 FINISHED TEST inputOfEmptyFieldsTest Duration: 1s =============================


 STARTING TEST inputOfEmptyPasswordFieldTest ======================

 FINISHED TEST inputOfEmptyPasswordFieldTest Duration: 1s ===============


 STARTING TEST inputOfInCorrectDataTest ========================================

 FINISHED TEST inputOfInCorrectDataTest Duration: 1s ===========================

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 110.919 sec

Results :

Tests run: 4, Failures: 0, Errors: 0, Skipped: 0

[INFO] Total time:  02:04 min

[INFO] Finished at: 2021-05-26T14:28:52+03:00
************************************************
mvn -Dtest=LoginTest#inputOfEmptyPasswordFieldTest test

T E S T S

 STARTING TEST inputOfEmptyPasswordFieldTest 

 FINISHED TEST inputOfEmptyPasswordFieldTest Duration: 4s 

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 17.832 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] Total time:  25.029 s

[INFO] Finished at: 2021-05-26T14:40:36+03:00
****************************************************
mvn test

T E S T S

Tests run: 7, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 139.462 sec


Results :

Tests run: 7, Failures: 0, Errors: 0, Skipped: 0

[INFO] --------------------------------------------

[INFO] BUILD SUCCESS

[INFO] ----------------------------------------------

[INFO] Total time:  02:25 min

[INFO] Finished at: 2021-05-26T15:08:42+03:00
**************************************************

mvn -Dtest=LoginTest#inputOfEmptyPasswordFieldTest+inputOfInCorrectDataTest test

[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 17.951 s - in tests.LoginTest


[INFO] Results:


[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 

[INFO] ------------------------------------------------------------------------

[INFO] BUILD SUCCESS

[INFO] ------------------------------------------------------------------------

[INFO] Total time:  23.477 s

[INFO] Finished at: 2021-05-26T15:26:52+03:00


**************************************************
mvn -Dtest=CartTest#addProductToCartTest* test

[INFO]Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.62 s - in tests.CartTest


[INFO] Results:

[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

************************************************
the task # 4

mvn -DTest=LoginTest -Dusername=standard_user -Dpassword=secret_sauce test
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 45.249 s - in TestSuite

Results:

Tests run: 8, Failures: 0, Errors: 0, Skipped: 0








