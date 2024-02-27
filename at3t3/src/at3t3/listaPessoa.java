package at3t3;

import java.util.ArrayList;
import javax.swing.JOptionPane;


public class listaPessoa {
    public static ArrayList<Pessoa> lista = new ArrayList<Pessoa>();
    private static int id = 0;
    
    public static void adicionar(Pessoa pe){
try {
     pe.setId(++id);

if (pe.getNome().isEmpty() || pe.getNome().isBlank()) {
    JOptionPane.showMessageDialog(null, "Preencha o nome do paciente", "Erro", JOptionPane.WARNING_MESSAGE);
    return;
}
if (!validatePhoneNumber(pe.getTelefone()) || pe.getTelefone().isBlank() || pe.getTelefone().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Telefone inválido. Preencha corretamente!\nExemplo: (12) 34567-8910", "Erro", JOptionPane.WARNING_MESSAGE);
    return;
}
if (!validarCPF(pe.getCpf()) || pe.getCpf().isBlank() || pe.getCpf().isEmpty()) {
    JOptionPane.showMessageDialog(null, "CPF inválido. Preencha corretamente!\nExemplo: 123.456.789-10", "Erro", JOptionPane.WARNING_MESSAGE);
    return;
}
if (!validarData(pe.getData()) || pe.getData().isBlank() || pe.getData().isEmpty()) {
    JOptionPane.showMessageDialog(null, "Data inválida. Preencha corretamente!\nExemplo: 02/02/2006", "Erro", JOptionPane.WARNING_MESSAGE);
} else {
    lista.add(pe);
    JOptionPane.showMessageDialog(null, "Lista adicionada", "OK", JOptionPane.WARNING_MESSAGE);
}
} catch (Exception e) {
    System.out.println("Erro: " + e.getMessage());
    e.printStackTrace();
    JOptionPane.showMessageDialog(null, "Erro ao adicionar na lista", "Erro", JOptionPane.WARNING_MESSAGE);
}
    }
public static boolean validatePhoneNumber(String phoneNumber) {

        String regex = "\\(\\d{2}\\) \\d{5}-\\d{4}";
        return phoneNumber.matches(regex);
    }

    public static boolean validarCPF(String CPF) {

        String regexcpf = "\\d{3}.\\d{3}.\\d{3}-\\d{2}";
        return CPF.matches(regexcpf);
    }

    public static boolean validarData(String Data) {
        String regexdata = "\\d{2}/\\d{2}/\\d{4}";
        return Data.matches(regexdata);
    }       

    
    public static ArrayList<Pessoa> listar(){
        return lista;
    }   
   
}
     