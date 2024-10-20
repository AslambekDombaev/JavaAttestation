import java.util.Objects;

public class Laptop {
    
    private int ozu;
    private int memory;
    private String color;
    private String oper_system;

    public Laptop(int ozu, int memory, String color, String oper_system) {
        this.ozu = ozu;
        this.memory = memory;
        this.color = color;
        this.oper_system = oper_system;
    }

    public int getOzu(){
        return ozu;
    }

    public int getMemory(){
        return memory;
    }

    public String getColor(){
        return color;
    }

    public String getOperSystem(){
        return oper_system;
    }

    public String getLaptopType(){
        return getClass().getSimpleName();
    }


    @Override
    public String toString() {
        return getLaptopType() +
        "ОЗУ=" + ozu + " Gb" +
        ", Memory=" + memory + " Gb" +
        ", Color='" + color + '\'' +
        ", OS='" + oper_system + '\'' +
        '}';
    }

    @Override
    public boolean equals(Object o) {
    if (this == o) 
        return true;
    if (o == null || getClass() != o.getClass()) 
        return false;
    Laptop laptop = (Laptop) o;
    return ozu == laptop.ozu && memory == laptop.memory &&  color.equals(laptop.color) && oper_system.equals(laptop.oper_system);
    }

    @Override
    public int hashCode() {
    return Objects.hash(ozu, memory, color, oper_system);
    }
}

