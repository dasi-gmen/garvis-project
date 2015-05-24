/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icaro.aplicaciones.recursos.controlGarvisPane.imp.util;
import icaro.aplicaciones.recursos.controlGarvisPane.imp.util.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InterruptedIOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.StringTokenizer;

/**
 *
 * @author 
 */
//public abstract class ConexionCONTROL {
   public  class ConexionCONTROL { 
    /**
     * The definitive version number of this release .
     * (Note: Change this before automatically building releases)
     */
    public static final String VERSION = "0.9.11";

//    private InputThread _inputThread = null;
//    private OutputThread _outputThread = null;
    private boolean _isConnected = false;
 
    private Queue _outQueue = new Queue();
    private long _messageDelay = 5000;
    private int _maxLineLength = 512;
    
    // Default settings for the ConexionCONTROL.
    private boolean _verbose = false;
    private String _name = "ConexionCONTROL";
    private String _login = "ConexionCONTROL";
    private String _version = "ConexionCONTROL " + VERSION; // + " Java IRC Bot - www.jibble.org";
    private String _finger = "You ought to be arrested for fingering a bot!";
    
    private GarvisUserControl controlGUI;

    
    /**
     * Constructs a  with the default settings.  Your own constructors
     * in classes which extend the ConexionCONTROL abstract class should be responsible
     * for changing the default settings if required.
     */
    public  ConexionCONTROL() {}

    

    public final synchronized void connect() throws IOException {
        controlGUI.start();
        this.log("*** Connected to GARVIS.");
        this.log("*** Logged onto GARVIS.");
        
        
        _isConnected = true;
        //this.onConnect();
        
    }


    /**
     * This method disconnects from the server by closing the socket and
     * ending the threads that read from and write to the server.  This method
     * is called when the connection to the server fails to ensure that the
     * threads are stopped.  It may also be called explicitly to disconnect
     * from a server.  You may wish to use the quitServer method to exit an
     * IRC server normally.
     */
    public final synchronized void disconnect() {
        _isConnected = false;
        this.log("*** Disconnected.");
        try {
        }
        catch (Exception e) {
            // If something went wrong, let's assume the socket is already closed.
        }
    }
    
        
    /**
     * Sends a message to a channel or a private message to a user.  These
     * messages are added to the outgoing message queue and sent at the
     * earliest possible opportunity.
     *
     * @param target The name of the channel or user nick to send to.
     * @param message The message to send.
     */
    public final void sendMessage(String message) {
        _outQueue.add(message);
    }
          

    
    /**
     * This method is called whenever a message is sent to a channel.
     * The implementation of this method in the ConexionIrc abstract class
     * performs no actions and may be overridden as required.
     *
     * @param channel The channel to which the message was sent.
     * @param sender The nick of the person who sent the message.
     * @param login The login of the person who sent the message.
     * @param hostname The hostname of the person who sent the message.
     * @param message The actual message sent to the channel.
     */
    protected void onMessage(String channel, String sender, String login, String hostname, String message) {}


    /**
     * This method is called whenever a private message is sent to the ConexionIrc.
     * The implementation of this method in the ConexionIrc abstract class
     * performs no actions and may be overridden as required.
     *
     * @param sender The nick of the person who sent the private message.
     * @param login The login of the person who sent the private message.
     * @param hostname The hostname of the person who sent the private message.
     * @param message The actual message.
     */
    protected void onPrivateMessage(String sender, String login, String hostname, String message) {}
    
    public void log(String line) {
        if (_verbose) {
            System.out.println(System.currentTimeMillis() + " " + line);
        }
    }

}
