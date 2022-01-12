#include<stdio.h>
#include<string.h>

int verifica_ped()
{
    FILE* arquivo = fopen("dados.dat","rb");

    int topo;

    fread(&topo,sizeof(int),1,arquivo);
    fclose(arquivo);
    return topo;
}

int busca(char *id_busca,int operacao)
{
    FILE *arquivo = fopen("dados.dat","rb");

    if(arquivo == NULL)
    {
        printf("Error ao abrir o arquivo");
        return 0;
    }

    int byte = sizeof(int);
    char id[64];
    int pos = 0;
    int achou = 0;

    while(fgetc(arquivo) != EOF && !achou){

        fseek(arquivo,byte,SEEK_SET);
        fread(&id,strlen(id_busca),1,arquivo);

        if(strcmp(id,id_busca) == 0)
            achou = 1;
        else
        {
            byte = byte+64;
            pos++;
        }
    }
    if(achou){
        if(operacao == 0)
        {
            fseek(arquivo,byte,SEEK_SET);
            memset(&id,0,sizeof(id));
            fread(&id,64,1,arquivo);
            printf("\nBusca pelo registro de chave %s\n",id_busca);
            printf("\n%s (RRN = %i  - byte-offset %i)\n",id,pos,byte);
        }
        fclose(arquivo);
        return pos;
    }
    else{
        if(operacao == 0)
        {
            printf("\nBusca pelo registro de chave %s\n",id_busca);
            printf("\nErro: registro nao encontrado!\n");
        }
        fclose(arquivo);
        return -1;
    }
}

void imprime_ped()
{

    FILE* arquivo = fopen("dados.dat","rb");

    if(arquivo == NULL)
    {
        printf("Error ao abrir o arquivo");
        return;
    }

    int pos;
    int rrn_total = 0;
    fread(&pos,sizeof(int),1,arquivo);

    while(pos != -1){
        fseek(arquivo,(pos*64)+sizeof(int)+1,SEEK_SET);
        printf("\n%i\n", pos);
        fread(&pos,sizeof(int),1,arquivo);
        rrn_total++;
    }
    printf("\nTotal de espacos disponiveis %i\n",rrn_total);
    fclose(arquivo);
}

void le_chave(char *registro,char *id)
{
    int aux = 0;
    while(registro[aux] != '|')
    {
        id[aux] = registro[aux];
        aux++;
    }
    id[aux] = '\0';
}

int insere(char *dados_passados)
{
    char dados[64];
    int byte;
    char id[64];

    dados_passados[strlen(dados_passados)-1] = '\0';
    memset(&dados,0,sizeof(dados));
    strcpy(dados,dados_passados);
    le_chave(dados_passados,id);

    if(verifica_ped() == -1)
        {
            FILE *arquivo = fopen("dados.dat","ab");

            if(arquivo == NULL)
            {
                printf("Erro ao abrir o arquivo");
                return 0;
            }
            fwrite(&dados,64,1,arquivo);
            printf("\nInsercao do registro de chave %s\n\nLocal:fim do arquivo\n",id);
            fclose(arquivo);
            return 1;
        }
    else
        {
            FILE *arquivo = fopen("dados.dat","r+b");

            if(arquivo == NULL)
            {
                printf("Erro ao abrir o arquivo");
                return 0;
            }
            int topo = verifica_ped();
            int pos_livre;

            fseek(arquivo,(topo*64)+sizeof(int)+1,SEEK_SET);
            fread(&pos_livre,sizeof(int),1,arquivo);

            fseek(arquivo,(topo*64)+sizeof(int),SEEK_SET);
            fwrite(&dados,64,1,arquivo);

            rewind(arquivo);
            fwrite(&pos_livre,sizeof(int),1,arquivo);
            byte = (topo*64)+sizeof(int);
            printf("\nInsercao do registro de chave %s\n\nLocal: RRN: %i (byte-offset %i) [reutilizado]\n",id,topo,byte);
            fclose(arquivo);
            return 2;
        }
}

int remove1(char *dado_remocao)
{
    int pos = busca(dado_remocao,1);
    int byte;
    if(pos == -1)
    {
        printf("\nRemocao do registro de chave : %s",dado_remocao);
        printf("\nErro: registro nao encontrado!\n");
        return 0;
    }
    int topo;

    FILE* fp = fopen("dados.dat","r+b");

    if(fp == NULL)
    {
        printf("Erro ao abrir o arquivo");
        return 0;
    }

    fread(&topo,sizeof(int),1,fp);
    byte = (pos*64)+sizeof(int);
    fseek(fp,byte,SEEK_SET);
    fwrite("*",1,1,fp);
    fwrite(&topo,sizeof(int),1,fp);
    rewind(fp);
    fwrite(&pos,sizeof(int),1,fp);
    printf("\nRemocao do registro de chave %s\nRegistro Removido!\n\nPosicao: RRN %i (byte-offset %i)\n",dado_remocao,pos,byte);
    fclose(fp);
    return 1;
}

int importacao(char* arquivo_importacao)
{
    int fim_dado,aux;
    char dado[64];
    char c;

    FILE *arquivo_importado = fopen(arquivo_importacao,"r");
    FILE *arquivo_principal = fopen("dados.dat","w+b");

    if(arquivo_principal == NULL || arquivo_importado == NULL)
    {
        printf("Erro ao abrir o arquivo");
        return 0;
    }

    int topo_pilha = -1;

    fwrite(&topo_pilha,sizeof(int),1,arquivo_principal);

    while((c = fgetc(arquivo_importado)) != EOF)
    {
        aux = 1;
        fim_dado = 0;
        memset(&dado,0,sizeof(dado));

        dado[0] = c;

        while(fim_dado  < 4)
            {
                dado[aux] = fgetc(arquivo_importado);
                if(dado[aux] == '|')
                    fim_dado++;
                aux++;
            }
            dado[aux] = '\0';
            fwrite(&dado,64,1,arquivo_principal);
    }

    fclose(arquivo_importado);
    fclose(arquivo_principal);
    return 1;
}

int executa_operacoes(char *nome_arquivo)
{
    FILE* arquivo = fopen(nome_arquivo,"r");

    if(arquivo == NULL)
    {
        printf("Erro ao abrir o arquivo");
        return 0;
    }

    char operacao;
    char chave[64];

    while((operacao = fgetc(arquivo)) != EOF)
    {
        if(operacao == 'b')
        {
            fscanf(arquivo,"%s",chave);
            busca(chave,0);
        }
        else{
            if(operacao == 'i')
            {
                fgetc(arquivo);
                fgets(chave,64,arquivo);
                insere(chave);
            }
            else{
                if(operacao == 'r')
                {
                    fscanf(arquivo,"%s",chave);
                    remove1(chave);
                }
                }
            }
    }
    fclose(arquivo);
    return 1;
}
