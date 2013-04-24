import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class ContactsGUI extends JFrame {

	// Core variables
    private volatile Database store = new Database();
    // GUI components - Panels
    private JPanel basePane;
    private JPanel contactListCard;
    private JPanel contactCard;
    private JPanel addContactCard;
    // GUI components - Common variables
	private JButton addContactButton;
    private JButton backButton;
    private JPanel bottomPanel;
    private JLabel headerLabel;
    private JScrollPane lowerScrollPane;
    private JPanel topPanel;
    // GUI components - Add contact
    private JLabel firstNameLabel = new JLabel();
    private JTextField firstNameField = new JTextField();
    private JLabel lastNameLabel = new JLabel();
    private JTextField lastNameField = new JTextField();
    private JLabel emailLabel = new JLabel();
    private JTextField emailField = new JTextField();
    private JLabel mobileNoLabel = new JLabel();
    private JTextField mobileNoField = new JTextField();
    private JLabel homeNoLabel = new JLabel();
    private JTextField homeNoField = new JTextField();
    private JLabel otherNoLabel = new JLabel();
    private JTextField otherNoField = new JTextField();
    private JLabel addressLabel = new JLabel();
    private JTextField addressField = new JTextField();
    private JLabel otherInfoLabel = new JLabel();
    private JTextField otherInfoField = new JTextField();
	
	public ContactsGUI()
	{
		baseCard();
	}
	
	public static void main(String[] args)
	{
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ContactsGUI().setVisible(true);
            }
        });
	}
	
	private void showCard(String cardName)
	{
        CardLayout displayer = (CardLayout)(basePane.getLayout());
        getContentPane().validate();
     	basePane.revalidate();
        displayer.show(basePane, cardName);
     	basePane.revalidate();
        getContentPane().validate();
//        pack();
	}
	
	private void baseCard()
	{
        generateContacts(); // Trial contacts
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        // Contact list
        contactListCard = new javax.swing.JPanel();
        contactListCard.setLayout(new java.awt.GridBagLayout());
        // Contact
        contactCard = new javax.swing.JPanel();
        contactCard.setLayout(new java.awt.GridBagLayout());
        // Add contact
        addContactCard = new javax.swing.JPanel();
        addContactCard.setLayout(new java.awt.GridBagLayout());
        // Base
		basePane = new javax.swing.JPanel();
        basePane.setLayout(new java.awt.CardLayout());
        // ADD GENERIC CARDS HERE
        contactListCard();
        basePane.add(contactListCard, "ContactList");
        addContactCard();
        basePane.add(addContactCard, "AddContact");
        getContentPane().setLayout(new java.awt.GridLayout());
        getContentPane().add(basePane);
        showCard("ContactList");
        pack();
	}
	
	private void contactListCard() 
	{
        java.awt.GridBagConstraints gridBagConstraints;
        
        // Top bar
        topPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        addContactButton = new javax.swing.JButton();
        headerLabel = new javax.swing.JLabel();
        lowerScrollPane = new javax.swing.JScrollPane();
        bottomPanel = new javax.swing.JPanel();

        topPanel.setPreferredSize(new java.awt.Dimension(240, 50));
        topPanel.setLayout(new java.awt.GridBagLayout());

        backButton.setText("<");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToMainActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 11, 0);
        topPanel.add(backButton, gridBagConstraints);

        addContactButton.setText("+");
        addContactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addContactActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 46, 11, 0);
        topPanel.add(addContactButton, gridBagConstraints);

        headerLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        headerLabel.setText("Contacts");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 33, 0, 0);
        topPanel.add(headerLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        contactListCard.add(topPanel, gridBagConstraints);

        // Bottom window
        lowerScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        lowerScrollPane.setPreferredSize(new java.awt.Dimension(240, 250));
        
        bottomPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        bottomPanel.setLayout(new java.awt.GridBagLayout());
        bottomPanel.setMaximumSize(new java.awt.Dimension(240, 250));
        
        // Fill bottom window with contacts
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
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        contactListCard.add(lowerScrollPane, gridBagConstraints);
	}

	private void contactCard(Contact person, String contactIndex)
	{
		java.awt.GridBagConstraints gridBagConstraints;
        
		JLabel contactLabel;
		JButton deleteContactButton;
		
        // Top bar
        topPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        deleteContactButton = new javax.swing.JButton();
        contactLabel = new javax.swing.JLabel();
        lowerScrollPane = new javax.swing.JScrollPane();
        bottomPanel = new javax.swing.JPanel();

        topPanel.setPreferredSize(new java.awt.Dimension(240, 50));
        topPanel.setLayout(new java.awt.GridBagLayout());

        backButton.setText("<");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToContactsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 11, 0);
        topPanel.add(backButton, gridBagConstraints);

        deleteContactButton.setText("-");
        deleteContactButton.setActionCommand(contactIndex);
        deleteContactButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteContactActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 46, 11, 0);
        topPanel.add(deleteContactButton, gridBagConstraints);

        contactLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        contactLabel.setText("Contact");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 33, 0, 0);
        topPanel.add(contactLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        contactCard.add(topPanel, gridBagConstraints);

        // Bottom window
        lowerScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        lowerScrollPane.setPreferredSize(new java.awt.Dimension(240, 250));
        
        bottomPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        bottomPanel.setLayout(new java.awt.GridLayout(0, 2));
        bottomPanel.setMaximumSize(new java.awt.Dimension(240, 250));
        
        // Make and populate fields
        JLabel firstNameLabel = new JLabel();
        firstNameLabel.setText("Firstname");
        bottomPanel.add(firstNameLabel);
        JLabel firstNameContainer = new JLabel();
        firstNameContainer.setText(person.getFirstName());
        bottomPanel.add(firstNameContainer);
        JLabel lastNameLabel = new JLabel();
        lastNameLabel.setText("Lastname");
        bottomPanel.add(lastNameLabel);
        JLabel lastNameContainer = new JLabel();
        lastNameContainer.setText(person.getLastName());
        bottomPanel.add(lastNameContainer);
        JLabel emailLabel = new JLabel();
        emailLabel.setText("E-mail");
        bottomPanel.add(emailLabel);
        JLabel emailContainer = new JLabel();
        emailContainer.setText(person.getEmailAddress());
        bottomPanel.add(emailContainer);
        JLabel mobileNoLabel = new JLabel();
       	mobileNoLabel.setText("Mobile number");
        bottomPanel.add(mobileNoLabel);
        JLabel mobileNoContainer = new JLabel();
        mobileNoContainer.setText(person.getPhoneNumber("Mobile"));
        bottomPanel.add(mobileNoContainer);
        JLabel homeNoLabel = new JLabel();
        homeNoLabel.setText("Home number");
        bottomPanel.add(homeNoLabel);
        JLabel homeNoContainer = new JLabel();
      	homeNoContainer.setText(person.getPhoneNumber("Home"));
        bottomPanel.add(homeNoContainer);
        JLabel otherNoLabel = new JLabel();
        otherNoLabel.setText("Other number");
        bottomPanel.add(otherNoLabel);
        JLabel otherNoContainer = new JLabel();
        otherNoContainer.setText(person.getPhoneNumber("Other"));
        bottomPanel.add(otherNoContainer);
        JLabel addressLabel = new JLabel();
        addressLabel.setText("Address");
        bottomPanel.add(addressLabel);
        JLabel addressContainer = new JLabel();
        addressContainer.setText(person.getHomeAddress());
        bottomPanel.add(addressContainer);
        JLabel otherInfoLabel = new JLabel();
        otherInfoLabel.setText("Other info");
        bottomPanel.add(otherInfoLabel);
        JLabel otherInfoContainer = new JLabel();
        otherInfoContainer.setText(person.getExtraInfo());
        bottomPanel.add(otherInfoContainer);
        
        lowerScrollPane.setViewportView(bottomPanel);
		gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        contactCard.add(lowerScrollPane, gridBagConstraints);
        
        basePane.remove(contactCard);
        basePane.validate();
        basePane.add(contactCard, "Contact");
        basePane.revalidate();
        showCard("Contact");
	}

	private void addContactCard()
	{
		java.awt.GridBagConstraints gridBagConstraints;

		JButton addConfirmButton;
		
        // Top bar
        topPanel = new javax.swing.JPanel();
        backButton = new javax.swing.JButton();
        addConfirmButton = new javax.swing.JButton();
        headerLabel = new javax.swing.JLabel();
        lowerScrollPane = new javax.swing.JScrollPane();
        bottomPanel = new javax.swing.JPanel();

        topPanel.setPreferredSize(new java.awt.Dimension(240, 50));
        topPanel.setLayout(new java.awt.GridBagLayout());

        backButton.setText("<");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backToContactsActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 0, 11, 0);
        topPanel.add(backButton, gridBagConstraints);

        addConfirmButton.setText("+");
        addConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addConfirmActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 46, 11, 0);
        topPanel.add(addConfirmButton, gridBagConstraints);
        
        headerLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        headerLabel.setText("Add contact");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 33, 0, 0);
        topPanel.add(headerLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        addContactCard.add(topPanel, gridBagConstraints);

        // Bottom window
        lowerScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        lowerScrollPane.setPreferredSize(new java.awt.Dimension(240, 250));
        
        bottomPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(4, 4, 4, 4));
        bottomPanel.setLayout(new java.awt.GridLayout(0, 2));
        bottomPanel.setMaximumSize(new java.awt.Dimension(240, 250));
        
        // Makes fields
        firstNameLabel.setText("Firstname");
        bottomPanel.add(firstNameLabel);
        bottomPanel.add(firstNameField);
        lastNameLabel.setText("Lastname");
        bottomPanel.add(lastNameLabel);
        bottomPanel.add(lastNameField);
        emailLabel.setText("E-mail");
        bottomPanel.add(emailLabel);
        bottomPanel.add(emailField);
       	mobileNoLabel.setText("Mobile number");
        bottomPanel.add(mobileNoLabel);
        bottomPanel.add(mobileNoField);
        homeNoLabel.setText("Home number");
        bottomPanel.add(homeNoLabel);
        bottomPanel.add(homeNoField);
        otherNoLabel.setText("Other number");
        bottomPanel.add(otherNoLabel);
        bottomPanel.add(otherNoField);
        addressLabel.setText("Address");
        bottomPanel.add(addressLabel);
        bottomPanel.add(addressField);
        otherInfoLabel.setText("Other info");
        bottomPanel.add(otherInfoLabel);
        bottomPanel.add(otherInfoField);
        
        lowerScrollPane.setViewportView(bottomPanel);
		gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        addContactCard.add(lowerScrollPane, gridBagConstraints);
	}

	private void generateContacts()
	{
		store.addContact("Jack", "Colquitt");
		store.addContact("Fred", "Claus");
		store.addContact("Easter", "Bunny");
		store.addContact("Carry", "French");
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

	// Contact list methods
	
	/**
	 * Moves from the contact list to the request contact
	 * @param evt
	 */
	private void goToContactActionPerformed(java.awt.event.ActionEvent evt) 
	{                                         
        String contactIndexString = evt.getActionCommand();
        int contactIndex = Integer.parseInt(contactIndexString);
        Contact requestedContact = store.getContact(contactIndex);
        contactCard(requestedContact, contactIndexString);
	}
	
	private void addContactActionPerformed(ActionEvent evt) 
	{
        addContactCard();
        basePane.add(addContactCard, "AddContact");
		showCard("AddContact");
	}

	private void backToMainActionPerformed(ActionEvent evt) 
	{
		
	}
	
	// Contact methods
	
	/**
	 * Moves from a particular contact page to the contact list
	 * @param evt
	 */
	private void backToContactsActionPerformed(ActionEvent evt) 
	{
		basePane.removeAll();
		contactListCard();
		basePane.add(contactListCard, "ContactList");
		showCard("ContactList");
	}
	
	private void deleteContactActionPerformed(ActionEvent evt) 
	{
		String contactIndexString = evt.getActionCommand();
		int contactIndex = Integer.parseInt(contactIndexString);
		store.deleteContact(contactIndex);
		basePane.removeAll();
		contactListCard();
		basePane.add(contactListCard, "ContactList");
		showCard("ContactList");
	}
	
	// Add contact methods
	
	private void addConfirmActionPerformed(ActionEvent evt)
	{
		boolean passed = true;
		System.out.println("Adding a contact");
		String firstName = firstNameField.getText();
		String lastName = lastNameField.getText();
		String email = emailField.getText();
		String mobileNo = mobileNoField.getText();
		String homeNo = homeNoField.getText();
		String otherNo = otherNoField.getText();
		String address = addressField.getText();
		String otherInfo = otherInfoField.getText();
		Contact newContact = null;
		try {
			newContact = new Contact(firstName, lastName, email, address, otherInfo);
			newContact.addPhoneNumber(mobileNo, "Mobile");
			newContact.addPhoneNumber(homeNo, "Home");
			newContact.addPhoneNumber(otherNo, "Other");
		} catch (Exception e)
		{
			passed = false;
		}
		if (passed)
		{
			store.addContact(newContact);
			contactListCard(); // Regenerate with new contact added
			showCard("ContactList");
		} else {
			headerLabel.setText("FAIL");
		}
	}
	
}
