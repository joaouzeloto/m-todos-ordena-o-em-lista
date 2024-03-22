public class Main {
    public static void main(String[] args)
    {
        Lista a = new Lista();
        for(int i=0;i<25;i++)
        {
            a.insere((int) (Math.random() * ((120 - 1) + 1)) + 1);
        }
        a.exibir();
        a.combSort();
        a.exibir();
    }
}