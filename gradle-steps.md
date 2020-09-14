
## Gradle ##
------------
Download, Read, Install, Read again : 

*  https://gradle.org/releases
*  https://gradle.org/install/
*  https://docs.gradle.org/current/userguide/userguide.html
*  https://docs.gradle.org/current/userguide/gradle_wrapper.html

Check proper installation:
```
gradle -v
```

Download the GildedRoseKata archive from github 

Extract only the java folder from this archive into what i will call my project folder.

*(later on, I will probably move it into my futur cloned github repo folder, which will be my real project folder)*

Go to the project folder and have a look at configured tasks:
```
cd <path-to-project-folder>
gradle tasks
```

### Update Gradle wrapper ###

As mentioned : *" The recommended way to execute any Gradle build is with the help of the Gradle Wrapper (in short just “Wrapper”) "*

*-- src: https://docs.gradle.org/current/userguide/gradle_wrapper.html*

*" It is recommended to always execute a build with the Wrapper to ensure a reliable, controlled and standardized execution of the build. *
*Using the Wrapper looks almost exactly like running the <build> with a Gradle installation. *
*Depending on the operating system you either run <gradlew> (linux) or <gradlew.bat> (win) instead of the gradle command. "*

*-- src: https://docs.gradle.org/current/userguide/gradle_wrapper.html#sec:using_wrapper*

Lets check our curent wrapper properties (from inside the project fldr):
```
cat ./gradle/wrapper/gradle-wrapper.properties  | grep "distributionUrl"
```

*Hm.. pointing to 6.5 but current is higher*

Lets update the wrapper:
```
gradle wrapper
```

Lets check the modifications:
```
cat ./gradle/wrapper/gradle-wrapper.properties | grep "distributionUrl"
```

*Nice! its updated. Everythings seems set now.*

Lets try it without any code alteration:
```
cd <path-to-project-folder>
./gradlew build
```

Build FAILED, this is normal, one of the unit test ("fixme") is configured to do so.

*There is a view for test results on: file:///<path-to-project-folder>/build/reports/tests/test/index.html*

*Easy way to checks results by refreshing (ctrl-f5) this page after each tests execution*

*Now, we can start. Everythings seems in order to begin the kata refacto*