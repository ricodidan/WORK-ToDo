package id.sch.smktelkom_mlg.worktodo.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;
import java.util.List;

import id.sch.smktelkom_mlg.worktodo.database.DatabaseHelper;
import id.sch.smktelkom_mlg.worktodo.model.Reminder;
import id.sch.smktelkom_mlg.worktodo.utils.AlarmUtil;
import id.sch.smktelkom_mlg.worktodo.utils.DateAndTimeUtil;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        DatabaseHelper database = DatabaseHelper.getInstance(context);
        List<Reminder> reminderList = database.getNotificationList(Reminder.ACTIVE);
        database.close();
        Intent alarmIntent = new Intent(context, AlarmReceiver.class);

        for (Reminder reminder : reminderList) {
            Calendar calendar = DateAndTimeUtil.parseDateAndTime(reminder.getDateAndTime());
            calendar.set(Calendar.SECOND, 0);
            AlarmUtil.setAlarm(context, alarmIntent, reminder.getId(), calendar);
        }
    }
}