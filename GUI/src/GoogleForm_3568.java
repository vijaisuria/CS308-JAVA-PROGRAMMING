import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class GoogleForm_3568 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Google Account Registration");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);
        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField(20);
        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField(20);
        JLabel emailLabel = new JLabel("Email (Username):");
        JTextField emailField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        JPasswordField confirmPasswordField = new JPasswordField(20);
        JLabel countryLabel = new JLabel("Country:");
        String[] countries = { "Select", "India", "US", "UK" };
        JComboBox<String> countryComboBox = new JComboBox<>(countries);
        JLabel phoneLabel = new JLabel("Phone number:");
        JTextField phoneField = new JTextField(20);
        JLabel recoveryEmailLabel = new JLabel("Recovery Email:");
        JTextField recoveryEmailField = new JTextField(20);
        JLabel dobLabel = new JLabel("Date of Birth:");
        JComboBox<String> monthComboBox = new JComboBox<>(new String[] { "Select", "January", "February", "March",
                "April", "May", "June", "July", "August", "September", "October", "November", "December" });
        JComboBox<String> dayComboBox = new JComboBox<>(new String[] { "Select" });
        JComboBox<String> yearComboBox = new JComboBox<>(new String[] { "Select" });
        // Populate dayComboBox with days 1 to 31 initially
        String[] daysInitial = new String[32];
        for (int i = 0; i <= 31; i++) {
            daysInitial[i] = Integer.toString(i);
        }
        dayComboBox.setModel(new DefaultComboBoxModel<>(daysInitial));
        // Now, add the ActionListener for monthComboBox
        monthComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMonth = (String) monthComboBox.getSelectedItem();
                int selectedYear = Integer.parseInt((String) yearComboBox.getSelectedItem());
                if (selectedMonth.equals("Select")) {
                    dayComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));
                } else {
                    int maxDays = getMaxDaysForMonth(selectedMonth, selectedYear);
                    String[] days = new String[maxDays + 1];
                    days[0] = "Select";
                    for (int i = 1; i <= maxDays; i++) {
                        days[i] = String.valueOf(i);
                    }
                    dayComboBox.setModel(new DefaultComboBoxModel<>(days));
                }
            }
        });
        // Populate dayComboBox and yearComboBox based on the selected month
        monthComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedMonth = (String) monthComboBox.getSelectedItem();
                int selectedYear = Integer.parseInt((String) yearComboBox.getSelectedItem());
                if (selectedMonth.equals("Select")) {
                    dayComboBox.setModel(new DefaultComboBoxModel<>(new String[] { "Select" }));
                } else {
                    int maxDays = getMaxDaysForMonth(selectedMonth, selectedYear);
                    String[] days = new String[maxDays + 1];
                    days[0] = "Select";
                    for (int i = 1; i <= maxDays; i++) {
                        days[i] = String.valueOf(i);
                    }
                    dayComboBox.setModel(new DefaultComboBoxModel<>(days));
                }
            }
        });
        // Populate yearComboBox with a range of years
        String[] years = new String[200];
        for (int i = 1900; i <= 2018; i++) {
            years[i - 1900] = Integer.toString(i);
        }
        years[0] = "Select";
        yearComboBox.setModel(new DefaultComboBoxModel<>(years));
        JLabel genderLabel = new JLabel("Gender:");
        String[] genders = { "Select", "Male", "Female", "Other" };
        JComboBox<String> genderComboBox = new JComboBox<>(genders);
        JButton resetButton = new JButton("Reset");
        JButton submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(firstNameLabel, gbc);
        gbc.gridx = 1;
        panel.add(firstNameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(lastNameLabel, gbc);
        gbc.gridx = 1;
        panel.add(lastNameField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(emailLabel, gbc);
        gbc.gridx = 1;
        panel.add(emailField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(passwordLabel, gbc);
        gbc.gridx = 1;
        panel.add(passwordField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(confirmPasswordLabel, gbc);
        gbc.gridx = 1;
        panel.add(confirmPasswordField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(countryLabel, gbc);
        gbc.gridx = 1;
        panel.add(countryComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(phoneLabel, gbc);
        gbc.gridx = 1;
        panel.add(phoneField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(recoveryEmailLabel, gbc);
        gbc.gridx = 1;
        panel.add(recoveryEmailField, gbc);
        gbc.gridx = 0;
        gbc.gridy = 8;
        panel.add(dobLabel, gbc);
        gbc.gridx = 1;
        panel.add(monthComboBox, gbc);
        gbc.gridx = 2;
        panel.add(dayComboBox, gbc);
        gbc.gridx = 3;
        panel.add(yearComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 9;
        panel.add(genderLabel, gbc);
        gbc.gridx = 1;
        panel.add(genderComboBox, gbc);
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        panel.add(resetButton, gbc);
        gbc.gridx = 2;
        panel.add(submitButton, gbc);
        frame.add(panel, BorderLayout.CENTER);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm(firstNameField, lastNameField, emailField, passwordField, confirmPasswordField,
                        countryComboBox, phoneField, recoveryEmailField, yearComboBox, monthComboBox, dayComboBox,
                        genderComboBox);
            }
        });
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validateForm(firstNameField, lastNameField, emailField, passwordField, confirmPasswordField,
                            countryComboBox, phoneField, recoveryEmailField, yearComboBox, monthComboBox, dayComboBox,
                            genderComboBox);
                    JOptionPane.showMessageDialog(frame, "Account successfully created!");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.setVisible(true);
    }
    private static void resetForm(JTextField firstName, JTextField lastName, JTextField email, JPasswordField password,
                                  JPasswordField confirmPassword,
                                  JComboBox<String> country, JTextField phone, JTextField recoveryEmail, JComboBox<String> year,
                                  JComboBox<String> month,
                                  JComboBox<String> day, JComboBox<String> gender) {
        firstName.setText("");
        lastName.setText("");
        email.setText("");
        password.setText("");
        confirmPassword.setText("");
        country.setSelectedIndex(0);
        phone.setText("");
        recoveryEmail.setText("");
        year.setSelectedIndex(0);
        month.setSelectedIndex(0);
        day.setSelectedIndex(0);
        gender.setSelectedIndex(0);
    }
    private static void validateForm(JTextField firstName, JTextField lastName, JTextField email,
                                     JPasswordField password, JPasswordField confirmPassword,
                                     JComboBox<String> country, JTextField phone, JTextField recoveryEmail, JComboBox<String> year,
                                     JComboBox<String> month,
                                     JComboBox<String> day, JComboBox<String> gender) throws Exception {
        if (firstName.getText().isEmpty() || lastName.getText().isEmpty() || email.getText().isEmpty()
                || password.getPassword().length == 0 || confirmPassword.getPassword().length == 0
                || country.getSelectedIndex() == 0 || phone.getText().isEmpty() || year.getSelectedIndex() == 0
                || month.getSelectedIndex() == 0 || day.getSelectedIndex() == 0 || gender.getSelectedIndex() == 0) {
            throw new Exception("All fields are required.");
        }
        if (!isValidEmail(email.getText())) {
            throw new Exception("Invalid email address.");
        }
        if (!isValidEmail(recoveryEmail.getText())) {
            throw new Exception("Invalid recovery email address.");
        }
        String passwordStr = new String(password.getPassword());
        String confirmPasswordStr = new String(confirmPassword.getPassword());
        if (passwordStr.length() < 8) {
            throw new Exception("Password must be at least 8 characters long.");
        }
        if (!passwordStr.equals(confirmPasswordStr)) {
            throw new Exception("Passwords do not match.");
        }
    }
    private static boolean isValidEmail(String email) {
        String regex = "^(.+)@(.+)\\.com$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    private static int getMaxDaysForMonth(String month, int year) {
        switch (month) {
            case "April":
            case "June":
            case "September":
            case "November":
                return 30;
            case "February":
                if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
                    return 29; // Leap year
                } else {
                    return 28;
                }
            default:
                return 31;
        }
    }
}