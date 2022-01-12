


int insere(char *dados_passados);
//Insere um registro no arquivo, caso tenha algum  espa�o disponivel retorna 2, caso insira no final retorna 1;

int remove1(char *dado_remocao);
//Remove um registro atr�ves da busca pela sua chave, retorna 0 caso o registro n�o esteja no arquivo e 1 caso remova com sucesso;

int verifica_ped();
//Retorna o valor que est� no topo da pilha;

int importacao(char* arquivo_importacao);
//Importa os dados do arquivo_importacao para o arquivo_destinat�rio, fazendo adapta��o de tamanho, caso haja erro em abrir o arquivo retorna 0;

int busca(char *id_busca);
//Busca por um registro, caso ele n�o esteja no arquivo retorna menos 1, se estiver retorna o rrn do registro;

void imprime_ped();
//Imprime a ped no arquivo e o n�mero de rrns dispon�veis;

int executa_operacoes(char *nome_arquivo);
//Executa operacoes do arquivo

void le_chave(char *registro, char *id);
//Le apenas a chave de busca de um registro e armazena em uma string id
