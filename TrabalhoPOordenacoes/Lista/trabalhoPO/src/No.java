public class No
{
        private int valor;
        private No prox,ant;

        public No(int valor, No prox, No ant)
        {
            this.valor = valor;
            this.prox = prox;
            this.ant = ant;
        }

        public int getValor()
        {
            return valor;
        }

        public void setValor(int valor)
        {
            this.valor = valor;
        }

        public No getProx()
        {
            return prox;
        }

        public void setProx(No prox)
        {
            this.prox = prox;
        }

        public No getAnt()
        {
            return ant;
        }

        public void setAnt(No ant)
        {
            this.ant = ant;
        }
}
