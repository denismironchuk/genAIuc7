# Testing Documentation

## PlayerAnalyzerTest Class

This class contains various JUnit test methods to validate the functionality of the `PlayerAnalyzer` class.

- `testNormalPlayer`: Tests if the `PlayerAnalyzer` calculates the correct score for a player of age 25, experience 5, and skills set to [2, 2, 2].

- `testJuniorPlayer`: Tests the score calculation for a younger player, age 15, experience 3, and skills set to [3, 3, 3].

- `testSeniorPlayer`: Tests the score calculation for a senior player, age 35, experience 15, and skills set to [4, 4, 4].

- `testMultiplePlayers`: Tests the score calculation when multiple players are in the list.

- `testNullSkills`: Tests that the method throws a `NullPointerException` when the skill set is null.

- `testEmptyArray`: Tests that an empty list of players results in a score of 0.

## StudentConverterTest Class

This class contains JUnit test methods for testing the `StudentConverter` class.

- `testHonorRollForStudentsAbove21AndGradeAbove90`: Checks if students above 21 years with a grade above 90 are marked as Honor Roll.

- `testExceptionalForStudentsBelow21AndGradeAbove90`: Checks if students below 21 years with a grade above 90 are marked as Exceptional.

- `testPassedForStudentsWithGradeBetween71And90`: Checks if students with grades between 71 and 90 are marked as Passed.

- `testNotPassedForStudentsWithGrade70OrLess`: Checks if students with a grade 70 or less are not marked as Passed.

- `testEmptyListReturnsEmptyList`: Checks that an empty input list returns an empty list.

- `testNullInputThrowsError`: Tests that passing a null list throws a `NullPointerException`.

## How to Run Tests Using Maven

To execute the test cases using Maven, follow the steps below:

1. **Navigate to Project Directory**: Open a terminal and navigate to the root directory of your Maven project where the `pom.xml` file is located.

    ```bash
    cd /path/to/your/project
    ```

2. **Run Tests**: Execute the following Maven command to run all test cases:

    ```bash
    mvn test
    ```

   This will compile your code and run all test cases. Maven will output the test results in the terminal.

3. **Run Specific Test Class**: If you wish to run tests from a single class, use the following command:

    ```bash
    mvn -Dtest=TestClassName test
    ```

   Replace `TestClassName` with the name of the test class you want to run (e.g., `PlayerAnalyzerTest` or `StudentConverterTest`).

4. **Review Test Reports**: After running the tests, Maven will generate test reports in `target/surefire-reports/` directory. You can open the `*.txt` or `*.xml` files to review the test results.

Note: Make sure Maven is installed on your system and that you are connected to the internet, as Maven may need to download dependencies.