#include "Lista Ordenada.h"
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct Lista{
    char* vet; //vetor que contém os elementos da lista
    int qtde; //quantidade de elementos efetivos na lista
    int tam; //quantidade máxima de elementos
};


TLista* cria_lista(int tam){
    TLista * lista = (TLista *) malloc(sizeof(TLista));
    lista->vet = (char *) malloc(sizeof(char)*tam);
    lista->tam = tam; // tamanho máximo da lista
    lista->qtde = 0; //lista com 0 elementos
    return lista;
}

int devolver(TLista *lista, char x, int *pos)
{
    int posinicial, posfinal, meiolista;

    posfinal = lista->qtde-1;
    posinicial = 0;

    while( posinicial <= posfinal)
    {
        meiolista = posfinal-posinicial/2;
        if(lista->vet[meiolista] > x)
        {
            posfinal = meiolista-1;
        }
        if(lista->vet[meiolista] < x)
        {
            posinicial = meiolista+1;
        }
        if(lista->vet[meiolista] == x)
        {
            (*pos) = meiolista+1;
            return 1;
        }
    }
    (*pos) = -1;
    return 0;
}

int inserir(TLista *lista, char x)
{
    int i = lista->qtde, j;

    if(lista->qtde == lista->tam)
        return 0; //lista cheia

    while( i >= 0  && lista->vet[i-1] > x) //percorre a lista enquanto os valores do vetor forem menores que o do elemento x
    {
        lista->vet[i] = lista->vet[i-1];
        i--;
    }

    lista->vet[i] = x; // insere x
    lista->qtde++;
    return 1;
}

int remover(TLista *lista, char x)
{
    int i;

    if(lista->qtde == 0)
        return 0; //lista vazia

    devolver(lista,x,&i); //busca posição de remoção
    i--;

    while(i < lista->qtde-1)
    {
        lista->vet[i] = lista->vet[i+1]; //arrasta os elementos uma posição para trás
        i++;
    }

    lista->qtde --; //diminui a quantidade de elementos na lista
    return 1;
}

int acessar(TLista *lista, int i, char *elem)
{
    if(lista->qtde < i || i < 1 || lista->qtde == 0)//verifica se a posição é invalida
    {
        (*elem) = ' ';
        return 0; //erro na operação
    }

    (*elem) = lista->vet[i-1];
    return 1;
}

int tamanho(TLista *lista)
{
    return(lista->qtde);
}

void imprimir(TLista *lista)
{
    printf("\n\nQuantidade: %i",lista->qtde);
    printf("\nElementos da Lista: ");

    int i;

    for (i = 0; i < lista->qtde; i++)
        printf("%c -> ",lista->vet[i]);

    printf("\n\n");

}

void destroi(TLista* list)
{
    free(list->vet);
    free(list);
}
