public class Olympian {
    public String name;
    public String country;
    public int goldenMedals = 0;
    public int silverMedals = 0;
    public int bronzeMedals = 0;

    public Olympian(String name, String country, int goldenMedals, int silverMedals, int bronzeMedals) {
        this.name = name;
        this.country = country;
        this.goldenMedals = goldenMedals;
        this.silverMedals = silverMedals;
        this.bronzeMedals = bronzeMedals;
    }

    @Override
    public String toString() {
        return "Olympian{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", goldenMedals=" + goldenMedals +
                ", silverMedals=" + silverMedals +
                ", bronzeMedals=" + bronzeMedals +
                '}';
    }
}
