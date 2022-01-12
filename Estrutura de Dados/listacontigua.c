#include "lista.h"
#include<stdio.h>
#include<stdlib.h>
#include<string.h>

struct Lista{
    char* vet; //vetor que cont�m os elementos da lista
    int qtde; //quantidade de elementos efetivos na lista
    int tam; //quantidade m�xima de elementos
};

TLista* cria_lista(int tam){
    TLista * list = (TLista *) malloc(sizeof(TLista));
    list->vet = (char *) malloc(sizeof(char)*tam);
    //(*list).vet = (char *) malloc(sizeof(char)*tam);
    list->tam = tam; // tamanho m�ximo da lista
    list->qtde = 0; //lista com 0 elementos
    return list;
}

void destroi(TLista* list){
    free(list->vet);
    free(list);
}

int tamanho(TLista* list){
    return list->qtde;
}

void imprimir(TLista* list){
    printf("\n\nQuantidade: %i",list->qtde);
    printf("\nElementos da Lista: ");
    int i;
    for (i=0;i<list->qtde;i++)
        printf("%c -> ",list->vet[i]);
    printf("\n\n");
}

int inserir(TLista* list, char x, int i)
{
    if(i < 1 || i > list->qtde+1 || list->qtde == list->tam)
        return 0;
    else {
        int j;
        for (j=list->qtde; j>=i; j--)
            list->vet[j] = list->vet[j-1];
        list->vet[j] = x;
        list->qtde++;
        return 1;
    }

}

int remover(TLista* lista, int i)
{
    if(lista->qtde< i || i < 1 || lista->qtde == 0)
    {
        return 0; //posi��o invalida
    }
    i--;
    while(i < lista->qtde)
    {
        lista->vet[i] = lista->vet[i+1]; //arrasta o proximo elemento para a casa anterior
        i++;
    }
    lista->qtde--;
    return 1;
}

int acessar(TLista* lista, int i, char* elem)
{
    if(i > lista->qtde || i < 1 )
    {
        (*elem) = ' '; //caso o elemento n�o exista o main ainda sim exibiria o ultimo elemento acessado, dessa maneira ele n�o devolve um dado errado
        return 0; //posi��o invalida
    }
    (*elem) = lista->vet[i-1]; //passa o dado usando a posi��o passada
    return 1;
}

int devolver(TLista* lista, char x, int *pos)
{
    int i = 0;

    if(lista->qtde == 0) //verifica se a lista n�o est� vazia
        return 0;

    while(i < lista->qtde-1)
    {
        if(lista->vet[i] == x) //procura o elemento x no vetor
        {
            (*pos) = i+1;
            return 1;
        }
        i++;
    }
    if(i == lista->qtde-1)
    {
        (*pos) = 0; //como o algoritmo exige que se retorne um valor para pos mesmo que o elemento n�o esteja no vetor decidi voltar o valor 0
        return 0;
    }
    return 0;
}
