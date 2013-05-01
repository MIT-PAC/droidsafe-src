Testing Droidsafe
================

Everyone should run the **run-regression-tests** target on their code and make sure it passes before merging back into master.
It takes about 20 minutes for it to finish. If you would like it to run faster, then focus in on a specific subset of *android-apps*
by specifying the *-Ddir.to.search* property.

Ant Commands
------------

Each target can be run from the root of the repository using **ant** *target*

* **compile-tests** - compiles Droidsafe tests.
* **run-tests** - runs all JUnit tests under tests/java/droidsafe/test
    - *-Dtest.class* - wildcard class name of tests to run
    - *-Dtest.timeout* - seconds after which to fail the test (default 30)
* **run-specdump-test** - checks whether a specdump can be created for each app in */android-apps/*
    - *-Ddir.to.search* - directory inside */android-apps/* to which to limit the app search to
    - *-Dtest.timeout* - seconds after which to fail the test (default 30)
* **run-regression-tests** - runs all JUnit tests under tests/java/droidsafe/test/regression
    - *-Ddir.to.search* - directory inside */android-apps/* to which to limit the app search to when running SpecdumpTest
* **update-specdump-regression-values** - updates the regression values using the results from the latest run of 'run-specdump-tests'
