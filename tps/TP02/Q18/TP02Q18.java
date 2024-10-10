
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

class QuickSortParcial {
    private Pokemon[] findPokemon;
    private int tam;
    public int comp = 0;
    public int mov = 0;
    int k = 10;

    public Pokemon[] getPokemon() {
        return findPokemon;
    }

    public QuickSortParcial(Pokemon[] findPokemon, int tam) {
        this.findPokemon = findPokemon;
        this.tam = tam;
    }

    public void imprimirSort() {
        for (int i = 0 ; i < k ; i++) {
            System.out.println(findPokemon[i].imprimir());
        }
    }

    public void sort() {
        quickSort(0, tam - 1);
    }

    private void quickSort(int low, int high) {
        int i = low;
        int j = high;
        Pokemon pivot = findPokemon[(i+j)/2];

        while (i <= j) {
            while((findPokemon[i].getGeneration() < pivot.getGeneration()) || ((findPokemon[i].getGeneration() == pivot.getGeneration()) && (findPokemon[i].getName().compareTo(pivot.getName()) < 0))) {
                i++;
                comp++;
            }

            while ((findPokemon[j].getGeneration() > pivot.getGeneration()) || ((findPokemon[j].getGeneration() == pivot.getGeneration()) && (findPokemon[j].getName().compareTo(pivot.getName()) > 0))) {
                j--;
                comp++;
            }

            if (i <= j) {
                mov++;
                swap(i, j);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(low, j);
        }
        if (i < k && i < high) {
            quickSort(i, high);
        }
    }

    private void swap(int i, int menor) {
        Pokemon aux = findPokemon[i];
        findPokemon[i] = findPokemon[menor];
        findPokemon[menor] = aux;
    }
}


public class TP02Q18 {
    
    public static void main(String[] args) {
        // ler o csv
        String csvPath = "/tmp/pokemon.csv";
        
        ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();

        // inicio medicao tempo
        long start = System.nanoTime();

        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {
            br.readLine(); 

            while(br.ready()) {
                String linha = br.readLine();
                // System.out.println("Linha lida: " + linha);

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

        // System.out.println("Pokémons carregados: " + pokedex.size());
        // for (Pokemon p : pokedex) {
        //     System.out.println(p.imprimir());
        // }

        Scanner sc = new Scanner(System.in);

        String id = sc.nextLine();
        int tam = 0;
        Pokemon[] findPokemon = new Pokemon[51];

        while (!(id.equals("FIM"))) {
            for (Pokemon p : pokedex) {
                if (p.getId() == Integer.parseInt(id)) {
                    findPokemon[tam++] = p;
                    break;
                }
            }
            
            id = sc.nextLine();
        }

        QuickSortParcial quickSort = new QuickSortParcial(findPokemon, tam);
        quickSort.sort();
        quickSort.imprimirSort();

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