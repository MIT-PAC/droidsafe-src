Testing Droidsafe
================

Everyone should run the **run-regression-tests** target on their code and make sure it passes before merging back into master.

Ant Commands
------------

Each target can be run from the root of the repository using **ant** *target*

* **compile-tests** - compiles Droidsafe tests.
* **run-tests** - runs all JUnit tests under tests/java/droidsafe/test
    - *-Dtest.class* - wildcard class name of tests to run
    - *-Dtest.timeout* - seconds after which to fail the test (default 30)
* **run-specdump-tests** - checks whether a specdump can be created for each app in */android-apps/*
    - *-Ddir.to.search* - directory inside */android-apps/* to which to limit the app search to
    - *-Dtest.timeout* - seconds after which to fail the test (default 30)
* **run-regression-tests** - runs all JUnit tests under tests/java/droidsafe/test/regression
* **update-specdump-regression-values** - updates the regression values using the results from the latest run of 'run-specdump-tests'
