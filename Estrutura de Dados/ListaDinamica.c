#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct elemento//**Defini��o de elemento da lista
{
    char info;

}elemento;

typedef struct lista//**Defini��o de lista
{
    elemento elem; //Elemento da lista
    struct lista *prox; //Ponteiro que aponta para o proximo da lista
    int qtde;//Quantidade de elementos da lista

}TLista;

typedef TLista* lista; //*Deixei como observa��o pois imagino que seja declarado no .h**

lista* cria_lista()//**Fun��o para criar a lista
{
    lista* list = (Lista*)malloc(sizeof(Lista));//Aloca espa�o para o primeiro elemento
    //(*list)->prox = NULL;//Proximo do primeiro elemento vale nulo
    //(*list)->qtde = 0;//Inicia valor de quantidade da lista igual a 0
    return list;//Retorna o ponteiro para primeira posi��o da lista
}

//**Neste caso a lista � ordenada

int inserir(lista *l, char x)
{
    if(l == NULL)//Erro ao criar a lista
        return 0;

    //**Declara��o de variaveis

    TLista* novo_elemento = (TLista*)malloc(sizeof(TLista));//Aloca espa�o para novo elemento
    novo_elemento->elem.info = x;

    //**Caso lista vazia

    if((*l)->qtde == 0)
    {
        novo_elemento->prox = (*l);//Proximo do novo elemento aponta para  o inicio da lista
        (*l) = novo_elemento;//Inicio da lista agora � o novo elemento
        (*l)->qtde++;//Incrementa a quantidade
        return 1;
    }
    //**Caso inser��o lista n�o vazia

    TLista *ant, *pos = (*l);//Cria��o de vari�veis para percorrer a lista

    while(pos != NULL && pos->elem.info < novo_elemento->elem.info )//Percorre a lista at� achar a posi��o adequada para inser��o
    {
        ant = pos;//Atualiza variaveis que percorrem a lista
        pos = pos->prox;
    }
    if(pos == (*l))//*Inser��o no inicio da lista
    {
        novo_elemento->prox = (*l);//Igual para lista vazia
        (*l) = novo_elemento;
        (*l)->qtde++;
    }
    else
    {
        novo_elemento->prox = ant->prox;//Altera o valor dos ponteiros proximos para que o novo elemento aponte para o proximo do anterior
        ant->prox = novo_elemento;//Proximo da posi��o anterior agora aponta para o novo elemento
        (*l)->qtde++;//Incrementa a quantidade de elementos da lista
    }
    return 1;
}

int remover(lista *l, char x)
{
    if((*l)->qtde == 0)//**Caso lista vazia
        return 0;

    TLista *ant, *pos = (*l);//Inicializa��o das vari�veis que percorrem a lista

    while(pos != NULL && x != pos->elem.info)//Percorre a lista ate o seu final ou at� achar o elemento que ser� removido
    {
        ant = pos;//Atualiza vari�veis que percorrem a lista
        pos = pos->prox;
    }

    if(pos == NULL)//Caso elemento n�o exista na lista
        return 0;

    if(pos == (*l))//Caso seja o primeiro elemento da lista
        (*l) = pos->prox;//Primeiro  elemento agora � o pr�ximo do antigo primeiro elemento
    else//Caso seja uma remo��o no meio da lista
        ant->prox = pos->prox; //Pr�ximo do anterior agora aponta para o pr�ximo do elemento removido

    free(pos);//Libera o no
    (*l)->qtde--;//Diminui a quantidade de elementos da lista
    return 1;
}

void imprimir(lista *l)
{
    TLista *aux = (*l);//Inicializa vari�vel que vai percorrer a lista

    printf("\n\nQuantidade: %i",(*l)->qtde);
    printf("\nElementos da Lista: ");

    while(aux != NULL)//Percorre a lista at� seu final
    {
        printf("%c -> ",aux->elem.info);//Imprime os elementos da lista
        aux = aux->prox;//Atualiza vari�vel que percorre a lisa
    }
    printf("\n\n");
}

int devolver(lista *l, char x, int *pos)//**Este caso volta a primeira apari��o do elemento na lista
{
    if((*l)->qtde == 0)//Verifica se a lista est� vazia
        return 0;

    TLista *aux = (*l);//Cria vari�vel auxiliar para percorre a lista
    int i = 1;//Inicia contador que vai indicar a posi��o do elemento relativa a lista

    while(aux != NULL && aux->elem.info != x)//Percorre a lista at� achar o elemento ou at� seu final
    {
        i++;//Incrementa a posi��o
        aux = aux->prox;//Atualiza vari�vel que percorre a lista
    }

    if(aux == NULL)//Elemento n�o est� na lista
    {
        *pos = -1;//Retorna -1 para indicar que a posi��o n�o existe
        return 0;
    }

    *pos = i;//Retorna posi��o relativa a lista
    return 1;
}

int  acessar(lista *l, int pos, char *x)
{
    if((*l)->qtde == 0 || (*l)->qtde < pos)//Verifica se a lista est� vazia ou se a posi��o � invalida
        return 0;

    TLista *aux = (*l);//Cria vari�vel para percorrer a lista
    int i = 1;//Vari�vel auxiliar para o no

    while(i <= pos)//Percorre a lista at� a posi��o recebida
    {
        aux = aux->prox;//Atualiza vari�veis
        i++;
    }
    *x = aux->elem.info;//Devolve o elemento na posi��o pos relativa a lista
    return 1;
}

void destroi(lista *l)
{
    TLista *aux;//Vari�vel para liberar os nos da lista
    while((*l) != NULL)//La�o que vai at� o fim da lista
    {
        aux = (*l);//Vari�vel auxiliar recebe o valor do primeiro valor da lista
        (*l) = (*l)->prox;//Primeiro elemento agora � o proximo do primeiro elemento
        free(aux);//Libera elemento auxiliar
    }
    free(l);//Libera  ultimo elemento  da lista
}
