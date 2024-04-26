public class Main {
    public static void main(String[] args)
    {
        Lista a = new Lista();
        for(int i=0;i<64;i++)
        {
            a.insere((int) (Math.random() * ((350 - 1) + 1)) + 1);
        }
        a.exibir();
        a.timSort();
        a.exibir();

        
    }
}