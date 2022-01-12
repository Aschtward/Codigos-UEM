#include<stdlib.h>
#include<stdio.h>


typedef struct elemento
{
    int dado;
    struct elemento* ant;

}elem;

typedef elem* p;

typedef struct pilha
{
    p ult;//Ponteiro para inserção de novo elemento
    int qtde;

}pilha;

typedef pilha TPilha;

TPilha* cria_pilha()
{
    TPilha *p = (TPilha*)malloc(sizeof(TPilha));//Alocação de memoria para o ponteiro para pilha
    p->ult = NULL;
    p->qtde = 0;//Definindo a quantidade de elementos igual a 0
    return p;
}

int pilha_vazia(TPilha* p)
{
    if(p->ult == NULL)
        return 1;
    else
        return 0;
}

int empilha(TPilha *p, int x)
{
    elem* novo_elemento = (elem*)malloc(sizeof(elem));
    novo_elemento->dado = x;

    if(p->ult == NULL)
    {
        p->ult = novo_elemento;
        p->ult->ant = NULL;
        p->qtde++;
        return 1;
    }
    else
    {
        novo_elemento->ant = p->ult;
        p->ult = novo_elemento;
        p->qtde++;
        return 1;
    }
}

int desempilha(TPilha* p, int *x)
{
    if(pilha_vazia(p))
        return 0;
    else
    {
        *x = p->ult->dado;
        p->ult = p->ult->ant;
        p->qtde--;
        return 1;
    }
}

int acessa_topo(TPilha* p , int *x)
{
    if(p->ult == NULL)
    {
        return 0;
    }
    else
    {
        *x = p->ult->dado;
        return 1;
    }
}

int tamanho(TPilha* p)
{
    return p->qtde;
}

void imprimir(TPilha* p)
{
    elem* aux = p->ult;

    printf("\n\nQuantidade: %i",p->qtde);
    printf("\nElementos da pilha: ");

    while(aux != NULL)
    {
        printf("%i -> ",aux->dado);//Poderia imprimir em ordem usando um ponteiro prox, porem achei que não fosse esse o intuiro dessa implementação
        aux = aux->ant;
    }

    printf("\n\n");
}

void faz_pilha_vazia(TPilha* p)
{
    //Nesse caso achei que o certo seria liberar os elementos da pilha mas não destruir ela

    elem* aux = p->ult;
    elem* liberado;

    while(aux != NULL)
    {
        liberado = aux;
        free(liberado);
        aux = aux->ant;
    }
    p->qtde = 0;
    p->ult = aux;
}

void destroi(TPilha *p)
{
    elem* aux = p->ult;
    elem* liberado;

    while(aux != NULL)
    {
        liberado = aux;
        aux = aux->ant;
        free(liberado);
    }
    free(p);
}
