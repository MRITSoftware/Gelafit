import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddProduto extends JFrame {

    // Defina as informações do banco de dados
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/gelafit";
    private static final String USUARIO = "talmop";
    private static final String SENHA = "tobovo";

    private JTextField nameField;
    private JTextField quantityField;
    private JTextField priceField;
    private JTextField descriptionField;

    public AddProduto() {
        setTitle("Adicionar Produto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        ImageIcon icon = createImageIcon("C:\\Users\\sakia\\OneDrive\\Área de Trabalho\\tela adicionar produto\\projeto\\assests\\images (2).png", 40, 40);
        JButton imageButton = new JButton(icon);
        imageButton.setContentAreaFilled(false);
        imagePanel.add(imageButton);

        JLabel addImageLabel = new JLabel("Adicionar Imagem do Produto");
        addImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(addImageLabel);

        mainPanel.add(imagePanel, BorderLayout.NORTH);

        JPanel componentPanel = new JPanel(new GridLayout(4, 2));
        JLabel nameLabel = new JLabel("Nome do Produto:");
        nameField = new JTextField(15);
        componentPanel.add(nameLabel);
        componentPanel.add(nameField);

        JLabel quantityLabel = new JLabel("Quantidade:");
        quantityField = new JTextField(5);
        JLabel priceLabel = new JLabel("Preço:");
        priceField = new JTextField(5);
        componentPanel.add(quantityLabel);
        componentPanel.add(quantityField);
        componentPanel.add(priceLabel);
        componentPanel.add(priceField);

        JLabel descriptionLabel = new JLabel("Descrição:");
        descriptionField = new JTextField(15);
        componentPanel.add(descriptionLabel);
        componentPanel.add(descriptionField);

        mainPanel.add(componentPanel, BorderLayout.CENTER);

        JButton saveButton = new JButton("Salvar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nameField.getText();
                int quantidade = Integer.parseInt(quantityField.getText());
                double preco = Double.parseDouble(priceField.getText());
                String descricao = descriptionField.getText();

                saveToDatabase(nome, quantidade, preco, descricao);
                dispose();
            }
        });

        JButton cancelButton = new JButton("Cancelar");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    private ImageIcon createImageIcon(String path, int width, int height) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(path));
            Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(resizedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void saveToDatabase(String nome, int quantidade, double preco, String descricao) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USUARIO, SENHA);
            if (connection != null) {
                System.out.println("Conectado ao banco de dados!");
            } else {
                System.out.println("Falha ao conectar ao banco de dados!");
            }

            String sql = "INSERT INTO produtos (nome, quantidade, preco, descricao) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, nome);
                statement.setInt(2, quantidade);
                statement.setDouble(3, preco);
                statement.setString(4, descricao);
                statement.executeUpdate();
            }
            connection.close();
            JOptionPane.showMessageDialog(this, "Produto salvo no banco de dados.");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erro ao salvar no banco de dados. Consulte os logs para mais detalhes.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AddProduto());
    }
}
