Building
========

Use the gradle wrapper. To execute the Tempest jar (including any potential Storm topology), run:

    gradlew.bat runJar

This will build the code, run all the tests, and execute the resulting jar. To just run the tests, run

    gradlew.bat test

Dependencies
============

Currently, the only dependencies are Storm, Jedis (Java redis client), and JUnit. Feel free to go nuts and add more!
