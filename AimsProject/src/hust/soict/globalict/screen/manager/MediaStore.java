package hust.soict.globalict.screen.manager;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.disc.Playable;

import javax.swing.*;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 15));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(e -> playMedia());
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(Box.createVerticalGlue());
        this.add(container);
        this.add(Box.createVerticalGlue());
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    private void playMedia() {
        if (media instanceof Playable) {
            JDialog playDialog = new JDialog();
            playDialog.setTitle("Playing: " + media.getTitle());
            playDialog.setSize(300, 200);
            playDialog.setLocationRelativeTo(null);
            JTextArea textArea = new JTextArea("Playing: " + media.getTitle());
            textArea.setEditable(false);
            playDialog.add(textArea);
            playDialog.setVisible(true);
        }
    }
}
