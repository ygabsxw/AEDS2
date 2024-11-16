
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

class QuickSort {
    private ListaDupla pokemonListaDupla;
    public int comp = 0;
    public int mov = 0;

    public QuickSort(ListaDupla pokemonListaDupla) {
        this.pokemonListaDupla = pokemonListaDupla;
    }

    public void sort() {
        quickSort(pokemonListaDupla.inicio, pokemonListaDupla.fim);
    }

    private void quickSort(Celula low, Celula high) {
        if (high != null && low != high && low != high.prox) {
            Celula i = low.ant;
            Celula j = low;

            Pokemon pivot = high.pokemon;

            while (j != high) {
                comp++;
                if ((j.pokemon.getGeneration() < pivot.getGeneration()) || 
                ((j.pokemon.getGeneration() == pivot.getGeneration()) && 
                (j.pokemon.getName().compareTo(pivot.getName()) < 0))) {
                    if (i == null) {
                        i = low;
                    } else {
                        i = i.prox;
                    }
                    if (i != j) {
                        Pokemon aux = i.pokemon;
                        i.pokemon = j.pokemon;
                        j.pokemon = aux;
                        mov++;
                    }
                }
                j = j.prox;
            }

            if (i == null) {
                i = low;
            } else {
                i = i.prox;
            }

            if (i != high) {
                Pokemon aux = i.pokemon;
                i.pokemon = high.pokemon;
                high.pokemon = aux;
                mov++;
            }

            quickSort(low, i.ant);
            quickSort(i.prox, high);
        }
    }
}

class Celula {
    Pokemon pokemon;
    Celula prox;
    Celula ant;

    public Celula(Pokemon pokemon) {
        this.pokemon = pokemon;
        this.prox = null;
        this.ant = null;
    }
}

class ListaDupla {
    public Celula inicio;
    public Celula fim; 
    public int n;

    public ListaDupla() {
        inicio = null;
        fim = null;
        n = 0;
    }

    public void inserirInicio(Pokemon pokemon) {
        Celula tmp = new Celula(pokemon);
        if (inicio == null) {
            inicio = tmp;
            fim = tmp;
        } else {
            tmp.prox = inicio;
            inicio.ant = tmp;
            inicio = tmp;
        }
        n++;
    }

    public void inserirFim(Pokemon pokemon) {
        Celula tmp = new Celula(pokemon);
        if (inicio == null) {
            inicio = tmp;
            fim = tmp;
        } else {
            tmp.ant = fim;
            fim.prox = tmp;
            fim = tmp;
        }
        n++;
    }

    public void inserir(Pokemon pokemon, int pos) {
        if (pos < 0 || pos > n) {
            return;
        }
        if (pos ==0) {
            inserirInicio(pokemon);
        } else if (pos == n) {
            inserirFim(pokemon);
        } else {
            Celula tmp = new Celula(pokemon);
            Celula current = inicio;
            for (int i = 0 ; i < pos - 1 ; i++) {
                current = current.prox;
            }
            tmp.prox = current.prox;
            tmp.ant = current;
            current.prox.ant = tmp;
            current.prox = tmp;
            n++;
        }
    }

    public Pokemon removerInicio() {
        if (inicio == null) {
            return null;
        }
        Celula tmp = inicio;
        Pokemon pokemonRemovido = tmp.pokemon;
        inicio = tmp.prox;
        if (inicio == null) {
            fim = null;
        } else {
            inicio.ant = null;
        }
        n--;
        return pokemonRemovido;
    }

    public Pokemon removerFim() {
        if (inicio == null) {
            return null;
        }
        Celula tmp = fim;
        Pokemon pokemonRemovido = tmp.pokemon;
        fim = tmp.ant;
        if (fim == null) {
            fim = null;
        } else {
            fim.prox = null;
        }
        n--;
        return pokemonRemovido;
    }

    public Pokemon remover(int pos) {
        if (pos < 0 || pos >= n || inicio == null) {
            return null;
        }
        if (pos == 0) {
            return removerInicio();
        } else if (pos == n - 1) {
            return removerFim();
        } else {
            Celula current = inicio;
            for (int i = 0 ; i < pos ; i++) {
                current = current.prox;
            }
            Pokemon pokemonRemovido = current.pokemon;
            current.ant.prox = current.prox;
            current.prox.ant = current.ant;
            n--;
            return pokemonRemovido;
        }
    }

    public void imprimirListaDupla() {
        Celula current = inicio;
        while (current != null) {
            System.out.println(current.pokemon.imprimir());
            current = current.prox;
        }
    }
}

public class TP03Q10 {
    
    public static void main(String[] args) {
        String csvPath = "/tmp/pokemon.csv";
        ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
        ListaDupla pokemonListaDupla = new ListaDupla();

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
                pokemonListaDupla.inserirFim(p);
            }
            idStr = sc.nextLine();
        }


        // inicio medicao tempo
        long start = System.nanoTime();

        QuickSort quickSort = new QuickSort(pokemonListaDupla);
        quickSort.sort();
        
        pokemonListaDupla.imprimirListaDupla();

        long end = System.nanoTime();

        double executionTime = (end - start);

        int comp = quickSort.comp;
        int mov = quickSort.mov;

        String conteudo = "843610" + "\t" + comp + "\t" + mov + '\t' + executionTime + "ms";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("843610_partialQuickSort.txt"))) {
            writer.write(conteudo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }


        sc.close();
    }
}