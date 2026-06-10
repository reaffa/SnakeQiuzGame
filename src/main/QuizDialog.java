package main;

import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;
import javax.swing.Timer;
import main.QuizQuestion;
import main.QuizStorage;

public class QuizDialog extends JDialog {
    QuizStorage QuizStorage = new QuizStorage();
    QuizQuestion QuizQuestion;
    boolean Result = false;
    private Timer Timer;
    int TimeLeft;
    private JLabel TimerLabel;

    public QuizDialog(JFrame parent, QuizQuestion QuizQuestion){
        super(parent, "Code challenge", true);
        this.setAlwaysOnTop(true);
        this.QuizQuestion = QuizQuestion;
        this.TimeLeft = QuizQuestion.getTimeLimit();

        setSize(1280, 720);
        setLayout(null);
        setLocationRelativeTo(parent);
        setUndecorated(true); // Removes the window border for a game-like look
        getContentPane().setBackground(new Color(0x0D244A));

        // DYNAMIC HEADING
        JLabel headingLabel = new JLabel(QuizQuestion.getHeading());
        headingLabel.setForeground(Color.WHITE);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 56));
        headingLabel.setBounds(0, 20, 1280, 100);
        headingLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(headingLabel);

        // DYNAMIC CODE SNIPPET
        JTextArea CodeArea = new JTextArea(QuizQuestion.getCodeSnippet());
        CodeArea.setFont(new Font("Consolas", Font.PLAIN, 18));
        CodeArea.setForeground(new Color(100, 255, 100)); // Bright terminal green
        CodeArea.setBackground(new Color(30, 30, 50));
        CodeArea.setBounds(100, 150, 1080, 400);
        CodeArea.setEditable(false);
        CodeArea.setMargin(new Insets(10,10,10,10)); // Padding inside the box
        add(CodeArea);

        // INPUT FIELD
        JTextField AnswerField = new JTextField();
        AnswerField.setFont(new Font("Consolas", Font.PLAIN, 36));
        AnswerField.setBounds(100, 550, 1080, 72);
        AnswerField.setHorizontalAlignment(SwingConstants.CENTER);
        add(AnswerField);

        // SUBMIT BUTTON
        JButton SubmitButton = new JButton("Submit Answer");
        SubmitButton.setBounds(150, 650, 200, 40);
        SubmitButton.setBackground(new Color(0, 150, 0));
        SubmitButton.setForeground(Color.WHITE);
        add(SubmitButton);

        // TIMER
        TimerLabel = new JLabel("Time: " + TimeLeft);
        TimerLabel.setForeground(Color.YELLOW);
        TimerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        TimerLabel.setBounds(380, 655, 100, 30);
        TimerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(TimerLabel);

        //
        SubmitButton.addActionListener(e -> {
            TimeLeft--;
            TimerLabel.setText("Time: " + TimeLeft);
            String Text = AnswerField.getText().trim();
            CheckAnswer(Text, QuizQuestion.getCorrectAnswer());
        });

        // --- COUNTDOWN TIMER ---
        Timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TimeLeft--;
                TimerLabel.setText(String.format("00:%02d", TimeLeft));

                if (TimeLeft <= 0) {
                    // TIME IS UP!
                    Result = false;
                    Timer.stop();
                    dispose(); // Close window
                }
            }
        });
        Timer.start();
    }
    private void CheckAnswer(String UserAnswer, String CorrectAnswer) {
        // Logic to check answer (Hardcoded for this example)
        if (UserAnswer.equalsIgnoreCase(CorrectAnswer)) {
            Result = true;
        } else {
            Result = false;
        }
        Timer.stop();
        dispose(); // Close the window
    }

    // This method lets GamePanel ask "Did they get it right?"
    public boolean getResult() {
        return Result;
    }

}
