public class Employee extends Users {
    private double salary;

    public Employee( String name,double salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee " +super.toString()+ "has " + salary + " SR";
    }

    
    public double getSalary() {
        return salary;
    }

   
    public void setSalary(double salary) {
        this.salary = salary;
    }
   
    
    
}
