package exos.lujan.jose.joselujanexos;

import android.content.Intent;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Quezacoo on 5/29/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService{
    /*private static final String TAG = "fcmexamplemessage";

    @override
    public void OnMessageReceived (RemoteMessage remoteMessage){
        log.d(TAG,, "From : " + remoteMessage.getFrom());
        log.d(TAG,, "Notification Body : " + remoteMessage.getNotification());
        notifyUser(remoteMessage.getFrom(), remoteMessage.getNotification().getBody());
    }

    public void NotifyUser(String from, String notification){
        myNotificationManager myNotificationManager = new myNotificationManager(getApplicationContext());
        myNotificationManager.showNotification(from, notification, new Intent(getApplicationContext(), MainActivity.class));

    }*/
}
