#include <stdio.h>
#include <stdlib.h>

typedef struct No
{
    int elemento;
    struct No *esq, *dir;
} No;

No* novo_no ( int elemento )
{
    No* novo = (No*) malloc ( sizeof(No) );
    novo->elemento = elemento;
    novo->esq = NULL;
    novo->dir = NULL;

    return novo;
}

typedef struct ArvoreBinaria
{
    No* raiz;
} ArvoreBinaria;

ArvoreBinaria* novo_arvore_binaria ()
{
    ArvoreBinaria* novo_arvore = (ArvoreBinaria*) malloc ( sizeof(ArvoreBinaria) );
    novo_arvore->raiz = NULL;
    return novo_arvore;
}

No * inserir_rec ( No * no, int x )
{
    if ( no == NULL )
    {
        return novo_no(x);
    }
    
    else if ( x < no->elemento)
    {
        no->esq = inserir_rec(no->esq, x);
    }

    else if ( x > no->elemento )
    {
        no->dir = inserir_rec(no->dir, x );
    }

    return no;
}

void inserir ( ArvoreBinaria* ab, int x )
{
    ab->raiz = inserir_rec(ab->raiz, x);
}

void caminhar_em_rec ( No* no )
{
    if ( no == NULL )
	{
        return;
	}

    printf("%d ", no->elemento);

    caminhar_em_rec(no->esq);

    if (no->esq != NULL)
    {
        printf("%d ", no->elemento);
    }
    
    caminhar_em_rec(no->dir);
}

void caminhar_em ( ArvoreBinaria* ab )
{
    caminhar_em_rec(ab->raiz);
}

int main ( )
{
    ArvoreBinaria* ab = novo_arvore_binaria();

    int x = 0;

    while (scanf("%d", &x) == 1 && x != -1)
    {
        inserir(ab, x);
    }
    
    printf("\nCaminhos: ");
    caminhar_em(ab);
    printf("\n");

}