import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JFrame;

public class MenuDemo implements ActionListener {

        JTextArea output;
        JScrollPane scrollPane;
        String newline = "\n";

        public JMenuBar createMenuBar() {
                JMenuBar menuBar;
                JMenu menu, submenu;
                JMenuItem menuItem;
                JRadioButtonMenuItem rbMenuItem;
                JCheckBoxMenuItem cbMenuItem;

                // Create the menu bar.
                menuBar = new JMenuBar();

                // Build the first menu.
                menu = new JMenu("Add New");
                menu.addActionListener(this);
                menu.setMnemonic(KeyEvent.VK_A);
                menu.getAccessibleContext()
                                .setAccessibleDescription("The only menu in this program that has menu items"); // maddy
                                                                                                                // updated

                menuBar.add(menu);

                menuItem = new JMenuItem("Birthdate", KeyEvent.VK_M);
                // menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
                menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
                menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
                menuItem.addActionListener(this);
                menu.add(menuItem);

                // Build second menu in the menu bar.
                menu = new JMenu("Watch the");
                menu.setMnemonic(KeyEvent.VK_N);
                menu.getAccessibleContext().setAccessibleDescription("This menu does nothing");
                menu.addActionListener(this);
                menuBar.add(menu);
                menuItem = new JMenuItem("Database", KeyEvent.VK_M);
                // menuItem.setMnemonic(KeyEvent.VK_T); //used constructor instead
                menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
                menuItem.getAccessibleContext().setAccessibleDescription("This doesn't really do anything");
                menuItem.addActionListener(this);
                menu.add(menuItem);
                menu = new JMenu("Search Database");
                menu.setMnemonic(KeyEvent.VK_N);
                menu.getAccessibleContext().setAccessibleDescription("This menu does nothing");
                menu.addActionListener(this);
                menuBar.add(menu);

                menuItem = new JMenuItem("By Name");
                menuItem.setMnemonic(KeyEvent.VK_M);
                menuItem.addActionListener(this);
                menu.add(menuItem);

                menuItem = new JMenuItem("By Date Of Birth");
                menuItem.setMnemonic(KeyEvent.VK_M);
                menuItem.addActionListener(this);
                menu.add(menuItem);

                return menuBar;
        }

        public Container createContentPane() {
                // Create the content-pane-to-be.
                JPanel contentPane = new JPanel(new BorderLayout());
                contentPane.setOpaque(true);
                final ImageIcon imageIcon = new ImageIcon("samman.jpg");
                // Create a scrolled text area.
                output = new JTextArea(5, 30) {
                        Image image = imageIcon.getImage();
                        Image grayImage = GrayFilter.createDisabledImage(image);
                        {
                                setOpaque(false);
                        } // instance initializer

                        public void paintComponent(Graphics g) {
                                g.drawImage(grayImage, 0, 0, this);
                                super.paintComponent(g);
                        }
                };
                output.setEditable(false);
                scrollPane = new JScrollPane(output);

                // Add the text area to the content pane.
                contentPane.add(scrollPane, BorderLayout.CENTER);

                return contentPane;
        }

        public void actionPerformed(ActionEvent e) {
                if (e.getActionCommand() == "Birthdate") {
                        new AddNewStudent();
                }
                /*
                 * if (e.getActionCommand() == "Database") { Connection
                 * con=MyAccConnect.connection(); try{ Statement st=con.createStatement();
                 * ResultSet r=st.executeQuery("select * from Birth"); while(r.next()){ String
                 * s=r.getString("Name")+" "+r.getString("Birthdate");
                 * //System.out.println(r.getString("Name")+" "+r.getString("Birthdate"));
                 * output.append(s + newline);
                 * 
                 * } } catch(Exception se){ se.printStackTrace(); }
                 * //output.setCaretPosition(output.getDocument().getLength());
                 * //ResultsDao.viewResult(); }
                 */

        }

        public static void createAndShowGUI() {
                // Create and set up the window.
                JFrame frame = new JFrame("MenuDemo");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Create and set up the content pane.
                MenuDemo demo = new MenuDemo();
                frame.setJMenuBar(demo.createMenuBar());
                frame.setContentPane(demo.createContentPane());

                // Display the window.
                frame.setSize(490, 410);
                frame.setVisible(true);
        }
}
