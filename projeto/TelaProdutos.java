import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class TelaProdutos extends JFrame {

    public TelaProdutos() {
        // Configuração básica da janela
        setTitle("GELAFIT");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout()); // Adiciona um painel principal 

        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Adiciona um painel para a imagem logo no canto superior esquerdo

        ImageIcon icon = createImageIcon("C:\\Users\\sakia\\OneDrive\\Área de Trabalho\\tela adicionar produto\\projeto\\assests\\logo gelafit.jpg", 100, 100);
        JLabel imageLabel = new JLabel(icon); // Adiciona a imagem à label, redimensionando se necessário

        imagePanel.add(imageLabel); // Adiciona a label ao painel da imagem

        mainPanel.add(imagePanel, BorderLayout.NORTH); // Adiciona o painel da imagem ao painel principal

        // Altere a linha onde você cria o painel de botões para o seguinte:
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton addButton = new JButton(); // Adiciona o botão ao painel de botões
        ImageIcon addButtonIcon = createImageIcon("C:\\Users\\sakia\\OneDrive\\Área de Trabalho\\tela adicionar produto\\projeto\\assests\\images (2).png", 30, 30);
        addButton.setIcon(addButtonIcon);
        addButton.setText("Adicionar Produto");
        addButton.setHorizontalTextPosition(SwingConstants.CENTER);
        addButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Abre a segunda tela
                SwingUtilities.invokeLater(() -> new AddProduto());
            }
        });

        buttonPanel.add(addButton); // Adiciona o botão ao painel de botões

        mainPanel.add(buttonPanel, BorderLayout.CENTER); // Adiciona o painel de botões ao painel principal no Centro

        // Adiciona um novo painel na região inferior (SOUTH) para o botão "Tela Principal"
        JPanel bottomButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton homeButton = new JButton(); // Adiciona o botão ao painel de botões
        ImageIcon homeButtonIcon = createImageIcon("C:\\Users\\sakia\\OneDrive\\Área de Trabalho\\tela adicionar produto\\projeto\\assests\\casa.png", 30, 30); // Substitua pelo caminho correto
        homeButton.setIcon(homeButtonIcon);
        homeButton.setText("Tela Principal");
        homeButton.setHorizontalTextPosition(SwingConstants.CENTER);
        homeButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { // Adicione a lógica para voltar à tela principal
                // Coloque o código aqui para voltar à tela principal
            }
        });

        bottomButtonPanel.add(homeButton); // Adiciona o botão ao painel de botões

        mainPanel.add(bottomButtonPanel, BorderLayout.SOUTH); // Adiciona o painel de botões na região inferior (SOUTH) ao painel principal

        add(mainPanel); // Adiciona o painel principal à janela

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
        SwingUtilities.invokeLater(() -> new TelaProdutos());
    }
}
