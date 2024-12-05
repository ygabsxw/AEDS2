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

    public static Pokemon findPokemonByName(ArrayList<Pokemon> pokedex, String name) {
        for (Pokemon p : pokedex) {
            if (p.getName().equals(name)) {
                return p;
            }
        }

        return null;
    }

}

class Celula {
    public Pokemon pokemon;
    public Celula prox;

    Celula (Pokemon p) {
        this.pokemon = p;
        this.prox = null;
    }

    Celula (Pokemon p, Celula prox) {
        this.pokemon = p;
        this.prox = prox;
    }
}

class Lista {
    private Celula primeiro;
    private Celula ultimo;

    public Lista() {
        primeiro = new Celula(null);
        ultimo = primeiro;
    }

    public void inserirInicio(Pokemon p) {
        Celula tmp = new Celula(p);
        tmp.prox = primeiro.prox;
        primeiro.prox = tmp;
        if (primeiro == ultimo) {
            ultimo = tmp;
        }
        tmp = null;
    }

    public void inserirFim(Pokemon p) {
        Celula tmp = new Celula(p);
        ultimo.prox = tmp;
        ultimo = ultimo.prox;
        tmp = null;
    }

    public void inserir(Pokemon p, int pos) {
        Celula i;
        int count;

        for (i = primeiro, count = 0 ; (i.prox != ultimo && count < pos) ; i = i.prox, count++) {
            if (pos == count + 1) {
                inserirFim(p);
            } else {
                Celula tmp = new Celula(p);
                tmp.prox = i.prox;
                i.prox = tmp;
                tmp = i = null;
            }
        }
    }

    public boolean pesquisar(Pokemon p, int pos) {
        boolean resp = false;
        for (Celula i = primeiro.prox ; i != null ; i = i.prox) {
            if (i.pokemon == p) {
                System.out.println("(Posicao: " + pos + ") SIM");
                resp = true;
                i = ultimo;
            }
        }
        if (!resp) {
            System.out.println("NAO");
        }

        return resp;
    }
}

class Hash {
    Lista tabela[];
    int tam;


    public Hash() {
        this(21);
    }

    public Hash(int tam) {
        this.tam = tam;
        tabela = new Lista[tam];
        for (int i = 0 ; i < tam ; i++) {
            tabela[i] = new Lista();
        }
    }

    public int calcularHash(Pokemon p) {
        int soma = 0;
        for (int i = 0 ; i < p.getName().length() ; i++) {
            soma += (int)p.getName().charAt(i);
        }
        return soma % tam;
    }

    public void inserirInicio(Pokemon p) {
        int pos = calcularHash(p);
        tabela[pos].inserirInicio(p);
    }

    public boolean pesquisar(Pokemon p) {
        int pos = calcularHash(p);
        return tabela[pos].pesquisar(p, pos);
    }
}


public class TP04Q07 {
    public static void main(String[] args) {
        String csvPath = "/tmp/pokemon.csv";
        ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
        Hash hashDiretaReHash = new Hash();

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
                hashDiretaReHash.inserirInicio(p);
            }
            idStr = sc.nextLine();
        }

        // int n = Integer.parseInt(sc.nextLine());
        String name = sc.nextLine();
        while (!name.equals("FIM")) {
            Pokemon p = Pokemon.findPokemonByName(pokedex, name);
            System.out.print("=> " + p.getName() + ": ");

            hashDiretaReHash.pesquisar(p);

            name = sc.nextLine();
        }



        sc.close();
    }
}