#include<stdio.h>
#include<stdlib.h>

typedef struct no* Tarvore; //Definição de ponteiros para o struct no

typedef struct no {
    int info;
    Tarvore esq, dir;
    int h;
} Tno;

Tarvore* criar()//Retorna ponteiro para ponteiro, pois  facilita a alteração da raiz em rotações
{
    Tarvore* ab = (Tarvore*)malloc(sizeof(Tarvore));//Alocação na memoria para tipo ponteiro de Tarvore
    (*ab)->dir = NULL;
    (*ab)->esq = NULL;
    return ab;
}

//Funções para facilitar calcular nova altura

int altura(Tarvore no)//Função para verificar se o no existe e retornar a altura
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

//Melhor visualização em desenho

void RotacaoEE(Tarvore *p)//Rotação a esquerda, caso um elemento  inserido a esquerda faça Fb = 2
{
    struct no *no;
    no = (*p)->esq;//No auxiliar é o elemento a esqueda da raiz
    (*p)->esq = no->dir;//Elemento  a esqueda da raiz vira o elemento a direita do no
    no->dir = *p;//Elemento a direita do  no é a raiz
    (*p)->h = maior(altura((*p)->esq),altura((*p)->dir)+1);//Calcula altura da raiz
    no->h = maior(altura(no->esq),(*p)->h+1);//Calcula  altura do no
    *p = no;//No é a raiz
}

void RotacaoDD(Tarvore *p)//Rotação a direita
{
    struct no* no;//No auxilixar
    no = (*p)->dir;//No é o elemento a direita da raiz
    (*p)->dir = no->esq;//Elemento a direita da raiz é elemento a esqueda do no
    no->esq = (*p);//Raiz é o elemento a esquerda do  no
    (*p)->h =  maior(altura((*p)->esq), altura((*p)->dir)+1);//Calcula altura de no e raiz
    no->h = maior(altura(no->dir),(*p)->h+1);
    (*p) = no;//Nova raiz é  o  no
}

void RotacaoED(Tarvore *p)//Rotação direita esquerda
{
    RotacaoDD(&(*p)->esq);
    RotacaoEE(p);
}

void RotacaoDE(Tarvore *p)//Rotação esquerda direita
{
    RotacaoEE(&(*p)->dir);
    RotacaoDD(p);
}

int inserir(Tarvore *p,int dado)
{
    int invalor; //Variável para guarda o resultado da inserção
    if(*p == NULL)//Verifica se achou no folha ou se é raiz e insere
    {
        Tarvore novo =(struct no*)malloc(sizeof(struct no));
        novo->info = dado;
        novo->h = 0;
        novo->esq = NULL;
        novo->dir = NULL;
        *p = novo;
        return 1;
    }

    Tarvore pos =  *p;//Cria variável para percorrer a arvore

    if(dado < pos->info)//Verifica se a inserção deve ir a esquerda
    {
        if((invalor = inserir(&(pos->esq),dado)) == 1)//Verifica se a inserção foi bem sucedida
        {
            if(FB(pos) >= 2)//Verifica se a arvore foi desbalanceada
            {
                if(dado < (*p)->esq->info)//Se a arvore desbalanceou para a esquerda ele rotaciona para esquerda
                    RotacaoEE(p);
                else
                    RotacaoED(p);//Se não desbalanceamento foi esquerda direita
            }
        }
    }
    else
    {
        if(dado > pos->info)//Verifica se a inserção deve ir para a direita
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
            return 0;//Se não é a esquerda nem a direita é valor duplicado
    }
    pos->h = maior(altura(pos->esq),altura(pos->dir)+1);//Corrige altura do  no
    return invalor;//Retorna valor da inserção
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

