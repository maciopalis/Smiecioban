import javax.swing.*;
import java.awt.*;

public class Menus extends JFrame {
    public Game game;
    private JFrame frame;
    private MusicManager musicManager;

    public Menus(JFrame frame) {
        this.musicManager = new MusicManager();
        this.frame = frame;
        this.game = game;
        showMainMenu();
        this.musicManager.playMainMenuMusic();
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
        frame.setLayout(null);

        JButton easyLevelButton = new JButton("Łatwy");
        easyLevelButton.setBounds(90,50,500,100);
        easyLevelButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        easyLevelButton.setFocusable(false);

        JButton mediumLevelButton = new JButton("Średni");
        mediumLevelButton.setBounds(90,170,500,100);
        mediumLevelButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        mediumLevelButton.setFocusable(false);

        JButton hardLevelButton = new JButton("Trundny");
        hardLevelButton.setBounds(90,290,500,100);
        hardLevelButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        hardLevelButton.setFocusable(false);

        JButton backButton = new JButton("Powrót");
        backButton.setBounds(90,440,500,100);
        backButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        backButton.setFocusable(false);
        backButton.addActionListener(e -> showMainMenu());

        easyLevelButton.addActionListener(e -> showLevelsEasy());
        mediumLevelButton.addActionListener(e -> showLevelsMedium());
        hardLevelButton.addActionListener(e -> showLevelsHard());
        backButton.addActionListener(e -> showMainMenu());

        frame.add(easyLevelButton);
        frame.add(mediumLevelButton);
        frame.add(hardLevelButton);
        frame.add(backButton);
        //pack();
        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    public void showLevelsEasy(){
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        JButton easyLevel1Button = new JButton("Poziom 1");
        easyLevel1Button.setBounds(90,30,500,100);
        easyLevel1Button.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        easyLevel1Button.setFocusable(false);

        JButton easyLevel2Button = new JButton("Poziom 2");
        easyLevel2Button.setBounds(90,140,500,100);
        easyLevel2Button.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        easyLevel2Button.setFocusable(false);

        JButton easyLevel3Button = new JButton("Poziom 3");
        easyLevel3Button.setBounds(90,250,500,100);
        easyLevel3Button.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        easyLevel3Button.setFocusable(false);

        JButton easyLevel4Button = new JButton("Poziom 4");
        easyLevel4Button.setBounds(90,360,500,100);
        easyLevel4Button.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        easyLevel4Button.setFocusable(false);

        JButton backButton = new JButton("Powrót");
        backButton.setBounds(90,475,500,100);
        backButton.setFont(new Font(("Comic Sans"), Font.BOLD, 30));
        backButton.setFocusable(false);
        backButton.addActionListener(e -> showMainMenu());

        easyLevel1Button.addActionListener(e -> {
            this.game = new Game(1, frame);
            this.musicManager.stopSound();
        });
        easyLevel2Button.addActionListener(e -> {
            this.game = new Game(2, frame);
            this.musicManager.stopSound();
        });
        easyLevel3Button.addActionListener(e -> {
            this.game = new Game(3, frame);
            this.musicManager.stopSound();
        });
        easyLevel4Button.addActionListener(e -> {
            this.game = new Game(4, frame);
            this.musicManager.stopSound();
        });
        backButton.addActionListener(e -> showMainMenu());

        frame.add(easyLevel1Button);
        frame.add(easyLevel2Button);
        frame.add(easyLevel3Button);
        frame.add(easyLevel4Button);
        frame.add(backButton);

        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    public void showLevelsMedium(){
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        JButton mediumLevel1Button = new JButton("Poziom 1");
        mediumLevel1Button.setBounds(90, 30, 500, 100);
        mediumLevel1Button.setFont(new Font("Comic Sans", Font.BOLD, 30));
        mediumLevel1Button.setFocusable(false);

        JButton mediumLevel2Button = new JButton("Poziom 2");
        mediumLevel2Button.setBounds(90, 140, 500, 100);
        mediumLevel2Button.setFont(new Font("Comic Sans", Font.BOLD, 30));
        mediumLevel2Button.setFocusable(false);

        JButton mediumLevel3Button = new JButton("Poziom 3");
        mediumLevel3Button.setBounds(90, 250, 500, 100);
        mediumLevel3Button.setFont(new Font("Comic Sans", Font.BOLD, 30));
        mediumLevel3Button.setFocusable(false);

        JButton mediumLevel4Button = new JButton("Poziom 4");
        mediumLevel4Button.setBounds(90, 360, 500, 100);
        mediumLevel4Button.setFont(new Font("Comic Sans", Font.BOLD, 30));
        mediumLevel4Button.setFocusable(false);

        JButton backButton = new JButton("Powrót");
        backButton.setBounds(90, 475, 500, 100);
        backButton.setFont(new Font("Comic Sans", Font.BOLD, 30));
        backButton.setFocusable(false);
        backButton.addActionListener(e -> showLevelSelection());


        mediumLevel1Button.addActionListener(e -> {
            this.game = new Game(5, frame);
            this.musicManager.stopSound();
        });
        mediumLevel2Button.addActionListener(e -> {
            this.game = new Game(6, frame);
            this.musicManager.stopSound();
        });
        mediumLevel3Button.addActionListener(e -> {
            this.game = new Game(7, frame);
            this.musicManager.stopSound();
        });
        mediumLevel4Button.addActionListener(e -> {
            this.game = new Game(8, frame);
            this.musicManager.stopSound();
        });
        backButton.addActionListener(e -> showLevelSelection());


        frame.add(mediumLevel1Button);
        frame.add(mediumLevel2Button);
        frame.add(mediumLevel3Button);
        frame.add(mediumLevel4Button);
        frame.add(backButton);

        frame.setVisible(true);
        frame.revalidate();
        frame.repaint();
    }

    public void showLevelsHard(){
        frame.getContentPane().removeAll();
        frame.setLayout(null);

        JButton hardLevel1Button = new JButton("Poziom 1");
        hardLevel1Button.setBounds(90, 30, 500, 100);
        hardLevel1Button.setFont(new Font("Comic Sans", Font.BOLD, 30));
        hardLevel1Button.setFocusable(false);

        JButton hardLevel2Button = new JButton("Poziom 2");
        hardLevel2Button.setBounds(90, 140, 500, 100);
        hardLevel2Button.setFont(new Font("Comic Sans", Font.BOLD, 30));
        hardLevel2Button.setFocusable(false);

        JButton hardLevel3Button = new JButton("Poziom 3");
        hardLevel3Button.setBounds(90, 250, 500, 100);
        hardLevel3Button.setFont(new Font("Comic Sans", Font.BOLD, 30));
        hardLevel3Button.setFocusable(false);

        JButton hardLevel4Button = new JButton("Poziom 4");
        hardLevel4Button.setBounds(90, 360, 500, 100);
        hardLevel4Button.setFont(new Font("Comic Sans", Font.BOLD, 30));
        hardLevel4Button.setFocusable(false);

        JButton backButton = new JButton("Powrót");
        backButton.setBounds(90, 475, 500, 100);
        backButton.setFont(new Font("Comic Sans", Font.BOLD, 30));
        backButton.setFocusable(false);
        backButton.addActionListener(e -> showLevelSelection());

        hardLevel1Button.addActionListener(e -> {
            this.game = new Game(9, frame);
            this.musicManager.stopSound();
        });
        hardLevel2Button.addActionListener(e -> {
            this.game = new Game(10, frame);
            this.musicManager.stopSound();
        });
        hardLevel3Button.addActionListener(e -> {
            this.game = new Game(11, frame);
            this.musicManager.stopSound();
        });
        hardLevel4Button.addActionListener(e -> {
            this.game = new Game(12, frame);
            this.musicManager.stopSound();
        });
        backButton.addActionListener(e -> showLevelSelection());

        frame.add(hardLevel1Button);
        frame.add(hardLevel2Button);
        frame.add(hardLevel3Button);
        frame.add(hardLevel4Button);
        frame.add(backButton);

        frame.setVisible(true);
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