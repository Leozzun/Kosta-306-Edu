package mvc.dto;

public class Profile {

    private String name;
    private String weight;
    private String password;

    public Profile(String name, String weight, String password) {
        this.name = name;
        this.weight = weight;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getWeight() {
        return weight;
    }

    public String getPassword() {
        return password;
    }
    
    @Override
    public String toString() {
        return name + "님 몸무게는 "
                + weight + "kg 이고 비번은 "
                + password + " 입니다.";
    }
}
