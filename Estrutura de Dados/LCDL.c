#include<stdio.h>
#include<stdlib.h>

typedef struct sno
{
    char info;
    struct sno* ant;
    struct sno* prox;

}elem;

typedef elem* ponteiro;

typedef struct lista
{
    ponteiro prim;
    int qtde;

}Lista;

typedef Lista TLista;

TLista* cria_lista()
{
    TLista* l = (TLista*)malloc(sizeof(TLista));
    l->prim = NULL;
    l->qtde = 0;
    return l;
}

int tamanho(TLista* l)
{
    return l->qtde;
}

ponteiro busca_posicao(TLista* l, char x)//posição anterior que o elemento deve ser inserido
{
    ponteiro aux = l->prim;
    do{
        aux = aux->prox;
    }while(aux->prox->info < x && aux != l->prim);

    if(aux == l->prim)//Caso seja o último elemento a ser inserido
        return aux->ant;

    return aux;
}

int inserir(TLista* l, char x)
{
    ponteiro novo_elemento = (elem*)malloc(sizeof(elem));
    novo_elemento->info = x;

    if(l->prim == NULL)//Caso lista vazia para atualizar o campo prim
    {
        novo_elemento->prox = novo_elemento;
        novo_elemento->ant = novo_elemento;
        l->prim = novo_elemento;
        l->qtde++;
        return 1;
    }

    if(x < l->prim->info)//Metodo para atualizar primeira posição da lista
    {
        novo_elemento->ant = l->prim->ant; //Anterior no novo elemento aponta para último elemento
        novo_elemento->prox = l->prim; //Próximo do novo elemento aponta para primeiro elemento
        l->prim->ant->prox = novo_elemento;//Ponteiro prox do último elemento agora é novo elemento
        l->prim->ant = novo_elemento; //Anterior do primeiro elemento aponta para novo elemento
        l->prim = novo_elemento;//Primeiro elemento agora é o novo elemento
        l->qtde++;
        return 1;
    }
    else//Inserção no meio/fim da lista
    {
        ponteiro aux = busca_posicao(l,x);//Busca a posição de inserção visto que a lista não está vazia e não se trata do primeiro elemento
        novo_elemento->prox = aux->prox;//Ponteiro prox do novo elemento aponta para proximo elemento a aux
        novo_elemento->ant = aux;//Ponteiro ant do novo elemento aponta para posição anterior a de inserção
        aux->prox->ant = novo_elemento;//Ponteiro ant do proximo elemento ao inserido aponta para novo elemento
        aux->prox = novo_elemento;//Ponteiro prox da posição anterior aponta para novo elemento
        l->qtde++;
        return 1;
    }
    return 0;
}

int remover(TLista* l, char x)
{
    if(l->prim == NULL)//Lista vazia
        return 0;

    ponteiro aux;

    if(l->prim->info == x)//Remoção do primeiro elemento, posição não tratada na busca de posição
    {
        if(l->qtde == 1)
        {
            aux = l->prim;
            l->prim = NULL;
            free(aux);
            l->qtde--;
            return 1;
        }
        else
        {
            l->prim->ant->prox = l->prim->prox;//Último elemento da lista agora aponta para segundo elemento da lista
            l->prim->prox->ant = l->prim->ant;//Segundo elemento da lista aponta para último elemento da lista
            aux = l->prim;//Variável auxiliar para remover o primeiro elemento
            l->prim = l->prim->prox;//Atualiza ponteiro para primeiro elemento
            free(aux);//Libera o auxiliar
            l->qtde--;
            return 1;
        }
    }
    else
    {
        aux = busca_posicao(l,x);

        if(aux->prox->info != x)//Elemento não presente na lista
            return 0;

        ponteiro pos;

        pos = aux->prox;
        aux->prox = pos->prox;//Ponteiro prox da posição anteior aponta para o proximo do elemento removido
        pos->prox->ant = aux;//Ponteiro anterior do proximo elemento aponta para posição anterior ao removido
        free(pos);
        l->qtde--;
        return 1;
    }
    return 0;
}

int imprimir(TLista* l)
{
    printf("\n\nQuantidade: %i",l->qtde);
    printf("\nElementos da Lista: ");
    int c = 0;

    elem* pos = l->prim;

    if(l->qtde == 0)
        return 0;
    do
    {
        printf("%c -> ",pos->info);
        pos = pos->prox;

    }while(pos != l->prim);
    printf("Ultimo : %c e Primeiro: %c",l->prim->ant->info,l->prim->ant->prox->info);

    printf("\n\n");

}

int acessar(TLista* l , int i, char *x)
{
    if(l->qtde == 0 || l->qtde < i)//Posição invalida
    {
        *x = ' ';
        return 0;
    }
    int aux = 1;

    ponteiro pos = l->prim;//Inicia variável para percorrer a lista
    while(aux < i)
    {
        pos = pos->prox;//Atualiza posição na lista
        aux++;
    }
    if(aux < i)//Elemento não existe
    {
        *x = ' ';
        return 0;
    }
    *x = pos->info;//Retorna o dado
    return 1;
}

int devolver(TLista* l, char x, int *pos)
{
    ponteiro aux = l->prim;//Começa no final da lista
    int i = 1;

    if(l->prim->info == x)
    {
        *pos = 1;
        return 1;
    }

    do{
        aux = aux->prox;
        i++;
    }while(aux != l->prim &&aux->info != x);//Do while pq apenas o while iria marcar uma posição antes

    if(aux == l->prim)
    {
        *pos = 0;
        return 0;
    }

    *pos = i;
    return 1;
}

void destroi(TLista* l)
{
    elem* aux = l->prim;
    elem* liberado;

    while(aux != NULL)
    {
        liberado = aux;
        aux = aux->prox;
        free(liberado);
    }
    free(l);
}
