
import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



class Pokemon {
    private int id;
    private int generation;
    private String name;
    private String description;
    private ArrayList<String> types;
    private ArrayList<String> abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean isLegendary;
    private LocalDate captureDate;


    public Pokemon () { }

    public Pokemon (int id, int generation, String name, 
    String description, ArrayList<String> types, ArrayList<String> abilities, double weight, 
    double height, int captureRate, boolean isLegendary, LocalDate captureDate) {
        setId(id);
        setGeneration(generation);
        setName(name);
        setDescription(description);
        setTypes(types);
        setAbilities(abilities);
        setWeight(weight);
        setHeight(height);
        setCaptureRate(captureRate);
        setIsLegendary(isLegendary);
        setCaptureDate(captureDate);
    }


    //id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //generation
    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    //name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //description
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //types
    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    //abilities
    public ArrayList<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<String> abilities) {
        this.abilities = abilities;
    }

    public void setAbilities(String abilities) {
        
        abilities = abilities.replaceAll("[\\[\\]\"']", "").trim();

        
        this.abilities = new ArrayList<>(Arrays.asList(abilities.split(",\\s*")));
    }

    //weight
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    //height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    //captureRate
    public int getCaptureRate() {
        return captureRate;
    }

    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }

    //isLegendary
    public boolean getIsLegendary() {
        return isLegendary;
    }

    public void setIsLegendary(boolean isLegendary) {
        this.isLegendary = isLegendary;
    }

    //captureDate
    public LocalDate getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(LocalDate captureDate) {
        this.captureDate = captureDate;
    }

    void ler (String csvLine) {
        String[] data = csvLine.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
        
        setId(Integer.parseInt(data[0]));
        setGeneration(Integer.parseInt(data[1]));
        setName(data[2]);
        setDescription(data[3]);

        //types
        ArrayList<String> typesList = new ArrayList<>();
        typesList.add(data[4]);
        if (!data[5].isEmpty()) typesList.add(data[5]);
        setTypes(typesList);

        //abilities
        String abilitiesStr = data[6].replace("[", "").replace("]", "").replace("'", "").trim();
        setAbilities(abilitiesStr);

        // weight
        if (!data[7].isEmpty()) {
            setWeight(Double.parseDouble(data[7]));
        } else {
            setWeight(0);
        }

        // height
        if (!data[8].isEmpty()) {
            setHeight(Double.parseDouble(data[8]));
        } else {
            setHeight(0); // Define 0 ou outro valor padrão se o campo estiver vazio
        }

        // captureRate
        if (!data[9].isEmpty()) {
            setCaptureRate(Integer.parseInt(data[9]));
        } else {
            setCaptureRate(0); // Define um valor padrão se o campo estiver vazio
        }

        setIsLegendary(data[10].equals("1") || data[10].equalsIgnoreCase("true"));

        //captureDate
        LocalDate date = parseDate(data[11]);
        setCaptureDate(date);

    }

    private LocalDate parseDate(String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dateStr, formatter);
    }

    String imprimir () {
        StringBuilder sb = new StringBuilder();
        sb.append("[#");
        sb.append(getId()).append(" -> ");
        sb.append(getName()).append(": ");
        sb.append(getDescription()).append(" - ['");

        //types
        if (getTypes().size() > 0) {
            sb.append(getTypes().get(0));
        }
        sb.append("'");
        if (getTypes().size() > 1) {
            sb.append(", '");
            sb.append(getTypes().get(1)).append("'");
        }
        sb.append("] - ");

        //abilities
        sb.append("[");
        for (int i = 0 ; i < getAbilities().size() ; i++) {
            sb.append("'");
            sb.append(getAbilities().get(i));
            sb.append("'");
            if (i < getAbilities().size() - 1) {
                // colocar a virgula caso ainda tenha abilities
                sb.append(", ");
            }
        }
        sb.append("] - ");

        sb.append(getWeight()).append("kg - ");
        sb.append(getHeight()).append("m - ");
        sb.append(getCaptureRate()).append("% - ");
        sb.append(getIsLegendary() ? "true" : "false").append(" - ");
        sb.append(getGeneration()).append(" gen] - ");
        sb.append(getCaptureDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));

        return sb.toString();
    }

}

class Lista {
    private int tam;
    private Pokemon[] pokemons;
    private int n;

    public Lista() {
        this(100);
    }

    public Lista(int tam) {
        this.tam = tam;
        this.pokemons = new Pokemon[this.tam];
        this.n = 0;
    }

    public void inserirInicio(Pokemon pokemon) {
        inserir(pokemon, 0);
    }

    public void inserirFim(Pokemon pokemon) {
        if (n <= tam) {
          pokemons[n++] = pokemon;
        }
    }

    public void inserir(Pokemon pokemon, int pos) {
        n++;
    
        for (int i = n; i > pos; i--) {
          pokemons[i] = pokemons[i - 1];
        }
    
        pokemons[pos] = pokemon;
    }  
    
    public Pokemon removerInicio() {
        return remover(0);
      }
    
    public Pokemon remover(int pos) {
        if (pos < 0 || pos > n)
          return null;
    
        Pokemon aux = pokemons[pos];
    
        n--;
        for (int i = pos; i < n; i++) {
          pokemons[i] = pokemons[i + 1];
        }
    
        return aux;
    }
    
    public Pokemon removerFim() {
        if (n <= 0)
          return null;
    
        return pokemons[n--];
    }  
    

    public void imprimirPokemon() {
        for (int i = 0 ; i < n ; i++) {
            System.out.print("[" + i + "] ");
            System.out.println(pokemons[i].imprimir());
        }
    }

}


public class TP03Q01 {
    public static void main(String[] args) {
        String csvPath = "/tmp/pokemon.csv";
        ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
        Lista pokemonList = new Lista();

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            br.readLine(); 

            while (br.ready()) {
                String linha = br.readLine();
                Pokemon p = new Pokemon();
                p.ler(linha);
                pokedex.add(p);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Erro: Arquivo não encontrado em " + csvPath);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo CSV: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);

        String idStr = sc.nextLine();
        while (!idStr.equals("FIM")) {
            int id = Integer.parseInt(idStr);
            Pokemon p = pokedex.get(id - 1);
            if (p != null) {
                pokemonList.inserirFim(p);
            }
            idStr = sc.nextLine();
        }

        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0 ; i < n ; i++) {
            String line = sc.nextLine();
            // divide por espaco
            String[] tokens = line.split(" ");
            // primeira parte (o comando) para saber oq sera executado
            String comando = tokens[0];

            if (comando.equals("II")) {
                int id = Integer.parseInt(tokens[1]); // segunda parte recebe o id do pokemon
                Pokemon p = pokedex.get(id - 1); 
                if (p != null) {
                    pokemonList.inserirInicio(p);
                }
            } else if (comando.equals("I*")) {
                int pos = Integer.parseInt(tokens[1]); // segunda parte recebe a pos a ser inserido
                int id = Integer.parseInt(tokens[2]); // terceira parte recebe o id do pokemon
                Pokemon p = pokedex.get(id - 1); 
                if (p != null) {
                    pokemonList.inserir(p, pos);
                }
            } else if (comando.equals("IF")) {
                int id = Integer.parseInt(tokens[1]); // segunda parte recebe o id do pokemon
                Pokemon p = pokedex.get(id - 1); 
                if (p != null) {
                    pokemonList.inserirFim(p);
                }
            } else if (comando.equals("RI")) {
                Pokemon p = pokemonList.removerInicio();
                if (p != null) {
                    System.out.println("(R) " + p.getName());
                }
            } else if (comando.equals("R*")) {
                int pos = Integer.parseInt(tokens[1]); // segunda parte recebe a pos a ser removido
                Pokemon p = pokemonList.remover(pos);
                if (p != null) {
                    System.out.println("(R) " + p.getName());
                }
            } else if (comando.equals("RF")) {
                Pokemon p = pokemonList.removerFim();
                if (p != null) {
                    System.out.println("(R) " + p.getName());
                }
            }
        }

        pokemonList.imprimirPokemon();

        sc.close();
    }
}