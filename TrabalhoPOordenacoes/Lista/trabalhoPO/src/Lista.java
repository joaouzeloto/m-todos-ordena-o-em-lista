public class Lista {

    private No inicio, fim;

    public Lista(No inicio, No fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public No getInicio() {
        return inicio;
    }

    public void setInicio(No inicio) {
        this.inicio = inicio;
    }

    public No getFim() {
        return fim;
    }

    public void setFim(No fim) {
        this.fim = fim;
    }

    public Lista() {
        this.inicio = null;
        this.fim = null;
    }

    public void insere(int value) {
        No novo = new No(value, null, null);
        if (inicio == null) {
            inicio = fim = novo;
        } else {
            novo.setAnt(fim);
            fim.setProx(novo);
            fim = novo;
        }
    }

    public No getNo(int n) {
        int i = 0;
        No aux = inicio;
        while (i != n && aux != null) {
            i++;
            aux = aux.getProx();
        }
        return aux;
    }

    public void exibir() {
        No aux = inicio;
        while (aux != null) {
            System.out.print(aux.getValor() + " ");
            aux = aux.getProx();
        }
        System.out.println();
    }

    public int getTam() {
        int i = 0;
        No aux = inicio;
        while (aux != null) {
            i++;
            aux = aux.getProx();
        }
        return i;
    }

    private Lista criaList() {
        Lista novo = new Lista();
        for (int i = 0; i < getTam(); i++)
            novo.insere(0);
        return novo;
    }

    //ORDENAÇÕES ESTUDAS EM SALA

    public void insertionSort()
    {
        No aux = inicio,comp;
        int valor;
        aux = aux.getProx();
        while (aux != null){
            comp = aux;
            valor = aux.getValor();
            while(comp != inicio && comp.getAnt().getValor() > valor){
                comp.setValor(comp.getAnt().getValor());
                comp = comp.getAnt();
            }
            comp.setValor(valor);
            aux = aux.getProx();
        }

    }

    public void selectionSort()
    {
        No posMenor, i, j;
        int aux;
        for(i=inicio;i!=null;i = i.getProx())
        {
            posMenor = i;
            for(j= i.getProx();j!=null;j = j.getProx())
                if(posMenor.getValor()>j.getValor())
                    posMenor = j;
            aux = i.getValor();
            i.setValor(posMenor.getValor());
            posMenor.setValor(aux);
        }
    }

    public No buscaBinaria(int valor, int tl)
    {
        int ini=0, fim = tl-1, meio = fim/2;
        No aux = getNo(meio);
        while (ini<fim&&aux.getValor()!=valor)
        {
            if(aux.getValor()<valor)
                ini = meio + 1;
            else
                fim = meio-1;
            meio = (ini+fim)/2;
            aux = getNo(meio);
        }
        if(aux.getValor()<valor)
            return aux.getProx();
        return aux;
    }


    public void selectionBinSort()
    {
        int tl = 1, valor;
        No aux,pos,comp;
        for (aux = inicio.getProx();aux!=null;aux = aux.getProx())
        {
            valor = aux.getValor();
            pos = buscaBinaria(valor,tl);
            tl++;
            comp = aux;
            while(comp!=pos&&comp.getAnt()!=null)
            {
                comp.setValor(comp.getAnt().getValor());
                comp = comp.getAnt();
            }
            pos.setValor(valor);

        }
    }


    public void heapSort() {
        int tl = getTam(), pai, fe, fd, maiorf, aux, fim = getTam();
        while (tl > 1)
        {
            pai = tl / 2 - 1;
            while (pai >= 0)
            {
                fe = 2 * pai + 1;
                fd = fe + 1;
                if (fd < tl) {
                    if (getNo(fe).getValor() > getNo(fd).getValor())
                        maiorf = fe;
                    else
                        maiorf = fd;
                } else
                    maiorf = fe;
                if (getNo(pai).getValor() < getNo(maiorf).getValor()) {
                    aux = getNo(pai).getValor();
                    getNo(pai).setValor(getNo(maiorf).getValor());
                    getNo(maiorf).setValor(aux);
                }
                pai--;
            }
            tl--;
            aux = getNo(fim - 1).getValor();
            getNo(fim - 1).setValor(inicio.getValor());
            getInicio().setValor(aux);
            fim--;
        }
    }

    public void shakeSort()
    {
        No aux;
        int ini=0, fim = getTam();
        int valor;
        while (ini<fim)
        {
            aux = getNo(ini);
            while (aux!=getNo(fim))
            {
                if(aux.getProx()!=null&&aux.getValor()>aux.getProx().getValor())
                {
                    valor = aux.getValor();
                    aux.setValor(aux.getProx().getValor());
                    aux.getProx().setValor(valor);
                }
                aux = aux.getProx();
            }
            fim--;
            aux = getNo(fim);
            while (aux.getAnt()!=null&&aux!=getNo(ini))
            {
                if(aux.getValor()<aux.getAnt().getValor())
                {
                    valor = aux.getValor();
                    aux.setValor(aux.getAnt().getValor());
                    aux.getAnt().setValor(valor);
                }
                aux = aux.getAnt();
            }
            ini++;
        }
    }

    public void bubbleSort() {
        No TL = fim, aux;
        int box;
        while (TL != inicio) {
            aux = inicio;
            while (aux != TL) {
                if (aux.getValor() > aux.getProx().getValor()) {
                    box = aux.getValor();
                    aux.setValor(aux.getProx().getValor());
                    aux.getProx().setValor(box);
                }
                aux = aux.getProx();
            }
            TL = TL.getAnt();
        }
    }

    public void shellSort() {
        int i, j, dist = 1, valor, TL = getTam();
        while (dist < TL)
            dist = dist * 3 + 1;
        dist = dist / 3;

        while (dist > 0) {
            for (i = dist; i < TL; i++) {
                valor = getNo(i).getValor();
                j = i;
                while (j - dist >= 0 && valor < getNo(j - dist).getValor()) {
                    getNo(j).setValor(getNo(j - dist).getValor());
                    j = j - dist;
                }
                getNo(j).setValor(valor);
            }
            dist = dist / 3;
        }

    }

    public void quickSortNoPivo() {
        quickSP(0, getTam() - 1);
    }

    private void quickSP(int ini, int fim) {
        int i = ini, j = fim, aux;
        while (i < j) {
            while (i < j && getNo(i).getValor() <= getNo(j).getValor())
                i++;
            aux = getNo(i).getValor();
            getNo(i).setValor(getNo(j).getValor());
            getNo(j).setValor(aux);
            while (i < j && getNo(j).getValor() >= getNo(i).getValor())
                j--;
            aux = getNo(i).getValor();
            getNo(i).setValor(getNo(j).getValor());
            getNo(j).setValor(aux);
        }
        if (ini < i - 1)
            quickSP(ini, i - 1);
        if (j + 1 < fim)
            quickSP(j + 1, fim);
    }

    private void quickP(int ini, int fim)
    {
        int i = ini, j = fim, pivo = (ini+fim)/2;
        int aux;
        while (i<j)
        {
            while (getNo(i).getValor()<getNo(pivo).getValor())
                i++;
            while (getNo(j).getValor()>getNo(pivo).getValor())
                j--;
            if(i<=j)
            {
                aux = getNo(i).getValor();
                getNo(i).setValor(getNo(j).getValor());
                getNo(j).setValor(aux);
                i++;
                j--;
            }
            if(ini<j)
                quickP(ini,j);
            if(i<fim)
                quickP(i,fim);
        }

    }

    public void quickSortPivo()
    {
        quickP(0,getTam()-1);
    }

    public void mergeSort1() {
        Lista aux = criaList();
        mergeS(aux, 0, getTam() - 1);
    }

    private void mergeS(Lista aux, int esq, int dir) {
        int meio;
        if (esq < dir) {
            meio = (esq + dir) / 2;
            mergeS(aux, esq, meio);
            mergeS(aux, meio + 1, dir);
            fusao(aux, esq, meio, meio + 1, dir);
        }
    }

    private void fusao(Lista aux, int ini1, int fim1, int ini2, int fim2) {
        int a = 0, i = ini1, j = ini2;
        while (i <= fim1 && j <= fim2) {
            if (getNo(i).getValor() < getNo(j).getValor())
                aux.getNo(a++).setValor(getNo(i++).getValor());
            else
                aux.getNo(a++).setValor(getNo(j++).getValor());
        }
        while (i <= fim1)
            aux.getNo(a++).setValor(getNo(i++).getValor());
        while (j <= fim2)
            aux.getNo(a++).setValor(getNo(j++).getValor());
        for (int k = 0; k < a; k++)
            getNo(k + ini1).setValor(aux.getNo(k).getValor());
    }


    public void mergeSort2()
    {
        Lista aux1 = new Lista(), aux2 = new Lista();
        int seq = 1;
        aux1 = criaList();
        aux2 = criaList();
        particao(aux1,aux2);
        while (seq<getTam())
        {
            particao(aux1,aux2);
            fusao2(aux1,aux2,seq);
            seq = seq * 2;
        }
    }

    private void particao(Lista aux1, Lista aux2)
    {
        for (int i=0;i<getTam()/2;i++)
        {
            aux1.getNo(i).setValor(getNo(i).getValor());
        }
        for(int i= getTam()/2,j=0; i<getTam();i++,j++)
        {
            aux2.getNo(j).setValor(getNo(i).getValor());
        }
    }

    private void fusao2(Lista aux1, Lista aux2,int seq)
    {
        int a=0, j=0, i =0;
        int lock = seq;

        while (a<getTam())
        {
            while (i<seq&&j<seq&&a<getTam())
            {
                if(aux1.getNo(i).getValor()<aux2.getNo(j).getValor())
                    getNo(a++).setValor(aux1.getNo(i++).getValor());
                else
                    getNo(a++).setValor(aux2.getNo(j++).getValor());
            }
            //System.out.println(getNo(a));
            while (i < seq && a<getTam())
                getNo(a++).setValor(aux1.getNo(i++).getValor());
            while (j < seq && a<getTam())
                getNo(a++).setValor(aux2.getNo(j++).getValor());
            seq = seq + lock;
        }
    }





    //ORDENAÇÕES DE LITERATURAS

    public void countingSort() {
        int i, j;
        No aux = inicio, maior = aux;
        aux = aux.getProx();

        //acha maior valor
        while (aux != null) {
            if (aux.getValor() > maior.getValor())
                maior = aux;
            aux = aux.getProx();
        }

        //cria o array C com base no maior
        int C[] = new int[maior.getValor()];
        aux = inicio;

        // adiciona a qtde de vezes que o elemento apareceu no respectivo lugar
        while (aux != null) {
            C[aux.getValor() - 1] = C[aux.getValor() - 1] + 1;
            aux = aux.getProx();
        }

        //faz a somatória dentro do array
        for (i = 1; i < C.length; i++)
            C[i] = C[i] + C[i - 1];

        //cria um array do tamanho da lista
        int[] B = new int[getTam()];

        //vai posicionando cada elemento em seu respectivo lugar em B conforme o algoritmo pede
        aux = fim;
        while (aux != null) {
            B[C[aux.getValor() - 1] - 1] = aux.getValor();
            C[aux.getValor() - 1] = C[aux.getValor() - 1] - 1;
            aux = aux.getAnt();
        }

        //posiciona na lista de acordo com B
        for (i = 0, aux = inicio; aux != null; i++, aux = aux.getProx())
            aux.setValor(B[i]);
    }

    public void bucketSort() {
        No maior = inicio, aux = maior.getProx(), auxB;
        int baldesqtde = 1, local;
        //acha maior elemento da lista
        while (aux != null) {
            if (maior.getValor() < aux.getValor())
                maior = aux;
            aux = aux.getProx();
        }
        //acha qtde adequada de baldes
        while (baldesqtde < getTam())
            baldesqtde = 3 * baldesqtde + 1;
        baldesqtde = baldesqtde / 3;

        Lista[] buckets = new Lista[baldesqtde];

        //inicializa
        for (int i = 0; i < buckets.length; i++)
            buckets[i] = new Lista();

        //posiciona NOs nos baldes
        aux = inicio;
        while (aux != null) {
            local = (int) ((aux.getValor() * 1.0 / maior.getValor()) * (baldesqtde - 1));
            buckets[local].insere(aux.getValor());
            aux = aux.getProx();
        }

        //ordena os buckets
        for (int i = 0; i < buckets.length; i++)
            buckets[i].bubbleSort();

        //ordena lista original
        aux = inicio;
        for (int i = 0; i < buckets.length; i++) {
            for (auxB = buckets[i].getInicio(); auxB != null; auxB = auxB.getProx(), aux = aux.getProx())
                aux.setValor(auxB.getValor());
        }
    }

    public void radixSort() {
        Lista ele[] = new Lista[10];
        No aux = inicio, auxB;
        int divisor = 1, resto, result, cont = 0;

        // inicializa vetor
        for (int i = 0; i < ele.length; i++)
            ele[i] = new Lista();

        // coloca cada elemento no local do digito menos significativo da vez
        while (aux != null) {
            result = aux.getValor() / divisor;
            if (result == 0)
                cont++;
            resto = result % 10;
            ele[resto].insere(aux.getValor());
            aux = aux.getProx();
        }
        divisor = divisor * 10;

        // ordena a lista principal e continua o processo
        while (cont != getTam())
        {
            cont = 0;
            aux = inicio;
            for (int i = 0; i < ele.length; i++) {
                auxB = ele[i].getInicio();
                while (auxB != null) {
                    aux.setValor(auxB.getValor());
                    aux = aux.getProx();
                    auxB = auxB.getProx();
                }
            }

            for (int i = 0; i < ele.length; i++)
                ele[i] = new Lista();
            aux = inicio;
            while (aux != null) {
                result = aux.getValor() / divisor;
                if (result == 0)
                    cont++;
                resto = result % 10;
                ele[resto].insere(aux.getValor());
                aux = aux.getProx();
            }
            divisor = divisor * 10;
        }
    }

    public void combSort() {
        No aux;
        int gap, auxI;
        gap = (int) (getTam() / 1.3);
        for (; gap > 0; gap = (int) (gap / 1.3)) {
            aux = inicio;
            for (int i = 0; i + gap < getTam(); i++) {
                if (aux.getValor() > getNo(i + gap).getValor()) {
                    auxI = aux.getValor();
                    aux.setValor(getNo(i + gap).getValor());
                    getNo(i + gap).setValor(auxI);
                }
                aux = aux.getProx();
            }
        }
    }

    public void gnomeSort()
    {
        No aux, marcar;
        int a;
        aux = inicio;
        while (aux.getProx() != null) {
            if (aux.getValor() > aux.getProx().getValor()) {
                a = aux.getValor();
                aux.setValor(aux.getProx().getValor());
                aux.getProx().setValor(a);
            }
            marcar = aux.getProx();
            while (aux.getAnt() != null && aux.getValor() < aux.getAnt().getValor()) {
                a = aux.getValor();
                aux.setValor(aux.getAnt().getValor());
                aux.getAnt().setValor(a);
                aux = aux.getAnt();
            }
            aux = marcar;
        }
    }

    private void insertionTimSort(int ini,int fim)
    {
        No auxN,comp;
        auxN = getNo(ini+1);
        while (auxN!=getNo(fim))
        {
            comp = auxN;
            int valor = auxN.getValor();
            while (comp!=getNo(ini)&&valor< comp.getAnt().getValor())
            {
                comp.setValor(comp.getAnt().getValor());
                comp = comp.getAnt();
            }
            comp.setValor(valor);
            auxN = auxN.getProx();
        }
    }

    public void fusaoTim(int ini1,int fim1,int ini2, int fim2)
    {

        Lista aux = new Lista();
        int i = ini1, j = ini2;
        int k = 0;
        while (i<=fim1&&j<=fim2)
        {
            if (getNo(i).getValor() < getNo(j).getValor()) {
                aux.insere(getNo(i++).getValor());
                k++;
            } else {
                aux.insere(getNo(j++).getValor());
                k++;
            }
        }
        while (i <= fim1) {
            aux.insere(getNo(i++).getValor());
            k++;
        }
        while (j <= fim2) {
            aux.insere(getNo(j++).getValor());
            k++;
        }
        for (int a = 0;a<k;a++)
        {
            getNo(a+ini1).setValor(aux.getNo(a).getValor());
        }

    }

    public void timSort()
    {
        int div = 32;
        for(int i=0;i<getTam();i=i+div)
        {
            if(i+div>=getTam())
                insertionTimSort(i,getTam());
            else
                insertionTimSort(i,i+div);
        }
        

        for(int i=div;i<getTam();i = i * 2)
        {
            for(int j = 0; j<getTam();j+=i*2)
            {
                int meio = j + i-1;
                int fim;
                if(meio+i<=getTam())
                    fim = meio + i;
                else
                    fim = getTam();
                if(meio<fim)
                    fusaoTim(j,meio,meio+1,fim);
            }

        }
    }


}