Testing Droidsafe
================

The testing infrastructure will sometime soon undergo a slight redesign consisting of the changes described in the 
[Testing Todo](../../todo/testing.md).

The gist of it
------
Run *ant run-regression-tests* from the project root and make sure that the LAST TEST (SpecdumpRegressionTestCase) 
passes before merging your changes into master. It will take ~ 20 minutes. If you would like it to run faster, then 
focus in on
a specific subset of the apps in */android-apps* by specifying the *-Ddir.to.search* property.

If the test fails, then look at the generated test report in *$APAC_HOME/test-reports/regression/* and see which app's
SpecdumpTestCase failed that wasn't supposed to. If the failure is not because of a timeout, then try running *make 
specdump* from the project root and see if your changes cause whatever exception is thrown.

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
    - *-Ddir.to.search* - directory inside */android-apps/* to which to limit the app search to when running 
      SpecdumpTest
* **update-specdump-regression-values** - updates the regression values using the results from the latest run of 
  'run-specdump-tests'

Regression Test Details
-----------------------

Currently there is only one regression test that gets run when you run *ant run-regression-tests* from the project root.
It is SpecdumpRegressionTestCase. 

We know that specdump fails for some apps at the moment and are ok with it. SpecdumpRegressionTestCase just checks that
a spec is successfully produced for all other apps.

The test starts by running the *run-specdump-test* target and looking at the resulting SpecdumpTestCase report in 
*/test-reports/*.  If a SpecdumpTestCase test-case (specdump for a single app) fails, then the test makes sure that we
expected it to fail by looking at the SHOULD PASS value in the app's Makefile.

