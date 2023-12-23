import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class AddProduto extends JFrame {

    public AddProduto() { // Configuração básica da janela
        setTitle("Adicionar Produto");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout()); // Adiciona um painel principal com layout 

        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Adiciona a imagem do logo

        // Adiciona a imagem como um botão, redimensionando se necessário
        ImageIcon icon = createImageIcon("C:\\Users\\sakia\\OneDrive\\Área de Trabalho\\tela adicionar produto\\projeto\\assests\\images (2).png", 40, 40);
        JButton imageButton = new JButton(icon);
        imageButton.setContentAreaFilled(false); // Torna o botão sem preenchimento para que a imagem seja visível

        imagePanel.add(imageButton); // Adiciona o botão da imagem adicionar

        // Adiciona a mensagem "Adicionar Imagem do Produto" abaixo da imagem
        JLabel addImageLabel = new JLabel("Adicionar Imagem do Produto");
        addImageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        imagePanel.add(addImageLabel);

        // Adiciona o painel da imagem ao painel principal no Norte 
        mainPanel.add(imagePanel, BorderLayout.NORTH);

        // Adiciona um segundo painel para outros componentes
        JPanel componentPanel = new JPanel(new GridLayout(4, 2)); // Usando GridLayout para organizar as caixas uma abaixo da outra

        // Adiciona um rótulo e um campo de texto para o nome do produto 
        JLabel nameLabel = new JLabel("Nome do Produto:");
        JTextField nameField = new JTextField(15);
        componentPanel.add(nameLabel);
        componentPanel.add(nameField);

        // Adiciona rótulos e campos de texto para quantidade e preço
        JLabel quantityLabel = new JLabel("Quantidade:");
        JTextField quantityField = new JTextField(5);
        JLabel priceLabel = new JLabel("Preço:");
        JTextField priceField = new JTextField(5);
        componentPanel.add(quantityLabel);
        componentPanel.add(quantityField);
        componentPanel.add(priceLabel);
        componentPanel.add(priceField);

        // Adiciona um rótulo e um campo de texto para a descrição
        JLabel descriptionLabel = new JLabel("Descrição:");
        JTextField descriptionField = new JTextField(15);
        componentPanel.add(descriptionLabel);
        componentPanel.add(descriptionField);

        // Adiciona o painel de componentes ao painel principal no Centro
        mainPanel.add(componentPanel, BorderLayout.CENTER);

        // Adiciona os botões na região inferior 
        JButton saveButton = new JButton("Salvar");
        JButton cancelButton = new JButton("Cancelar");

        // Adiciona um ActionListener para o botão "Cancelar"
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fecha a janela ao clicar no botão "Cancelar"
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        // Adiciona o painel de botões à região inferior 
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Adiciona o painel principal à janela
        add(mainPanel);

        // Torna a janela visível
        setVisible(true);
    }

    private ImageIcon createImageIcon(String path, int width, int height) {
        try {
            // Lê a imagem do arquivo
            BufferedImage originalImage = ImageIO.read(new File(path));

            // Redimensiona a imagem
            Image resizedImage = originalImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);

            // Cria um ImageIcon a partir da imagem redimensionada
            return new ImageIcon(resizedImage);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Cria e exibe a tela
        SwingUtilities.invokeLater(() -> new AddProduto());
    }
}
