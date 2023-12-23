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
        setSize(370, 400);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout()); // Adiciona um painel principal 

        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Adiciona um painel para a imagem logo no canto superior esquerdo

        ImageIcon icon = createImageIcon("C:\\Users\\sakia\\OneDrive\\Área de Trabalho\\tela adicionar produto\\projeto\\assests\\logo gelafit.jpg", 100, 100);
        JLabel imageLabel = new JLabel(icon); // Adiciona a imagem à label, redimensionando se necessário

        imagePanel.add(imageLabel); // Adiciona a label ao painel da imagem

        mainPanel.add(imagePanel, BorderLayout.NORTH); // Adiciona o painel da imagem ao painel principal

        // Adiciona um novo painel no centro para os botões
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Usando FlowLayout para organizar os botões lado a lado

        // Adiciona o botão "Adicionar Produto"
        JButton addButton = createButton("Adicionar Produto", "C:\\Users\\sakia\\OneDrive\\Área de Trabalho\\tela adicionar produto\\projeto\\assests\\images (2).png", 30, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.invokeLater(() -> new AddProduto());
            }
        });
        buttonPanel.add(addButton);

        // Adiciona o botão "Ver Clientes"
        JButton viewClientsButton = createButton("Ver Clientes", "C:\\Users\\sakia\\OneDrive\\Área de Trabalho\\tela adicionar produto\\projeto\\assests\\verclientes.png", 30, 30);
        // Adicione a lógica para o botão "Ver Clientes" aqui, por exemplo, abrir uma nova tela
        buttonPanel.add(viewClientsButton);

        mainPanel.add(buttonPanel, BorderLayout.CENTER); // Adiciona o painel de botões ao painel principal no Centro

        // Adiciona um novo painel no centro para os botões abaixo dos dois primeiros
        JPanel secondRowPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Adiciona o botão "Relatório"
        JButton reportButton = createButton("Relatório", "C:\\Users\\sakia\\OneDrive\\Área de Trabalho\\tela adicionar produto\\projeto\\assests\\relatorio.png", 30, 30);
        // Adicione a lógica para o botão "Relatório" aqui, por exemplo, gerar um relatório
        secondRowPanel.add(reportButton);

        // Adiciona o botão "Suporte"
        JButton supportButton = createButton("Suporte", "C:\\Users\\sakia\\OneDrive\\Área de Trabalho\\tela adicionar produto\\projeto\\assests\\suporte.png", 30, 30);
        // Adicione a lógica para o botão "Suporte" aqui, por exemplo, abrir uma tela de suporte
        secondRowPanel.add(supportButton);

        mainPanel.add(secondRowPanel, BorderLayout.SOUTH); // Adiciona o segundo painel de botões abaixo do primeiro no Centro

        add(mainPanel); // Adiciona o painel principal à janela

        // Torna a janela visível
        setVisible(true);
    }

    private JButton createButton(String buttonText, String iconPath, int width, int height) {
        JButton button = new JButton(buttonText);

        try {
            Image iconImage = ImageIO.read(new File(iconPath)).getScaledInstance(width, height, Image.SCALE_SMOOTH);
            button.setIcon(new ImageIcon(iconImage));
        } catch (IOException e) {
            e.printStackTrace();
        }

        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setVerticalTextPosition(SwingConstants.BOTTOM);

        return button;
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
