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
    do {
        std::cout<<"Digite o dia: ";
        std::cin>>this->dia;
        std::cout<<"Digite o mes: ";
        std::cin>>this->mes;
        std::cout<<"Digite o ano: ";
        std::cin>>this->ano;
    } while(!this->dataValida());
}

void Data::escreveData()
{
    std::cout<<this->dia<<"/"<<this->mes<<"/"<<this->ano<<std::endl;
}

class Pessoa
{
    private:
        std::string nome;
        Data dataNascimento;
    public:
        static int quantidade;
        void setNome(std::string nome);
        std::string getNome();
        void leNome();
        void escrevaNome();


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
    std::cout<<"Digite o nome: ";
    std::getline(std::cin, nome);
}

void Pessoa::escrevaNome()
{
    std::cout<<this->nome<<std::endl;
}

int main()
{
    Pessoa pessoas;
    pessoas.leNome();
    pessoas.escrevaNome();
    return 0;
}