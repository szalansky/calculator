# Calculator

### Installation & tests

This project uses Gradle to build code and run tests. Apart from JUnit 5
 and PIT there are no external dependencies.
 
I developed it in IntelliJ IDEA CE and run the tests from it,
but they can also be executed in shell with the following command:

```bash
$ gradle test
```

### Solution

I created an interface `Operation` which has a public method called
`execute` accepting a parameter `double number` which provides the
value for the left side of the operation (only really matters in
non-commutative operations like subtraction or division).

I used the interface to implement addition, subtraction, multiplication
and division.

Expressions are evaluated from left to right, ignoring the mathematical
order of the operations. When `Processor` receives `apply` (and the list
contains any operations) the value of the `apply` command resets the
`acc` field. This field is used to store result and can be read
using `getAcc()` function.

Processor will not accept operations that:
* are of incorrect type (e.g. `invalidop 30`)
* have a non-numeric argument (e.g. `add @`)
* are malformed (e.g. `add`)

if it encounters any of the above, it will throw an exception.

The Cli class acts as a kind of "glue" between Processor and the operating.
The `main` method allows user to provide an input file with operations and
execute the entire program (which prints the output of the operations).

### Tests

I added tests for the examples provided in the description as well
as a few examples of my own.

Mutation coverage for all classes except `Cli` is 100%. Surprisingly,
the `Processor` class has only 91% of line coverage because of unused
constructor which PIT (mutation testing framework) did not tamper with.

Latest line/mutation coverage report included.