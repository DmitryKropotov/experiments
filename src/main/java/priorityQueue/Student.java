package priorityQueue;

public class Student implements Comparable{
    private int rank;
    private String name;

    public Student(int rank, String name) {
        this.rank = rank;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Student) {
            Student student2 = (Student)o;
            return this.rank-student2.rank;
        } else {
            throw new RuntimeException("wrong class");
        }
    }
}
