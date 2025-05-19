package br.com.alura.buscaCEP.principal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class BuscaCepGUI extends JFrame {

    private JTextField cepField;
    private JTextField logradouroField;
    private JTextField bairroField;
    private JTextField cidadeField;
    private JTextField ufField;

    public BuscaCepGUI() {
        setTitle("Busca de CEP");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 5));

        panel.add(new JLabel("CEP:"));
        cepField = new JTextField();
        panel.add(cepField);

        panel.add(new JLabel("Logradouro:"));
        logradouroField = new JTextField();
        logradouroField.setEditable(false);
        panel.add(logradouroField);

        panel.add(new JLabel("Bairro:"));
        bairroField = new JTextField();
        bairroField.setEditable(false);
        panel.add(bairroField);

        panel.add(new JLabel("Cidade:"));
        cidadeField = new JTextField();
        cidadeField.setEditable(false);
        panel.add(cidadeField);

        panel.add(new JLabel("UF:"));
        ufField = new JTextField();
        ufField.setEditable(false);
        panel.add(ufField);

        JButton buscarBtn = new JButton("Buscar CEP");
        buscarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarCEP();
            }
        });

        panel.add(buscarBtn);
        getContentPane().add(panel);
    }

    private void buscarCEP() {
        String cep = cepField.getText().trim().replace("-", "");
        if (cep.length() != 8) {
            JOptionPane.showMessageDialog(this, "Digite um CEP válido com 8 dígitos.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            URL url = new URL("https://viacep.com.br/ws/" + cep + "/json/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            Scanner sc = new Scanner(url.openStream());
            StringBuilder inline = new StringBuilder();
            while (sc.hasNext()) {
                inline.append(sc.nextLine());
            }
            sc.close();

            JSONObject obj = new JSONObject(inline.toString());

            if (obj.has("erro")) {
                JOptionPane.showMessageDialog(this, "CEP não encontrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
                return;
            }

            logradouroField.setText(obj.optString("logradouro", ""));
            bairroField.setText(obj.optString("bairro", ""));
            cidadeField.setText(obj.optString("localidade", ""));
            ufField.setText(obj.optString("uf", ""));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar o CEP: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BuscaCepGUI().setVisible(true);
        });
    }
}

