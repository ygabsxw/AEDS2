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
        Data(int dia, int mes, int ano);
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
    cout<<"Digite o dia: ";
    cin>>this->dia;
    cout<<"Digite o mes: ";
    cin>>this->mes;
    cout<<"Digite o ano: ";
    cin>>this->ano;
}

void Data::escreveData()
{
    cout<<this->dia<<"/"<<this->mes<<"/"<<this->ano<<std::endl;
}

class Pessoa
{
    private:
        string nome;
        Data dataNascimento;
    public:
        static int quantidade;
        void setNome(string nome);
        string getNome();
        void leNome();
        void escrevaNome();


};

int Pessoa::quantidade = 0;

void Pessoa::setNome(string nome)
{
    this->nome = nome;
}

string Pessoa::getNome()
{
    return this->nome;
}  

void Pessoa::leNome()
{
    cout<<"Digite o nome: ";
    getline(cin, nome);
}

void Pessoa::escrevaNome()
{
    cout<<this->nome<<std::endl;
}

