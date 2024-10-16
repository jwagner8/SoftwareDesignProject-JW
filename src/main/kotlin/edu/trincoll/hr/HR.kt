package edu.trincoll.hr

// The HR class should have:
//   - a list of employees
//   - a hire method that takes an employee and returns a new HR object with that employee added
//   - a fire method that takes an id and returns a new HR object with the employee with that id removed
//   - a payEmployees method that returns the total pay of all employees

class HR(private val employees: List<Employee> = emptyList()) {

    // Hire method that adds a new employee and returns a new HR object
    fun hire(employee: Employee): HR {
        return HR(employees + employee)
    }

    // Fire method that removes an employee by id and returns a new HR object
    fun fire(id: Int): HR {
        return HR(employees.filter { it.id != id })
    }

    // Calculate the total pay of all employees
    fun payEmployees(): Double {
        return employees.sumOf { it.pay() }
    }
}
