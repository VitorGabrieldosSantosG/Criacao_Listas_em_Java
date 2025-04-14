public class ListaDinamica implements IListaDinamica {

    private No primeiroElemento;
    private No ultimoElemento;

    public ListaDinamica(Object conteudo) {

        this.primeiroElemento = null;
        this.ultimoElemento = null;

    }

    public No criaElemento(Object conteudo) {
        return new No(conteudo);
    }

    @Override
    public void inserirElemento(Object elemento) {
        No novo = criaElemento(elemento);

        if (estaVazia()) {
            primeiroElemento = novo;
            ultimoElemento = novo;
        } else {
            ultimoElemento.setProx(novo);
            novo.setAnterior(ultimoElemento);
            ultimoElemento = novo;
        }
    }


    @Override
    public void inserirSequencia(Object elementos) {

        Object[] valores = (Object[]) elementos;

        for (int i = 0; i < valores.length; i++) {
            inserirElemento(valores[i]);
        }


    }

    @Override
    public boolean removerElemento(Object elemento) {
        if (estaVazia()) {
            System.out.println("Não há elementos na lista.");
        } else if (buscarElemento(elemento)) {
            if (this.primeiroElemento.getConteudo().equals(elemento)) {
                this.primeiroElemento = this.primeiroElemento.getProx();
            } else {
                No aux = this.primeiroElemento;

                while(aux != null){
                    if(aux.getProx().getConteudo() != elemento) {
                        aux.setProx(aux.getProx().getProx());
                    }
                        aux = aux.getProx();
                }
            }
        } else {
            System.out.println("O elemento buscado para apagar, não existe.");
        }
        return false;
    }


    @Override
    public void removerSequencia(Object elementos) {
        Object[] valores = (Object[]) elementos;

        for (int i = 0; i < valores.length; i++) {
            removerElemento(valores[i]);
        }
    }

    @Override
    public void removerTodasOcorrencias(Object elemento) {

        if (estaVazia()) {
            System.out.println("A lista está vazia!!");
        } else {
            while(buscarElemento(elemento)){
                removerElemento(elemento);
            }
        }


    }

    @Override
    public boolean estaVazia() {
        if (this.primeiroElemento == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean buscarElemento(Object elemento) {

        No aux = primeiroElemento;
        while (aux != null) {
            if (aux.getConteudo().equals(elemento)) {
                return true;

            }
            aux = aux.getProx();
        }
        return false;
    }

    @Override
    public void ordenarCrescente() {
        for (int i = 0; i < quantidadeElementos(); i++) {
            No aux = primeiroElemento;

            while (aux != null && aux.getProx() != null) {
                Object conteudoAtual = aux.getConteudo();
                Object conteudoProximo = aux.getProx().getConteudo();

                if (conteudoAtual instanceof Comparable && conteudoProximo instanceof Comparable) {
                    Comparable compAtual = (Comparable) conteudoAtual;
                    Comparable compProx = (Comparable) conteudoProximo;

                    if (compAtual.compareTo(compProx) > 0) {
                        aux.setConteudo(conteudoProximo);
                        aux.getProx().setConteudo(conteudoAtual);
                    }
                }

                aux = aux.getProx();
            }
        }
    }


    @Override
    public void ordenarDecrescente() {
        for (int i = 0; i < quantidadeElementos(); i++) {
            No aux = primeiroElemento;

            while (aux != null && aux.getProx() != null) {
                Object conteudoAtual = aux.getConteudo();
                Object conteudoProximo = aux.getProx().getConteudo();

                if (conteudoAtual instanceof Comparable && conteudoProximo instanceof Comparable) {
                    Comparable compAtual = (Comparable) conteudoAtual;
                    Comparable compProx = (Comparable) conteudoProximo;

                    if (compAtual.compareTo(compProx) < 0) {
                        aux.setConteudo(conteudoProximo);
                        aux.getProx().setConteudo(conteudoAtual);
                    }
                }

                aux = aux.getProx();
            }
        }
    }

    @Override
    public int quantidadeElementos() {

        int contador = 0;
        No aux = primeiroElemento;

        while (aux != null) {
            aux = aux.getProx();
            contador++;
        }

        return contador;
    }

    @Override
    public void editarElemento(Object elementoAntigo, Object elementoNovo) {

        No aux = primeiroElemento;

        while (aux != null) {
            if (aux.getConteudo() == elementoAntigo) {
                aux.setConteudo(elementoNovo);
                break;
            }
            aux = aux.getProx();

        }

    }

    @Override
    public void limpar() {
        this.primeiroElemento.setProx(null);
        this.primeiroElemento = null;
        System.out.println("A lista foi limpa");
    }

    @Override
    public void exibir() {
        if (estaVazia()) {
            System.out.println("A lista está vazia");
        } else {

            No aux = primeiroElemento;

            while (aux != null) {
                System.out.println(aux.getConteudo());
                aux = aux.getProx();
            }
        }
    }

    @Override
    public No obterPrimeiroElemento() {
        return this.primeiroElemento;
    }

    @Override
    public No obterUltimoElemento() {
        return this.ultimoElemento;
    }
}
