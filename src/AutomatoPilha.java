import java.util.Stack;

public class AutomatoPilha {
    private Stack<Character> pilha;

    public AutomatoPilha() {
        pilha = new Stack<>();
    }

    public boolean processar(String entrada) {
        pilha.clear();
        pilha.push('$');

        int i = 0;
        while (i < entrada.length() && entrada.charAt(i) == '0') {
            pilha.push('0');
            i++;
        }

        while (i < entrada.length() && entrada.charAt(i) == '1') {
            if (pilha.isEmpty() || pilha.peek() != '0') {
                return false;
            }
            pilha.pop();
            i++;
        }

        return pilha.size() == 1 && pilha.peek() == '$' && i == entrada.length();
    }

    public static void main(String[] args) {
        AutomatoPilha ap = new AutomatoPilha();
        String[] testes = {"", "01", "0011", "0001111", "0000111111", "001"};
        for (String teste : testes) {
            boolean resultado = ap.processar(teste);
            System.out.println("Entrada: " + teste + " -> " + (resultado ? "Aceita" : "Rejeitada"));
        }
    }
}
