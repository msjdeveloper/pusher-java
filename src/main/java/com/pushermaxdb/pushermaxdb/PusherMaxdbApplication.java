package com.pushermaxdb.pushermaxdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pusher.client.Pusher;
import com.pusher.client.PusherOptions;
import com.pusher.client.channel.Channel;
import com.pusher.client.channel.PusherEvent;
import com.pusher.client.channel.SubscriptionEventListener;
import com.pusher.client.connection.ConnectionEventListener;
import com.pusher.client.connection.ConnectionStateChange;

@SpringBootApplication
public class PusherMaxdbApplication {

	public static void main(String[] args) {
		SpringApplication.run(PusherMaxdbApplication.class, args);
		
		PusherOptions options = new PusherOptions().setCluster("sa1");
		
		Pusher pusher = new Pusher("10c93286078a36c239e2", options);
		
		Channel channel = pusher.subscribe("my-channel");
		channel.bind("my-event", new SubscriptionEventListener() {
		    @Override
		    public void onEvent(PusherEvent event) {
		        System.out.println("Received event with data: " + event.toString());
		        System.out.println("Subscription Count is: " + channel.toString());
		    }
		});
	}

}
