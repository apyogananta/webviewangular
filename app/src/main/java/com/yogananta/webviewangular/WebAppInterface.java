package com.yogananta.webviewangular;

import static android.content.Context.NOTIFICATION_SERVICE;
import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.webkit.JavascriptInterface;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import java.nio.channels.Channel;

public class WebAppInterface
{
    private Activity _activity;
    private Context _context;

    public WebAppInterface(Context context, Activity activity)
    {
        _context = context;
        _activity = activity;
    }

    @JavascriptInterface
    public void showToast(String message)
    {
        Toast.makeText(_context, message, Toast.LENGTH_LONG).show();
    }

    @JavascriptInterface
    public void showCall() {
        Intent kontakIntent = new Intent(Intent.ACTION_MAIN);
        kontakIntent.addCategory(Intent.CATEGORY_APP_CONTACTS);
        _context.startActivity(kontakIntent);
    }

    @JavascriptInterface
    public void showNotification(String title, String message) {

            NotificationChannel channel = new NotificationChannel("apChannel" , "AP", NotificationManager.IMPORTANCE_DEFAULT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(_context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setContentText(message)
                .setChannelId(channel.getId());

        NotificationManager manager = (NotificationManager) _context.getSystemService(NOTIFICATION_SERVICE);
        manager.createNotificationChannel(channel);
        manager.notify(1, builder.build());

    }

    @JavascriptInterface
    public void showWhatsApp() {
        String url = "https://api.whatsapp.com/send?phone=+6289618464844";
        Intent waIntent = new Intent(Intent.ACTION_VIEW);
        waIntent.setData(Uri.parse(url));
        _context.startActivity(waIntent);
    }

    @JavascriptInterface
    public void showCamera() {
        Intent kameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        _context.startActivity(kameraIntent);
    }

}

