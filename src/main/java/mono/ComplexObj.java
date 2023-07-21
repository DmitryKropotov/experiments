package mono;

public class ComplexObj {
    boolean exists;
    String name;

    public ComplexObj(boolean exists, String name) {
        this.exists = exists;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ComplexObj{" +
                "exists=" + exists +
                ", name='" + name + '\'' +
                '}';
    }
}
