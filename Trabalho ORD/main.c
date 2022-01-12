#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include"Funcoes.h"

int main(int argc, char *argv[]) {

    if (argc == 3 && strcmp(argv[1], "-c") == 0) {

        printf("Modo de criação ativado ... nome do arquivo = %s\n", argv[2]);
        //criar(argv[2]);

    } else if (argc == 3 && strcmp(argv[1], "-k") == 0) {

        printf("Modo de execucao de operacoes ativado ... nome do arquivo = %s\n", argv[2]);
        //imprie(argv[2]);

    } else if (argc == 2 && strcmp(argv[1], "-p") == 0) {

        printf("Modo de impressao da PED ativado ...\n");
        //imprime_ped();

    } else {

        fprintf(stderr, "Argumentos incorretos!\n");
        fprintf(stderr, "Modo de uso:\n");
        fprintf(stderr, "$ %s (-i|-e) nome_arquivo\n", argv[0]);
        fprintf(stderr, "$ %s -p\n", argv[0]);
        exit(EXIT_FAILURE);

    }

    return 0;
}
