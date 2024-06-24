#include <iostream>
#include <string>

#define MAX 1000

class Data 
{
    private: 
        int dia;
        int mes;
        int ano;
    public:
        Data() { }
        Data(int dia, int mes, int ano)
        {
            this->dia = dia;
            this->mes = mes;
            this->ano = ano;
        }
        void setDia(int dia);
        void setMes(int mes);
        void setAno(int ano);
        bool dataValida();
        int getDia();
        int getMes();
        int getAno();
        void leData();
        void escreveData();
};


void Data::setDia(int dia)
{
    this->dia = dia;
}

void Data::setMes(int mes)
{
    this->mes = mes;
}

void Data::setAno(int ano)
{
    this->ano = ano;
}

bool Data::dataValida()
{
    bool valida = true;
    if(this->dia < 1 || this->dia > 31 || this->mes < 1 || this->mes > 12 || this->ano < 0)
    {
        valida = false;
    }
    return valida;
}

int Data::getDia()
{
    return this->dia;
}

int Data::getMes()
{
    return this->mes;
}

int Data::getAno()
{
    return this->ano;
}

void Data::leData()
{
    int dia, mes, ano;
    do {
        std::cout<<"Digite o dia: ";
        std::cin>>dia;
        std::cout<<"Digite o mes: ";
        std::cin>>mes;
        std::cout<<"Digite o ano: ";
        std::cin>>ano;
    } while(!this->dataValida());
    setDia(dia);
    setMes(mes);
    setAno(ano);
}

void Data::escreveData()
{
    std::cout<<this->dia<<"/"<<this->mes<<"/"<<this->ano<<std::endl;
}

class Pessoa
{
    private:
        std::string nome;
        Data nascimento;
        static int quantidade;
    public:
        static int getQuantidade()
        {
            return quantidade;
        }
        Pessoa() {
            this->nascimento = Data();
            quantidade++;
        }
        void setNome(std::string nome);
        std::string getNome();
        void leNome();
        void escrevaNome();
        void lePessoa();
        void escrevaPessoa();

};

int Pessoa::quantidade = 0;

void Pessoa::setNome(std::string nome)
{
    this->nome = nome;
}

std::string Pessoa::getNome()
{
    return this->nome;
}  

void Pessoa::leNome()
{
    std::string nome;
    std::cout<<"Digite o nome: ";
    std::getline(std::cin, nome);
    setNome(nome);
}

void Pessoa::escrevaNome()
{
    std::cout<<this->nome<<std::endl;
}

void Pessoa::lePessoa()
{
    leNome();
    nascimento.leData();

}

void Pessoa::escrevaPessoa()
{
    escrevaNome();
    nascimento.escreveData();
}

void cadastro(Pessoa* P[])
{
    if (Pessoa::getQuantidade() < MAX){
        P[Pessoa::getQuantidade()] = new Pessoa();
        P[Pessoa::getQuantidade()-1]->lePessoa();
    }
}



int main()
{
    Pessoa pessoas;
    pessoas.lePessoa();
    pessoas.escrevaPessoa();
    return 0;
}