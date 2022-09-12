public class Idol {
    public String name;
    public int age;
    public double height, weight;

    public String status() {
        if(this.age<10) {
            return "Lolicon";
        }
        if(this.age>10 && this.age<50) {
            return "OK ngon";
        }
        if(this.age>50) {
            return "Ngon vl mlem mlem";
        }
        return "";
    }
}
