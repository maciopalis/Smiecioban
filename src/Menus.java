import javax.swing.*;
import java.awt.*;

public class Menus extends JFrame {
    public Game game;
    private JFrame frame;
    private MusicManager musicManager;

    public Menus(JFrame frame) {
        this.musicManager = new MusicManager();
        this.frame = frame;
        showMainMenu();
        this.musicManager.playMainMenuMusic();
    }

    public void showMainMenu() {
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        ImageIcon radek = new ImageIcon(new ImageIcon("graphics/garbageman/radek_menu.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        JLabel titleLabel = new JLabel("Śmiecioban");
        titleLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        titleLabel.setBounds(160, 45, 500, 100);
        titleLabel.setIcon(radek);
        titleLabel.setIconTextGap(20);
        titleLabel.setHorizontalTextPosition(SwingConstants.LEFT);

        JButton levelButton = createButton("Wybierz poziom", 150);
        JButton controlsButton = createButton("Sterowanie", 275);
        JButton informationButton = createButton("Informacje", 400);

        levelButton.addActionListener(e -> showLevelSelection());
        controlsButton.addActionListener(e -> showControls());
        informationButton.addActionListener(e -> showInformation());

        frame.add(titleLabel);
        frame.add(levelButton);
        frame.add(controlsButton);
        frame.add(informationButton);

        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    private JButton createButton(String text, int yPosition) {
        JButton button = new JButton(text);
        button.setBounds(90, yPosition, 500, 100);
        button.setFont(new Font("Comic Sans", Font.BOLD, 30));
        button.setFocusable(false);
        return button;
    }

    public void showLevelSelection() {
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        JButton easyLevelButton = createButton("Łatwy", 50);
        JButton mediumLevelButton = createButton("Średni", 170);
        JButton hardLevelButton = createButton("Trudny", 290);
        JButton backButton = createButton("Powrót", 440);

        easyLevelButton.addActionListener(e -> showLevels("easy"));
        mediumLevelButton.addActionListener(e -> showLevels("medium"));
        hardLevelButton.addActionListener(e -> showLevels("hard"));
        backButton.addActionListener(e -> showMainMenu());

        frame.add(easyLevelButton);
        frame.add(mediumLevelButton);
        frame.add(hardLevelButton);
        frame.add(backButton);

        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    private void showLevels(String difficulty) {
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        for (int i = 1; i <= 4; i++) {
            JButton levelButton = createButton("Poziom " + i, 30 + (i - 1) * 110);
            int level = getLevel(difficulty, i);
            levelButton.addActionListener(e -> {
                this.game = new Game(level, frame);
                this.musicManager.stopSound();
            });
            frame.add(levelButton);
        }

        JButton backButton = createButton("Powrót", 475);
        backButton.addActionListener(e -> showLevelSelection());
        frame.add(backButton);

        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    private int getLevel(String difficulty, int level) {
        switch (difficulty) {
            case "easy":
                return level;
            case "medium":
                return level + 4;
            case "hard":
                return level + 8;
            default:
                throw new IllegalArgumentException("Invalid difficulty: " + difficulty);
        }
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

    public void levelCompletedMenu(int currentLevel, int moves){
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        JLabel informationLabel = new JLabel("Poziom ukończony w " + moves + " ruchach!");
        informationLabel.setFont(new Font("Comic Sans", Font.BOLD, 30));
        informationLabel.setBounds(90, 10, 500, 100);

        JLabel completedLabel = new JLabel("<html>Sterowanie:<br>W - Góra<br>A - Lewo<br>S - Dół<br>D - Prawo</html>");
        completedLabel.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        completedLabel.setBounds(90,45,500,300);

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
        frame.add(informationLabel);
        frame.add(completedLabel);
        frame.add(nextButton);

        frame.revalidate();
        frame.repaint();
    }

}