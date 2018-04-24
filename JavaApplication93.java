/*
 * Walid Zein
 * API project
 */
package javaapplication93;

import org.jibble.pircbot.*;
import org.jibble.pircbot.IrcException;
import java.io.IOException;

public class JavaApplication93 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, IrcException {
        MyBot bot = new MyBot();
        bot.setVerbose(true);
        bot.connect("irc.freenode.net");
        bot.joinChannel("#cs2336");
    }

    
}
