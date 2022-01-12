#include<stdio.h>
#include<stdlib.h>

typedef struct no* Tarvore; //Defini��o de ponteiros para o struct no

typedef struct no {
    int info;
    Tarvore esq, dir;
    int h;
} Tno;

Tarvore* criar()//Retorna ponteiro para ponteiro, pois  facilita a altera��o da raiz em rota��es
{
    Tarvore* ab = (Tarvore*)malloc(sizeof(Tarvore));//Aloca��o na memoria para tipo ponteiro de Tarvore
    (*ab)->dir = NULL;
    (*ab)->esq = NULL;
    return ab;
}

//Fun��es para facilitar calcular nova altura

int altura(Tarvore no)//Fun��o para verificar se o no existe e retornar a altura
{
    if(no == NULL)
        return -1;
    else
        return  no->h;
}

int FB(Tarvore no)//Calcular em modo a altura da sub-arvore
{
    return labs(altura(no->esq)-altura(no->dir));
}

int maior(int x, int y)
{
    if(x < y)
        return x;
    else
        return y;
}

//Melhor visualiza��o em desenho

void RotacaoEE(Tarvore *p)//Rota��o a esquerda, caso um elemento  inserido a esquerda fa�a Fb = 2
{
    struct no *no;
    no = (*p)->esq;//No auxiliar � o elemento a esqueda da raiz
    (*p)->esq = no->dir;//Elemento  a esqueda da raiz vira o elemento a direita do no
    no->dir = *p;//Elemento a direita do  no � a raiz
    (*p)->h = maior(altura((*p)->esq),altura((*p)->dir)+1);//Calcula altura da raiz
    no->h = maior(altura(no->esq),(*p)->h+1);//Calcula  altura do no
    *p = no;//No � a raiz
}

void RotacaoDD(Tarvore *p)//Rota��o a direita
{
    struct no* no;//No auxilixar
    no = (*p)->dir;//No � o elemento a direita da raiz
    (*p)->dir = no->esq;//Elemento a direita da raiz � elemento a esqueda do no
    no->esq = (*p);//Raiz � o elemento a esquerda do  no
    (*p)->h =  maior(altura((*p)->esq), altura((*p)->dir)+1);//Calcula altura de no e raiz
    no->h = maior(altura(no->dir),(*p)->h+1);
    (*p) = no;//Nova raiz �  o  no
}

void RotacaoED(Tarvore *p)//Rota��o direita esquerda
{
    RotacaoDD(&(*p)->esq);
    RotacaoEE(p);
}

void RotacaoDE(Tarvore *p)//Rota��o esquerda direita
{
    RotacaoEE(&(*p)->dir);
    RotacaoDD(p);
}

int inserir(Tarvore *p,int dado)
{
    int invalor; //Vari�vel para guarda o resultado da inser��o
    if(*p == NULL)//Verifica se achou no folha ou se � raiz e insere
    {
        Tarvore novo =(struct no*)malloc(sizeof(struct no));
        novo->info = dado;
        novo->h = 0;
        novo->esq = NULL;
        novo->dir = NULL;
        *p = novo;
        return 1;
    }

    Tarvore pos =  *p;//Cria vari�vel para percorrer a arvore

    if(dado < pos->info)//Verifica se a inser��o deve ir a esquerda
    {
        if((invalor = inserir(&(pos->esq),dado)) == 1)//Verifica se a inser��o foi bem sucedida
        {
            if(FB(pos) >= 2)//Verifica se a arvore foi desbalanceada
            {
                if(dado < (*p)->esq->info)//Se a arvore desbalanceou para a esquerda ele rotaciona para esquerda
                    RotacaoEE(p);
                else
                    RotacaoED(p);//Se n�o desbalanceamento foi esquerda direita
            }
        }
    }
    else
    {
        if(dado > pos->info)//Verifica se a inser��o deve ir para a direita
        {
            if((invalor = inserir((&pos)->dir,dado)) == 1)//Verifica se foi bem sucedida indo para a direita
            {
                if(FB(pos) >= 2)//Verifica caso seja desbalanceada a direita
                {
                    if((*p)->dir->info < dado)//Verifica tipo de balanceamento
                        RotacaoDD(p);
                    else
                        RotacaoDE(p);
                }
            }
        }
        else
            return 0;//Se n�o � a esquerda nem a direita � valor duplicado
    }
    pos->h = maior(altura(pos->esq),altura(pos->dir)+1);//Corrige altura do  no
    return invalor;//Retorna valor da inser��o
}

int vazia(Tarvore *p)//Fun��o verificar se a arvore esta vazia
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

int procura(int x, Tarvore p)//Fun��o para voltar a existencia do no na arvore?
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

