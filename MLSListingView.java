import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class MLSListingView extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    private static final int viewWidth = 720;
    private static final int viewHeight = 450;
    private static final int listingRows = 20;
    private static final int listingColumns = 60;

    private PropertyList propertyList;

    private JTextArea listings;
    private JScrollPane scroll;

    private JLabel searchPropLabel;
    private JComboBox<String> priceComboBox;
    private JButton goButton;


    private JButton showAllButton;
    private JButton showSFHButton;
    private JButton showCondoButton;
    private JButton clearButton;
    
    public MLSListingView() {
        setTitle("MLSListings");
        setSize(MLSListingView.viewWidth, MLSListingView.viewHeight);
        setLocationRelativeTo(null);

        JPanel searchPanel = new JPanel();
        JPanel displayPanel = new JPanel();
        JPanel actionPanel = new JPanel();

        // Setting up searchPanel
        searchPropLabel = new JLabel("Search Property:");
        priceComboBox = new JComboBox<String>();
        priceComboBox.addItem("Under 400K");
        priceComboBox.addItem("400K-600K");
        priceComboBox.addItem("600K-800K");
        priceComboBox.addItem("800K-1M");
        priceComboBox.addItem("1M or more");
        goButton = new JButton("Go");
        goButton.addActionListener(this);

        searchPanel.add(searchPropLabel);
        searchPanel.add(priceComboBox);
        searchPanel.add(goButton);

        // Setting up displayPanel
        listings = new JTextArea(MLSListingView.listingRows, MLSListingView.listingColumns);
        listings.setBorder(BorderFactory.createEtchedBorder());
        scroll = new JScrollPane(listings);
        displayPanel.add(scroll);
        
        // Setting up actionPanel
        showAllButton = new JButton("Show All");
        showSFHButton = new JButton("Show SFH");
        showCondoButton = new JButton("Show Condo");
        clearButton = new JButton("Clear");

        showAllButton.addActionListener(this);
        showSFHButton.addActionListener(this);
        showCondoButton.addActionListener(this);
        clearButton.addActionListener(this);

        actionPanel.add(showAllButton);
        actionPanel.add(showSFHButton);
        actionPanel.add(showCondoButton);
        actionPanel.add(clearButton);

        add(searchPanel, BorderLayout.NORTH);
        add(displayPanel, BorderLayout.CENTER);
        add(actionPanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String header = "Address\t\t\tPrice\tYear\tOther Info\n";

        if (source == showAllButton) {
            listings.setText(
                header +
                this.propertyList.getAllProperties());
        } else if (source == clearButton) {
            listings.setText("");
        } else if (source == showSFHButton) {
            listings.setText(
                header +
                this.propertyList.getSingleFamilyHouse());
        } else if (source == showCondoButton) {
            listings.setText(
                header +
                this.propertyList.getCondo());
        } else if (source == goButton) {
            int posOfPriceRange = priceComboBox.getSelectedIndex();

            if (posOfPriceRange == 0) {
                listings.setText(
                    header +
                    this.propertyList.searchByPriceRange(0.0, 400000.0));
            } else if (posOfPriceRange == 1) {
                listings.setText(
                    header +
                    this.propertyList.searchByPriceRange(400000.0, 600000.0));
            } else if (posOfPriceRange == 2) {
                listings.setText(
                    header +
                    this.propertyList.searchByPriceRange(600000.0, 800000.0));
            } else if (posOfPriceRange == 3) {
                listings.setText(
                    header +
                    this.propertyList.searchByPriceRange(800000.0, 1000000.0));
            } else {
                listings.setText(
                    header +
                    this.propertyList.searchByPriceRange(1000000.0, 9999999.0));
            }
        }
    }

    void setProperties(PropertyList propertyList) {
        if (propertyList == null) {
            System.out.println("Failed to set property list to view");
        } else {
            this.propertyList = propertyList;
        }
    }
}