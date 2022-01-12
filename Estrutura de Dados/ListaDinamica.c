#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct elemento//**Definição de elemento da lista
{
    char info;

}elemento;

typedef struct lista//**Definição de lista
{
    elemento elem; //Elemento da lista
    struct lista *prox; //Ponteiro que aponta para o proximo da lista
    int qtde;//Quantidade de elementos da lista

}TLista;

typedef TLista* lista; //*Deixei como observação pois imagino que seja declarado no .h**

lista* cria_lista()//**Função para criar a lista
{
    lista* list = (Lista*)malloc(sizeof(Lista));//Aloca espaço para o primeiro elemento
    //(*list)->prox = NULL;//Proximo do primeiro elemento vale nulo
    //(*list)->qtde = 0;//Inicia valor de quantidade da lista igual a 0
    return list;//Retorna o ponteiro para primeira posição da lista
}

//**Neste caso a lista é ordenada

int inserir(lista *l, char x)
{
    if(l == NULL)//Erro ao criar a lista
        return 0;

    //**Declaração de variaveis

    TLista* novo_elemento = (TLista*)malloc(sizeof(TLista));//Aloca espaço para novo elemento
    novo_elemento->elem.info = x;

    //**Caso lista vazia

    if((*l)->qtde == 0)
    {
        novo_elemento->prox = (*l);//Proximo do novo elemento aponta para  o inicio da lista
        (*l) = novo_elemento;//Inicio da lista agora é o novo elemento
        (*l)->qtde++;//Incrementa a quantidade
        return 1;
    }
    //**Caso inserção lista não vazia

    TLista *ant, *pos = (*l);//Criação de variáveis para percorrer a lista

    while(pos != NULL && pos->elem.info < novo_elemento->elem.info )//Percorre a lista até achar a posição adequada para inserção
    {
        ant = pos;//Atualiza variaveis que percorrem a lista
        pos = pos->prox;
    }
    if(pos == (*l))//*Inserção no inicio da lista
    {
        novo_elemento->prox = (*l);//Igual para lista vazia
        (*l) = novo_elemento;
        (*l)->qtde++;
    }
    else
    {
        novo_elemento->prox = ant->prox;//Altera o valor dos ponteiros proximos para que o novo elemento aponte para o proximo do anterior
        ant->prox = novo_elemento;//Proximo da posição anterior agora aponta para o novo elemento
        (*l)->qtde++;//Incrementa a quantidade de elementos da lista
    }
    return 1;
}

int remover(lista *l, char x)
{
    if((*l)->qtde == 0)//**Caso lista vazia
        return 0;

    TLista *ant, *pos = (*l);//Inicialização das variáveis que percorrem a lista

    while(pos != NULL && x != pos->elem.info)//Percorre a lista ate o seu final ou até achar o elemento que será removido
    {
        ant = pos;//Atualiza variáveis que percorrem a lista
        pos = pos->prox;
    }

    if(pos == NULL)//Caso elemento não exista na lista
        return 0;

    if(pos == (*l))//Caso seja o primeiro elemento da lista
        (*l) = pos->prox;//Primeiro  elemento agora é o próximo do antigo primeiro elemento
    else//Caso seja uma remoção no meio da lista
        ant->prox = pos->prox; //Próximo do anterior agora aponta para o próximo do elemento removido

    free(pos);//Libera o no
    (*l)->qtde--;//Diminui a quantidade de elementos da lista
    return 1;
}

void imprimir(lista *l)
{
    TLista *aux = (*l);//Inicializa variável que vai percorrer a lista

    printf("\n\nQuantidade: %i",(*l)->qtde);
    printf("\nElementos da Lista: ");

    while(aux != NULL)//Percorre a lista até seu final
    {
        printf("%c -> ",aux->elem.info);//Imprime os elementos da lista
        aux = aux->prox;//Atualiza variável que percorre a lisa
    }
    printf("\n\n");
}

int devolver(lista *l, char x, int *pos)//**Este caso volta a primeira aparição do elemento na lista
{
    if((*l)->qtde == 0)//Verifica se a lista está vazia
        return 0;

    TLista *aux = (*l);//Cria variável auxiliar para percorre a lista
    int i = 1;//Inicia contador que vai indicar a posição do elemento relativa a lista

    while(aux != NULL && aux->elem.info != x)//Percorre a lista até achar o elemento ou até seu final
    {
        i++;//Incrementa a posição
        aux = aux->prox;//Atualiza variável que percorre a lista
    }

    if(aux == NULL)//Elemento não está na lista
    {
        *pos = -1;//Retorna -1 para indicar que a posição não existe
        return 0;
    }

    *pos = i;//Retorna posição relativa a lista
    return 1;
}

int  acessar(lista *l, int pos, char *x)
{
    if((*l)->qtde == 0 || (*l)->qtde < pos)//Verifica se a lista está vazia ou se a posição é invalida
        return 0;

    TLista *aux = (*l);//Cria variável para percorrer a lista
    int i = 1;//Variável auxiliar para o no

    while(i <= pos)//Percorre a lista até a posição recebida
    {
        aux = aux->prox;//Atualiza variáveis
        i++;
    }
    *x = aux->elem.info;//Devolve o elemento na posição pos relativa a lista
    return 1;
}

void destroi(lista *l)
{
    TLista *aux;//Variável para liberar os nos da lista
    while((*l) != NULL)//Laço que vai até o fim da lista
    {
        aux = (*l);//Variável auxiliar recebe o valor do primeiro valor da lista
        (*l) = (*l)->prox;//Primeiro elemento agora é o proximo do primeiro elemento
        free(aux);//Libera elemento auxiliar
    }
    free(l);//Libera  ultimo elemento  da lista
}
