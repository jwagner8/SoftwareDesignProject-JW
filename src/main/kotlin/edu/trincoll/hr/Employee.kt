package edu.trincoll.hr

// Abstract class Employee should have:
//   - a name of type String
//   - an id of type Int.
// It should implement the Comparable interface with the
// compareTo method.
//
// It should include an abstract method pay()
// that returns a Double.
//
// It should override the toString method to
// return a string with the name and id of the employee.
abstract class Employee(
    val name: String,
    val id: Int
) : Comparable<Employee> {

    // Abstract method to calculate pay
    abstract fun pay(): Double

    // Override compareTo for sorting logic
    override fun compareTo(other: Employee): Int {
        // Compare by pay first (higher pay comes first)
        val payComparison = other.pay().compareTo(this.pay())
        if (payComparison != 0) return payComparison

        // If pay is the same, compare by name alphabetically
        val nameComparison = this.name.compareTo(other.name)
        if (nameComparison != 0) return nameComparison

        // If name is also the same, compare by id (lower id first)
        return this.id.compareTo(other.id)
    }

    // Override toString to return a formatted string with name and id
    override fun toString(): String {
        return "Employee(name='$name', id=$id)"
    }
}
