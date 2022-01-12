#include<stdio.h>
#include<stdlib.h>


struct elemento
{
    char info;
    int prox;
};

struct Lista{
    int tam;
    struct elemento* vet; //vetor que contém os elementos da lista
    int qtde; //quantidade de elementos efetivos na lista//quantidade máxima de elementos
    int prim;//posição do primeiro elemento
    int dispo;//posição desocupada
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
    list->dispo = 0;//indice 0 do vetor está desocupado
    list->prim = -1;//não existe ainda primeiro elemento
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

    if(list->qtde == 0 || x < list->vet[list->prim].info)//verifica se está inserindo no primeiro elemento da lista
    {
        posinsere = list->dispo;
        list->vet[list->dispo].info = x;//Insere o elemento na posição disponivel
        list->dispo = list->vet[posinsere].prox;//Manutenção da lista de disponiveis, disponivel agora tem o valor do proximo do proprio disponivel
        list->vet[posinsere].prox = list->prim;//Proximo do novo elemento agora "aponta" para o antigo primeiro elemento da lista
        list->prim = posinsere;//Primeiro elemento da lista recebe o valor da posição do elemento inserido;
        list->qtde++;
        return 1;
    }
    else//Inserção no meio ou no fim da lista
    {
        posinsere = list->prim;//Inicialização da variável que vai percorrer a lista
        int posant, pos;//Posição anterior a nova inserção e posição do vetor que o elemento será inserido

        while(posinsere != -1 && list->vet[posinsere].info < x)//Percorre a lista ate chegar ao seu fim ou ate achar a posição de inserção
        {
            posant = posinsere;//Atualiza posição anterior a nova inserção
            posinsere = list->vet[posinsere].prox;//Atualiza a posição auxiliar que guarda a proxima posição
        }
        pos = list->dispo;
        list->vet[pos].info = x;//Elemento inserido na posição disponivel
        list->dispo = list->vet[pos].prox;//Valor da posição disponivel agora vai para a proxima posição disponivel
        list->vet[pos].prox = list->vet[posant].prox;//Proximo da nova inserção aponta para proximo da posição anterior
        list->vet[posant].prox = pos;//Proximo da posição anterior a inserção aponta para a posição do elemento inserido
        list->qtde++;//Aumenta a quantidade de elementos da lista
        return 1;
    }
}

int remover(TLista* list, char x)
{
    if(list->qtde == 0)//Verifica lista vazia
        return 0;

    int pos, posant;//Cria variáveis para percorrer a lista

    pos = list->prim;//Inicia variável para percorrer a lista

    if(list->vet[list->prim].info == x)
    {
        pos = list->prim;
        list->prim = list->vet[pos].prox;
        list->vet[pos].prox = list->dispo;
        list->dispo = pos;
        list->qtde--;
        return 1;
    }

    while(pos != -1 && list->vet[pos].info != x)//Percorre a lista até chegar ao final ou achar o elemento
    {
        posant = pos;//Atualiza o valor da posição anterior
        pos = list->vet[pos].prox;//Atualiza a posição que percorre a lista
    }

    if(pos == -1)
    {
        return 0;//elemento não está na lista
    }

    list->vet[posant].prox = list->vet[pos].prox;//Proximo da posição anterior ao elemento a ser removido aponta para o proximo da posição do elemento removido
    list->vet[pos].prox = list->dispo;//Proximo da posição do elemento removido aponta para a posição disponivel
    list->dispo = pos;//Posição disponivel agora aponta para a posição do elemento removido
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
    int p = 1;//Posição se inicializa na primeira posição do vetor
    while(i != -1)
    {
        if(list->vet[i].info == x)
        {
            *pos = p;
            return 1;
        }
        i = list->vet[i].prox;//Atualiza variável de controle
        p++;//Incrementa posição relativa

    }
    *pos = -1;//Atualiza valor da posição para não passar um valor errado
    return 0;
}

int acessar(TLista* list, int pos, char *x)
{
    if(pos > list->qtde)//Verifica se a posição passada é invalida
        {
            *x = ' ';//Passando uma caractere para não aparecer o ultimo elemento acessado
            return 0;
        }

    int poselem = list->prim;//Inicia variável que vai marcar a posição no vetor do elemento

    while(pos > 1)//Percorre a lista o numero de posições que foi passado
    {
        poselem = list->vet[poselem].prox;//Atualiza a posição do ponteiro
        pos--;//Atualiza a variável de controle
    }
    if(pos == 0)//Elemento não existe na lista
    {
        *x = ' ';//Passando um caractere para não aparecer o ultimo elemento acessado
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
