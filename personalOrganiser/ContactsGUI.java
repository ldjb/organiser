package personalOrganiser;

import java.awt.GridBagConstraints;
import javax.swing.*;

public class ContactsGUI extends JFrame {

	// Core variables
	
	
    // GUI components
    private JButton addContactButton;
    private JButton backButton;
    private JPanel bottomPanel;
    private JLabel contactsListLabel;
    private JScrollPane lowerScrollPane;
    private JPanel topPanel;
    private Database store = new Database();
	
	public ContactsGUI()
	{
		initComponents();
		generateContacts();
		populateList();
	}
	
	public static void main(String[] args)
	{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContactsGUI().setVisible(true);
            }
        });
	}
	
	private void initComponents() 
	{
        java.awt.GridBagConstraints gridBagConstraints;

        topPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        addContactButton = new javax.swing.JButton();
        contactsListLabel = new javax.swing.JLabel();
        lowerScrollPane = new javax.swing.JScrollPane();
        bottomPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        topPanel.setPreferredSize(new java.awt.Dimension(240, 50));
        topPanel.setLayout(new java.awt.GridBagLayout());

        backButton.setText("<");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 11, 0);
        topPanel.add(backButton, gridBagConstraints);

        addContactButton.setText("+");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 46, 11, 0);
        topPanel.add(addContactButton, gridBagConstraints);

        contactsListLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        contactsListLabel.setText("Contacts");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 33, 0, 0);
        topPanel.add(contactsListLabel, gridBagConstraints);

        getContentPane().add(topPanel, new java.awt.GridBagConstraints());

        lowerScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        lowerScrollPane.setPreferredSize(new java.awt.Dimension(240, 250));
        
        bottomPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        bottomPanel.setLayout(new java.awt.GridBagLayout());
        bottomPanel.setMaximumSize(new java.awt.Dimension(240, 250));
	}
	
	private void generateContacts()
	{
		store.addContact("Jack", "Colquitt");
		store.addContact("Fred", "Claus");
		store.addContact("Easter", "Bunny");
		store.addContact("Rosie", "Jones");
		store.addContact("Francis", "Bacon");
		store.addContact("Francis", "Bacon");
		store.addContact("Francis", "Bacon");
		store.addContact("Francis", "Bacon");
		store.addContact("Francis", "Bacon");
		store.addContact("Francis", "Bacon");
		store.addContact("Francis", "Bacon");
		store.addContact("Francis", "Bacon");
		store.addContact("Francis", "Bacon");
		store.addContact("Francis", "Bacon");
		store.addContact("Francis", "Bacon");
		store.addContact("Francis", "Bacon");
		store.addContact("Easter", "Bunny");
		store.addContact("Rosie", "Jones");
		store.addContact("Me","");
		store.addContact("Tedd", "Baker");
		store.addContact("Mr.", "Happy");
	}
	
	private void populateList()
	{
        java.awt.GridBagConstraints gridBagConstraints;
        int storeSize = store.getContactsSize();
		int gridY = 0;
		if (storeSize == 0)
		{
			System.out.println("No contacts yet.");
		} else {
			for (int i = 0; i < storeSize; i++)
			{
		        System.out.println("Looping :::" + gridY + ":::");
				gridBagConstraints = new java.awt.GridBagConstraints();
		        gridBagConstraints.gridy = gridY;
		        gridBagConstraints.weightx = 1;
		        gridBagConstraints.weighty = 1;
		        gridBagConstraints.fill = GridBagConstraints.BOTH;
				Contact next = store.getContact(i);
				String nextFirstName = next.getFirstName();
				String nextLastName = next.getLastName();
				String fullName = nextFirstName + " " + nextLastName;
			    JLabel nameTag = new JLabel();
			    nameTag.setText(fullName);
			    bottomPanel.add(nameTag, gridBagConstraints);
			    gridBagConstraints.gridx = 1;
			    JButton goToContact = new JButton();
			    final int buttonNumber = i;
			    String buttonNumberString = Integer.toString(i);
			    goToContact.setActionCommand(buttonNumberString);
		        goToContact.addActionListener(new java.awt.event.ActionListener() {
		            public void actionPerformed(java.awt.event.ActionEvent evt) {
		                goToContactActionPerformed(evt);
		            }
		        });
			    goToContact.setText("View");
			    bottomPanel.add(goToContact, gridBagConstraints);
			    gridY++;
			}
		}
		lowerScrollPane.setViewportView(bottomPanel);
		gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        getContentPane().add(lowerScrollPane, gridBagConstraints);
        pack();
	}
	
	  private void goToContactActionPerformed(java.awt.event.ActionEvent evt) {                                         
	        String contactIndexString = evt.getActionCommand();
	        int contactIndex = Integer.parseInt(contactIndexString);
	        System.out.println("Button " + contactIndex);
	    }     
}
