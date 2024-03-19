package DFA;

public class DFA {

    public static void main(String[] args) {
        String texto1 = "AABAACAADAABAABA";
        String patron1 = "AABA";
        buscarPatron(texto1, patron1);

        String texto2 = "THIS IS A TEST TEXT";
        String patron2 = "TEST";
        buscarPatron(texto2, patron2);
    }

    public static void buscarPatron(String texto, String patron) {
        int estadoActual = 0;
        int[][] transiciones = construirTablaDeTransiciones(patron);

        for (int i = 0; i < texto.length(); i++) {
            estadoActual = transiciones[estadoActual][texto.charAt(i) - 'A'];
            if (estadoActual == patron.length()) {
                System.out.println("Se encontró el patrón '" + patron + "' en la posición " + (i - patron.length() + 1));
                estadoActual = 0;
            }
        }
    }

    public static int[][] construirTablaDeTransiciones(String patron) {
        int m = patron.length();
        int[][] transiciones = new int[m + 1][256];

        for (int estado = 0; estado <= m; estado++) {
            for (char c = 0; c < 256; c++) {
                int siguienteEstado = Math.min(m, estado + 1);
                while (siguienteEstado > 0 && (patron.substring(0, estado) + (char) c).endsWith(patron.substring(0, siguienteEstado))) {
                    siguienteEstado--;
                }
                transiciones[estado][c] = siguienteEstado;
            }
        }
        return transiciones;
    }
}