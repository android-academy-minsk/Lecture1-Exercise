package by.androidacademy.exercise1;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    private static final String MESSAGE_EXTRA = "message_extra";

    public static void show(Context context,
                            String message) {
        final Intent secondActivityIntent = new Intent(context, SecondActivity.class);
        secondActivityIntent.putExtra(MESSAGE_EXTRA, message);
        context.startActivity(secondActivityIntent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        final String message = getIntent().getStringExtra(MESSAGE_EXTRA);
        final TextView messageTextView = findViewById(R.id.tv_message);
        messageTextView.setText(message);
    }
}
