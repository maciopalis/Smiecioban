import javax.swing.*;
import java.awt.*;

public class Menus extends JFrame {
    public Game game;
    private JFrame frame;

    public Menus(JFrame frame) {
        this.frame = frame;
        this.game = game;
        showMainMenu();
    }

    public void showMainMenu() {
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        ImageIcon radek = new ImageIcon(new ImageIcon("graphics/garbageman/radek_menu.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel titleLabel = new JLabel("Śmiecioban");
        titleLabel.setFont(new Font(("Comic Sans MS"), Font.BOLD, 50));
        titleLabel.setBounds(160,45,500,100);
        titleLabel.setIcon(radek);
        titleLabel.setIconTextGap(20);
        titleLabel.setHorizontalTextPosition(SwingConstants.LEFT);

        JButton levelButton = new JButton("Wybierz poziom");
        levelButton.setBounds(90,150,500,100);
        levelButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        levelButton.setFocusable(false);

        JButton controlsButton = new JButton("Sterowanie");
        controlsButton.setBounds(90,275,500,100);
        controlsButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        controlsButton.setFocusable(false);

        JButton informationButton = new JButton("Informacje");
        informationButton.setBounds(90,400,500,100);
        informationButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        informationButton.setFocusable(false);

        levelButton.addActionListener(e -> showLevelSelection());
        controlsButton.addActionListener(e -> showControls());
        informationButton.addActionListener(e -> showInformation());

        frame.add(titleLabel);
        frame.add(levelButton);
        frame.add(controlsButton);
        frame.add(informationButton);

        //pack();
        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    public void showLevelSelection() {
        frame.getContentPane().removeAll();
        frame.setLayout(new GridLayout(4, 1));

        String[] levels = {"Level 1", "Level 2", "Level 3"};
        for (int i = 0; i < levels.length; i++) {
            int level = i + 1;
            JButton levelButton = new JButton(levels[i]);
            levelButton.addActionListener(e -> {
                this.game = new Game(level, frame);
                dispose();
            });
            frame.add(levelButton);
        }

        JButton backButton = new JButton("Powrót");
        backButton.addActionListener(e -> showMainMenu());
        frame.add(backButton);

        frame.revalidate();
        frame.repaint();
    }

    private void showControls() {
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        JLabel controlsLabel = new JLabel("<html>Sterowanie:<br>W - Góra<br>A - Lewo<br>S - Dół<br>D - Prawo</html>");
        controlsLabel.setFont(new Font(("Comic Sans"), Font.BOLD, 50));
        controlsLabel.setBounds(160,45,500,300);

        JButton backButton = new JButton("Powrót");
        backButton.setBounds(90,400,500,100);
        backButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        backButton.setFocusable(false);
        backButton.addActionListener(e -> showMainMenu());

        frame.add(controlsLabel);
        frame.add(backButton);

        frame.revalidate();
        frame.repaint();
    }

    private void showInformation() {
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        JLabel informationLabel = new JLabel("<html>Gra stworzona w ramach projektu JPWP.<br><br><br><br><br><br><br>Autor: Maciej Paliwoda</html>");
        informationLabel.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        informationLabel.setBounds(60,20,600,350);

        JButton backButton = new JButton("Powrót");
        backButton.setBounds(90,400,500,100);
        backButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        backButton.setFocusable(false);
        backButton.addActionListener(e -> showMainMenu());

        frame.add(informationLabel);
        frame.add(backButton);

        frame.revalidate();
        frame.repaint();
    }

    public void levelCompletedMenu(int currentLevel){
        frame.getContentPane().removeAll();
        frame.setLayout(null);
        JLabel completedLabel = new JLabel("<html>Sterowanie:<br>W - Góra<br>A - Lewo<br>S - Dół<br>D - Prawo</html>");
        completedLabel.setFont(new Font(("Comic Sans"), Font.BOLD, 50));
        completedLabel.setBounds(160,45,500,300);

        JButton nextButton = new JButton("Dalej");
        nextButton.setBounds(90,400,500,100);
        nextButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        nextButton.setFocusable(false);
        nextButton.addActionListener(e -> showLevelSelection());

        switch(currentLevel){
            case 1:
                completedLabel.setText("<html>Recykling pozwala ograniczyć zużycie surowców naturalnych i chroni nasze środowisko.</html>");
                break;
            case 2:
                completedLabel.setText("<html>Segregując odpady, dajesz im drugie życie – szkło, plastik i papier mogą być przetwarzane wielokrotnie.</html>");
                break;
            case 3:
                completedLabel.setText("<html>Recykling jednej butelki plastikowej pozwala zaoszczędzić energię potrzebną na 25 minut pracy żarówki LED.</html>");
                break;
            case 4:
                completedLabel.setText("<html>Pamiętaj, że wyrzucając śmieci do odpowiednich koszy, zmniejszasz ilość odpadów trafiających na wysypiska.</html>");
                break;
            case 5:
                completedLabel.setText("<html>Z każdej tony makulatury można wyprodukować aż 900 kg nowego papieru!</html>");
                break;
            case 6:
                completedLabel.setText("<html>Szkło to jeden z najlepszych materiałów do recyklingu – można go przetwarzać bez końca.</html>");
                break;
            case 7:
                completedLabel.setText("<html>Segregowanie bioodpadów pozwala tworzyć naturalny kompost, który może użyźniać glebę.</html>");
                break;
            case 8:
                completedLabel.setText("<html>Nie wyrzucaj baterii do zwykłych koszy – zawierają toksyczne substancje, które szkodzą środowisku.</html>");
                break;
            case 9:
                completedLabel.setText("<html>Plastikowe butelki mogą być przetwarzane na nowe opakowania, ubrania czy materiały budowlane.</html>");
                break;
            case 10:
                completedLabel.setText("<html>Recykling metali, takich jak aluminium, pozwala zaoszczędzić aż 95% energii w porównaniu z ich produkcją od podstaw.</html>");
                break;
            case 11:
                completedLabel.setText("<html>Zamiast wyrzucać, przemyśl, czy dany przedmiot można naprawić lub oddać komuś, kto go potrzebuje.</html>");
                break;
            case 12:
                completedLabel.setText("<html>Segregowanie odpadów to prosty sposób, by chronić planetę dla przyszłych pokoleń.</html>");
                break;
            default:
                completedLabel.setText("<html>Recykling to nie tylko ochrona środowiska – to także oszczędność energii i redukcja emisji CO₂.</html>");
        }

        frame.add(completedLabel);
        frame.add(nextButton);

        frame.revalidate();
        frame.repaint();
    }

}