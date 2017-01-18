package migrationtest

class Person {

    Integer age = -1

    static constraints = {
    }

    static mapping = {
        age defaultValue: "-1"
    }
}
