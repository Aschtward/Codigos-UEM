#include<stdio.h>
#include<stdlib.h>


struct elemento
{
    char info;
    int prox;
};

struct Lista{
    int tam;
    struct elemento* vet; //vetor que cont�m os elementos da lista
    int qtde; //quantidade de elementos efetivos na lista//quantidade m�xima de elementos
    int prim;//posi��o do primeiro elemento
    int dispo;//posi��o desocupada
    int max; //tamanho maximo da lista
};

typedef struct Lista TLista;

TLista* cria_lista(int tam){
    TLista * list = (TLista *) malloc(sizeof(TLista));
    list->vet = (struct elemento *) malloc(sizeof(struct elemento)*tam);
    int i;
    for(i = 0; i < tam;i++)
    {
        list->vet[i].prox = i+1;
    }
    list->qtde = 0; //lista com 0 elementos
    list->dispo = 0;//indice 0 do vetor est� desocupado
    list->prim = -1;//n�o existe ainda primeiro elemento
    list->max = tam;//tamanho da lista
    return list;
}

void imprimir(TLista* list)
{
    printf("\nQuantidade: %i", list->qtde);
    printf("\nImprimindo a Lista:");
    int i = list->prim;
    while(i != -1)
    {
        printf("%c ->",list->vet[i].info);
        i = list->vet[i].prox;
    }
}

int inserir(TLista* list, char x)
{
    if(list->qtde == list->tam-1)//verifica lista cheia, retorna 0 se verdadeiro
        return 0;

    int posinsere;

    if(list->qtde == 0 || x < list->vet[list->prim].info)//verifica se est� inserindo no primeiro elemento da lista
    {
        posinsere = list->dispo;
        list->vet[list->dispo].info = x;//Insere o elemento na posi��o disponivel
        list->dispo = list->vet[posinsere].prox;//Manuten��o da lista de disponiveis, disponivel agora tem o valor do proximo do proprio disponivel
        list->vet[posinsere].prox = list->prim;//Proximo do novo elemento agora "aponta" para o antigo primeiro elemento da lista
        list->prim = posinsere;//Primeiro elemento da lista recebe o valor da posi��o do elemento inserido;
        list->qtde++;
        return 1;
    }
    else//Inser��o no meio ou no fim da lista
    {
        posinsere = list->prim;//Inicializa��o da vari�vel que vai percorrer a lista
        int posant, pos;//Posi��o anterior a nova inser��o e posi��o do vetor que o elemento ser� inserido

        while(posinsere != -1 && list->vet[posinsere].info < x)//Percorre a lista ate chegar ao seu fim ou ate achar a posi��o de inser��o
        {
            posant = posinsere;//Atualiza posi��o anterior a nova inser��o
            posinsere = list->vet[posinsere].prox;//Atualiza a posi��o auxiliar que guarda a proxima posi��o
        }
        pos = list->dispo;
        list->vet[pos].info = x;//Elemento inserido na posi��o disponivel
        list->dispo = list->vet[pos].prox;//Valor da posi��o disponivel agora vai para a proxima posi��o disponivel
        list->vet[pos].prox = list->vet[posant].prox;//Proximo da nova inser��o aponta para proximo da posi��o anterior
        list->vet[posant].prox = pos;//Proximo da posi��o anterior a inser��o aponta para a posi��o do elemento inserido
        list->qtde++;//Aumenta a quantidade de elementos da lista
        return 1;
    }
}

int remover(TLista* list, char x)
{
    if(list->qtde == 0)//Verifica lista vazia
        return 0;

    int pos, posant;//Cria vari�veis para percorrer a lista

    pos = list->prim;//Inicia vari�vel para percorrer a lista

    if(list->vet[list->prim].info == x)
    {
        pos = list->prim;
        list->prim = list->vet[pos].prox;
        list->vet[pos].prox = list->dispo;
        list->dispo = pos;
        list->qtde--;
        return 1;
    }

    while(pos != -1 && list->vet[pos].info != x)//Percorre a lista at� chegar ao final ou achar o elemento
    {
        posant = pos;//Atualiza o valor da posi��o anterior
        pos = list->vet[pos].prox;//Atualiza a posi��o que percorre a lista
    }

    if(pos == -1)
    {
        return 0;//elemento n�o est� na lista
    }

    list->vet[posant].prox = list->vet[pos].prox;//Proximo da posi��o anterior ao elemento a ser removido aponta para o proximo da posi��o do elemento removido
    list->vet[pos].prox = list->dispo;//Proximo da posi��o do elemento removido aponta para a posi��o disponivel
    list->dispo = pos;//Posi��o disponivel agora aponta para a posi��o do elemento removido
    list->qtde--;//Diminui quantidade de elementos da lista
    return 1;
}

int tamanho(TLista* list)
{
    return list->qtde;//Retorna quantidade de elementos da lista
}

int devolver(TLista* list, char x, int *pos)
{
    int i = list->prim;//Inicializa variavel que percorre a lista
    int p = 1;//Posi��o se inicializa na primeira posi��o do vetor
    while(i != -1)
    {
        if(list->vet[i].info == x)
        {
            *pos = p;
            return 1;
        }
        i = list->vet[i].prox;//Atualiza vari�vel de controle
        p++;//Incrementa posi��o relativa

    }
    *pos = -1;//Atualiza valor da posi��o para n�o passar um valor errado
    return 0;
}

int acessar(TLista* list, int pos, char *x)
{
    if(pos > list->qtde)//Verifica se a posi��o passada � invalida
        {
            *x = ' ';//Passando uma caractere para n�o aparecer o ultimo elemento acessado
            return 0;
        }

    int poselem = list->prim;//Inicia vari�vel que vai marcar a posi��o no vetor do elemento

    while(pos > 1)//Percorre a lista o numero de posi��es que foi passado
    {
        poselem = list->vet[poselem].prox;//Atualiza a posi��o do ponteiro
        pos--;//Atualiza a vari�vel de controle
    }
    if(pos == 0)//Elemento n�o existe na lista
    {
        *x = ' ';//Passando um caractere para n�o aparecer o ultimo elemento acessado
        return 0;
    }
    *x = list->vet[poselem].info;//Retorna o elemento procurado
    return 1;
}

void destroi(TLista* list)
{
    free(list->vet);
    free(list);
}
