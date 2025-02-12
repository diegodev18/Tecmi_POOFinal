import java.util.ArrayList;

public class Pokedex {
    public static void iniciarPokedex(ArrayList<Pokemon> pokedex) {
        pokedex.add(new Pokemon(101, "Pikachu", "Eléctrico", "Electricidad Estática", 120, 5));
        pokedex.add(new Pokemon(102, "Charmander", "Fuego", "Mar de Llamas", 150, 5));
        pokedex.add(new Pokemon(103, "Bulbasaur", "Planta/Veneno", "Espesura", 130, 5));
        pokedex.add(new Pokemon(104, "Squirtle", "Agua", "Torrente", 140, 5));
        pokedex.add(new Pokemon(105, "Eevee", "Normal", "Fuga", 160, 5));
        pokedex.add(new Pokemon(106, "Gengar", "Fantasma/Veneno", "Levitación", 200, 5));
    }
}
