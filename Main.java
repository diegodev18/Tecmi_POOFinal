import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Pokemon> pokedex = new ArrayList<>(); // Aquí se crea el ArrayList de Pokemones

        // pokedex.add(new Pokemon(null, null, null)); // Aquí se crea un nuevo Pokemon (Cambiar null por los valores que quieras)
        pokedex.add(new Pokemon("Pikachu", "Eléctrico", "Electricidad Estática"));
        pokedex.add(new Pokemon("Charmander", "Fuego", "Mar de Llamas"));
        pokedex.add(new Pokemon("Bulbasaur", "Planta/Veneno", "Espesura"));
        pokedex.add(new Pokemon("Squirtle", "Agua", "Torrente"));
        pokedex.add(new Pokemon("Eevee", "Normal", "Fuga"));
        pokedex.add(new Pokemon("Gengar", "Fantasma/Veneno", "Levitación"));
    }
}