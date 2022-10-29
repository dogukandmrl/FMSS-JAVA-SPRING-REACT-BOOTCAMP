import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalProgrammingExampleWeek8 {
    public static void main(String[] args) {
 //1. Consumer Game

        Game game = new Game("Tekken","Fighting");
        System.out.println(game);
        Consumer<Game> updateGame = g -> g.setName("Mortal Kombat");
        updateGame.accept(game);
        System.out.println(game);

        Consumer<Game> updateGameAndGenre = g -> g.setName("Counter Strike");
        updateGameAndGenre = updateGameAndGenre.andThen(g -> g.setGenre("FPS"));
        updateGameAndGenre.accept(game);
        System.out.println(game);
//2. Predicate Password
        Predicate<String>  isPasswordValid = password -> password == "admin";
        isPasswordValid = isPasswordValid.and(password ->password.length()==6);
        System.out.println(isPasswordValid.test("admin"));

        Predicate<String> isPasswordOr = password -> password =="admin";
        isPasswordOr = isPasswordOr.or(password -> password.length()==6);
        System.out.println(isPasswordOr.test("admin"));
        System.out.println(isPasswordOr.negate().test("admin"));

//3.Supplier Animal
        Supplier<Animal> supplier = () -> new Animal("Felidia");
        Animal animal = supplier.get();
        System.out.println(animal);

        BooleanSupplier isAvailable = () -> true;
        System.out.println(isAvailable.getAsBoolean());
    }
}