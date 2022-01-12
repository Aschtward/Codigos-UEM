#include<stdio.h>
#include<stdlib.h>

typedef struct elemento
{
    char dado;                               //Defini��o das estruturas de lista e dos elementos da lista
    struct elemento* prox;
    struct elemento* ant;

}elem;

typedef struct lista
{
    elem* prim;
    elem* ult;
    int qtde;

}lista;

typedef lista TLista;

TLista* cria_lista()
{
    TLista *l = (TLista*)malloc(sizeof(TLista));        //Aloca��o do espa�o para o ponteiro para ponteiro l
    l->prim = NULL;             //Definindo os ponteiros para elemento como nulos
    l->ult = NULL;
    l->qtde = 0;        //Iniciando quantidade igual a zero
    return l;
}

int tamanho(TLista* l)
{
    return l->qtde;
}

elem* busca_posicao(TLista* l, char x)//Devolve a posi��o anterior ao elemento
{
    elem* aux = l->prim;        //Vari�vel que percorre a lista inicializada como primeiro elemento

    while(aux->prox != NULL && aux->prox->dado < x)//Percorre a lista at� o ultimo elemento ou at� achar a posi��o
    {
        aux = aux->prox;
    }
    return aux;
}

int inserir(TLista* l, char x)
{
    elem* novo_elemento = (elem*)malloc(sizeof(elem));
    novo_elemento->dado = x;

    if(l->prim == NULL)//Lista vazia
    {
        novo_elemento->ant = NULL;      //Definindo os valores para anterior como nulo
        l->prim = novo_elemento;    //Primeiro elemento � o novo elemento
        l->ult = novo_elemento;     //Ultimo elemento � o novo elemento, visto que � o �nico da lista
        l->qtde++;
        return 1;
    }
    if(x < l->prim->dado)//Inser��o no inicio
    {
        novo_elemento->prox = l->prim;      //Passa o primeiro elemento para a segunda posi��o da lista
        novo_elemento->ant = NULL;
        novo_elemento->prox->ant = novo_elemento;       //Obs: quando usei l->prim->ant o compilador n�o conseguiu escrever na memoria, a unica solu��o que achei foi essa
        l->prim = novo_elemento;    //Atualiza valor do primeiro elemento
        l->qtde++;
        return 1;
    }
    else
        {
            if(l->ult->dado < x)//Inser��o no fim
            {
                novo_elemento->ant = l->ult;    //Atualiza dados do ultimo elemento para que ele va para tras na lista
                novo_elemento->prox = NULL;
                l->ult->prox = novo_elemento;
                l->ult = novo_elemento;
                l->qtde++;
                return 1;
            }
            else//Inser��o no meio da lista;
            {
                elem* aux = busca_posicao(l,x);//Devolve posi��o anterior

                novo_elemento->prox = aux->prox;    //Basicamente a inser��o em lista dinamica simplesmente ligada porem alterando os valores do ponteiro ant
                novo_elemento->ant = aux;
                aux->prox->ant = novo_elemento;
                aux->prox = novo_elemento;
                l->qtde++;
                return 1;
            }
        }
    return 0;
}

int remover(TLista* l, char x)
{
    if(l->qtde == 0)//Lista vazia
        return 0;

    elem* aux;

    if(x == l->prim->dado)//Remo��o no inicio
    {
        aux = l->prim;      //Atualiza o primeiro elemento removendo os ponteiros
        aux->prox->ant = NULL;      //Segundo elemento da lista se torna o primeiro elemento
        l->prim = aux->prox;
        free(aux);
        l->qtde--;
        return 1;
    }
    else
    {
        if(x == l->ult->dado)//Remo��o no final
        {
           aux = l->ult;        //Atualiza os ponteiros do ultimo elemento
           aux->ant->prox = NULL;       //Elemento anterior se torna novo ultimo
           l->ult = aux->ant;
           free(aux);
           l->qtde--;
           return 1;
        }
        else//Remo��o no meio
        {
            elem* pos;

            aux = busca_posicao(l,x);

            if(aux->prox == l->ult)//Elemento n�o existe na lista
                return 0;

            pos = aux->prox;        //Atualiza o  ponteiro antes do elemento posterior e o prox do anterior
            pos->prox->ant = aux;
            aux->prox = pos->prox;
            free(pos);
            l->qtde--;
            return 1;
        }

    }
}

int imprimir(TLista* l)//Igual a lista dinamica simplesmente ligada
{
    printf("\n\nQuantidade: %i",l->qtde);
    printf("\nElementos da Lista: ");

    elem* pos = l->prim;

    while(pos != NULL)
    {
        printf("%c -> ",pos->dado);
        pos = pos->prox;
    }
    printf("\n\n");

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

int devolver(TLista* l, char x, int *pos)
{
    elem* aux = l->ult;//Come�a no final da lista
    int i = l->qtde;

    while(aux != NULL && aux->dado != x)//Percorre at� achar o elemento
    {
        aux = aux->ant;
        i--;
    }
    if(aux == NULL)
    {
        *pos = 0;
        return 0;           //Devolve a posi��o
    }
    *pos = i;
    return 1;
}

int acessar(TLista* l , int i, char *x)
{
    if(l->qtde == 0 || l->qtde < i)//Posi��o invalida
    {
        *x = ' ';
        return 0;
    }
    int aux = 1;

    elem* pos = l->prim;//Inicia vari�vel para percorrer a lista
    while(aux < i)
    {
        pos = pos->prox;//Atualiza posi��o na lista
        aux++;
    }
    if(aux < i)//Elemento n�o existe
    {
        *x = ' ';
        return 0;
    }
    *x = pos->dado;//Retorna o dado
    return 1;
}
