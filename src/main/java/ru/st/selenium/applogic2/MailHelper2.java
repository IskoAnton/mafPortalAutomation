package ru.st.selenium.applogic2;
import org.apache.log4j.Logger;
import org.testng.Reporter;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.SubjectTerm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Properties;

public class MailHelper2 {
    private String email = "isko.antontest@gmail.com";
    private String password = "HjeodjIu12";
    public final Logger log = Logger.getLogger(this.getClass().getSimpleName());
    public String getEmailLink(String subject) throws Exception {
        String url = "";
        Properties props = System.getProperties();
        props.setProperty("mail.store.protocol", "imaps");

        Session session = Session.getDefaultInstance(props, null);
        Store store = session.getStore("imaps");
        store.connect("imap.gmail.com", email,
                password);

        Folder folder = store.getFolder("INBOX");
        folder.open(Folder.READ_WRITE);

        //System.out.println("Total Message:" + folder.getMessageCount());
        //System.out.println("Unread Message:"
                //+ folder.getUnreadMessageCount());

        Message[] messages = null;
        boolean isMailFound = false;
        Message mailFromMafia= null;

        //Search for mail from Mafia
        for (int i = 0; i < 5; i++) {
            messages = folder.search(new SubjectTerm(
                            subject),
                    folder.getMessages());
            //Wait for 10 seconds
            if (messages.length == 0) {
                Thread.sleep(10000);
            }
        }

        //Search for unread mail from Mafia
        //This is to avoid using the mail for which
        //Registration is already done
        for (Message mail : messages) {
            if (!mail.isSet(Flags.Flag.SEEN)) {
                mailFromMafia = mail;
                System.out.println("Message Count is: "
                        + mailFromMafia.getMessageNumber());
                isMailFound = true;
            }
        }

        //Test fails if no unread mail was found from God
        if (!isMailFound) {
            throw new Exception(
                    "Could not find new mail from Mafia :-(");

            //Read the content of mail and launch registration URL
        } else {
            String line;
            StringBuffer buffer = new StringBuffer();
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(mailFromMafia
                            .getInputStream()));
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            //Your logic to split the message and get the Registration URL goes here
            if (subject.equalsIgnoreCase("Email Verification")) {
                String[] registrationURL1 = buffer.toString().split("Confirm registration: ");
                String[] registrationURL2 = registrationURL1[1].split("If you did not request");
                url = registrationURL2[0].replace("=", "");
                log("Email registration link in email is \"" + url + "\"");
                mailFromMafia.setFlag(Flags.Flag.DELETED, true);
            } else if (subject.equalsIgnoreCase("Reset Password")) {

                String[] registrationURL1 = buffer.toString().split("Reset Password: ");
                String[] registrationURL2 = registrationURL1[1].split("If you did not request");
                url = registrationURL2[0].replace("=", "");
                log("Email restore password link in email is \"" + url + "\"");
                mailFromMafia.setFlag(Flags.Flag.DELETED, true);
            }
        }
        return url;
    }

    public void log(String text) {
        log.info(text);
        Reporter.log(text);
    }


}


