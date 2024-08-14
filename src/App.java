import java.io.IOException;
import java.util.Scanner;


public class App {    
    
    public static void printa(String msg) {
        System.out.println(msg);
    }

    public static void movimenta_estoque(Produto produto, String operacao, int quantidade) throws IOException, InterruptedException {
        String escolha;
        Scanner scanner = new Scanner(System.in);

        if (operacao.equals("E")){
            produto.estoque += quantidade;
        }
        else if (operacao.equals("S")){
            if (quantidade > produto.estoque) {
                CLS.limpa();
                printa("Quantidade digitada maior do que em estoque");
                printa("Estoque atual: " + produto.estoque + " Estoque vai ficar: " + (produto.estoque - quantidade) + " Continua ?(s/n)");
                escolha = scanner.nextLine();
                escolha = escolha.trim().toUpperCase();

                if (escolha.equals("S")){
                    produto.estoque -= quantidade;
                }
                else {
                    printa("Não sera atualizado o estoque");
                }
            }
            else {
                produto.estoque -= quantidade;
            }            
            scanner.close();
        }
        else {
            printa("Nenhuma opção valida digitada");
        }
    }

    public static void main(String[] args) throws Exception {
        String escolha;
        int quantidade_movimentar = 0;

        CLS.limpa();

        Scanner scanner = new Scanner(System.in);

        Produto produto = new Produto();

        produto.codpro = 10;
        produto.descricao = "Teste";
        produto.estoque = 200;
        produto.preco = (float) 10.50;

        CLS.limpa();

        printa("Produto " + produto.descricao + "Tem o estoque de: " + produto.estoque);

        printa("Digite E para dar entrada e S para saida:");
        escolha = scanner.nextLine();

        printa("Digite a quantidade para movimentar: ");
        quantidade_movimentar = scanner.nextInt();

        escolha = escolha.trim().toUpperCase();

        if (escolha.length() != 1){
            printa("Digite uma opção valida");
        }
        else {
            movimenta_estoque(produto, escolha, quantidade_movimentar);
            CLS.limpa();
            printa("Produto " + produto.descricao + " Atualizou o estoque para: " + produto.estoque);
        }

        

        scanner.close();
    }
    

}
