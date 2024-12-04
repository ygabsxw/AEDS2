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

class No {
    public Pokemon pokemon;
    public No esq;
    public No dir;
    public boolean cor;

    public No (Pokemon pokemon) {
        this(pokemon, null, null, false);
    }

    public No(Pokemon pokemon, boolean cor) {
        this(pokemon, null, null, cor);
    }

    public No (Pokemon pokemon, No esq, No dir, boolean cor) {
        this.pokemon = pokemon;
        this.esq = esq;
        this.dir = dir;
        this.cor = cor;
    }
}

class ArvoreAlvinegra {
    private No raiz;

    public ArvoreAlvinegra() {
        raiz = null;
    }

    public boolean pesquisar(String name) {
        return pesquisar(name, raiz);
    }

    private boolean pesquisar(String name, No i) {
        boolean resp;
        if (i == null) {
            resp = false;
        } else if (name.compareTo(i.pokemon.getName()) == 0) {
            resp = true;
        } else if (name.compareTo(i.pokemon.getName()) < 0) {
            System.out.print("esq ");
            resp = pesquisar(name, i.esq);
        } else {
            System.out.print("dir ");
            resp = pesquisar(name, i.dir);
        }

        return resp;
    }

    public void inserir(Pokemon p) {
        if(raiz == null) {
            raiz = new No(p, false);
        } else if (raiz.esq == null && raiz.dir == null) {
            if (p.getName().compareTo(raiz.pokemon.getName()) < 0) {
                raiz.esq = new No(p);
            } else {
                raiz.dir = new No(p);
            }
        } else if (raiz.esq == null) {
            if (p.getName().compareTo(raiz.pokemon.getName()) < 0) {
                raiz.esq = new No(p);
            } else if (p.getName().compareTo(raiz.dir.pokemon.getName()) < 0) {
                raiz.esq = new No(raiz.pokemon);
                raiz.pokemon = p;
            } else {
                raiz.esq = new No(raiz.pokemon);
                raiz.pokemon = raiz.dir.pokemon;
                raiz.dir.pokemon = p;
            }
            raiz.esq.cor = raiz.dir.cor = false;
        } else if (raiz.dir == null) {
            if (p.getName().compareTo(raiz.pokemon.getName()) > 0) {
                raiz.dir = new No(p);
            } else if (p.getName().compareTo(raiz.esq.pokemon.getName()) > 0) {
                raiz.dir = new No(raiz.pokemon);
                raiz.pokemon = p;
            } else {
                raiz.dir = new No(raiz.pokemon);
                raiz.pokemon = raiz.esq.pokemon;
                raiz.esq.pokemon = p;
            }
            raiz.esq.cor = raiz.dir.cor = false;
        } else {
            inserir(p, null, null, null, raiz);
        }
        raiz.cor = false;
    }

    private void inserir(Pokemon p, No bisavo, No avo, No pai, No i) {
        if (i == null) {
            if (p.getName().compareTo(pai.pokemon.getName()) < 0) {
                i = pai.esq = new No(p, true);
            } else {
               i = pai.dir = new No(p, true);
            }
            if (pai.cor == true && avo != null) {
                balancear(bisavo, avo, pai, i);
            } 
        } else {
            //achou um 4-no: : eh preciso fragmeta-lo e reequilibrar a arvore
            if (i.esq != null && i.dir != null && i.esq.cor && i.dir.cor) {
                i.cor = true;
                i.esq.cor = i.dir.cor = false;
                if (i == raiz) {
                    i.cor = false;
                } else if (pai.cor == true && avo != null) {
                    balancear(bisavo, avo, pai, i);
                }
            }
            if (p.getName().compareTo(i.pokemon.getName()) < 0) {
                inserir(p, avo, pai, i, i.esq);
            } else if (p.getName().compareTo(i.pokemon.getName()) > 0) {
                inserir(p, avo, pai, i, i.dir);
            }
        }
    }

    private void balancear(No bisavo, No avo, No pai, No i) {
        if (avo != null && pai != null && pai.cor == true) {
            if (pai.pokemon.getName().compareTo(avo.pokemon.getName()) < 0) {
                if (i.pokemon.getName().compareTo(pai.pokemon.getName()) < 0) {
                    avo = rotacaoDir(avo);
                } else {
                    avo = rotacaoEsqDir(avo);
                }
            } else {
                if (i.pokemon.getName().compareTo(pai.pokemon.getName()) > 0) {
                    avo = rotacaoEsq(avo);
                } else {
                    avo = rotacaoDirEsq(avo);
                }
            }
            if (bisavo == null) {
                raiz = avo;
            } else if (avo.pokemon.getName().compareTo(bisavo.pokemon.getName()) < 0) {
                bisavo.esq = avo;
            } else {
                bisavo.dir = avo;
            }

            avo.cor = false;
            if (avo.esq != null) avo.esq.cor = true;
            if (avo.dir != null) avo.dir.cor = true;
        }
    }

    private No rotacaoDir(No no) {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        return noEsq;
    }

    private No rotacaoEsq(No no) {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        return noDir;
    }

    private No rotacaoDirEsq(No no) {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);
    }

    private No rotacaoEsqDir(No no) {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);
    }
}


public class TP04Q04 {
    public static void main(String[] args) {
        String csvPath = "/tmp/pokemon.csv";
        ArrayList<Pokemon> pokedex = new ArrayList<Pokemon>();
        ArvoreAlvinegra pokemonTree = new ArvoreAlvinegra();

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
                pokemonTree.inserir(p);
            }
            idStr = sc.nextLine();
        }

        // int n = Integer.parseInt(sc.nextLine());
        String name = sc.nextLine();
        while (!name.equals("FIM")) {
            Pokemon p = Pokemon.findPokemonByName(pokedex, name);
            if (p != null) {
                System.out.println(p.getName());
            } else {
                System.out.println(name);
            }
            System.out.print("raiz ");

            boolean found = pokemonTree.pesquisar(name);
            
            System.out.println(found ? "SIM" : "NAO");

            name = sc.nextLine();
        }



        sc.close();
    }
}