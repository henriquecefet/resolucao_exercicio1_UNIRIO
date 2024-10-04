import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main  {
    private JLabel saldoLabel;

    public Main() {
        ContaBancaria conta = new ContaBancaria(1000.00);  // Saldo inicial de exemplo
        criarTela(conta);
    }

    public static void main(String[] args) {
        new Main();
    }

    public void criarTela(ContaBancaria conta) {
        JFrame frame = new JFrame("Conta Bancária");
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Painel principal com BoxLayout para permitir pular linhas
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Label para mostrar o saldo
        saldoLabel = new JLabel("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
        panel.add(saldoLabel);

        // Adiciona um espaçamento (simulando pular linha)
        panel.add(Box.createVerticalStrut(15));  // 15 pixels de espaçamento

        // Campo de texto para depositar
        JTextField depositoField = new JTextField();
        panel.add(new JLabel("Valor para depositar:"));
        panel.add(depositoField);

        panel.add(Box.createVerticalStrut(15));  // Espaçamento entre componentes

        // Botão de depósito
        JButton depositarButton = new JButton("Depositar");
        depositarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double valorDeposito = Double.parseDouble(depositoField.getText());
                    conta.depositar(valorDeposito);
                    atualizarSaldo(conta);
                    JOptionPane.showMessageDialog(frame, "Depósito de R$ " + valorDeposito + " realizado com sucesso!");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Valor inválido para depósito.");
                }
            }
        });
        panel.add(depositarButton);

        panel.add(Box.createVerticalStrut(15));  // Espaçamento entre componentes

        // Campo de texto para saque
        JTextField saqueField = new JTextField();
        panel.add(new JLabel("Valor para sacar:"));
        panel.add(saqueField);

        panel.add(Box.createVerticalStrut(15));  // Espaçamento entre componentes

        // Botão de saque
        JButton sacarButton = new JButton("Sacar");
        sacarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double valorSaque = Double.parseDouble(saqueField.getText());
                    if (conta.sacar(valorSaque)) {
                        atualizarSaldo(conta);
                        JOptionPane.showMessageDialog(frame, "Saque de R$ " + valorSaque + " realizado com sucesso!\nA taxa de R$ 1.50 foi aplicada.");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Saldo insuficiente para saque.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Valor inválido para saque.");
                }
            }
        });
        panel.add(sacarButton);

        // Adiciona o painel ao frame e exibe a janela
        frame.add(panel);
        frame.setVisible(true);
    }

    // Atualiza o saldo mostrado na tela
    private void atualizarSaldo(ContaBancaria conta) {
        saldoLabel.setText("Saldo: R$ " + String.format("%.2f", conta.getSaldo()));
    }


}
