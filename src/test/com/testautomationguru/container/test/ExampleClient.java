package com.testautomationguru.container.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.ServerHandshake;

/** This example demonstrates how to create a websocket connection to a server. Only the most important callbacks are overloaded. */
public class ExampleClient extends WebSocketClient {


    public static void main(String arg[]) throws URISyntaxException {
        ExampleClient c = new ExampleClient( new URI( "s://dv.investimetric.io:5000/ws" )); // more about drafts here: http://github.com/TooTallNate/Java-WebSocket/wiki/Drafts
        c.connect();
    }


    ExampleClient(URI serverURI) {
        super( serverURI );
    }


    @Override
    public void onOpen( ServerHandshake handshakedata ) {
        ByteBuffer longelinebuffer = ByteBuffer.wrap( "{\"type\":\"ping\"}".getBytes() );
        ByteBuffer longelinebuffer2 = ByteBuffer.wrap( "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"pairs\"}]}".getBytes() );
        ByteBuffer longelinebuffer3 = ByteBuffer.wrap( "{\"type\":\"subscribe\",\"channels\":[{\"name\":\"ob\",\"pair\":\"BTC-USD\"}]}".getBytes() );

        sendFragmentedFrame(Framedata.Opcode.TEXT,longelinebuffer3,true);
        System.out.println( "opened connection" );
        // if you plan to refuse connection based on ip or httpfields overload: onWebsocketHandshakeReceivedAsClient
    }

    @Override
    public void onMessage( String message ) {
        System.out.println( "received: " + message );
    }


    @Override
    public void onClose( int code, String reason, boolean remote ) {
        // The codecodes are documented in class org.java_websocket.framing.CloseFrame
        System.out.println( "Connection closed by " + ( remote ? "remote peer" : "us" ) + " Code: " + code + " Reason: " + reason );
    }

    @Override
    public void onError( Exception ex ) {
        ex.printStackTrace();
        // if the error is fatal then onClose will be called additionally
    }







}