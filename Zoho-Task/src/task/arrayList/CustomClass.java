package task.arrayList;


public class CustomClass {
    private String name;
    private Integer number;

    public CustomClass() {
        this.name = "Default Name";
        this.number = 0;
    }

    public CustomClass(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
