
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

class MergeSort {
    private Pokemon[] findPokemon;
    private int tam;
    public int comp = 0;
    public int mov = 0;

    public Pokemon[] getPokemon() {
        return findPokemon;
    }

    public MergeSort(Pokemon[] findPokemon, int tam) {
        this.findPokemon = findPokemon;
        this.tam = tam;
    }

    public void imprimirSort() {
        for (int i = 0 ; i < tam ; i++) {
            System.out.println(findPokemon[i].imprimir());
        }
    }

    public void sort() {
        mergeSort(0, tam - 1);
    }

    private void mergeSort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // ordena primeira e segunda metade
            mergeSort(left, mid);
            mergeSort(mid + 1, right);

            // junta as duas partes ordenadas
            merge(left, mid, right);
        }
    }

    public void merge(int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Pokemon []a1 = new Pokemon[n1];
        Pokemon []a2 = new Pokemon[n2];

        for (int i = 0 ; i < n1 ; i++) {
            a1[i] = findPokemon[left + i];
        }
        for (int j = 0 ; j < n2 ; j++) {
            a2[j] = findPokemon[mid + 1 + j];
        }

        int i = 0, j = 0, k = left;

        while (i < n1 && j < n2) {
            comp++;
            if (a1[i].getTypes().size() > 0 && a2[j].getTypes().size() > 0) {
                if ((a1[i].getTypes().get(0).compareTo(a2[j].getTypes().get(0)) < 0) ||
                    ((a1[i].getTypes().get(0).compareTo(a2[j].getTypes().get(0)) == 0) && (a1[i].getName().compareTo(a2[j].getName()) < 0))) {
                    mov++;
                    findPokemon[k] = a1[i];
                    i++;
                } else {
                    mov++;
                    findPokemon[k] = a2[j];
                    j++;
                }
            } else if (a1[i].getTypes().size() > 1 && a2[j].getTypes().size() > 1) {
                if  (((a1[i].getTypes().get(0).compareTo(a2[j].getTypes().get(0))) < 0) ||
                    ((a1[i].getTypes().get(0).compareTo(a2[j].getTypes().get(0)) == 0) && (a1[i].getTypes().get(1).compareTo(a2[j].getTypes().get(1)) < 0)) ||
                    ((a1[i].getTypes().get(0).compareTo(a2[j].getTypes().get(0)) == 0) && ((a1[i].getTypes().get(1).compareTo(a2[j].getTypes().get(1)) == 0)) && (a1[i].getName().compareTo(a2[j].getName()) < 0))) {
                    mov++;
                    findPokemon[k] = a1[i];
                    i++;
                } else {
                    mov++;
                    findPokemon[k] = a1[j];
                    j++;
                }
            } else {
                mov++;
                findPokemon[k] = a2[j];
                j++;
            }
            k++;
           
        }

        // Copia os elementos restantes
        while (i < n1) {
            findPokemon[k] = a1[i];
            i++;
            k++;
        } 

        while (j < n2) {
            findPokemon[k] = a2[j];
            j++;
            k++;
        }
    }
}


public class TP02Q13 {
    
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

        MergeSort mergeSort = new MergeSort(findPokemon, tam);
        mergeSort.sort();
        mergeSort.imprimirSort();

        long end = System.nanoTime();

        double executionTime = (end - start);

        int comp = mergeSort.comp;
        int mov = mergeSort.mov;

        String conteudo = "843610" + "\t" + comp + "\t" + mov + '\t' + executionTime + "ms";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("843610_mergesort.txt"))) {
            writer.write(conteudo);
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }


        sc.close();
    }
}