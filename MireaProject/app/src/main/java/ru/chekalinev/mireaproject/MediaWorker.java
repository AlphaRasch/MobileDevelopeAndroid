package ru.chekalinev.mireaproject;


import static android.Manifest.permission.POST_NOTIFICATIONS;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import ru.chekalinev.mireaproject.databinding.FragmentWorkerBinding;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MediaWorker extends Worker {
    private static final String CHANNEL_ID = "ID";


    public MediaWorker(
            Context context,
            @NonNull WorkerParameters params) {
        super(context, params);
    }


    @Override
    public Result doWork() {
        if(ActivityCompat.checkSelfPermission(this.getApplicationContext(), POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            //Log.d("worker", "notify");

        }
        NotificationCompat.Builder _builder = new NotificationCompat.Builder(this.getApplicationContext(), CHANNEL_ID)
                .setContentTitle("Current DateTime")
                .setContentText(getInputData().getString("datetime"))
                .setSmallIcon(R.drawable.music_icon)
                .setPriority(NotificationCompat.PRIORITY_HIGH);

        int _importance = NotificationManager.IMPORTANCE_DEFAULT;
        NotificationChannel _channel = new NotificationChannel(CHANNEL_ID, "WORKER", _importance);
        _channel.setDescription("_description");

        NotificationManagerCompat _notificationManagerCompat = NotificationManagerCompat.from(this.getApplicationContext());
        _notificationManagerCompat.createNotificationChannel(_channel);
        _notificationManagerCompat.notify(1, _builder.build());
        return Result.success();
    }

}
