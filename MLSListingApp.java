import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.*;
import java.nio.file.*;
import java.nio.file.AccessMode.*;
import java.io.*;

public class MLSListingApp {
    public static void main(String[] args) {
        PropertyList listOfProperties = new PropertyList();
        listOfProperties.initialize();

        EventQueue.invokeLater(new Runnable()
        {
            public void run() {
                MLSListingView mlsView = new MLSListingView();
                mlsView.setProperties(listOfProperties);
                mlsView.setVisible(true);
                mlsView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}
