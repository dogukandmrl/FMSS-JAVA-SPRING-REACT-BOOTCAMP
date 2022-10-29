public class Animal {
    private String familia;
    public Animal(String familia){
        this.familia=familia;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }
    @Override
    public String toString(){
        return "Animal{"+
                "Familia ="+ familia+'\'' +
                '}';
    }
}
