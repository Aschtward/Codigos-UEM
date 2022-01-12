#include<stdio.h>
#include<stdlib.h>

typedef struct no* Tarvore;

typedef struct no {
    int info;
    Tarvore esq, dir;
    int h;
} Tno;

Tarvore* criar()//Retorna ponteiro para ponteiro
{
    Tarvore* ab = (Tarvore*)malloc(sizeof(Tarvore));//Alocação na memoria para tipo ponteiro de Tarvore
    (*ab)->dir = NULL;
    (*ab)->esq = NULL;
    return ab;
}

int inserir(int x, Tarvore *p)
{
    if((*p) != NULL)
    {
        if(x < (*p)->info)
            inserir(x,&((*p)->esq));
        else
            inserir(x,&((*p)->dir));
    }
    else
    {
        (*p) = (Tno*)malloc(sizeof(Tno));
        (*p)->info = x;
        (*p)->esq = NULL;
        (*p)->dir = NULL;
        (*p)->h = 0;
        return 1;
    }
}

int vazia(Tarvore *p)//Função verificar se a arvore esta vazia
{
    if((*p) == NULL)
        return 1;
    else
        return 0;
}

int faz_vazia(Tarvore p)//Elimina todos os nos a partir de um certo no, pode ser usado para destruir a arvore ou para remover um ramo
{
    if(p == NULL)
    {
        return 1;
    }
    faz_vazia(p->esq);
    faz_vazia(p->dir);
    free(p);
    p = NULL;
}

void destroi_arvore(Tarvore* p)
{
    if(p = NULL)
        return;
    faz_vazia(*p);
    free(p);
}

void mostrar(Tarvore p)
{
    if(p != NULL){
        mostrar(p->esq);
        printf("No:%i  Dir:%i  Esq:%i",p->info,p->dir,p->esq);
        printf("\n\n");
        mostrar(p->dir);
    }
}

int procura(int x, Tarvore p)//Função para voltar a existencia do no na arvore?
{
    if(p == NULL)
        return 0;
    else{
        if(p->info == x)
            return 1;
        else
        {
            if(x < p->info)
            {
                procura(x,(p->esq));
            }
            else
                procura(x,(p->dir));
        }
    }
}

Tno* remove_no(Tno* aux)
{
    Tno *no1;
    Tno *no2;

    if(aux->esq == NULL)//Verifica se o no a ser removido não tem filhos a esquerda
    {
        no2 = aux->dir;//Caso não tenha filho a esquerda ou seja nó folha é substituido pelo filho da direita
        free(aux);//Libera o no que é removido
        return no2;//Retorna o no para substituir o antigo no ou Null caso seja no folha
    }

    no1 = aux;
    no2 = aux->esq;

    while(no2->dir != NULL)//Procura o no folha a direita na subarvore esquerda
    {
        no1 = no2;
        no2 = no2->dir;
    }

    if(no1 != aux)//Troca os valores para depois liberar o no folha que foi usado para remover o elemento
    {
        no1->dir = no2->esq;
        no2->esq = aux->esq;
    }
    no2->dir = aux->dir;//Troca os ponteiros de no que vai substituir pelo que vai ser removido
    free(aux);//Remove no aux
    return no2;//Volta no2 para ocupar espaço de aux
}

int remover(int x, Tarvore *p)
{
    if(p == NULL)
        return 0;

    Tno* ant = NULL;
    Tno* aux = *p;

    while(aux != NULL)
    {
        if(x == aux->info)//Verifica se achou o no e trata da remoção em qualquer um dos casos (0 a 2 filhos)
            {
                if(aux == *p)
                    *p = remove_no(aux);
                else
                {
                    if(ant->dir == aux)
                        ant->dir = remove_no(aux);
                    else
                        ant->esq = remove_no(aux);
                }
                return 1;
            }
        ant = aux;
        if(aux->info < x)
            aux = aux->dir;
        else
            aux = aux->esq;
    }
}

