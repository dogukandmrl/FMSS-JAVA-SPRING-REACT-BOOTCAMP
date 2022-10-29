public class Game {
    private  String name;
    private String genre;
    public Game(String name,String genre){
        this.name= name;
        this.genre = genre;
    }
    public  String getName(){
        return  name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getGenre(){
        return genre;
    }
    public void setGenre(String genre){
        this.genre = genre;
    }
    @Override
    public String toString(){
        return "name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
