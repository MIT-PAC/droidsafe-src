Testing Droidsafe
================

Basics
------
Run *ant run-regression-tests* from the project root and make sure it passes before merging your changes into master.  
It will take about 20 minutes. If you would like it to run faster, then focus in on a specific subset of *android-apps*
by specifying the *-Ddir.to.search* property.

If the test fails, then look at the generated test report in *$APAC_HOME/test-reports/regression/* and see which app failed to debug it further. If the failure is not because of a timeout, then try running *make specdump* from the project root and see if your changes cause whatever exception is thrown.

All Ant Commands
----------------

Each target can be run from the root of the repository using **ant** *target*

* **compile-tests** - compiles Droidsafe tests.
* **run-tests** - runs all JUnit tests under tests/java/droidsafe/test
    - *-Dtest.class* - wildcard class name of tests to run
    - *-Dtest.timeout* - seconds after which to fail the test (default 60)
* **run-specdump-test** - checks whether a specdump can be created for each app in */android-apps/*
    - *-Ddir.to.search* - directory inside */android-apps/* to which to limit the app search to
    - *-Dtest.timeout* - seconds after which to fail the test (default 60)
* **run-regression-tests** - runs all JUnit tests under tests/java/droidsafe/test/regression
    - *-Ddir.to.search* - directory inside */android-apps/* to which to limit the app search to when running SpecdumpTest
* **update-specdump-regression-values** - updates the regression values using the results from the latest run of 'run-specdump-tests'

Regression Test Details
-----------------------

Currently the only regression test that there is is SpecdumpRegressionTestCase. This is the only test that gets run when you run *ant run-regression-tests*. Here is how it works -  
The test starts by looking at looking at the latest SpecdumpTestCase report in */test-reports/*.
If a test-case (specdump for a single app) fails, then the test makes sure it was supposed to fail by looking at the value in the app's Makefile.
