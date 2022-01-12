
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct Pilha{
    int* vet; //vetor que contém os elementos da pilha
    int qtde; //quantidade de elementos efetivos na pilha, topo da pilha vai ser qtde
    int tam; //quantidade máxima de elementos
};

typedef struct Pilha TPilha;

TPilha* cria_pilha(int tam){
    TPilha * pilha = (TPilha *) malloc(sizeof(TPilha));
    pilha->vet = (int *) malloc(sizeof(int)*tam);
    pilha->tam = tam; // tamanho máximo da pilha
    pilha->qtde = 0; //pilha com 0 elementos
    return pilha;
}

int pilha_vazia(TPilha* p)
{
    if(p->qtde > 0)//Verifica se existe um elemento na pilha, caso sim retorna zero, caso não retorna 1
        return 0;
    return 1;
}

int empilha(TPilha* p, int x)
{
    if(p->qtde > p->tam)//Verifica se a pilha está cheia, caso sim retorna 0
        return 0;
    else{
        p->vet[p->qtde] = x;//Insere elemento na ultima posição
        p->qtde++;//Incrementa numero de elementos e ultimo elemento
        return 1;
    }
}

int desempilha(TPilha* p, int *x)
{
    if(pilha_vazia(p))//Verifica pilha vazia
        return 0;
    else
    {
        *x = p->vet[p->qtde-1];//Retorna ultimo elemento
        p->qtde--;//Decrementa o topo
        return 1;
    }
}

int acessa_topo(TPilha* p, int *x)
{
    if(pilha_vazia(p))
    {
        return 0;
    }
    else
    {
        int i = p->qtde-1;
        *x = p->vet[i];
        return 1;
    }
}

int tamanho(TPilha* p)
{
    return p->qtde;
}

void faz_pilha_vazia(TPilha* p)
{
    p->qtde = 0;
}

void destroi(TPilha *p)
{
    free(p->vet);//Libera alocaçao na memoria das variáveis
    free(p);
}

int imprimir(TPilha* p)
{
    printf("\n\nQuantidade: %i",p->qtde);
    printf("\nElementos da pilha: ");

    int i;

    for (i = 0; i < p->qtde; i++)
        printf("%i -> ",p->vet[i]);

    printf("\n\n");
}
