import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;

public class MedicalSystem extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JButton registerButton;
    private Map<String, String> userDatabase;
    private Map<String, String> diseaseSymptoms;
    private Map<String, String> diseaseCauses;
    private Map<String, String> diseasePrevention;

    public MedicalSystem() {
        setTitle("Medical System");
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize to fullscreen
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        userDatabase = new HashMap<>();
        diseaseSymptoms = new HashMap<>();
        diseaseCauses = new HashMap<>();
        diseasePrevention = new HashMap<>();

        // Store disease, symptoms, causes, and prevention
        diseaseSymptoms.put("allergy", "Eye irritation, Runny nose, Stuffy nose, Puffy, watery eyes, Sneezing, Inflamed, itchy nose and throat");
        diseaseCauses.put("allergy", "Foods (nuts, eggs, milk, soy, shellfish, wheat), Pollen, Mold, Latex, Pet dander");
        diseasePrevention.put("allergy", "Avoid the outdoors between 5-10 a.m. and save outside activities for late afternoon or after a heavy rain, when pollen levels are lower.\n" +
                "Keep windows in your living spaces closed to lower exposure to pollen.\n" +
                "To keep cool, use air conditioners and avoid using window and attic fans.\n" +
                "Wear a medical alert bracelet or other means to communicate to others about your allergy in case of a reaction.\n" +
                "Discuss a prescription for epinephrine (e.g., EpiPen) with your healthcare provider, if you have risk of serious allergic reaction.\n" +
                "Review product labels carefully before buying or consuming any item.\n" +
                "Know what you are eating or drinking.");

        // Add information for headache disease
        diseaseSymptoms.put("headache", "Pulsing or throbbing quality, Begins with intense pain on one side of the head, which eventually spreads, Felt on one or both sides of the head");
        diseaseCauses.put("headache", "Emotional and physical stress, Fatigue, Irregular sleep habits (sleeping too much or too little), Skipping meals");
        diseasePrevention.put("headache", "Be aware of early symptoms so you can try to stop the headache as soon as it begins.\n" +
                "Don’t smoke, and if you do, quit.\n" +
                "Don’t skip meals.");

        // Add information for fever disease
        diseaseSymptoms.put("fever", "Fever (100° F), Headache, More intense pain and fatigue, More severe, often dry cough.");
        diseaseCauses.put("fever", "Viral infections, Bacterial infections, Heat exhaustion, Certain inflammatory conditions.");
        diseasePrevention.put("fever", "Wash your hands often. Keep them away from your nose, eyes, and mouth. Use an instant hand sanitizer when you can’t wash your hands.\n" +
                "Get regular exercise and eat well.\n" +
                "Follow good sleep habits.\n" +
                "Get a flu shot each fall.");

        // Add information for conjunctivitis disease
        diseaseSymptoms.put("conjunctivitis", "Redness, Itching, Tearing, Burning sensation, Pus-like discharge, Crusting of the eyelids.");
        diseaseCauses.put("conjunctivitis", "Bacterial or viral infection, Allergic reaction to pollen or animal dander, Chemical irritants.");
        diseasePrevention.put("conjunctivitis", "Wash your hands frequently. Avoid touching your eyes. Wash anything that may be contaminated.");

        // Add information for cold disease
        diseaseSymptoms.put("cold", "Sneezing, Coughing, Runny nose, Sore throat, Congestion, Slight body aches, Low-grade fever.");
        diseaseCauses.put("cold", "Viruses, Close contact with infected individuals, Touching contaminated surfaces, Weak immune system.");
        diseasePrevention.put("cold", "Wash your hands often. Avoid close contact with sick individuals. Disinfect frequently-touched surfaces. Maintain a healthy lifestyle.");

        // Add information for asthma disease
        diseaseSymptoms.put("asthma", "Shortness of breath, Chest tightness, Wheezing, Coughing, Difficulty breathing.");
        diseaseCauses.put("asthma", "Airborne allergens, Respiratory infections, Physical activity, Cold air, Air pollutants.");
        diseasePrevention.put("asthma", "Avoid asthma triggers. Take prescribed medications regularly. Monitor your breathing. Maintain a healthy weight.");

        // Add information for diabetes disease
        diseaseSymptoms.put("diabetes", "Increased thirst, Frequent urination, Extreme hunger, Unexplained weight loss, Fatigue, Blurred vision.");
        diseaseCauses.put("diabetes", "Genetic factors, Obesity, Physical inactivity, Poor diet, Age.");
        diseasePrevention.put("diabetes", "Maintain a healthy diet. Exercise regularly. Monitor blood sugar levels. Avoid smoking. Manage stress.");

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(224, 255, 255));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Padding

        Font font = new Font("Times New Roman", Font.PLAIN, 18); // Set font style
        Color textColor = new Color(0, 102, 204); // Set text color

        JLabel titleLabel = new JLabel("Welcome to the Medical System");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 28));
        titleLabel.setForeground(new Color(0, 153, 153));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        gbc.gridwidth = 1; // Reset gridwidth

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(font);
        usernameLabel.setForeground(textColor);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(usernameLabel, gbc);

        usernameField = new JTextField(15);
        usernameField.setFont(font);
        usernameField.setBorder(new LineBorder(new Color(0, 102, 204), 2));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(font);
        passwordLabel.setForeground(textColor);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(passwordLabel, gbc);

        passwordField = new JPasswordField(15);
        passwordField.setFont(font);
        passwordField.setBorder(new LineBorder(new Color(0, 102, 204), 2));
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(passwordField, gbc);

        loginButton = new JButton("Login");
        loginButton.setFont(font);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBackground(new Color(84, 255, 159)); // Set button background color
        loginButton.setBorder(new LineBorder(Color.GREEN, 2, true)); // Rounded border
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(loginButton, gbc);

        registerButton = new JButton("Register");
        registerButton.setFont(font);
        registerButton.setForeground(Color.WHITE);
        registerButton.setBackground(new Color(84, 255, 159)); // Set button background color
        registerButton.setBorder(new LineBorder(Color.GREEN, 2, true)); // Rounded border
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(registerButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticateUser(username, password)) {
                    String[] options = {"Online Treatment", "Offline Treatment"};
                    int choice = JOptionPane.showOptionDialog(MedicalSystem.this,
                            "Choose your treatment type:", "Treatment Type", JOptionPane.DEFAULT_OPTION,
                            JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                    if (choice == 0) {
                        handleOnlineTreatment();
                    } else if (choice == 1) {
                        // Redirect to DoctorSearchGUI
                        SwingUtilities.invokeLater(() -> {
                            DoctorSearchGUI doctorSearchGUI = new DoctorSearchGUI();
                            doctorSearchGUI.setVisible(true);
                        });
                    }
                } else {
                    JOptionPane.showMessageDialog(MedicalSystem.this, "Invalid Username or Password",
                            "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (userDatabase.containsKey(username)) {
                    JOptionPane.showMessageDialog(MedicalSystem.this,
                            "Username already exists. Please choose a different username.", "Registration Error",
                            JOptionPane.ERROR_MESSAGE);
                } else if (!isValidPassword(password)) {
                    JOptionPane.showMessageDialog(MedicalSystem.this,
                            "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character.", "Registration Error",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    userDatabase.put(username, password);
                    JOptionPane.showMessageDialog(MedicalSystem.this, "Registration Successful! You can now login.");
                }
            }
        });

        add(panel);
        pack(); // Pack the frame to fit the components
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    private boolean authenticateUser(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }

    private boolean isValidPassword(String password) {
        String passwordPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
        return Pattern.compile(passwordPattern).matcher(password).matches();
    }

    private void handleOnlineTreatment() {
        JPanel symptomPanel = new JPanel(new GridLayout(0, 1));
        symptomPanel.add(new JLabel("Enter Symptom 1:"));
        JTextField symptomField1 = new JTextField(15);
        symptomPanel.add(symptomField1);
        symptomPanel.add(new JLabel("Enter Symptom 2:"));
        JTextField symptomField2 = new JTextField(15);
        symptomPanel.add(symptomField2);
        symptomPanel.add(new JLabel("Enter Symptom 3:"));
        JTextField symptomField3 = new JTextField(15);
        symptomPanel.add(symptomField3);

        int result = JOptionPane.showConfirmDialog(this, symptomPanel, "Enter Symptoms",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String symptom1 = symptomField1.getText().trim();
            String symptom2 = symptomField2.getText().trim();
            String symptom3 = symptomField3.getText().trim();

            if (!symptom1.isEmpty() && !symptom2.isEmpty() && !symptom3.isEmpty()) {
                String predictedDisease = null;
                for (Map.Entry<String, String> entry : diseaseSymptoms.entrySet()) {
                    String[] symptomsArray = entry.getValue().toLowerCase().split(", ");
                    if (symptomsArray.length >= 3) {
                        boolean match1 = false, match2 = false, match3 = false;
                        for (String symptom : symptomsArray) {
                            if (symptom.contains(symptom1.toLowerCase())) {
                                match1 = true;
                            }
                            if (symptom.contains(symptom2.toLowerCase())) {
                                match2 = true;
                            }
                            if (symptom.contains(symptom3.toLowerCase())) {
                                match3 = true;
                            }
                        }
                        if (match1 && match2 && match3) {
                            predictedDisease = entry.getKey();
                            break;
                        }
                    }
                }

                if (predictedDisease != null) {
                    JOptionPane.showMessageDialog(MedicalSystem.this,
                            "Predicted Disease: " + predictedDisease + "\n" +
                                    "Causes: " + diseaseCauses.get(predictedDisease.toLowerCase()) + "\n" +
                                    "Symptoms: " + diseaseSymptoms.get(predictedDisease.toLowerCase()) + "\n" +
                                    "Prevention: \n" + diseasePrevention.get(predictedDisease.toLowerCase()), "Disease Information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(MedicalSystem.this,
                            "No matching disease found in the database. Please consult a healthcare provider.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(MedicalSystem.this, "Please enter all three symptoms.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MedicalSystem();
            }
        });
    }
}

// DoctorSearchGUI class
class DoctorSearchGUI extends JFrame {
    private JComboBox<String> specialistComboBox;
    private JComboBox<String> locationComboBox;
    private JPanel resultsPanel;

    private Map<String, String[]> locationDoctorsMap;
    private Map<String, ImageIcon[]> locationDoctorImagesMap;
    private Map<String, String[]> specialistDoctorsMap;
    private Map<String, ImageIcon[]> specialistDoctorImagesMap;

    public DoctorSearchGUI() {
        // Set up the main frame
        setTitle("Best Doctors in Bangalore");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create top panel for the title
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.setBackground(new Color(0, 128, 255));
        topPanel.setPreferredSize(new Dimension(800, 100));

        JLabel titleLabel = new JLabel("Best Doctors In Bangalore", SwingConstants.CENTER);
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
        topPanel.add(titleLabel, BorderLayout.CENTER);

        // Create the search panel
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchPanel.setPreferredSize(new Dimension(800, 50));
        searchPanel.setBackground(new Color(173, 216, 230));

        specialistComboBox = new JComboBox<>(new String[]{"Select Specialist", "Cardiologist", "Neurologist", "Gynecologist", "Ophthalmologist", "Dentist", "Orthopedic", "Dermatologist", "Pediatrician"});
        specialistComboBox.setPreferredSize(new Dimension(150, 30));
        specialistComboBox.setBorder(new LineBorder(new Color(0, 128, 255), 2));

        locationComboBox = new JComboBox<>(new String[]{"Select Location", "Kasavanahalli", "Koramangala", "Nandi Hills", "Whitefield", "Indiranagar"});
        locationComboBox.setPreferredSize(new Dimension(150, 30));
        locationComboBox.setBorder(new LineBorder(new Color(0, 128, 255), 2));

        searchPanel.add(specialistComboBox);
        searchPanel.add(locationComboBox);

        // Create results panel
        resultsPanel = new JPanel();
        resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.Y_AXIS));
        resultsPanel.setBackground(new Color(224, 255, 255));

        JScrollPane scrollPane = new JScrollPane(resultsPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        // Add panels to the main frame
        add(topPanel, BorderLayout.NORTH);
        add(searchPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Initialize data and default image
        initializeDoctorData();

        // Add action listeners
        locationComboBox.addActionListener(new LocationSelectionHandler());
        specialistComboBox.addActionListener(new SpecialistSelectionHandler());
    }

    private void initializeDoctorData() {
        locationDoctorsMap = new HashMap<>();
        locationDoctorImagesMap = new HashMap<>();
        specialistDoctorsMap = new HashMap<>();
        specialistDoctorImagesMap = new HashMap<>();

        // Default image for all doctors
        ImageIcon defaultDoctorImage = new ImageIcon(new ImageIcon("images/male.jpg").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));

        // Adding doctors and their images for locations
        locationDoctorsMap.put("Kasavanahalli", new String[]{"Narayan Neurologist", "Chaitanya Cardiologist"});
        locationDoctorImagesMap.put("Kasavanahalli", new ImageIcon[]{defaultDoctorImage, defaultDoctorImage});

        locationDoctorsMap.put("Koramangala", new String[]{"Radha Ophthalmologist", "Venky Gynecologist"});
        locationDoctorImagesMap.put("Koramangala", new ImageIcon[]{defaultDoctorImage, defaultDoctorImage});

        locationDoctorsMap.put("Nandi Hills", new String[]{"Manogna Cardiologist", "Prerana Dentist"});
        locationDoctorImagesMap.put("Nandi Hills", new ImageIcon[]{defaultDoctorImage, defaultDoctorImage});

        locationDoctorsMap.put("Whitefield", new String[]{"Anusha Dermatologist", "Suresh Orthopedic"});
        locationDoctorImagesMap.put("Whitefield", new ImageIcon[]{defaultDoctorImage, defaultDoctorImage});

        locationDoctorsMap.put("Indiranagar", new String[]{"Ravi Pediatrician", "Meena Cardiologist"});
        locationDoctorImagesMap.put("Indiranagar", new ImageIcon[]{defaultDoctorImage, defaultDoctorImage});

        // Adding doctors and their images for specialists
        specialistDoctorsMap.put("Cardiologist", new String[]{"Chaitanya Cardiologist", "Manogna Cardiologist", "Meena Cardiologist"});
        specialistDoctorImagesMap.put("Cardiologist", new ImageIcon[]{defaultDoctorImage, defaultDoctorImage, defaultDoctorImage});

        specialistDoctorsMap.put("Neurologist", new String[]{"Narayan Neurologist"});
        specialistDoctorImagesMap.put("Neurologist", new ImageIcon[]{defaultDoctorImage});

        specialistDoctorsMap.put("Gynecologist", new String[]{"Venky Gynecologist"});
        specialistDoctorImagesMap.put("Gynecologist", new ImageIcon[]{defaultDoctorImage});

        specialistDoctorsMap.put("Ophthalmologist", new String[]{"Radha Ophthalmologist"});
        specialistDoctorImagesMap.put("Ophthalmologist", new ImageIcon[]{defaultDoctorImage});

        specialistDoctorsMap.put("Dentist", new String[]{"Prerana Dentist"});
        specialistDoctorImagesMap.put("Dentist", new ImageIcon[]{defaultDoctorImage});

        specialistDoctorsMap.put("Orthopedic", new String[]{"Suresh Orthopedic"});
        specialistDoctorImagesMap.put("Orthopedic", new ImageIcon[]{defaultDoctorImage});

        specialistDoctorsMap.put("Dermatologist", new String[]{"Anusha Dermatologist"});
        specialistDoctorImagesMap.put("Dermatologist", new ImageIcon[]{defaultDoctorImage});

        specialistDoctorsMap.put("Pediatrician", new String[]{"Ravi Pediatrician"});
        specialistDoctorImagesMap.put("Pediatrician", new ImageIcon[]{defaultDoctorImage});
    }

    private void displayDoctors(String[] doctors, ImageIcon[] images) {
        resultsPanel.removeAll();
        if (doctors != null && images != null) {
            for (int i = 0; i < doctors.length; i++) {
                final String doctorName = doctors[i];
                final ImageIcon doctorImage = images[i];

                JPanel doctorPanel = new JPanel(new BorderLayout());
                doctorPanel.setBorder(new LineBorder(new Color(0, 102, 204), 1));
                doctorPanel.setBackground(Color.WHITE);
                JLabel doctorLabel = new JLabel(doctorName);
                doctorLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                JButton bookButton = new JButton("Book Now");
                bookButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
                bookButton.setForeground(Color.WHITE);
                bookButton.setBackground(new Color(128, 0, 0));
                bookButton.setBorder(new LineBorder(Color.WHITE, 2, true)); // Rounded border
                JLabel imageLabel = new JLabel(doctorImage);

                bookButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        handleBooking(doctorName, doctorImage);
                    }
                });

                doctorPanel.add(imageLabel, BorderLayout.WEST);
                doctorPanel.add(doctorLabel, BorderLayout.CENTER);
                doctorPanel.add(bookButton, BorderLayout.EAST);
                resultsPanel.add(doctorPanel);
            }
        }
        resultsPanel.revalidate();
        resultsPanel.repaint();
    }

    private void handleBooking(String doctorName, ImageIcon doctorImage) {
        // Create a dialog to select date and time
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Select Date:"));

        JComboBox<String> dateComboBox = new JComboBox<>(new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"});
        panel.add(dateComboBox);

        panel.add(new JLabel("Select Time:"));
        JComboBox<String> timeComboBox = new JComboBox<>(new String[]{"11 AM", "12 PM", "1 PM", "2 PM", "3 PM", "4 PM", "5 PM"});
        panel.add(timeComboBox);

        int result = JOptionPane.showConfirmDialog(this, panel, "Booking Details",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            String selectedDate = (String) dateComboBox.getSelectedItem();
            String selectedTime = (String) timeComboBox.getSelectedItem();

            if (selectedDate != null && selectedTime != null) {
                Random random = new Random();
                int tokenNumber = random.nextInt(1000) + 1; // Generate a random token number between 1 and 1000

                String email = JOptionPane.showInputDialog(this, "Enter your email:");

                if (email != null && !email.trim().isEmpty() && email.endsWith("@gmail.com")) {
                    // Create a panel to show the confirmation message along with the doctor's image
                    JPanel confirmationPanel = new JPanel(new BorderLayout());
                    JLabel confirmationLabel = new JLabel("<html>Booking Successful!<br>" +
                            "Doctor: " + doctorName + "<br>" +
                            "Date: " + selectedDate + "<br>" +
                            "Time: " + selectedTime + "<br>" +
                            "Your token number is: " + tokenNumber + "<br>" +
                            "Details have been sent to: " + email + "</html>");
                    confirmationLabel.setFont(new Font("Times New Roman", Font.PLAIN, 16));
                    confirmationPanel.add(confirmationLabel, BorderLayout.CENTER);
                    confirmationPanel.add(new JLabel(doctorImage), BorderLayout.WEST);

                    JOptionPane.showMessageDialog(this, confirmationPanel, "Booking Confirmation", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "A valid email ending with @gmail.com is required to complete the booking.",
                            "Booking Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please select a date and time.",
                        "Booking Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class LocationSelectionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedLocation = (String) locationComboBox.getSelectedItem();
            if (selectedLocation != null && !selectedLocation.equals("Select Location")) {
                displayDoctors(locationDoctorsMap.get(selectedLocation), locationDoctorImagesMap.get(selectedLocation));
            }
        }
    }

    private class SpecialistSelectionHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String selectedSpecialist = (String) specialistComboBox.getSelectedItem();
            if (selectedSpecialist != null && !selectedSpecialist.equals("Select Specialist")) {
                displayDoctors(specialistDoctorsMap.get(selectedSpecialist), specialistDoctorImagesMap.get(selectedSpecialist));
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DoctorSearchGUI doctorSearchGUI = new DoctorSearchGUI();
            doctorSearchGUI.setVisible(true);
        });
    }
}
